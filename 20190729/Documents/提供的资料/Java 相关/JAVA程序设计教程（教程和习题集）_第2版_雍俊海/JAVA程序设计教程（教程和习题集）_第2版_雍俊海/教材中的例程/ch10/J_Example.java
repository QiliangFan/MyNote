// ////////////////////////////////////////////////////////
// 
// J_Example.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     加法与乘法运算效率比较例程。
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

package cn.edu.tsinghua.example;

/**
 * 比较加法与乘法运算效率。
 *
 * @author 雍俊海
 * @version 2.0
 * @since J2SE 1.6
 */
public class J_Example
{
    /** 
     * 比较加法与乘法运算效率。 
     * @param args 程序的参数，这里没有实际的含义。
     */
    public static void main(String args[ ])
    {
        int n=100000000; // 运算次数

        J_Timer t = new J_Timer( ); // 计算加法的时间代价
        t.mb_setStart( );
        J_Calculator.mb_add( n );
        t.mb_setEnd( );
        long t1 = t.mb_getTime( );

        t.mb_setStart( ); // 计算乘法的时间代价
        J_Calculator.mb_multiply( n );
        t.mb_setEnd( );
        long t2 = t.mb_getTime( );

        // 输出比较结果
        System.out.println("计算" + n + "次加法需要" + t1 +"毫秒");
        System.out.println("计算" + n + "次乘法需要" + t2 +"毫秒");
        if (t1 < t2)
            System.out.println("结论: 加法快");
        else if (t1 > t2)
            System.out.println("结论: 乘法快");
        else
            System.out.println("结论: 加法与乘法一样快");
    } // 方法main结束
} // 类J_Example结束
