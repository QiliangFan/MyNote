// ////////////////////////////////////////////////////////
// 
// J_Genericity.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     具有多父类型的类型变量泛型例程。
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

class J_C1
{
    public void mb_methodA( )
    {
        System.out.print("A");
    } // 方法mb_methodA结束
} // 类J_C1结束

interface J_C2
{
    public void mb_methodB( );
} // 接口J_C2结束

class J_C3 extends J_C1 implements J_C2
{
    public void mb_methodB( )
    {
        System.out.print("B");
    } // 方法mb_methodB结束
} // 类J_C3结束

class J_T <T extends J_C1 & J_C2>
{
    public void mb_methodT( T t )
    {
        t.mb_methodA( );
        t.mb_methodB( );
    } // 方法mb_methodT结束
} // 类J_T结束

public class J_Genericity
{
    public static void main(String args[ ])
    {
        J_T<J_C3> a = new J_T<J_C3>( );
        a.mb_methodT( new J_C3( ) );
    } // 方法main结束
} // 类J_Genericity结束
