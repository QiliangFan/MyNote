// ////////////////////////////////////////////////////////
// 
// J_Graphics.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     字体及图形显示例程。
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
import java.awt.Font;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

class J_Panel extends JPanel
{
    protected void paintComponent(Graphics g)
    {
        int[ ]x = {55, 67,109, 73, 83, 55, 27, 37,  1, 43};
        int[ ]y = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36};

        Graphics2D g2d = (Graphics2D)g;
        g.clearRect(0, 0, getWidth( ), getHeight( ));
        g.drawLine(20, 30, 60, 90);
        g2d.translate( 80, 20 );
        g2d.draw(new Rectangle(0, 10, 40, 80));

        g2d.translate( 70, 20 );
        g2d.rotate(Math.PI/2);
        Font bakF = g2d.getFont( ); // 保存原来的字体设置
        g2d.setFont(new Font("Serif", Font.ITALIC|Font.BOLD, 14 ) );
        g2d.drawString("设置字体", 0, 0);
        g2d.setFont(bakF);  // 恢复来的字体设置

        g2d.rotate(-Math.PI/2);
        g2d.translate( 40, -20 );
        g2d.draw(new Arc2D.Double(0, 30, 40, 40, 0, 360, Arc2D.OPEN));
        g2d.translate( 70, 0 );
        g2d.draw(new QuadCurve2D.Double(0, 30, 20, 130, 40, 30));
        g2d.translate( 70, 0 );
        g2d.draw(new Ellipse2D.Double(0, 10, 40, 80));
        g2d.translate( 70, 0 );
        g2d.draw(new Polygon(x, y, x.length));
    } // 方法paintComponent结束
} // 类J_Panel结束

public class J_Graphics extends JFrame
{
    public J_Graphics( )
    {
        super("字体及图形显示例程");
        Container c = getContentPane( );
        c.add(new J_Panel( ), BorderLayout.CENTER);
    } // J_Graphics构造方法结束

    public static void main(String args[ ])
    {
        J_Graphics app = new J_Graphics( );

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(540, 160);
        app.setVisible(true);
    } // 方法main结束
} // 类J_Graphics结束
