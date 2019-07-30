// ////////////////////////////////////////////////////////
// 
// J_Synchronization.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     在实验室中进行数据更新与分析的例程，用于说明多线程并发问题。
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


class J_Experiment // 实验
{
    private int m_temperature, m_pressure; // 温度与气压
    
    public void mb_update(int t, int p) // 数据更新
    {
        m_temperature = t;
        m_pressure    = p;
    } // 方法mb_update结束
    
    public void mb_analyze( ) // 数据分析
    {
        int t= m_temperature;
        int p= m_pressure;
        for (int i=0; i<1000; i++) // 进行延时，使得并发问题更容易出现
            ;
        if (t!=m_temperature) // 分析温度数据
        {
            System.out.print("实验数据出现情况: ");
            System.out.println("t(" + t + ") != (" + m_temperature + ")");
            System.exit(0);
        } // if结构结束
        if (p!= m_pressure) // 分析气压数据
        {
            System.out.print("实验数据出现情况: ");
            System.out.println("p(" + p + ") != (" + m_pressure + ")");
            System.exit(0);
        } // if结构结束
    } // 方法mb_analyze结束
} // 类J_Experiment结束

class J_Assistant extends Thread // 实验室的助理人员
{
    J_Experiment m_data;
    
    public J_Assistant(J_Experiment d)
    {
        m_data= d;
    } // 构造方法J_Assistant结束

    public void run( )
    {
        int i, j;
        for(; true; )
        {
            i= (int)(Math.random( ) * 1000);
            j= (int)(Math.random( ) * 1000);
            m_data.mb_update(i, j);
        } // for循环结束
    } // 方法run结束
} // 类J_Assistant结束

class J_Analyst extends Thread // 实验室的分析人员
{
    J_Experiment m_data;
    
    public J_Analyst(J_Experiment d)
    {
        m_data= d;
    } // 构造方法J_Analyst结束
    
    public void run( )
    {
        for(; true; )
            m_data.mb_analyze( );
    } // 方法run结束
} // 类J_Analyst结束

public class J_Synchronization
{
    public static void main( String args[ ] )
    { 
        J_Experiment data= new J_Experiment( );
        J_Assistant threadA = new J_Assistant(data);
        J_Analyst   threadB = new J_Analyst(data);
        threadA.start( );
        threadB.start( );
    } // 方法main结束
} // 类J_Synchronization结束
