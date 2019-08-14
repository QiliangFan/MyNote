# 1.Mapreduce 机制

{ **WrodCount\ 倒排索引 **}

**×中间某步形成的list×**      <  =   >  **另一种多进程**

![MapReduce](/home/liangliang/文档/Hadoop/MapReduce.jpg)

### **!编程 1、 提交、 运行的步骤!** 

~~~markdown
中间map  ->  list -> 最终map 
~~~

### Word-Count

~~~java
//word count
//数据准备 :   指定待处理数据的目录
// 编程实现: 1. Mapper     2. Reducer    3. Controller
// 在本地编写代码, 打包成jar包后, 在Hadoop上运行 
package con.test.liang.Mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import sun.util.resources.cldr.ss.CalendarData_ss_SZ;

import java.io.IOException;
import java.util.Iterator;

//Word Count 1.0
public class MyWC01 {

    // 1- Mapper
    //注意不要用错包!
    public static class MyGenderMapper
        extends Mapper<LongWritable,Text,Text, IntWritable>{//注意 ,这里的类型要用mapreduce中的类型
        //对象是在Hdfs上序列化, 所以必须要用可在hdfs上序列化的类
        //输入的Key是每部分字符在源文本中的偏移量


        public MyGenderMapper() {
            super();
        }

        Text wordText = new Text();
        IntWritable one = new IntWritable(1);

        @Override
        protected void map(LongWritable key, Text value,  Context context) throws IOException, InterruptedException {
            //1. 切分每一行的每一个单词
            String line = value.toString();
            String[] words = line.split(" ");
            for(String w:words){
                wordText.set(value);
                context.write(wordText, one);
            }
        }
    }

    // 2 - Reducer
    public static class MyGenderReducer
        extends Reducer<Text,IntWritable, Text,IntWritable>{
        //实现Reducer 类中的reduce方法

        @Override
        protected void reduce(Text key, Iterable<IntWritable> nums, Context context) throws IOException, InterruptedException {
            //统计处理=> nums
            int sum = 0;
            Iterator<IntWritable> iterator = nums.iterator();
            while(iterator.hasNext()){
                IntWritable num = iterator.next();
                int numValue = num.get();
                sum = sum+numValue;
            }
            IntWritable wordSum = new IntWritable(sum);
            context.write(key,wordSum);
        }



    }

    // 3 - Controller
    //一般在命令行中给出输入目录,
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 0.初始化Map job
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration,"MyWC01");
        job.setJarByClass(MyWC01.class);

        //1. 指明输入位置: -> HDFS目录
        // 可能有多个输入位置
        //org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
        FileInputFormat.addInputPath(job, new Path(args[0]));  //最好不要指定目录,不然就写死了
        // 指定输入目录下的数据源文件的类型
        //默认是文本类型,可以不写
        job.setInputFormatClass(TextInputFormat.class);

        // 2. 指定Mapper
        job.setMapperClass(MyGenderMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        /*
         * 还可以指定其他操作: patition\combin\sort\shuffle
         */

        // 3. 指定Reducer - 类信息 + 最终map的key \ value 的类信息  + Reducer的执行个数
        job.setReducerClass(MyGenderReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //默认为1, 如果设置为0,reducer不执行
        job.setNumReduceTasks(2);

        // 4. 指定输出:  目录  +   类型
//        FileOutputFormat.setOutputPath(job, new Path("/output/wcoutput"));
    //上面这样写死了,也不好
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        //指定输出类型
        job.setOutputFormatClass(TextOutputFormat.class);

        // 5. 提交作业
//        job.submit();
//        上面这个不推荐,只是简单提交
        Boolean result=job.waitForCompletion(true);   //等待完成,且是否可视化显示过程;返回是否提交成功并且执行结束

        Boolean success = job.isSuccessful();  //返回是否执行成功;

        System.exit( result ? 0 : -1);   //对系统返回程序执行的状态码
    }
}
~~~

### 投入文件

#### 	1. 导出jar ->指明main方法(右键, export 为jar 包 ,  注意勾选主类)

#### 	2.  上传jar

#### 	3.  在集群中执行MR

​			命令行中输入指令, 输入目录要存在 ,而输出目录一定不要存在

hadoop  jar  <jar包>  <输入文件的文件夹位置(里面最好不要有没用的文件)>   <输出文件位置>

~~~http
注意: 指定输入文件夹时, 要注意输入文件夹内不要有无关数据文件
指定输出文件夹时, 一定要是不存在的文件夹
当jar 包中没有指定main  class时 , 系统会报class not  found  或者 jar 找不到, 可能位置并不相同. 
此时应当注意: 要去jar包内部, 修改Manifest.mf , 配置一下jar包的主类
而 Manifest文件最后要空一行!
~~~

