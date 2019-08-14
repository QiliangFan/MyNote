# 1. Using  th:   

## 1. Externalizing text:  th:text

​	<p  th:text= "#{home.welcome}">Welcome to our grocery store!</p>

~~~wiki
1. th:text 标签会计算表达式中的值, 并且将值作为宿主标签的body内容
2. #{home.welcome} 表达式是一种  Standard Expression Syntax
3. 这个表达式的 外部文本是可以通过Thymeleaf配置确定的,  并且是完全取决于正在使用的org.thymeleaf.messageresolver.IMessageResolver的实现类 .  通常, 基于 .properties 的实现类会被使用, 但我们能通过建立自己的实现类来从数据库中获取数据
4. 当我们并没有明确配置一个message resolver 时, 应用程序会使用一个默认的 Standard Message Resolver (Implemented  by  org.thymeleaf.messageresolver.StandardMessagesolver)
5. 当使用Standard message resolver 时,  它会试图去在相同文件夹下相同名字的properties文件夹内查找文件
~~~

​	contexts:

~~~java
public class  HomeController implement IGTVGController{
    	public  void process(final HttpServletRequest request,  final HttpServletResponse reponse,
                            final ServeltContext servletContext ,  final ITemplateEngine templateEngine)
            				throws Exception{
            WebContext ctx = 
                				new WebContext( request, reponse , servletContext, request.getLocale);
            templageEngine.process("home",ctx, response.getWriter());
        }
}
~~~

接着我们需要创建一个context对象 :(在web app中应该实现org.thymeleaf.context.IWebContext)

~~~java
public  interface  IContext{
    public  Locale getLocale();
    public boolean  containsVariable(final String  name);
    public set<String> getVariableNames();
    public OBject getVariable(final  String name);
}
//Thymeleaf  core  library   提供了实现类: org.thymeleaf.context.Context

public interface  IWebContext extends IContext{
    public HttpServletRequest getRequest();
    public HttpServletResponse getResponse();
    public HttpSession  getSession();
    public ServletContext getServletContext();
}
//Thymeleaf core  libary 提供了实现类: org.thymeleaf.context.WebContext
~~~

正如上面所看到的:

~~~java
WebContext ctx = new  WebContext(request, response, servletContext ,request.getLocale());
templateEngine.process("home", ctx, response.getWriter())
~~~

我们便可以使用以下四中特殊表达式:

~~~xml
${x}  从request中获取变量x的值
${param}  从request paramter中返回x的值
${session.x}  从session中返回x的值
${application.x}  从servlet context 中获取变量x的值
~~~

template engine 便可以处理template (by uing name) 通过使用context, 并且传递一个response writer进去,从而可以通过这个writer写入数据

~~~html
<p>Welcome to our  &lt;b&gt;our%&lt;/b&gt;ds</p>
~~~

当#{hoem.welcome}中有<b>这样的标签时, < 和 > 会被转义, 而这是th:text的默认行为

~~~html
<p th:utext="#{home.welcome}">
    welcom !
</p>
~~~

th:utext 则不对变量内容进行转义

## 2. Standard Expression  Syntax



 ~~~properties
//Simple expressions
Variable Expressions: ${..}
Selection Variable Expressions: *{...}
Message Expressions: #{...}
Link URL Expressions: @{...}
Fragment Expressions: ~{...}

//Literals:
Text Lierals: 'one ssa', 'dsad'...
Number literals: 0, 25, 3.0
Boolean literals: true,  false
Null literal: null
Literal tokens: one, sometext,main...

//Text operations:
String conatenations: +
Literal substitutions:  |the name is ${name}|

//Boolean operations:
Binary operatiors: and , or
Boolean negation(unary operator):! , not

//Comparisons  and  equality:
Comparators: > ,  <  ,>=(gt ,lt,ge,le)
Equality operators : == , !=(eq, ne)

//Conditional operators:
if-then: (if) ?(then)
if-then-else:(if) ? (then) : (else)
Default : (value) ?: (defautvalue)
 ~~~

### 1. Messages:

​	为了给external text 添加参数:

~~~pro
home.welcome=hello ,{0}!
~~~

~~~html
<p th:utext="#{home.welcome(${session.user.name})}">
    Welcome to our grocery store, Sebastian Pepper!
</p>

<p th:utext="#{${welcomeMsgKey}($session.user.name)})"
~~~

### 2. variables:

~~~html
/*
* Access to properties using the point (.). Equivalent to calling property getters.
*/
${person.father.name}
/*
* Access to properties can also be made by using brackets ([]) and writing* the name of the property as a variable or *between single quotes.
*/
${person['father']['name']}
/*
* If the object is a map, both dot and bracket syntax will be equivalent to* executing a call on its get(...) method.
*/
${countriesByCode.ES}
${personsByName['Stephen Zucchini'].age}
/*
* Indexed access to arrays or collections is also performed with brackets,
* writing the index without quotes.
*/
${personsArray[0].name}
/*
* Methods can be called, even with arguments.
*/
${person.createCompleteName()}
${person.createCompleteNameWithSeparator('-')}
~~~

~~~html
<!--当计算OGNL表达式时, 一些对象可以被灵活引用-->
#ct   :the  context object
#vars  :the context variables
#locale : the context locale
#request: (only  in Web Contexts) the HttpServletRequest object
#response: (only in Web Contexts) the HttpServletResponse object
#session:  (only in web Contexts) the HttpSession object
#servletContext: (only in Web Contexts) the ServletCntext object
===>>
<span th:text="${#locale.country}">us</span>
~~~

### 3. Expression  on selection  (asterisk  syntax)  ->   *{...}

