# 1. 配置fiddler

(运行python爬虫时记得把fiddler关了,不然太慢了)

 1. tools->options->https

     	1. 勾选captrue https
          	2. 勾选decrypt https trafic
               	3. 勾选ignore xxx
                    	4. 点击Action ,信任证书
                         	5. 关闭重启fiddler

 2. 抓包

     	1. <>: html内容
          	2. ...其他图标(主要关注json,很有可能是前后端接口,)
               	3. file-> capture traffic (f12)  反选,停止监听

 3. 点击请求, 由窗口选中inspectors. 

     1. 右上:http请求信息(Raw分窗口中有请求头中所有原本信息)

        ​				(webforms:中是请求时带的数据, 一种是query string ,一种是 form datas)

     2. 右下:http响应信息(首先点击decoded, 将响应的内容解压缩. 后台传输到前台的数据一般是压缩的)

        ​			(Raw中同样是所有的响应头的信息)

        ​			(ImageView 对于图片请求,显示图片)

        ​			(**json** 窗口可以看到json数据)

        ​			(xml 可以看到xml数据)

4. 坐下黑色框可以快捷输入指令: 
   1. clear  清除所有请求
   2. select json:选择所有json (image , html,...)
   3.  ?内容 :搜索包含内容的所有请求, 回车执行

# 2. urllib 库

​	{模拟浏览器发送请求的库,Python3自带}(目前网上关于这个块的博客还大多是python2的)

## 1.使用的模块: urllib.request   urllib.parse(分别对应python2 的urlib 和 urllib2)

## 2.urllib.request

 1. urllib.request-> {urlopen  ,urlretrieve}

     1. 发送请求:  response=urllib.request.urlopen(url=myurl)

         1. response方法:

             1. read()  读二进制内容即字节类型(b 开头)

                encode 字符串转化为二进制

                decode  二进制转化为字符串(参数默认为"utf-8")

                *写入文件中*

                ~~~python
                with open('baidu.html','w',encoding="utf8") as fp:
                    fp.write(response.read().decode())
                ~~~

                

             2. geturl() 获取url地址

             3. getheaders() 获取header, 一个列表, 里面是元组(可直接用dict转化为字典)

             4. getcode()  获取状态码 如200

             5. readlines() 按行读取,返回列表(字节数据)

             6. 下载图片:(图片是二进制的!而read读取的数据本来就是二进制) 

                 1. 获取图片url
                 2. 通过request 的urlopen获取信息
                 3. 将内容(本身就是二进制)保存在文件中, 后缀要注意!

         2. urlretrieve方法

             1. urlretrieve(url, filename) 读取url内容并保存在文件中

## 3.urllib.parse

(url 只能由字母 数字 下划线组成,***如果出现中文, 需要编码***-浏览器窗口中的中文是浏览器进行了处理)

1. urllib.parse.quote(str): 将 冒号中文等进行编码
2. urllib.parse.unquote(str): 将编码的字符串进行解码:(注意http后的:不需要编码,故而进行编码时,应注意适当拼接)
3.  urllib.parse.urlencode(dict): 将字典传入, 会生成querystring(如果有中文还会对其进行编码, q1=sd&q2=ds

~~~python
lt=[]
for k,v in dict_data.items():
    lt.append(k+"="+str(v))
query_string='&'.join(lt)   #通过字典合成query的字符串
~~~

## 3.构建get请求:

​	通过url后连接queryString 构建即可

***注意*** : url='http://www.baidu.com/'   加上最后的斜线才是完整的url, 否则有时还可能报错(浏览器中会自动添加)

## 4.构建请求头部信息(反爬虫第一步)

​	User Agent(用户代理):python发送请求时,ua是对应的库,这样很容易被封禁,需要伪装自己.

 1. 构建请求对象: **urllib.request.Request()**

 2. 步骤

    ~~~python
    hreaders={
        'User-Agent':'...'
    }
    request=urllib.request.Request(url=url,headers=headers)
    response=urllib.request.urlopen(request)
    
    print(response.read().decode())
    ~~~

    User-Agent

    ~~~htt
    IE6.0:Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)
    IE7.0:Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)
    IE8.0:Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)
    IE9.0:Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1)
    Firefox3.5:Mozilla/5.0 (compatible; rv:1.9.1) Gecko/20090702 Firefox/3.5
    Firefox3.6:Mozilla/5.0 (compatible; rv:1.9.2) Gecko/20100101 Firefox/3.6
    Firefox4.0:Mozilla/5.0 (compatible; rv:2.0) Gecko/20110101 Firefox/4.0
    Firefox6.0:Mozilla/5.0 (Windows NT 6.1; WOW64; rv:6.0.2) Gecko/20100101 Firefox/6.0.2
    Chrome11.0:Mozilla/5.0 (compatible) AppleWebKit/534.21 (KHTML, like Gecko) Chrome/11.0.682.0 Safari/534.21
    Opera11.0:Opera/9.80 (compatible; U) Presto/2.7.39 Version/11.00
    Maxthon3.0:Mozilla/5.0 (compatible; U) AppleWebKit/533.1 (KHTML, like Gecko) Maxthon/3.0.8.2 Safari/533.1
    Android:Mozilla/5.0 (Linux; U; Android 2.2) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 
    
    iPhone:Mozilla/5.0 (iPhone; U; CPU OS 4_2_1 like Mac OS X) AppleWebKit/532.9 (KHTML, like Gecko) Version/5.0.3 Mobile/8B5097d Safari/6531.22.7
    
    iPad:Mozilla/5.0 (iPad; U; CPU OS 4_2_1 like Mac OS X) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/4.0.2 Mobile/8C148 Safari/6533.18.5
    
    Safari5.0:Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_7) AppleWebKit/534.16+ (KHTML, like Gecko) Version/5.0.3 Safari/533.19.4
    ~~~

    

