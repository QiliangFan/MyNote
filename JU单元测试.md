1. 添加依赖, 搜索Junit mvn,
2. 加功能 : elipse 添加 JUnit test case
3. 选版本: Junit与所下包版本相同(注意与功能代码分离)
4. 工程下->新建source folder->取名test(命名规范)
5. 工程下->新建Junit Test case->注意选择source folder为test->包名取为要测的包->选取class under tree,此时发现找不到要测试的Dao
6. Junit默认测试实现类, dao包右键新建一个包impl ,新建相应dao的实现类(事实上这没有用,只是让你看见junit test 会创建什么)
7. 回到test下, 再尝试新建Junit test, 勾选第一个窗口的四个方法:teardown,第二个窗口勾选要测试的方法

~~~http
注意, 尽管src和test源代码文件不同,但如果包名路径一致, 就可以访问!

~~~

~~~http
注意! 尽管 test 和src 是不同文件夹, 但是编译后都放在一个编译输出文件下! 事实上是等价的!!!!!!!!!
~~~

8. 实现Junit test 功能:
   1. new SourceFolder 
   2. new JUnit Test Case(JUnit 4)
   3. 命名规范:在要测试的接口名前加 Test
   4. 不要勾选那四个方法了!
   5. 开始!

~~~java
public class TestCustomerDao{
    private SqlSession session=null;
    private CustomerDao custromerDao=null;
    
    @Before
    public void setup(){   //如果路径不规范,需要为public=>to be tested!!
        //在所有测试方法之前执行一次,完成初始化任务
        String resource="...xml";
        Reader reader=Resources.getResourceAsReader(
        	TestCustomerDao.class.getClassLoader(), resource  //attention!
        );
        session=...;
        customerDao=session.getMapper(CustomerDao.class)
    }
    
    
    
    @Test
    public void testFindById(){
        assertTrue(..);   //a condition
    }
    
    @Test
    public void testFindAll(){
        
    }
    
    @After
    public void tear(){
        //在所有测试方法执行结束后执行,完成资源的释放
    }
}
~~~

