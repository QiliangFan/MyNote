# 1.配置:

## 1.web.xml中配置分发器:

~~~xml
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
~~~

## 2.在springmvc-servlet.xml 配置资源映射(视图解析 ViewResolver)

~~~xml
<!--开启mvc注解功能-->
<mvc:annotation-driven/>

<!--配置转发器的扫描路径-->
<context:component-scan base-package="com.test.bookshop.web.controller"/>

<!--配置物理视图的解析-->
<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver" >
	<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"></property>
    <property name="prefix" value="/WEB-INF/jsp/"></property>
    <property name="suffix" value=".jsp"></property>
        <!--在配置文件中配置物理文件的前后缀-->
</bean>

<!--* 表示匹配当前文件夹下所有文件-->
<!--** 表示匹配当前文件夹下所有文件以及子文件\以及子文件的子文件-->
<!--映射静态资源-->
<mvc:resources mapping="/static/**" location="/static/"/>
~~~

## 3.controller 获取数据

{ map存取键值时,key的值最好设置为value的类的首字母小写 }

### 0.  参数绑定:

~~~java
//类型不匹配时或无该参数时会使用参数的默认值
@RequestMapping("test")
public String test(@RequestParam(value="username",required=false,default="liangliang")String username,
                  @RequestParam("pwd") String password){
    
}
~~~

### 1. URI模板

~~~java
//URI 摸板
//如果URI摸板中的变量名与方法名一致,则不必指定名字
//URI模板可以从类级别和方法级别的 @RequestMapping 注解获取数据
@RequestMapping(path="/owners/{ownerId}",method=RequestMethod.GET)
public String findOwner(@PathVariable String ownerId,Model model){
    Owner owner = ownerService.findOwner(ownerId);
    model.addAttribute("owner",owner);
    return "displayOwner";
}

@RequestMapping(path="/owners/{ownerId}",method=RequestMethod.GET)
public String findOwner(@PathVariable("ownerId") String ownerId,Model model){
    Owner owner = ownerService.findOwner(ownerId);
    model.addAttribute("owner",owner);
    return "displayOwner";
}

//带正则表达式的URI摸板
//语法: {varName:regex}
@RequestMapping("/spring-web/{symbolicName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}")
    public void handle(@PathVariable String version, @PathVariable String extension) {
        // 代码部分省略...
    }
}

//路径样式的匹配
//   注意 *    **   的区别
//   /myPath/*.do
//   /myPath/*/{petid}
//   /hosts/*/pets/**

//当URL匹配多个摸板(Pattern),优先选择最准确的那个
//摸板变量和通配符数量更少的那个路径摸板更准确
//  /** 比所有其他模式都更不准确

//! 如果要允许矩阵变量的使用,必须把RequestMappingHandlerMapping类的removeSemicolonContent属性设置为false, 该值默认为true
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <mvc:annotation-driven enable-matrix-variables="true"/>
</beans>
//矩阵变量  ################################################## 伴生于URI模板路径
/* 矩阵变量可以出现在URI摸板变量中的任何位置,中间以' ; '区分不同矩阵变量, 矩阵变量的多个值用逗号隔开*/

// GET /pets/42;q=11;r=22
@RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET)
public void findPet(@PathVariable String petId, @MatrixVariable int q) {
    // petId == 42
    // q == 11
}

// 为矩阵变量指定更准确地变量
// GET /owners/42;q=11/pets/21;q=22
@RequestMapping(path = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
public void findPet(
    @MatrixVariable(name="q", pathVar="ownerId") int q1,
    @MatrixVariable(name="q", pathVar="petId") int q2) {
    // q1 == 11
    // q2 == 22
}

// 通过Map存储所有矩阵变量
// GET /owners/42;q=11;r=12/pets/21;q=22;s=23
@RequestMapping(path = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
public void findPet(
    @MatrixVariable Map<String, String> matrixVars,
    @MatrixVariable(pathVar="petId") Map<String, String> petMatrixVars) {
    // matrixVars: ["q" : [11,22], "r" : 12, "s" : 23]
    // petMatrixVars: ["q" : 11, "s" : 23]
}
~~~

### 2.筛选请求参数的条件减小请求匹配范围:

~~~java
//要求必须有某参数为某一值
@RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET, params="myParam=myValue")
    public void findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {}

//要求必须有某一参数
@RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET, params="myParam")
    public void findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {}

//要求不具有某一参数
@RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET, params="!myParam")
    public void findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {}
~~~

### 3.筛选请求头:

~~~java
//其中可以用媒体类型通配符匹配Content-Type和Accept的值
@RequestMapping(path = "/pets", method = RequestMethod.GET, headers="content-type=text/*")
    public void findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {
        // 方法体实现省略
    }
