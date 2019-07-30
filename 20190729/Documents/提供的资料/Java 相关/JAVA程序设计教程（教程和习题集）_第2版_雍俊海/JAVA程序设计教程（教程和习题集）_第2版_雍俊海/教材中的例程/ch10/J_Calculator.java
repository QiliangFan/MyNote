// ////////////////////////////////////////////////////////
// 
// J_Calculator.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     加法与乘法计算器例程。
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
 * 计算器。
 * <p>
 * 计算器加法与乘法。
 *
 * @author 雍俊海
 * @version 2.0
 * @since J2SE 1.6
 */
public class J_Calculator
{
    /** 
     * 计算n次乘法。 
     * @param n 乘法的次数。
     * @return 最后一次乘法的结果。
     */
    public static int mb_multiply(int n)
    {
        int i, m;
        m = 1;
        for (i=1; i<=n; i++)
            m = i * n;
        return m;
    } // 方法mb_multiply结束

    /** 
     * 计算n次加法。 
     * @param n 加法的次数。
     * @return 最后一次加法的结果。
     */
    public static int mb_add(int n)
    {
        int i, s;
        s = 0;
        for (i=1; i<=n; i++)
            s = i + n;
        return s;
    } // 方法mb_add结束
} // 类J_Calculator结束
