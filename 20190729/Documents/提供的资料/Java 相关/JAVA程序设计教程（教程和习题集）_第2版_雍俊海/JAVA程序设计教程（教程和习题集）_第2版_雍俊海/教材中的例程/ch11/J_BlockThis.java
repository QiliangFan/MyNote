// ////////////////////////////////////////////////////////
// 
// J_BlockThis.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     线程同步例程: 说明类的实例对象与静态成员域之间的关系。
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


public class J_BlockThis extends Thread
{
    public static int m_data=0;
    public static int m_times=10000;
    public int m_ID;
    public boolean m_done;

    J_BlockThis(int id)
    {
        m_ID=id;
    } // J_BlockThis构造方法结束

    public void run( )
    {
        m_done=false;
        int d= ((m_ID % 2==0) ? 1 : -1);
        System.out.println("运行线程: " + m_ID + "(增量为: " + d + ")");
        synchronized(this)
        {
            System.out.println("线程: " + m_ID
                + "进入同步语句块, m_data=" + m_data);
            for(int i=0; i<m_times; i++)
            for(int j=0; j<m_times; j++)
                m_data+=d;
            System.out.println("线程: " + m_ID
                + "离开同步语句块, m_data=" + m_data);
        } // 同步语句块结束
        
        m_done=true;
        System.out.println("结束线程: " + m_ID);
    } // 方法run结束
    
    public static void main(String args[ ])
    {
        J_BlockThis t1 = new J_BlockThis(1);
        J_BlockThis t2 = new J_BlockThis(2);
        t1.m_done=false;
        t2.m_done=false;
        t1.start( );
        t2.start( );
        while ( !t1.m_done || !t2.m_done ) // 等待两个线程运行结束
            ;
        System.out.println("结果: m_data=" + m_data);
    } // 方法main结束
} // 类J_BlockThis结束
