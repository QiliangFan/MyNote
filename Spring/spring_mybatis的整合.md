1. 添加依赖

   * Spring-web mvc依赖
   * Spring jdbc 版本要与Spring webmvc一致
   * 添加mybatis的相关依赖:MyBatis  \  MyBatis-Spring(完成Mybatis和spring的整合)
   * mysql jdbc接口 
   * 导入数据库连接池依赖:  使用DBCP, ->DBPool 连接池(DBCP 和DBCP2 差别不大)

2. 创建\ 编写SSM的配置文件

   * web.xml => 声明当前项目使用spring完成整合管理 , 指明整合配置文件名称和位置

   ~~~js
   在web.xml最前面声明一个监听器:org.springframework.web.context.ContextLoaderListener,用于管理整个项目,表明spring是管理整体项目的
   ~~~

   ~~~xml
   //web.xml
   <!--指明spring整合配置文件位置-->
     <context-param>
       <param-name>contextConfigLocation</param-name>
       <param-value>classpath:spring/spring-config.xml</param-value>
     </context-param>
     <listener>
         <!--使用监听器是为了让他更早执行-->
       <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
       <!--默认配置文件放在 /WEB-INF/applicationContext.xml,可以自行指定-->
     </listener>
   ~~~

   事实上. 可以注意到, spring整合配置文件和spring配置文件可以是同一个

   * springmvc的配置文件

   

   * 编写整合配置文件

   ~~~xml
   <!--spring-config.xml-->
   <?xml version="1.0" encoding="UTF-8"?>
   <!--添加schema,完成业务逻辑层和数据访问层的配置-->
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:p="http://www.springframework.org/schema/p"
          xmlns:context="http://www.springframework.org/schema/context"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
   
   <!--整合mybatis,读入dbconfig.properties-->
       <bean id="propertyPlaceholderConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
           <property name="location" value="classpath:dbconfig.properties"></property>
       </bean>
       
    <!--声明\配置 dataSource-->
       <!--spring 在BeanFactory中创建了一个这样的数据库连接池bean-->
       <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
           <property name="driverClassName" value="${driver}"></property>
           <property name="url" value="${url}"/>
           <property name="username" value="${usr}"></property>
           <property name="password" value="${pwd}"></property>
           <property name="maxIdle" value="${maxIdle}"></property>
           <property name="initialSize" value="${initialSize}"></property>
           ...
       </bean>
       
    <!--声明\配置 SqlSesionFactory -->
       <!--SqlSessionFactory Bean sqlSessionFactoryBean=...-->
       <!--sqlSessionFactoryBean.setDtaSource(dataSource)-->
       <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
           <property name="dataSource" ref="dataSource"></property>
           
           <!--仍可以用原本的mybatis-config.xml配置文件但这样不推荐,注释掉-->
           <property name="configLocation" value="mybatis-config.xml"></property>
           <!--配置别名和映射文件-->
            <property name="typeAliasesPackage" value="com.liang.test.domain.po"></property>
           
           <!--建议所有dao叫做:***mapper-->
           <property name="mapperLocations" value="classpath:mybatis/mapper/*.xml"></property>
        </bean>  
       <bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
           <!--扫描Mapper, 这样在实现控制反转时, 可以实现自动装配而不必找不到类-->
           <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
           <property name="basePackage" value="com.liang.test.bookshop.dao"></property>
       </bean>
       
       <!--不通过注解实现控制反转,非常不推荐-->
       <!--需要注意是否有set \ get方法-->
       <bean id="userMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
           <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
           <peoperty name="mapperInterface" value="com.test.bookshop.dao.Bookshop"/>
       </bean>
       
       <bean id="bookMpper" ...>...</bean>
       <bean id="bookService" class="com.test.bookshop.biz.impl.BookshopServiceImpl">
           <property name="bookMapper" ref="bookMapper"></property>
           <!--必须要为bookMapper设置set方法,否则报错-->
       </bean>
       
   </beans>
   ~~~

   ~~~properties
   #dbconffig.properties
   #1. 数据库连接信息
   driver = ...
   url = ...
   usn = root
   pwd = root
   
   #2. 数据库连接池的配置信息
   initialSize = 2
   maxActive = 20
   maxIdle = 20   #最大空闲时间, 超时回收, s
   minIdel = 5
   maxWait = 60000    #创建连接时最大等待时间 , ms
   ~~~

   

   * 
   * MyBatis配置文件=> 全局配置文件和映射配置文件

3. 将MyBatis 的功能(Dao ) 实现

   * 完成po
   * Mapper.xml
   * Mapper接口

4. 完成ssm的注入

~~~java
@Repository   //表明这是一个dao
public interface BookMapper{
}

....
//另一个文件中
@Autowired
BookMapper bookMapper;
~~~

