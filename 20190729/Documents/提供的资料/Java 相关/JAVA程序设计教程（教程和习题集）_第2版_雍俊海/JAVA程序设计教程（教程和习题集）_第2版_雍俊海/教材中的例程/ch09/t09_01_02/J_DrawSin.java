// ////////////////////////////////////////////////////////
// 
// J_DrawSin.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     绘制正弦曲线的小应用程序图形用户界面例程。
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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JPanel;

class J_Panel extends JPanel
{
    protected void paintComponent(Graphics g)
    {
        double d, tx;
        int    x, y, x0, y0;

        d= Math.PI/100; // 将曲线分成为约200段
        x0=y0=0;
        for (tx=0, x=20; tx <= 2*Math.PI; tx+=d, x++)
        { // 曲线绘制
            y= 120-(int)(Math.sin(tx)*50+60); // 缩放、平移、对称
            if (x>20)
                g.drawLine(x0, y0, x, y); // 将曲线分成为线段，然后逐段绘制
            x0= x;
            y0= y;
        } // for循环结束
        g.drawString("y=sin(x)", 10, 70);
    } // 方法paintComponent结束
} // 类J_Panel结束

public class J_DrawSin extends JApplet
{
    public void init( )
    {
        Container c = getContentPane( );
        c.add(new J_Panel( ), BorderLayout.CENTER);
    } // 方法init结束
} // 类J_DrawSin结束
