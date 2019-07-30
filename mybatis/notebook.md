# MyBatis （2.0前称为IBatis）——Apache

## ** 别名是伙伴 **       **映射是朋友** 

com.test.ssm.bzis

（buziness 事务处理，放service之类的）

com.test.ssm.dao

com.test.ssm.domain.po

com.test.ssm.web.controller





1. 读入全局配置文件
2. 据此创建SessionFactory（主要是SqlSessionFactory）
3. 据此SessionFactory 创建session，
4. 借助session完成CRUD





#### 创建数据库：

new db=mydb

new table=Users(id\name\age\salary\regtime=>timestamp)





创建MyBatis的全局配置文件（默认在src下，默认名：mybatis-config.xml)->均可自定义（通过**DTD**文件描述）

设置映射配置路径（映射配置文件名字为 相应实体类名称.xml，与其同位置



借助mybatis完成数据库操作	（AA.class.getClassLoader()





#### 配置properties 

​		src\dbconfig.properties

​	在全局配置文件中，必须最先引入



#### 接口绑定

1. 声明Dao接口，声明其中的方法

2. 保证相应的映射配置文件的namespce的名称是：

    		**对应的接口的全限定名称** 

3. UserDao uDao=session.getMapper(UserDao.class);  绑定后就可以获取相应的接口的类

   uDao.findAll()  !!

   

useGeneratedKeys 表示将主键设为自增

keyProperty 表示类中属性字段    keyColumn 表示表中字段





## 7_27

应用系统开发时 ，表名在数据库中是小写的，但在应用开发中表名首字母大写，mysql不分大小写

数据库对象命名规范？！！（做到自己建的表，别人一看就知道什么意思

### MBObject 命名规范:

#### 	表名：

​				1. 实体表：名词复数（满足Pascal命名规范，每个单词首字母大写。)

​						或者：表名以T开头、tbl_name、

​				2. 关系表：名词And名词，满足Pascal命名规范

#### 	字段名：

​					camel命名规范！

#### 	索引名：

​					idx_indexname

#### 	外键名：

​					fk_一表实体名\_ 多表的实体名    一对多外键映射

​				

## 编程的开发规范：

​	（阿里巴巴的开发规范）

## 前端开发规范：

​		***（作业：主键的种类，建议使用的主键类型。）*** 

varchar(20) 可以支持20个中文字符和英文字符，现在大多支持Unicode

数据库中到底要不要建外键，更倾向于不建立外键关系！（练习时要建，熟悉

有含义的数字串作为varchar更好	

mydb-》

使用mybatis 实现数据库中的关联关系

​	Peoples(id ,name , passportId)

​	Passports(id, seriaIno, expire)

​	Presses(id, name, address)

​	Books(id, name, isbn, price, priceId)

​	Authors(id, name ,gender )

​	BookAndAuthor(id, bookId, authorId)



### 开发环境的准备：

 1. 动态项目3.0 

 2. 勾选generate xml

 3. 转化为Maven项目

 4. grooup id是仓库名字：一般叫 com.test.**

 5. Artifact id :文档名

 6. 添加依赖：pom.xml中

 7. 去maven中央仓库 mvn中寻找

 8. 添加到pom.xml中：(Maven会自动把添加的jar包的依赖也下载)

    ~~~ xml
    <dependencies>
    	<dependency>
            <groupId></groupId>
            <articfactId></articfactId>
            <version></version>
        </dependency>
    </dependencies>
    ~~~

9. 创建项目构架-package

   ​	com.test.ssm.dao	



### MyBatis 基于接口绑定的开发的关联关系实现：

### 	1. 创建实体类

User

People、Passport、Press、Book、Author

​	

#### 构造函数：全构造，无参构造，无自增ID构造，无关联关系属性构造（一般这四种）

toString（）方法不要无脑输出，应当输出我们关注的属性



### 2.  创建系统全局配置文件

​	src下 右键新建xml文件 ：添加解释xml文件的dtd文档 url  （MyBatis帮助文档中找）

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!-- MyBatis 系统全局配置文件 -->
<configuration>
	<!-- 0. 读入属性配置文件 -->
	<properties resource="dbconfig.properties"/>
	<!-- 1. 设置实体类别名, 实体类别名是伙伴  -->
	<typeAliases>
		<typeAlias type="com.test.ssm.domain.po.User" alias="User"/>
	</typeAliases>
	<!-- 2. 配置环境，并指定默认的环境 -->
	<environments default="devlopment">
		<environment id="devlopment">
			<!-- 2.1 指明事务管理器 -->
			<transactionManager type="JDBC"/>
			<!-- 2.2 指明、设置数据源 -->
			<dataSource type="POOLED">
				<!-- 通过四个属性，给出数据源的信息 -->
				<property name="driver" value="${driver}"/>
				<property name="url" value="${url}"/>
				<property name="username" value="${usn}"/>
				<property name="password" value="${pwd}"/>
			</dataSource>
		</environment>
	</environments>
	<!-- 3. 指明映射配置文件的名称和位置 -->
	<!-- 推荐：映射配置文件和实体类同位置，名称实体类名称.xml -->
	<mappers>
		<mapper resource="com/test/ssm/domain/po/User.xml"/>
	</mappers>
</configuration>
~~~

