// ////////////////////////////////////////////////////////
// 
// J_Reference.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     引用数据类型值传递例程。
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

class J_Time
{
    public int m_month = 1;
} // 类J_Time结束

public class J_Reference
{
    public static void mb_method( J_Time t )
    {
        System.out.println("在t.m_month++之前t.m_month=" + t.m_month);
        t.m_month++;
        System.out.println("在t.m_month++之后t.m_month=" + t.m_month);
    } // 方法mb_method结束

    public static void main(String args[ ])
    {
        J_Time a = new J_Time( );
        System.out.println("在方法调用之前a.m_month=" + a.m_month);
        mb_method( a );
        System.out.println("在方法调用之后a.m_month=" + a.m_month);
    } // 方法main结束
} // 类J_Reference结束
