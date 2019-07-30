// ////////////////////////////////////////////////////////
// 
// J_Example.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     for语句的简化写法在整数数组中的应用例程。
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

public class J_Example
{
    public static void main(String args[ ])
    {
        int [ ] a = {10, 20, 30, 40, 50};
        int s = 0;
        for ( int c : a)
            s += c; // 这里需要注意c是数组的元素，而不是相应的下标
        System.out.println("数组a的元素之和等于" + s);

        s = 0;
        for ( int i=1; i<=a.length; i++ )
            s += i;
        System.out.println("从1一直加到数组a的元素长度，结果等于" + s);

        s = 0;
        int [ ] ca = a;
        for ( int i=0; i< ca.length; i++ )
        {
            int c = ca[i];
            s += c;
        } // for循环结束
        System.out.println("数组a的元素之和等于" + s);
    } // 方法main结束
} // 类J_Example结束