映射配置文件：

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- <mapper namespace="my.mybatis.dao"> -->
<mapper namespace="com.test.ssm.dao.UserDao">
	<select id="findById" parameterType="int" resultType="User">
		select * 
		from Users 
		where id = #{id}
	</select>
	<select id="findAll" resultType="User">
		select * 
		from Users
	</select>
	<insert id="insert" parameterType="User"
		useGeneratedKeys="true" keyProperty="id">
		insert into Users 
		values (null, #{name}, #{age}, #{salary}, #{regtime})
	</insert>
	<update id="update" parameterType="User">
		update Users 
		set name = #{name}, age = #{age}, salary = #{salary}, regtime = #{regtime} 
		where id = #{id} 
	</update>
	<delete id="delete" parameterType="int">
		delete from Users 
		where id = #{id}
	</delete>
</mapper>
~~~

BNF编程语言描述：

~~~c++
| 或
[]  表示可选
{}   表示内容出现0次到无限次
？ 内容可出现0次或一次
+   里面的内容可出现一次或多次
*   里面的内容可出现零次或多次
::= 定义
~~~

### mybatis-config.dtd

~~~dtd
<?xml version="1.0" encoding="UTF-8" ?>
<!--

       Copyright 2009-2016 the original author or authors.

       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at

          http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.

-->
<!ELEMENT configuration (properties?, settings?, typeAliases?, typeHandlers?, objectFactory?, objectWrapperFactory?, reflectorFactory?, plugins?, environments?, databaseIdProvider?, mappers?)>

<!ELEMENT databaseIdProvider (property*)>
<!ATTLIST databaseIdProvider
type CDATA #REQUIRED
>

<!ELEMENT properties (property*)>
<!ATTLIST properties
resource CDATA #IMPLIED
url CDATA #IMPLIED 可选
>

<!ELEMENT property EMPTY>
<!ATTLIST property
name CDATA #REQUIRED
value CDATA #REQUIRED
>

<!ELEMENT settings (setting+)>

<!ELEMENT setting EMPTY>
<!ATTLIST setting
name CDATA #REQUIRED
value CDATA #REQUIRED
>

<!ELEMENT typeAliases (typeAlias*,package*)>

<! 如果使用 package只要使用 name=包名，就可将包下的类全部改名为短类名-即去掉全限定类名>

<!ELEMENT typeAlias EMPTY>
<!ATTLIST typeAlias
type CDATA #REQUIRED
alias CDATA #IMPLIED
>

<!ELEMENT typeHandlers (typeHandler*,package*)>

<!ELEMENT typeHandler EMPTY>
<!ATTLIST typeHandler
javaType CDATA #IMPLIED
jdbcType CDATA #IMPLIED
handler CDATA #REQUIRED
>

<!ELEMENT objectFactory (property*)>
<!ATTLIST objectFactory
type CDATA #REQUIRED
>

<!ELEMENT objectWrapperFactory EMPTY>
<!ATTLIST objectWrapperFactory
type CDATA #REQUIRED
>

<!ELEMENT reflectorFactory EMPTY>
<!ATTLIST reflectorFactory
type CDATA #REQUIRED
>

<!ELEMENT plugins (plugin+)>

<!ELEMENT plugin (property*)>
<!ATTLIST plugin
interceptor CDATA #REQUIRED
>

<!ELEMENT environments (environment+)>
<!ATTLIST environments
default CDATA #REQUIRED
>

<!ELEMENT environment (transactionManager,dataSource)>
<!ATTLIST environment
id CDATA #REQUIRED
>

<!ELEMENT transactionManager (property*)>
<!ATTLIST transactionManager
type CDATA #REQUIRED
>

<!ELEMENT dataSource (property*)>
<!ATTLIST dataSource
type CDATA #REQUIRED
>

<!ELEMENT mappers (mapper*,package*)>

<! 使用 package 也可指定一个包，包下的所有类与 相应的 xml映射文件被关联，同时 xml映射文件被导入>

<!ELEMENT mapper EMPTY>
<!ATTLIST mapper
resource CDATA #IMPLIED
url CDATA #IMPLIED
class CDATA #IMPLIED
>

<!ELEMENT package EMPTY>
<!ATTLIST package
name CDATA #REQUIRED
>
~~~

上面要注意textAlias 和 mapper时package的用法！

##### Dao

​	编写UserDap（也叫UserMapper）	





## N+1问题：

### 	1.  1对1关系：

   1. 两次查询(查询指定ID用户及其拥有的护照）：select * from Peoples where id=#{id};    select * from Passports where id=#{passportId}

      （查询全部用户及其各自拥有的的护照）：select * from Peoples;   select * from Passports where id =#{passportId};[1+N 操作]

   2. 一次查询：

      ~~~mysql
      select Peoples.*, PassportId.*
      from peoples inner join passports on peoples.passportId=passport.id;
      ~~~

      ~~~xml
      <resultMap type="People" id="GetPassportByPassportId">
      		<id column="id" property="id"/>
      		<result column="name" property=""/>
      		<association property="passport" column="passportId" select="byPassportId"></association>
      </resultMap>
      ~~~

      id 表示主键字段

      result 表示普通字段

      association 表示外键映射（select 表示如何从column到property映射的sql语句）

      美中不足之处在于，passport中的people无法赋值

      

### 2. 1对多关系	

​				多的一边：****

​				一的一边：



### 3. 多对多关系：	

~~~js
AuthorDao
Author.xml


~~~





# 如果MyBatis的xml文件没有进入编译的class文件夹内:

~~~xml
<!--在pom.xml中配置build-->
<resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
</resources>
~~~

