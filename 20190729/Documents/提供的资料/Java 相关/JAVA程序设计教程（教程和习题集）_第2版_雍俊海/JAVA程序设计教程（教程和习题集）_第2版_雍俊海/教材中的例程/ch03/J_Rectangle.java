// ////////////////////////////////////////////////////////
// 
// J_Rectangle.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     矩形例程。
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

public class J_Rectangle implements J_Shape
{
    public double m_minX, m_minY; // 第一个角点坐标
    public double m_maxX, m_maxY; // 另一个角点坐标

    public J_Rectangle(double x1, double y1, double x2, double y2)
    {
        if (x1<x2)
        {
            m_minX = x1;
            m_maxX = x2;
        }
        else
        {
            m_minX = x2;
            m_maxX = x1;
        } // if-else结构结束
        if (y1<y2)
        {
            m_minY = y1;
            m_maxY = y2;
        }
        else
        {
            m_minY = y2;
            m_maxY = y1;
        } // if-else结构结束
    } // J_Rectangle构造方法结束

    // 计算并返回形状的面积
    public double mb_getArea( )
    {
        return ( (m_maxY-m_minY) * (m_maxX-m_minX) );
    } // 方法mb_getArea结束
} // 类J_Rectangle结束
