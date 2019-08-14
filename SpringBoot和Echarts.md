# 1. SpringBoot 搭建

~~~http
http://spring.io
~~~

~~~http
#方法0 : 创建Maven项目, 添加Spring Boot的相关依赖
		借助starter (1. 官方的   \     2. 第三方启动器)
		借助parent 父项目的描述 (管理maven依赖组件的管理)
#方法1 : 在官网上下载配置好的SpringBoot项目, 下载到本地, 解压, 以Maven项目的方式导入IDE
(注意: spring boot 默认项目导出jar包, 如果为web app项目, 还会内嵌jar包. 如果导出war包,需要自己配置很多!)
	进入 PROJECT ->Spring Boot ->  Quick Start -> 选取需要的功能模块 ->  选择最后导出的包的类型(jar)\选择java编译版本(8)
	-> 选依赖:
	Spring  Boot DevTools(支持热部署)
	Spring Web Starter
	LomBok (支持自动生成getter . setter, 构造方法   --并非必须)
	Thymeleaf (纯的html页面, 主流)  -> (为了用jsp)
	Spring Security 和  OAuth2 Client (安全方面)
	MySQL Driver 
	JDBC API  |   MyBatis Framework  | Spring Data JPA  三个选择一个,  用来实现后台与数据库交互
	{ 完成后,可以在porm.xml中看到, 所有依赖都没有版本, 都在<paraent></parent> 父项目中确定依赖}
#方法2 : 在IDE中通过插件方式,创建SpringBoot项目
	----Eclipse(安装Spring Boot 插件)
	Eclipse MarketPlace 搜索 Spring Tools -> 安装Spring tools4插件 (如果搜索不到,是eclipse版本过低)-> 
	new project -> spring ...->  操作类似于spring 官网上的操作 ->记得 jar  java8  依赖(最基本:Spring BOOT devtools , Thymeleaf , Spring starter)
	{建议取消Maven 配置中的ali镜像功能}
	
	----idea
	新建项目 -> spring initializer(或者叫spring asistant)
~~~

~~~xml
<!--pom.xml-->
...
<optional>true</optional>
<!--表示子项目不继承这个依赖-->
~~~

# 2. spring boot的使用

~~~java
@SpringBootApplication   //表示该类是spring项目的主类,运行它,就运行了spring项目, 很多配置都在此类中配置
//所有控制器 等都要在主类所在包下或子包下!

//spring配置支持两种配置文件: .properties   .yml

//所有的静态资源都默认放在static下 , 如果要指定,需要大量的配置

//template 存放所有的页面文件(SPRING默认指定)
//一旦选用Thymeleaf, 意味着放弃了jsp  ,以及jstl 
//就可以选用 springel

//test中存放测试类

//仍然用controller 注释控制器,但不再需要配置视图解析器
~~~

~~~pro
#application.properties

~~~

~~~json
整合jsp-> 去除thymeleaf依赖!
加tomcat 内嵌依赖   tomcat- embeded-jasper  (绝对不要8.5.31的!)
//需要指定版本就加, 不需要就删了,由spring boot指定
//新增依赖一般加载test依赖前面

//最好把版本都删除 ,  由spring boot管理版本
加jstl 依赖: jstl   taglib

spring boot依赖:  java servlet  API


main ->创建webapp ->创建WEB-INF

配置网站根目录:
//application.properties
spring.mvc.view.prefix = /WEB-INF/page/
spring.mvc.view.suffix = .jsp
~~~

# 3. Spring Boot 与 MyBatis的整合

1. 纯xml方式配置

~~~java
//加依赖: Mysql-Driver   ,  MyBatis spring boot starter
~~~

~~~properties
//application.properties
//注意 . properties文件的加密
mybatis.type-aliases-package=com.liang.spring1.demo.domain.po
mybatis.config-location=classpath:mybatis/mybatis-config.xml
mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/mm?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=fanqiliang
~~~

~~~java
//主配置类中,配置对dao的扫描
@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.test.springboot.dao")
public class ...
~~~

~~~java
@RequestMapping("/test")
@Respnseody
public User test(){
    return new User("laing",1);
}
//传到前台成为一个json对象
~~~

# 4. Spring JPA 的使用:

1. 添加Spring data jpa 依赖(spring-boot-starter-data-jpa)

2. 添加MySql  Driver 依赖

