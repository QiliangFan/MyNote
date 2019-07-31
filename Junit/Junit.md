# 1. 注释:

@BeforeClass:该注解注解的方法,执行在所有方法最前面(**为静态方法,只执行一次**)

@AfterClass:该注解注解的方法,执行在所有方法最后(**为静态方法,只执行一次**)

@Before: 用于注释在方法前,表示该方法在所有测试方法前执行(**每个测试方法执行前都会执行一次!!**)

@After: 用于注释在方法前,表示该方法在所有测试方法后执行(**每个测试方法执行后都会执行一次!!**)

@Test: 用于注释在方法前,表示该方法将在Junit 测试单元运行时执行

@Ignore: 修饰的测试方法会被测试运行器忽略(即使有@Test)

@Runwith: 更改测试运行器(一般不需要用自己写的)

# 2. 方法:

assertTrue({condition})  //里面是一个测试条件

assertEquals(<expected>,<exactly-value>)

fail(str)  //抛出错误,并打印str

# 3. 测试:

在要测试的类(非接口类)上右键新建Junit Test case, 注意选择好源代码路径! 注意包名!

如果要测试接口,就只能手动建立Junit Test Case, 然后手动添加测试方法.

~~~java
@Test
public void <FUNC-NAME>(){...}
~~~

~~~http
测试样例不能证明你是对的,只能说明你没有错.
~~~

# 4. @Test

1. @Test(expected=<异常类>.class)

   当方法抛出预期的异常时, 则测试通过,而且程序不报错

2. @Test(timeout=<毫秒>)

   当程序执行超时后, 会中止, 并且标记为错误 , 但当前代码段标记为红色,即已执行.

# 5. @Ignore

忽@Test方法的执行, @Ignore("...")还能带有为什么忽略的信息

# 6. 测试套件-批量测试

~~~java
@RunWith(Suite.class)
@Suite.SuiteClasses({TaskTest1.class,TaskTest2.class})
    //里面加入自己所写的测试类
public class SuiteTest{
    //这个类不包含任何方法
}
~~~

# 7.Junit参数化设置

~~~java
@RunWith(Parameterized.class)
public class ParameterTest{
    int expected=0;
    int input1=0;
    int input2=0;
    
    @Parameters
    public static Collection<Object[]> t(){
        return Arrays.asList(new Object[][]{
            {3,1,2},
            {4,2,2}
        });
    }
    
    public ParameterTest(int expected,int input1,int inpnut2){
        this.expected=expected;
        this.input1=input1;
        this.input2=input2;
    }
    
    @Test
    public void TestAdd(){
    	assertEquals(expected,new Caculate().add(input1,input2));
    }
    //运行会会发现运行了两次
}
~~~

~~~js
1. 需要更改测试运行器
2. 需要声明变量存放预期值和结果值
3. 声明一个返回值为Collection的公共静态方法,并使用@Parameters修饰
4. 为测试类声明一个带有参数的公共构造函数,并在函数体中为之赋值
~~~

# 8. Junit测试spring(目前过于复杂,不考虑)

~~~java
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml","classpath:spring/spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public SpringTest{
    private MockMvc mockMvc;
    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;
    
    @AutoWired
    private static ApplicationContext context=null;
 	
    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
    	context = new ClassPathXmlApplicationContext("applicationContext.xml");
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void Test(){
        //模拟Get请求
       MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/comment" );
       mockHttpServletRequestBuilder.param("itemId", "1" ); 
       ResultActionsresultActions = mockMvc.perform( mockHttpServletRequestBuilder ); 
       resultActions.andExpect(status().isOk());
        
       //测试get
       mockMvc.perform(MockMvcRequestBuilders.get("/comment").conentType(MediaType.APPLCATION_FORM_URLENCODED).param("itemId","1").contentType(MediaType.APPLICATION_FORM_URLENCODED)
    }
}
~~~