3. 注意,伪装UA时,有些网站会转为使用https协议, 程序要求验证ssl证书,从而报错.

   解决方案:

   ~~~python
   import ssl
   ssl._create_default_https_context = ssl._create_unverified_context
   ~~~

## 5.  构建POST请求:(www.json.cn )

流程:

1. 得到url

2. 建立数据字典

3. 设置请求头

4. 构建请求对象

5. 处理POST表单数据:

   ~~~python
   form_data=urllib.parse.urlencode(form_data).encode()     #将数据编码为字节数据(http请求响应也都是字节数据)
   ~~~

   

6. 发送POST请求:

   ~~~py
   response=urllib.request.urlopen(request,data=form_data)
   ~~~

7. 接收响应数据(由于post请求多为ajax,响应内容多为json或小部分xml):

   ~~~python
   reponse.read().decode() #获取json内容,是unicode数据字符
   #可以去在线json解析网站解析
   ~~~

8. **注意!** 接受的数据如果有中文往往不能正常显示,可以:

~~~python
result=json.loads(response.read())
with open("my.json","w") as fp:
    print(json.dump(result,fp,ensure_ascii=False))
~~~

这样,打印和存入文件就能显示为中文了(需要控制台和文件支持gbk编码)

loads函数的效果会随json编码变化而变化.

[ fidder 中,一个文本,上面有个箭头的图片,表示post请求]

## 6.发送POST请求得到的json数据有误

1. 可能未正确模拟浏览器, 只加UA可能仍然不够,需要把headers, 补全完整, 在fiddler中抓包获取headers完整信息, 随后添加.
2. 当把headers添加完整后, 再去看***Accept-Encoding***, 是不是 gzip之类的,这样的结果是无法正常解码的. 同样的, ***Content-Length*** 也不是必要的
3. 试图提交表单数据时,某些数据项根据内容动态变化, 即加密措施.此时需要去网页中寻找js文件,查找相应登陆参数生成方法.

## 7. AJAX请求捕获

### 	1. 捕获get请求:(豆瓣电影排名,右边子模块, 动作\喜剧\\...)

### 	2. 捕获post请求:百度翻译\肯德基的翻页

(要善于分析参数信息中无效的参数,以及有规律的参数, 要多尝试)

## 8. Error(异常处理try-except):

*urllib.error* 下有两个异常类:URLError, HTTPError

### 1. URLError

* 产生情况:
  	* 没有网
  	* 服务器连接失败
  	* 找不到指定的服务器

### 2. HTTPError

 * 是*<u>URLError的子类</u>*,(注意捕获顺序)产生情况:
   	* e.code  可以打印错误码

## 9. Handler处理器/自定义Opener

​	urlopen() 给一个url, 发送请求, 获取响应(缺点, 不能定制头部,需要自己加)

​	Request 类, 通过这个对象定制请求头,创建请求对象.

以上两个无法实现的高级功能:

	* 使用代理_当ip被封时, 不能通过代理继续访问
	* cookie无法使用,只能在请求头中手动加cookie,过于麻烦.

### 1. Handler类和Opener类的使用:

~~~python
#注意使用不同高级功能时,Handler类型也不一致
handler = urlib.request.HTTPHandler()
opener = urllib.request.build_opener(handler)
#构建请求对象
request = urllib.request.Request(url, headers = headers)
#发送请求
response = opener.open(request)
~~~

### 2. 代理(proxy):

​	1.含义:

			* 正向代理: 在使用爬虫时,当同个频繁访问一个服务器时,就可能会被封禁.将请求发给代理服务器,代理服务器转发给目标服务器, 代理服务器将response返回. 如果能同一时间段随机使用一个代理服务器,对目标服务器访问时,就可以避免被检测到进而封禁IP.[代理客户端获取数据]
			* 反向代理: 服务器有多个**镜像服务器**, DNS服务器根据某种规则,将请求分发给最优的服务器.[代理服务端提供数据]

2. 透明代理\匿名代理\高匿名代理

3. www.kuaidaili.com 上面有免费的代理服务器(一般都不好用

   西刺代理 这个网站也有免费的代理服务器(有点慢)

4. **浏览器配置代理服务器**

设置->高级->打开代理设置->局域网设置->代理服务器->设置ip地址和端口

5. 筛选代理是否可用的软件:ProxyThorn

   最好首先将免费代理都爬取, 放在txt文件中

   ~~~htt
   ***.***.***.***:port
   ~~~

6. **代码设置代理** :

~~~python
dic={
    'http':'113.79.75.104:9797'
}
handler = urllib.request.ProxyHandler(dic)
opener = urllib.request.build_opener(handler)
url = "..."
headers = {
    'User-Agent':'...'
}
request = urlib.requets.Request(url,headers=headers)
response = opener.open(request)
~~~

### 3. Cookie 模拟登陆:

{根源于HTTP的无状态,却又需要保存数据}=>多用于登陆验证时提供身份信息

在headers中添加cookie, 如果还不行就将抓包抓取的headers全部复制进去

~~~tex
代码保存cookie,用于进一步操作.

~~~

~~~python
import http.cookiejar

cj=http.cookiejar.CookirJar()
handler = rullib.request.HttpCookieProcessor(cj)
opener = urllib.request.build_opener(handler)
requet= ...
opener.open(request,data=form_data)

#用这个opener.open 发送请求,服务端返回的cookie会保存在opener中!
#通过这种opener就可以模拟真实浏览器
~~~

