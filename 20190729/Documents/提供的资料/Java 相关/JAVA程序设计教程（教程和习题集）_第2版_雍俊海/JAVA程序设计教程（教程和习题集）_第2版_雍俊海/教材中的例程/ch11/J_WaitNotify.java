// ////////////////////////////////////////////////////////
// 
// J_WaitNotify.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     利用wait和notify成员方法进行线程同步的例程。
// ////////////////////////////////////////////////////////
// Copyright:
//
// Using this example, please explicitly refer to the book:
//     Jun-Hai Yong. Textbook for Programming in Java. 
//     Beijing: Tsinghua University Press, 2007.
// The example should be used legally, beneficially and
// without any harm to anybody. Please note that the
// author and the publisher make no warranty of any kind
// on the examples provided.
// Citation examples:
// The program is an example in (or based on, or modified from)
//     Jun-Hai Yong. Textbook for Programming in Java. 
//     Beijing: Tsinghua University Press, 2007.
//
// Some other books by Jun-Hai Yong are:
//      [1] Jun-Hai Yong. Programming in Java. 
//          Beijing: Tsinghua University Press, 2004.
//      [2] Jun-Hai Yong. Exercises for Programming in Java.
//          Beijing: Tsinghua University Press, 2006.
//
// 版权:
// 使用本例子，请注明引用:
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
// 请合法使用例程，其用途应当合法有益而且不应对任何人造成任何
// 伤害或损失。同时请注意教材作者及出版社没有对例程做出任何承
// 诺与保证。
// 具体引用的方法及例子如下:
// 本程序是下面教材的一个例程(或本程序基于下面教材的例程修改)
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
//
// 雍俊海还编写过如下的教材和教参:
//      [1] 雍俊海. Java 程序设计. 北京: 清华大学出版社, 2004.
//      [2] 雍俊海. Java程序设计习题集(含参考答案). 
//          北京: 清华大学出版社, 2006.
//
// ////////////////////////////////////////////////////////


class J_Experiment
{
    private int m_temperature, m_pressure;
    private boolean m_ready=false;
    
    public synchronized void mb_update(int t, int p)
    {
        System.out.println("进入更新方法内部:");
        if (m_ready) // 前面更新的数据还没有被处理
        {
            System.out.println("    等待数据分析完成...");
            try
            {
                wait( ); // 等待数据分析
            }
            catch(Exception e)
            {
                e.printStackTrace( );
                System.err.println(e);
            } // try-catch结构结束
            System.out.println("    继续更新数据...");
        } // if语句结束
        m_temperature = t;
        m_pressure    = p;
        System.out.println("更新完成: 温度值为" + t + ", 气压值为" + p);
        m_ready=true;
        notify( );
    } // 同步方法mb_update结束
    
    public synchronized void mb_analyze( )
    {
        System.out.println("进入数据分析方法内部:");
        if (!m_ready) // 数据还没有更新
        {
            System.out.println("    等待数据更新完成...");
            try
            {
                wait( ); // 等待数据更新
            }
            catch(Exception e)
            {
                e.printStackTrace( );
                System.err.println(e);
            } // try-catch结构结束
            System.out.println("    继续分析数据...");
        } // if语句结束
        int t= m_temperature;
        int p= m_pressure;
        System.out.println("分析完成: 温度值为" + t + ", 气压值为" + p);
        m_ready=false;
        notify( );
    } // 同步方法mb_analyze结束
} // 类J_Experiment结束

class J_Assistant extends Thread
{
    J_Experiment m_data;
    
    public J_Assistant(J_Experiment d)
    {
        m_data= d;
    } // 构造方法J_Assistant结束

    public void run( )
    {
        System.out.println("助理线程开始工作");
        int i, j, k;
        for(k=0; k<3; k++)
        {
            i= (int)(Math.random( ) * 1000);
            j= (int)(Math.random( ) * 1000);
            m_data.mb_update(i, j);
        } // for循环结束
        System.out.println("助理线程结束工作");
    } // 方法run结束
} // 类J_Assistant结束

class J_Analyst extends Thread
{
    J_Experiment m_data;
    
    public J_Analyst(J_Experiment d)
    {
        m_data= d;
    } // 构造方法J_Analyst结束
    
    public void run( )
    {
        System.out.println("分析员线程开始工作");
        for(int k=0; k<3; k++)
            m_data.mb_analyze( );
        System.out.println("分析员线程结束工作");
    } // 方法run结束
} // 类J_Analyst结束

public class J_WaitNotify
{
    public static void main( String args[ ] )
    { 
        J_Experiment data= new J_Experiment( );
        J_Assistant threadA = new J_Assistant(data);
        J_Analyst   threadB = new J_Analyst(data);
        threadA.start( );
        threadB.start( );
        System.out.println("方法main结束");
    } // 方法main结束
} // 类J_WaitNotify结束
