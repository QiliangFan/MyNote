# 1. HDFS

### 1. 虚拟化技术&常用操作

 1. VMware
    $$
    \begin{cases}
    ESX-Server(也有ESxi ) \\
    Workstation
    \end{cases}
    $$

2. VirtualBox (oracle)
3. MS virtual : virtural PC(32位) -> Hyper-v(64位)

~~~xml
卸载Hyper-v：
控制面板 ->windows功能-> 禁用Hyper-v
禁用Hyper-v的服务
命令：取消自动启动。。。
卸载对应的虚拟网卡
~~~

4. Mac pa...  厉害的虚拟化
5. Docker

## 2. Hadoop 集群准备

​	VMware启动 => 启动三台虚拟机

​	启动Xshell

启动Hadoop集群（sbin 是存放shell脚本的地方）

​	start-dfs.sh

​			验证：

​	start-yarn.sh  ( 启动资源管理)

​	etc文件下的配置文件：

sercondary namenode 会将 namenode数据拷贝过去（都是master）



jps  （java processes) :查看节点运行情况



namenode 将数据加载进来，并进行操作和日志记录， 同时一段时间就将数据拷贝到Secondary namenode



Secondary namenode: 



namendoe:提供所有元信息：包括数据位置（提供并生成 数据的注册信息）



datanode：数据块（存储数据）



#### ×××操作HDFS的文件命令：

~~~shell
hdfs dfs  -ls  <path>   # hadoop dfs -ls /    是比较老的命令，不推荐用 列出文件目录
hdfs dfs  -put  <localfile>   <hdfsfile>   #上传本地文件到hdfs文件目录中
hdfs dfs   -get  <hdfs file>  <local ifle  or  dir>   #将hdfs中文件保存为本地文件或放在本地某个目录下，拷贝多个文件时要为文件目录
hdfs dfs  -rm  <hdfs file>   #删除hdfs中某个文件
hdfs dfs  -rm  -r <hdfs dir>  #删除hdfs 中某个文件夹
hdfs dfs  -cat  <hdfs file>  #查看hdfs下某个文件
hdfs  dfs  -mkdir <hdfs path>   #创建目录
hdfs  dfs  -mkdir -p  <hdfs path>  #递归创建目录
hdfs  dfs -cp  <hdfs file>  <hddfs file>
hdfs dfs  -mv <hdfs file>   <hdfs file>
~~~





### 3.  Java&Python API  <-> HDFS

~~~toml
程序开发模式：
	1. 程序的编写
			Local
				安装Hadoop的LInux上安装Eclipse编写代码//极其不推荐
			Remote
				在本机中安装Eclipse并编写代码
	2. 程序的运行
			Local  exec：
				必须将自己的程序打包成jar包
				必须将jar包上传
				必须用 hadoop  jar  来执行这个jar
            IDE中执行：
            	pure : Maven java项目来操作HDFS
            	plugin : 
            			1.  下载对应Hadoop版本的plugin （github上搜hadoop3 eclipse）
            			//不推荐
~~~

~~~java
//operate hadoop  by java
//  maven =>  quickstart archtype => dependies:  hadoop  client
// Hadoop  by  java URL
package com.liang.hadoop;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestHadoopByUrl {
    //只做一次！开启（注册）HDFS协议，让java Url对象可以识别hdfs的地址
    static {  //静态代码块,只在当前类被首次访问时执行一次
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }


    private static String hdfsURL = "hdfs://master:9000/liang/1.txt";
    //url 和端口可在web UI中看到(可配置)

    private static void copyToLocal(String hdfsurl) throws Exception {
        //生成URL对象
        URL url=new URL(hdfsurl);
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();

    }


    public static void main(String[] args) throws Exception {
        //从hadoop上下载文件到本地
        copyToLocal(hdfsURL);  //只能获取单向的输入流
        //一般在下载资源的时候操作
    }
}
~~~

~~~java
//Java FileSystem API
//设置java程序的操作者用户为icss ，
// 设置Windows 下的Hadoop 运行程序
package com.liang.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

public class TestHDFSByFSApi {
    //设置windows 环境变量：HADOOP_USER_NAME - icss
    static {
        System.setProperty("HADOOP_USER_NAME", "icss");
    }

    public static void main(String[] args) throws IOException {
        //宿主机中安装配置hadoop的运行环境（不要侵入式程序）
        //其实就是hadoop的 bin 和sbin下的数据
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") != -1) {
            //运行在windows系统下
            System.setProperty("hadoop.home.dir", "<你的windows hadoop运行环境>");
        } else {
            /**/
        }
        //获取URL
        String hdfsURI = "hdfs://172.16.169.10:9000/";

        //获取hadoop的配置文件：
        Configuration conf = new Configuration();
        URI uri = URI.create(hdfsURI);
        FileSystem fs = FileSystem.get(uri, conf);
        String coreSiteXml = "hdfs://master:9000/input/core-site.xml";
        Path src = new Path(coreSiteXml);
        Path dst = new Path("src/1.xml");

        fs.copyToLocalFile(src, dst);

        fs.getStatus();
    }
}
~~~



### 4.  HDFS运维命令（注意环境变量）

~~~c++
jps   //nodes  that is running 
start-yarn.sh   //resources manager node
start-dfs.sh    //hdfs's file manage system node
hdfs  -daemon  start namenode    //start  a  single  node  by  assigned{namenode , secondarynamenode}  [start ,stop]
hdfs  -daemon start datanode   //should  exec  on  datanode-machine
hdfs  -daemons start datanode   //stat serveral  datanodes,  should exec  on  namenode machine
yarn  -daemon start  resourcemanager   //should  exec on resourcemanager machine
yarn  -daemon start  nodemanager   //should  exec on nodemanager machine
    //generally, resoucemanager machine  equals to namenode machine

    //safe mode's  open and close
    hdfs dfsadmin safemode leave|enter|get
    
    //hadoop system status
    hadoop version
    hadoop classpath
    hadoop  jar   <mainClass or  mapreduce jar file>//run  a  program (java jar  is  not recommand)
    hadoop fs ==  hdsf dfs
    
    hadfs namenode  -format  //格式hdfs文件系统
    hdfs classpath
    hdfs  namenode | secondarynamenode  //insepect  the status of namenode | secondarynamenode
    hdfs datanode
    hdfs  fsck  //查看是否有坏块
        
~~~

#### 5. hdfs 指令

~~~c
// 上面有些常用的文件操作
http:ip:9870   //进入hadoop的网页管理端， ip为节点ip, 默认为master 的ip ， 端口默认9870  
    
    
    hdfs  dfs -head <file>
    hdfs dfs -tail  <file>    //看文件中几行
    
    hdfs  dfs -chmod  ... 
    hdfs  dfs  find <filename> 
    
    hdfs  dfs -copyFromLocal <localsrc>  <dst>
    hdfs  dfs  -copyToLocal  <src>   <locadst>    //不推荐这两个 ，用-get 和-put
    
   hdfs  dfs  -getmerge     //上传文件时将其合并以将其凑成一个块
~~~



~~~xml
<!--取消web ui的上传限制-->
<propertyy>

		<name>dfs.permissions</name>

		<value>false</value>

</property>  
~~~

