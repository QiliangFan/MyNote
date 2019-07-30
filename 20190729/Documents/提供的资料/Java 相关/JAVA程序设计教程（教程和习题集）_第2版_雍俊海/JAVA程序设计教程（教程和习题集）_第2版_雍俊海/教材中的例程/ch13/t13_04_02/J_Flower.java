// ////////////////////////////////////////////////////////
// 
// J_Flower.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     计算机动画例程——花的缩放。
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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JApplet;
import javax.swing.Timer;

public class J_Flower extends JApplet implements ActionListener
{
    int  m_frame = 0; // 当前帧的帧号
    Timer  m_timer; // 定时器
    boolean  m_frozen = false; // 定时器状态: 当为false时，暂停；否则，启动

    public void init( )
    {
        int delay = 50;
        m_timer = new Timer(delay, this);
        m_timer.setInitialDelay(0);
        m_timer.setCoalesce(true);

        getContentPane( ).addMouseListener(new MouseAdapter( )
        {
            public void mousePressed(MouseEvent e)
            {
                m_frozen = !m_frozen;
                if (m_frozen)
                     mb_stopAnimation( );
                else mb_startAnimation( );
            } // 方法mousePressed结束
        }); // 父类型为类MouseAdapter的匿名内部类结束，并且方法调用结束
    } // 方法init结束

    public void start( )
    { 
        mb_startAnimation( );
    } // 方法start结束

    public void stop( )
    { 
        mb_stopAnimation( );
    } // 方法stop结束

    public void actionPerformed(ActionEvent e)
    {
        m_frame++; // 当前帧号自增1
        repaint( ); // 更新当前帧
    } // 方法actionPerformed结束

    public void mb_startAnimation( )
    {
        if (!m_frozen && !m_timer.isRunning( ))
            m_timer.start( );
    } // 方法mb_startAnimation结束

    public void mb_stopAnimation( )
    {
        if (m_timer.isRunning( ))
            m_timer.stop( );
    } // 方法mb_stopAnimation结束

    public void paint(Graphics g)
    { 
        Graphics2D g2d= (Graphics2D)g;
        int i= (m_frame>0 ? m_frame%600 : (-m_frame)%600);
        double a= (i>300 ? 600-i : i);
        double b= a*6/16;
        double a_2= a/2;
        double b_2= b/2;
        
        g2d.setPaint(new GradientPaint(0, 0, new Color(187,255,204),
                                       0, 300, Color.green, true));
        g2d.fill( new Rectangle2D.Double( 0, 0, 320,  300)); // 绘制背景

        g2d.setColor( Color.magenta ); // 绘制小花
        g2d.fill( new Ellipse2D.Double( 160-b_2, 150-a_2, b, a));
        g2d.fill( new Ellipse2D.Double( 160-a_2, 150-b_2, a, b ));		
        g2d.setColor( Color.orange );
        g2d.fill( new Ellipse2D.Double( 160-b_2, 150-b_2, b, b ));

        g2d.setPaint(Color.white); // 显示当前帧号
        g2d.fill( new Rectangle2D.Double( 0, 300, 320, 20 ) );
        g2d.setColor(Color.black);
        g2d.drawString(""+m_frame, 150, 315);
    } // 方法paint结束
} // 类J_Flower结束
