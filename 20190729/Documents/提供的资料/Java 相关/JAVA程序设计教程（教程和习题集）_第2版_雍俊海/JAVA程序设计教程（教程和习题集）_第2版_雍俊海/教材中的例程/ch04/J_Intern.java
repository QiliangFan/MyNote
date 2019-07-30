// ////////////////////////////////////////////////////////
// 
// J_Intern.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     字符串池例程。
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

public class J_Intern
{
    public static void main(String args[ ])
    {
        String s1 = "123456"; // 字符串直接量
        String s2 = "123456"; // 字符串直接量
        String s3 = "123" + "456"; // 这不是字符串直接量
        String a0 = "123";
        String s4 = a0 + "456"; // 这不是字符串直接量
        String s5 = new String("123456"); // 这不是字符串直接量
        String s6 = s5.intern( );
        System.out.println("s2" + ((s2==s1) ? "==" : "!=") +"s1");
        System.out.println("s3" + ((s3==s1) ? "==" : "!=") +"s1");
        System.out.println("s4" + ((s4==s1) ? "==" : "!=") +"s1");
        System.out.println("s5" + ((s5==s1) ? "==" : "!=") +"s1");
        System.out.println("s6" + ((s6==s1) ? "==" : "!=") +"s1");
    } // 方法main结束
} // 类J_Intern结束