~~~html
<div th:object="${session.user}">
    <p>
        <span th:text="*{firstname}"></span>
        <span th:text="${#object.firtname}"></span>
    </p>
</div>
~~~

如果没有提供选择的对象,那么*{..} 和 ${..} 没有什么太大区别

### 4. Link URLs    @{...}

这个表达式的真实的处理和转化过程是被 **org.thymeleaf.linkbuilder.StandarLinkBuilder** 的实现类完成的

~~~html
<!--'http://localhost:8080/gtcg/order/details?order=3'-->
<a href="details.html" th:href="@{http://localhost:8080/gtcg/order/details(orderId=${o.id})}">view</a>
<!--'/gtvg/order/detais?orderId=3'-->
<a href="details.html" th:href="@{/order/details(orderId=${o.id})}">view</a>
<!--'/gtvg/order/3/details'-->
<a href="details.html" th:href="@{/order/{orderId}}/details(orderId=${o.id})">view</a>
~~~

Some  things to note here:

~~~properties
1. th:href  is a  modifier: 一旦被处理, 它的值将替换 href 属性
2. 当使用(orderId=${o.id})作为参数时,  URL-parameter-encoding 操作将会自动进行
3. 当小括号内有多个参数时, 用逗号分割: (execId=${execId}, execType="Fast")
4. Variable template 同时也允许在URL 路径中使用, 如上面第三条
5. 如果cookies 被禁用:  a  suffix ";jsessionid=..." might be added to relative URLs  so that the session is preserved
(这叫做URL重写, 你可以通过重写过滤器. 使用response.encodeURL(...)来实现自己的重写)
6. 使用th:href时也同时允许我们有href属性, 使得我们的template  links 始终可导航
7. @{/path/to/something}以context的名字为根目录
	@{~/path/to/something} 以前台的域为根目录
~~~

### 5. Fragments!!(One written, use  anywhere!)

~~~html
<footer th:fragment="copy">
	<script type="text/javascript" th:src="@{..}"></script>
</footer>

<div th:insert="footer::copy"></div>
<!--result-->
<div>  
    <footer>  
       <script type="text/javascript" th:src="@{/plugins/jquery/jquery-3.0.2.js}"></script>  
    </footer>    
</div>    

<div th:replace="footer::copy"> </div>
<!--result-->
<footer>  
  <script type="text/javascript" th:src="@{/plugins/jquery/jquery-3.0.2.js}"></script>  
</footer>    

<div th:include="footer::copy"> </div>
<!--rersult-->
<div>  
  <script type="text/javascript" th:src="@{/plugins/jquery/jquery-3.0.2.js}"></script>  
</div>    
~~~

### 6. Literals:

~~~html
<div th:if="${user.isAdmin()}==false"></div>
<div th:if="${user.something}==null"></div>
~~~

~~~properties
这里==false 没有包含在{ }中, 则表示交由Thymeleaf 框架处理 ,  如果==false 写在{  } 内部, 则表明由OGNL/SpringEL engines处理 
Text Literal 必须要用'...'  ,如th:text="I 'love' you"  //此时如果要显示' 就要转义了!
而Literal tokens :只支持 [a-zA-Z0-9]  和 [ 和  ]  和.  和-  ,就可以这样:  th:text="ssss"而不需要引号了
//注意,使用这种literal tokens必须只包含上面的字符才行!(也不能有变量)
~~~

### 7. Appending texts

~~~html
<span th:text=" ' the name of the user is '+${user.name}"></span>
//字面量和表达式的计算结果可以相互连接
~~~

### 8. Literal  substitutions:

~~~html
<span th:text="|Welcome to  our  application, ${user.name} !|"></span>
<span th:text="'Welcome to our application, '+ ${user.name}+'!' "></span>
~~~

如果将要用变量链接替换的字符串用 | | 包住, 则不在需要做链接操作, Thymeleaf将自动处理其中变量.而不会将其认为字符串

此时任何字面量都不允许出现在||之间, 只有变量和普通字符可以

{事实上我们注意到, 如果要在th:text中使用字符串 , 是要使用他的字面量的!->只有小数情况下可以不要单引号}

### 9.  Arithmetic  operations:

~~~html
<div th:with="isEven=(${prodStat.count}%2==0))"></div> 使用Thymeleaf
<div th:with="isEven=${prodStat.count}%2==0)"></div>  使用OGNL表达式
~~~

### 10. Comparators  and Equality

~~~html
<div th:if="${proStat.count}  &gt;  1">
<span th:text="'Execution mode is' + ((${execMode}=='dev'?'Development':'Production'))"></span>
~~~

注意, 在严格的xml语法中, 属性值是不允许出现 <  和>的

### 11. Conditional  expressions:

~~~html
<tr th:class="${row.even}?'even':'odd'"></tr>
<tr th:class="${row.even}?'even'"></tr>  如果条件不成立返回null value
<!--事实上,我们只需要理解:后的内容是为表达式提供默认值即可-->
<tr th:class="${row.even}?:'even'"></tr>  如果条件不成立返回even, 而条件成立时返回自身
~~~

### 12 . No-Operation token:

~~~html
<span th:text="${user.name}?"_>no user authenticated</span>
~~~

当user.name不存在时, _ 表示不做任何操作,也即是th:text为空,不占据span的内容

### 13. Data  Conversion /Formatting

~~~html
<td th:text="${{user.lasetAccessDate}}">...</td>
~~~

${{..}}  和 *{{..}} 将会通知thymeleaf 去调用conversion  service来转化它, 默认情况下,StandardConverService(Implementation of IStandardConversionService) 会简单的调用对象的toString方法

注意:在spring boot中, 在spring Configuration 中配置的converison  services  将会自动处理${{..}}  和  *{{...}}