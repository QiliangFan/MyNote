# 1. 环境配置:

- java jdk的配置
- maven 的配置
- tomcat 的配置

# 2. Idea配置:

1. 配置jdk和libraries :

   ​	File -> Project Structrue

2. 配置Maven:

   ​	File -> Settings -> Build, Execution,Deployyment -> Maven

   ​	选择本地仓库位置,  选择maven配置文件settings.xml位置

3. 创建Maven项目:

   记住勾选{ Create from archetype }  =>  选择  webapp的骨架

4. 配置工程目录

   src/main下,新建java  . resource  , 分别mark as  Sources root 和 Resources root

   新建test , test下新建 java, java文件夹 mark as => Test Sources root

5. Add Configuration

   添加Tomcat配置

上传文件功能如果出错:

~~~xml
<!--web.xml-->
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
<!--    <multipart-config>-->
<!--      <max-file-size>20848820</max-file-size>-->
<!--      <max-request-size>418018841</max-request-size>-->
<!--      <file-size-threshold>1048576</file-size-threshold>-->
<!--    </multipart-config>-->
  </servlet>
  <servlet-mapping>
    <servlet-name>springmvc</servlet-name>
    <!--控制所有访问url-->
    <url-pattern>/</url-pattern>
  </servlet-mapping>
</web-app>
~~~

~~~xml
<!--springmvc-servlet.xml-->
<?xml version="1.0" encoding="UTF-8"?>
<!--这样写,spring mvc会查找最新的标签,而且还少几个组件-->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
         http://www.springframework.org/schema/mvc
         http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    <!--由上可知,可以使用context\xsi\p, p是property的简写-->
    <mvc:annotation-driven/>
    <context:component-scan base-package="com.liang.test.controller"/>

<!--    <bean id="multipartResolver" class="org.springframework.web.multipart.support.StandardServletMultipartResolver"/>-->

    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="1024000"></property>
    </bean>

    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>
    <!-- 直接去Anotated Controllers中找 -->

</beans>
~~~

