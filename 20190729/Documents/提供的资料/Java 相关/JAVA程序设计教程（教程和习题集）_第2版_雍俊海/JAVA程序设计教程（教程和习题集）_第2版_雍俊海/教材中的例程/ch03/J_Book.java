// ////////////////////////////////////////////////////////
// 
// J_Book.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     关于书的类的成员域和成员方法的静态属性与非静态属性例程。
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

public class J_Book
{
    public int m_id; // 书的编号
    public static int m_bookNumber = 0; // 书的总数

    public J_Book( )
    {
        m_bookNumber ++;
    } // J_Book构造方法结束

    public void mb_info( )
    {
        System.out.println( "当前书的编号是：" + m_id);
    } // 方法mb_info结束

    public static void mb_infoStatic( )
    {
        System.out.println( "书的总数是：" + m_bookNumber);
    } // 方法mb_infoStatic结束

    public static void main(String args[ ])
    {
        J_Book a = new J_Book( );
        J_Book b = new J_Book( );
        a.m_id = 1101;
        b.m_id = 1234;
        System.out.print( "变量a对应的");
        a.mb_info( );
        System.out.print( "变量b对应的");
        b.mb_info( );
        J_Book.mb_infoStatic( );
        System.out.println( "比较(a.m_bookNumber==J_Book.m_bookNumber)"
            + "的结果是：" + (a.m_bookNumber==J_Book.m_bookNumber));
        System.out.println( "比较(b.m_bookNumber==J_Book.m_bookNumber)"
            + "的结果是：" + (b.m_bookNumber==J_Book.m_bookNumber));
    } // 方法main结束
} // 类J_Book结束

