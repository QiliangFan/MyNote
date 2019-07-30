// ////////////////////////////////////////////////////////
// 
// J_Texture.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     颜色及纹理设置例程。
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
import java.awt.Color;
import java.awt.Container;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;

class J_Panel extends JPanel
{
    public void mb_drawCircleGreen(Graphics2D g, int x, int y)
    {
        Color c = g.getColor( ); // 获取原来的颜色
        g.setColor( Color.green );
        g.fill( new Ellipse2D.Double( x, y, 100, 100 ) );
        g.setColor( c );  			// 恢复原来的颜色设置
    } // 方法mb_drawCircleGreen结束

    public void mb_drawCircleGradientPaint(Graphics2D g, int x, int y)
    {
        Paint p = g.getPaint( ); // 获取原来的图形属性设置
        g.setPaint( new GradientPaint(x, y, Color.green,
                                x+50, y+50, Color.yellow, true) );
        g.fill( new Ellipse2D.Double( x, y, 100, 100 ) );
        g.setPaint( p );  // 恢复原来的图形属性设置
    } // 方法mb_drawCircleGradientPaint结束

    public void mb_drawRectangleTextureGraphics(Graphics2D g, int x, int y)
    {
        Paint p = g.getPaint( ); // 获取原来的图形属性设置
        BufferedImage buffImage
            = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB );

        Graphics2D gg = buffImage.createGraphics( );   
        gg.setColor( Color.yellow );
        gg.fillRect( 0, 0, 10, 10 ); // 将图像背景设置为黄色
        gg.setColor( Color.blue );
        gg.drawRect( 1, 1, 6, 6 );   // 画一个蓝色的方框
        gg.setColor( Color.green );
        gg.fillRect( 1, 1, 3, 3 );   // 画一个绿色的正方形
        gg.setColor( Color.red );
        gg.fillRect( 4, 4, 3, 3 );   // 画一个红色的正方形
 
        g.setPaint( new TexturePaint(buffImage, new Rectangle( 10, 10 ) ) );
        g.fill( new Rectangle2D.Double( x, y, 100, 100 ) );
        g.setPaint( p );  // 恢复原来的图形属性设置
    } // 方法mb_drawRectangleTextureGraphics结束

    public void mb_drawRectangleTextureImage(Graphics2D g, int x, int y)
    {
        Paint p = g.getPaint( ); // 获取原来的图形属性设置
        BufferedImage buffImage;
        try
        {
            File f = new File("ts.jpg");
            buffImage = ImageIO.read(f); // 读取图像
            g.setPaint( 
                new TexturePaint(buffImage, new Rectangle( 50, 50 ) ) );
            g.fill( new Rectangle2D.Double( x, y, 100, 100 ) );
            g.setPaint( p );  // 恢复原来的图形属性设置
        }
        catch (Exception e)
        {
            System.err.println("发生异常:" + e);
            e.printStackTrace( );
        } // try-catch结构结束
    } // 方法mb_drawRectangleTextureImage结束

    protected void paintComponent(Graphics g)
    {
        mb_drawCircleGreen((Graphics2D)g, 20, 20);
        mb_drawCircleGradientPaint((Graphics2D)g, 140, 20);
        mb_drawRectangleTextureGraphics((Graphics2D)g, 260, 20);
        mb_drawRectangleTextureImage((Graphics2D)g, 380, 20);
    } // 方法paintComponent结束
} // 类J_Panel结束

public class J_Texture extends JFrame
{
    public J_Texture( )
    {
        super("颜色及纹理设置例程");
        Container c = getContentPane( );
        c.add(new J_Panel( ), BorderLayout.CENTER);
    } // J_Texture构造方法结束

    public static void main(String args[ ])
    {
        J_Texture app = new J_Texture( );

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(510, 180);
        app.setVisible(true);
    } // 方法main结束
} // 类J_Texture结束
