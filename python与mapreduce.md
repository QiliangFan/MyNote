# 1. python虚拟环境:

~~~shell
#安装第三方库
pip intstall  virtualenv

#生成虚拟环境的目录
virtualenv  <虚拟环境目录名称>

#开启创建的虚拟环境
#进入对应虚拟环境的Scripts目录下
activate  
deactivate
~~~

# 2. python 数据爬取



~~~http
注意要在本机上配置hosts文件,  要对应hadoop分布式系统的ip
~~~



注意选包, 在Release History中看更新历史来选包r

~~~http
http://pypi.org
~~~



用setuptools  安装带有setup.py的包

~~~http
https://www.lfd.uci.edu/~gohlke/pythonlibs/
~~~

用python  install   **.wheel

~~~python
from hdfs import Client

url = "http://172.16.160.10:9870"
client = Client(url)
hdfs_path = "/input/"
client.download(hdfs_path,"liang/");
~~~

# 3. python操作Mapreduce

 	1. 数据准备:
     * 本地(Windows\ linux)
     * 集群(HDFS)
	2. 代码:
    * .py  -> mapper
    * .py  ->  reducer
    * 投入运行的命令: controller    => eg: python3 mapper.py| sort| python3 reducer.py

3. 语法:
   * python 3.* (print语句有括号) 
   * python 2.*  (print语句无括号)

4. 投入运行\查看结果(借助管道流实现MR)

   0 - words.txt上传到Linux

   1 - mapper.py 和 reducer.py 上传到Linux上

   2 - 注意语法和python版本的问题

   3 - 结束循环输入:    ctrl + z

   4 - 管道流 :  cat  words.txt |  python mapper.py 

   5  - linux 和 windows 下的一个排序函数: sort  =>  cat  words.txt |  python mapper.py | sort  -k  1

   ~~~http
   sort的参数 -k  表示按第几列排序
   ~~~

   6 - 调用reducer: 

   ~~~shell
   cat words.txt | python mapper.py | sort -k 1 | python reducer.py
   ~~~

#### * 在集群的HDFS上执行python操作Mapreduce

​	0 - words.txt 上传到HDFS上 =>  hdfs  dfs  -put  ~/data/words.txt    /input/py/wcinput

​	1 - hadoop 根目录的share/lib下有hadoop-stream.jar  来使hadoop支持管道流(版本不同可能位置不同)

​	2 - hadoop  jar  hadoop3/share/hadoop/tools/lib/hadoop-stareaming-3.1.2.jar  - files  'mapper.py,reducer.py '  

-input  /input/py/wcinput   -ouput  /output/py/wcoutput01 -mapper 'python mapper.py'  -reducer  'python reducer.py'

~~~http
'引号内的不能有多余空格'!!!
-files 指明需要分发到其他节点的文件(引号任意, 不同文件逗号分割)
-input  指定输入目录
-output 指定输出目录 (也不能存在)
-mapper 后接jar包| 后接python脚本 (必须要单引号)  {如果为python还必须加上python执行指令}
-reducer 指定 reduce操作 , 操作与mapper差不多
~~~



~~~http
csv 文件以文本展示时, 以逗号分割, 单元格内的逗号以文本显示时会加上双引号.
python可以很容易分割csv文件,java则需要一些更多的操作
了解 这三个正则匹配
(?:)
(?=)
(?!)
~~~

