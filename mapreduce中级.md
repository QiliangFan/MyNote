1. 数据:

orderdetails:

​		格式:

​					orderid ,  productid,  amount

​			1 , 1, 10

​			2 , 1, 20

​			3 ,2, 1

​			4, 2, 2

categories:

​		格式: 

​				productid  , category

​		1 , c1

​		2,  c2

===>orderid,  productid, category, amount



~~~mapreduce
zcat     *.gz   > all:
cat  *.dat  > all:
# 合并小文件
~~~

数据类型在HDFS执行序列化

  1. 实现接口(其实还实现了Comparable, 用于在reduce阶段实现排序, 不是必须的)

     (Writable )

  2. 实现相应的读写方法:

     read...

     write...

***=> 通过这两种方式, 实现自己的可读写对象, 就能用java bean做key和value***

# 1. MP  < = > JavaBean(Map中的key和value用javabean表示)

	1. 最终输出类型如果标志为文本,会调用java bean的toString方法来显示内容
 	2. javabean的实现读写方法时, 注意读写顺序, 同时读写String 用readUTF()
 	3. 进行reduce链接时 , key应为 关联的关键字段 , value 应为不同的具有"进行关联的共同字段"相等的那些字段

~~~java
package com.test.javabean.hadoop;

import com.homework.liang.MapReduce.AirPorts;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReduceSidhJosin {

    public static class ReduceSideJosinMapper
            extends Mapper<LongWritable, Text, Text, JoinBean> {

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] fields = line.split(",");

            //声明字段属性:
            String orderId = "";
            String productId = "";
            String category = "";
            String amount = "";

            //声明标志位
            String flag = "";

            //获取数据源数据文件的信息
            FileSplit inputSplit =(FileSplit) context.getInputSplit();
            String dataSourceFileNameInfo = inputSplit.getPath().getName();

            //判断数据来源,根据不同的数据源填充JavaBean
            if(dataSourceFileNameInfo != null && dataSourceFileNameInfo.toLowerCase().indexOf("details")!=-1){
                //数据来源为orderdetails.txt
                orderId  = fields[0];
                productId = fields[1];
                amount = fields[2];

                flag = "0";   //规定, 如果为0->数据来源于orderdetails.txt
            }else if(dataSourceFileNameInfo != null && dataSourceFileNameInfo.toLowerCase().indexOf("categories")!=-1){
                productId = fields[0];
                category = fields[1];
                flag = "1";   //规定: 1 表示数据来源于categories文件
            }

            JoinBean joinBean = new JoinBean(orderId,productId,category,amount,flag);

            context.write(new Text(productId),joinBean);
        }
    }

    public static class RecudeSdhJosinReducer extends Reducer<Text,JoinBean,NullWritable,JoinBean>{
        @Override
        protected void reduce(Text key, Iterable<JoinBean> values, Context context) throws IOException, InterruptedException {

            // 声明存储category
            String category = "";
            // 声明\ 创建一个保存最终链接后的beans的集合
            List<JoinBean> detailBeans = new ArrayList<>();
            // 遍历同一个prouctId 的list
            for(JoinBean bean: values){
                if("1".equals(bean.getFlag())){
                    //当前bean的数据来源于categories文件
                    category = bean.getCategory();
                }else{
                    //来源于另一个文件
                    detailBeans.add(new JoinBean(bean.getOrderId(),bean.getProductId(),bean.getCategory(),bean.getAmount(),"01"));
                }
            }

            for(JoinBean bean: detailBeans){
                bean.setCategory(category);
                context.write(null, bean);
            }
        }
    }


    public  static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 0.初始化Map job
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration,"MyWC01");
        job.setJarByClass(ReduceSidhJosin.class);

        //1. 指明输入位置: -> HDFS目录
        // 可能有多个输入位置
        //org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
        FileInputFormat.addInputPath(job, new Path(args[0]));  //最好不要指定目录,不然就写死了
        // 指定输入目录下的数据源文件的类型
        //默认是文本类型,可以不写
        job.setInputFormatClass(TextInputFormat.class);

        // 2. 指定Mapper
        job.setMapperClass(ReduceSideJosinMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(JoinBean.class);


        //默认为1, 如果设置为0,reducer不执行
        job.setNumReduceTasks(0);//不执行输出文件
        job.setReducerClass(RecudeSdhJosinReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(JoinBean.class);


        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        //指定输出类型
        job.setOutputFormatClass(TextOutputFormat.class);
        //将调用javaBean的toString方法

        Boolean result=job.waitForCompletion(true);   //等待完成,且是否可视化显示过程;返回是否提交成功并且执行结束

        Boolean success = job.isSuccessful();  //返回是否执行成功;

        System.exit( result ? 0 : -1);   //对系统返回程序执行的状态码
    }
}
~~~



# 2. MR  < = >  DB

## 1. 数据准备:

~~~http
数据源 :  Users 
数据输出 :  StatsInfos

# 实现 DBWritable   WritableComparable <T>   Writable    接口
上传DBDriver(mysql-connector- *.*.jar) 到hadoop集群中: 放到Hadoop每个节点的classpath中, 同时restart  一下
用hadoop classpath  查看hadoop的classpath
最好在:  $HADOOP_HOME/share/hadoop/common/lib

1.  保证MySql 服务器被远程访问
2.  保证远程应用可以访问到MySql服务器
				IPaddress  畅通
				Port -  3306 畅通=> 关防火墙   
					或 !!!  创建一个允许3306端口访问的入站规则
~~~

