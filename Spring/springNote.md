# 1. Spring MVC初步

## 	1. new maven project:

​			创建骨架(artifact)- webapp

### 1.添加 servlet-api 依赖(其实可以将tomcat作为server runtime加入

~~~xml
依赖中,<scope></scope>中
<scope>provide</scope> 开发时用制定的jar包构建,发布时则不提供,由用户自己的来支持依赖
<scope>test</scope> 表明只在开发测试时使用,发布时则不包含在内

eg:
<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
</dependency>
~~~

### 2.目录结构:

~~~txt
Deployment Descripor: 时web.xml中内容,表示发布信息
Java Resources: 是所有源代码和静态配置文件的目录
Java Script Resources: 外部js库
Deployed Resources:发布资源,我们不需要管
target: 构建目录, 里面会有war包
src: resources->项目中所有的配置文件(相当于放在src文件根目录下的配置文件)
	webapp->项目中的jsp文件
	{去src/main/resources发现,有个同名文件夹.这其实就是resources文件夹)
	
 !!!{{事实上,去看编译输出目录,resource和main是同一个编译输出目录!!!}}
~~~

~~~http
注意:eclipse可能默认不显示空文件夹, build path中,将报错的missing文件夹remove,再手动建立.
但要注意,test文件夹的编译输出目录,与普通java源码编译输出不同路径:test-classes
~~~

~~~http
src/main/java   ->写java代码
src/main/resources   ->Config file
src/main/webapp     ->所有前端页面
src/test/java  -> TestCase
...
...
~~~

### 3. 添加Spring web MVC依赖(包含了众多spring相关jar)

​	1.在web.xml声明使用Spring MVC管理web app项目,并指明Spring MVC的配置文件的信息(名称和位置)

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://java.sun.com/xml/ns/javaee"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
	id="WebApp_ID" version="3.0">
    
	<display-name>myssm2</display-name>
	<servlet>
		<servlet-name>springmvc</servlet-name>
        <!--转发中控servlet,核心servlet-->
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--声明该springservlet的配置文件-->
        <!--默认在/WEB-INF/<servletname>-servlet.xml下-->
		<init-param>
			<param-name>contextConfigLocation</param-name>
            <!--配置文件路径(注意,classpath即编译输出路径)-->
			<param-value>classpath:springmvc-servlet.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>springmvc</servlet-name>
        <!--控制所有访问url-->
		<url-pattern>/</url-pattern>
	</servlet-mapping>

</web-app>
~~~

 2. 修改web.xml中, 声明支持servlet-3.*

 3. 完成SpringMVC的配置文件(.xml  通过schema方式描述):

    https://docs.spring.io/spring/docs/

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!--这样写,spring mvc会查找最新的标签,而且还少几个组件-->
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
<!--由上可知,可以使用context\xsi\p, p是property的简写-->
    
    <context:component-scan base-package="org.example.web"/>

    <!-- 直接去Anotated Controllers中找 -->

</beans>
~~~

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"  
        xmlns:context="http://www.springframework.org/schema/context"  
        xmlns:mvc="http://www.springframework.org/schema/mvc" 
        xmlns:p="http://www.springframework.org/schema/p"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
        xsi:schemaLocation="  
            http://www.springframework.org/schema/beans       
            http://www.springframework.org/schema/beans/spring-beans-3.0.xsd  
            http://www.springframework.org/schema/context   
            http://www.springframework.org/schema/context/spring-context-3.0.xsd  
                            
            http://www.springframework.org/schema/mvc  
            http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd">  
      <!--这里加了两个组件,用于完成spring mvc-->
	<!--在beans下加新标签, 上面加:xml:<tagname>和url, 下面加标签的url和标签的描述文件url-->
    </beans>  
~~~

4. 在spring mvc中使用注解(annotation) 管理Controller:(在spring的配置文件中)

   ~~~xml
   <mvc:annotation-driven/> 
   <!--声明项目具有MVC注解的功能-->
   
   <!--让当前项目能够识别(扫描)带有注解的控制器, 并注册到当前项目中,以备使用-->
   <!--com.test.bookshop.web.controller-->
   <context:component-scan base-package="com.test.bookshop.web.controller"/>
   ~~~

   * 声明让当前项目可以使用基于注解的控制器

~~~java
package com.**

//声明当前类为控制器类
@Controller
public class MyController{
	
}
~~~

		* 实现一个控制方法:

~~~java
//控制方法
//若控制器声明了requestmapping, 则方法的路径是相对类的requestmapping的路径!
//否则,则为绝对路径(因为  /path 就是绝对路径, 而./path才是相对路径)
@RequestMapping("/a")
public String test(){
	return "abc";
}

//以get方法访问的路径
@GetMapping("/in")
public String test1(){
    
}
~~~

* 实现一个JSP页面(称之物理视图):

  ​					***{jsp文件一般放在WEB-INF下, 这样jsp不能直接被外部访问,只能通过服务器转发访问}***

* 将逻辑视图名和物理视图完成绑定 = > 视图解析=>跳转

~~~xml
<!--spring-servlet.xml-->
<beans>
    ...
    
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    	<property name="prefix" value="/WEB-INF/jsp/"></property>
        <property name="suffix" value=".jsp"></property>
        <!--在配置文件中配置物理文件的前后缀-->
    </bean>
</beans>
~~~

~~~http
Restful (了解)
~~~

~~~http
为了实现解耦,在controller中最好不要使用 pojo以外的类!!!==>不便于Junit的测试(如以ServletHttpRequest为参数时)
~~~

~~~java
@RequestMapping("..")
public ModelAndView doLogin(){
    //ModelAndView mav=new ModelAndView("success");
    ModelAndView mav=new ModelAndView();
   	//mav.addObject("sd",obj);
    Map<String,Object> data= new HashMap<String, Object>();
    data.put("user",user.getuser());
    data.put("salary",user.getSalary());
    mav.addAllObjects(data);  //稍微优雅一点
    mav.setViewName("success");
    return mav;//返回视图信息和数据
}
~~~

~~~http
在web.xml配置了分发器urlpattern 为/, 则在controller中所有的mapping,return的 /**都是 这个/
而这个 / 是在项目根路径的基础上的即 controller中所有的/**都是:
127.0.0.1:8080/bookshop/**

然而在前端页面的的根目录是, 127.0.0.1:8080/   
!!!!!!! 因为前端访问以域为根!!!!
~~~

### 4. 跳转

~~~java
1. 转向 - 转发{ 通过URL重写带有参数}
2. 	page - page 
		href <=> url转向
	page - controller
		href <=> url转向
		form submit action  = url 提交跳转
	controller - page
		url 转向 \ 转发
     controller - controller
     	url 转向 \ 转发
//这一切的前提是jsp被视图解析器解析, 而controller 要也已经被注册
~~~









~~~python
postman : 接口测试工具
websockt: 基于spring 的网页通信技术方向
~~~

~~~JSP
<%@page contentType="text/html;charset=UTF-8" pageEncoding="utf8"%>
~~~

