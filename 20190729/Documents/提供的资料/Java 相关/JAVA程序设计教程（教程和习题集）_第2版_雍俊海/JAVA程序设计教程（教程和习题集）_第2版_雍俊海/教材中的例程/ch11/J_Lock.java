// ////////////////////////////////////////////////////////
// 
// J_Lock.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     线程死锁例程。
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


public class J_Lock extends Thread
{
    public static Object m_objectA= new Object( );
    public static Object m_objectB= new Object( );

    J_Lock(String s)
    {
        super(s);
    } // J_Lock构造方法结束

    public static void mb_sleep( )
    {
        try
        {
            Thread.sleep((long)(Math.random( ) * 1000));
        }
        catch (InterruptedException e)
        {
            System.err.println("异常InterruptedException: " + e);
            e.printStackTrace( );
        } // try-catch结构结束
    } // 方法mb_sleep结束

    public void run( )
    {
        boolean t=true;
        System.out.println(getName( ) + "开始运行");
        for( ; true; t=!t)
        {
            synchronized(t ? m_objectA : m_objectB)
            {
                System.out.println(getName( ) + ": " +
                    (t ? "对象A" : "对象B") + "被锁住");
                mb_sleep( );
                synchronized(t ? m_objectB : m_objectA)
                {
                    System.out.println(getName( ) + ": " +
                        (t ? "对象B" : "对象A") + "被锁住");
                    mb_sleep( );
                    System.out.println(getName( ) + ": " +
                        (t ? "对象B" : "对象A") + "的锁打开");
                } // 内层同步语句块结束
                System.out.println(getName( ) + ": " +
                    (t ? "对象A" : "对象B") + "的锁打开");
            } // 外层同步语句块结束
        } // for循环结束
    } // 方法run结束

    public static void main(String args[ ])
    {
        J_Lock t1 = new J_Lock("线程1");
        J_Lock t2 = new J_Lock("线程2");
        t1.start( );
        t2.start( );
    } // 方法main结束
} // 类J_Lock结束