3. 配置热部署(Dev Tools提供)

   ​	项目修改:

   			* 源码->新的class文件
   			* 静态资源->css \ js\图片\html等
   			* 项目中用到的配置文件

   ~~~java
   //基于Devtools 实现热部署
   1. 添加热部署依赖(DevTools);
   2.  配置加入静态资源的热部署(本质是去除cache功能)
   3. 浏览器中, 开发者模式中, 禁用cache
   4. html meta标签中禁用缓存
   
   //IDE中使热部署生效
   //配置IDEA自动build源码 file->settings->complier中勾选
   //ctrl +shift+ alt + /    调用出register 界面,勾选:compiler.automaker.allow.when.app.running
   ~~~

   ~~~properties
   //application.properties
   //themeleaf 热部署
   spring.thymeleaf.cache=false
   spring.devtools.restart.enabled=true
   
   //设置重启时扫描的文件夹:
   spring.devtools.restart.additional-paths=src/main/webapp
   // spring.devtools.restart.exclude=src/**  两个*表示递归的子目录查找
   ~~~

   ~~~xml
   <!--pom.xml-->
   
    <build>
           <plugins>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
   
                   <!--在fork过程中,让热部署起作用-->
                   <configuration>
                       <fork>true</fork>
                   </configuration>
               </plugin>
           </plugins>
       </build>
   ~~~

4. 加入JPA:

   0 - 加依赖:

   1 - 配置

   ​		dataSource(driver , url, username, password)

   ~~~properties
   #application.properties
   spring.datasource.driver-class-name=com.mysql.jdbc.Driver
   spring.datasource.url=jdbc:mysql://localhost:3306/mm?serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=fanqiliang
   #配置方言
   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   
   
   spring.jpa.show-sql=true
   #如果有需要更新schema, 没有表就建立, 一切更新根据po
   spring.jpa.hibernate.ddl-auto=update 
   
   #使用配置springboot内置数据库连接池
   spring.datasource.hikari.maximum-pool-size=3
   spring.datasource.hikari.minimum-idle=5
   
   ~~~

   

   2 - 实现Dao

   ~~~java
   @Repository
   public interface UserDao extends JpaRepository<User,Integer> {
       User findByName(String name);
   
       List<User> findByAge(int age);
   
       User findByNameAndAge(String name,String age)
   }
   //JpaRepository<T, ID>    泛型分别是要操作的po 和 主键类型
   
   ~~~

   3 - 实现po

   ~~~java
   import javax.persistence.Entity;
   import javax.persistence.Table;  //注意包!! 是javax.persistence
   
   @Entity
   @Table(name="Users")
   public class User implements Serializable {
   	@Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Integer id;
       //调用save时, user中主键的自增值也会被赋值
   
       @Column(name="name")
       private String name;
   
       //不写了,名称相同自动映射
       private Date birthday;
       private Integer age;
       private Double salary;
       private Timestamp regtime;
   }
   
   ~~~

   4 - service:

   ~~~java
   import com.liang.spring1.demo.domain.po.User;
   
   public interface UserService {
       User find();
   }
   ~~~

   5 - serviceImpl:

   ~~~java
   @Component   //必须要这个才能autowired
   public class UserServiceImpl implements UserService {
   
       @Autowired
       private UserDao userDao;
   
       @Override
       public User find() {
           userDao.deleteAll(); //注意到我们根本没有deleteAll()
       }
   }
   ~~~

   6 - query关键字:

   ~~~http
   https://docs.spring.io/spring-data/jpa/docs/2.1.7.RELEASE/reference/html/#_supported_query_keywords
   ~~~

   7 - 返回json

   ~~~java
   @RestController
   @RequestMapping("/user")
   public class UserController{
       @AutoWIred
       UserDao  userDao;
       
       @GetMapping("/save")
       public  User user(){
           return  userDao.findById(1)
       }
   }
   ~~~

# 5. Spring  boot 与 JSON

## 1. @RestfulController

## 2. @ResponseBody

# 6. JSON数据来源:

1. MR中的数据 =>  json
2. 数据库中获取 =>  json字串

# 7. Spring boot的测试

1. 导入测试依赖:
2. 编写测试类

~~~java
@RunWIth(SpringRunner.class)
@SpringBootTest(classes=mySpring)  //写springboot项目的主配置类
public  class UserDaoTest{
    @Autowired
    private UserDao userDao;
    
    @Test
    public void teestFindByName(){
        User u= userDao.findByName("张三");
    	Assert.assertTrue(1==u.getId());
    }
}
~~~