~~~

### 4. 使用@RequestHeader映射请求头

~~~java
@RequestMapping("/test")
public String test(@RequestHeader(value="Accept-Language") String al){..}
~~~

### 5.使用@CookieValue映射Cookie值

~~~java
@RequestMapping("/test")
public String test(@CookieValue("JSESSIONID") String sessionId){...}
~~~

### 6.POJO

~~~java
对于:
User(address,...)
Address(province,...)

<input type="text" name="address.province"/>
//不仅Spring可以将表单数据与POJO的属性简单映射,对于对象属性,也能通过命名匹配相应数据
@RequestMapping("/test")
    public String test(User usr){...}
~~~

### 7. 以Model , ModelMap , Map为参数(最终都会转化为ModelAndView) | 以ModelAndView为返回值

~~~java
@RequestMapping("/test")
public String test(Map<String,Object> map){
    map.put(..);
    return "success";
}

@RequestMapping("/test")
public ModelAndView test(){
    ModelAndView mav=ModelAndView("...");  //设置视图名称
    mav.setViewName("...");  //设置视图名称
    mav.addObject(obj);   //默认key为obj对应class的首字母小写名
    mav.addObject("萨达",obj);
    mav.addOjects(map);   //将一个map中的数据添加到ModelAndView中
    return mav;
}
//返回视图的同时,reuqest还带有参数
~~~

### 8. 通过对类进行@SessionAtrributes( { "user" } )注释,将参数存于session

~~~java
//当controller用@SessionAtrributes注释时,其中注明的相关属性,如果被目标方法随逻辑视图传递到物理视图中,那么也将保存至sessiion中
@SessionAttributes({"user"})
@Controller
public class SpringMVC{
	@RequestMapping("/test")
    public String test(Map<String,Object> map){
    	User user=new User();
        map.put("user",user);
        return "success";
    }//当模型数据随视图返回,若其中有符合@SessionAttributes的参数,则将一并保存至session中
}

//@SessionAttributes允许的表示:
@SessionAttributes(value={"user","people"},types={String.class, Integer.class})
//所有名为user people的参数将在返回时保存至session中
//所有值为String Integer的参数将在返回时保存至session中
~~~

### 9.通过@ModelAttribute注解,预先从后台提供数据:

~~~java
@ModelAtrribute
public void getUser(@RequestParam(value="id",required=false) Integer id, Map<String,Object> map){...}
//有@ModelAttribute注解的方法将在同一Controller方法执行前执行
//上面由于id不是必须,当无id时,其为null;同时最好设为不是必须的参数!!!
//如果在@ModelAtrribute方法中将信息存入request中,会随后续的方法返回的视图一同前往物理视图!-------- 1
//异或是, 如果在后续的方法中,有参数是POJO, 且属性名称与map中key值一致, 则会进行binding, 将属性依次填充. ---2
~~~

### 10.支持的参数类型:

~~~java
//几乎所有Servlet API, 如HttpServletRequest都可作为参数
//HttpSession
//java.util.Locale 由已配置的地区解析器获取,在MVC环境下,就是配置的LocaleResolver 或LocaleContextResolver
//java.util.TimeZone(java 6)/java.time.ZoneId(java 8) 由LocaleContextReslver解析获得
// 用于存取请求的 java.io.InputStream或java.io.Reader, 该对象与通过Servlet API获取的输入流一致!
//用于响应请求的 java.io.OutputStream或java.io.writer, 该对象与通过Servlet API获取的输入流一致!
//org.springframework.http.HttpMethod 可以拿到HTPP请求方法
//@PathVariable 存放URI摸板变量的值
//@MatrixVariable 存放URI路径中的键值对
//@RequestParam 存放Servlet请求中所
//@RequestHeader 存放了Servlet请求中所指定的HTPP请求头的值
//@RequestPart 提供对"multipart/form-data"请求块内容的存取
~~~

## 4. 返回视图

~~~java
@RequestMapping("\test")
public String test(){
	return "success";
}

@RequestMapping("\toTest")
public String test2(){
 	return "redirect:\test";   
}

@RequestMapping("\test1")
public ModelAndView test1(){
	ModelAndView mav=new ModelAndView("redirect:/");
}

@RequestMapping("\test")
public String testForward(){
	return "forward:success";
    //forward 方式是服务器跳转,不改变原有的request请求!
}
//如果无"redirect:" 或"forward:",默认为通过视图解析器转发,
//用redirect重定向后,不通过视图解析器处理,直接转向(可以转向Controller!)
//用forward转发后,也不通过视图解析器处理
//注意, forward转发时, 转发原有请求, 其HTTP请求方式和参数都不变!是服务器跳转
~~~