~~~shell
#注意启动资源管理和节点管理线程
start-yarn.sh

#  IO 都在HDFS上
	I. 包含数据源(文件s)的目录(s)
	O, 指定输出结果的文件所在目录(初始时应该不存在, 由mapreduce 创建)
   
#  MR代码
	0- 确认输入的信息\ 看输入文件的构成  \ 
	1. Mapper
		对 Line (文件中的一行执行的操作)  #某一行
	2. Reducer
		对 List  执行操作
	3. Controller
		确认输入目录(s) \ 输出目录 (最后一个一定是输出目录,前面都是输入目录)
				硬编码:  将路径写到程序中
				借助命令行参数的方式
				
# 3 个map
	srcMap   
			----->  LongWritable ,  Text
			-----> 每行首字符在正片文档中的偏移量 | 每行字符串
    middleMap
    		----->  Text  --  IntWritable
    		------>  分离出的每一个单词 --  在单词计数中value不重要
    		# MR机制
    		# 将所有middleMap的结果合并
   	destMap
   			------>Text  , IntWritable
   			-------> 需要统计的文本中每一个不同的单词 -  该单词的计数
~~~

### 倒排索引

#### 1. 搜索引擎中, 先对页面内容进行分词(可能还需要去掉一些停词)

#### 2. 实现倒排索引=>( 网页中包含的单词 : 网页地址)  一个map

#### 3. 存储到kv数据库中 = 列级数据库



#### 倒排: 获取被叫号码的所有主叫号码:

​	13001  110

​	13002  120

​	13001 120 

....

~~~java
package con.test.liang.Mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.util.Iterator;

public class MyWC02 {

    public static class MyMapper
            extends Mapper<LongWritable,Text,Text, Text>{
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] str_arr = line.split(" ");
            context.write(new Text(str_arr[1]), new Text(str_arr[0]));
        }
    }

    public static class MyReducer
            extends Reducer<Text,Text,Text, Text>{
        private Text caller;
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            Iterator<Text> iterator = values.iterator();
            String list = "";
            while(iterator.hasNext()){
                caller = iterator.next();
                String callerStr = caller.toString();
                list = list +":"+ callerStr;
            }
            Text listText= new Text(list);
            context.write(key, listText);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 0.初始化Map job
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration,"MyWC01");
        job.setJarByClass(MyWC01.class);


        //1. 指明输入位置: -> HDFS目录
        // 可能有多个输入位置
        //org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
        //命令行有多个输入目录 , 除最后一个是输出目录外, 其余都是输入目录

        String[] otherArgs = new GenericOptionsParser(configuration, args).getRemainingArgs();//获取除hdfs参数以外的剩余参数
        if(otherArgs.length<2){
            System.err.println("Usage : XXX.jar <in>  [<in>...]  <out>");
            System.exit(2);
        }

        for(int i=0; i<otherArgs.length-1;i++){
            FileInputFormat.addInputPath(job,new Path(args[i]));
        }

//        FileInputFormat.addInputPath(job, new Path(args[0]));  //最好不要指定目录,不然就写死了
        // 指定输入目录下的数据源文件的类型
        //默认是文本类型,可以不写
        job.setInputFormatClass(TextInputFormat.class);

        // 2. 指定Mapper
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        /*
         * 还可以指定其他操作: patition\combin\sort\shuffle
         */

        // 3. 指定Reducer - 类信息 + 最终map的key \ value 的类信息  + Reducer的执行个数
        job.setReducerClass(MyReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        //默认为1, 如果设置为0,reducer不执行
        job.setNumReduceTasks(2);

        // 4. 指定输出:  目录  +   类型
//        FileOutputFormat.setOutputPath(job, new Path("/output/wcoutput"));
        //上面这样写死了,也不好
        FileOutputFormat.setOutputPath(job,new Path(args[args.length-1]));
        //指定输出类型
        job.setOutputFormatClass(TextOutputFormat.class);

        // 5. 提交作业
//        job.submit();
//        上面这个不推荐,只是简单提交
        Boolean result=job.waitForCompletion(true);   //等待完成,且是否可视化显示过程;返回是否提交成功并且执行结束

        Boolean success = job.isSuccessful();  //返回是否执行成功;

        System.exit( result ? 0 : -1);   //对系统返回程序执行的状态码
    }
}
~~~

## 对于海量数据中的异常数据

~~~java
//不应该对其进行处理,而应该捕获后记录位置
catch(Exception e){
		context.getCounter(...).increment(1);
}
~~~

~~~http
注意 ,报反射异常很可能是因为没有无参构造函数或者是抽象类
~~~

