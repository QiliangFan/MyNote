// ////////////////////////////////////////////////////////
// 
// J_Image.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     图像输入、输出与像素处理例程。
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

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

class J_Panel extends JPanel
{
    BufferedImage m_image;

    public J_Panel( )
    {
        System.out.print("当前支持的可读取的图像类型有: ");
        mb_printString(ImageIO.getReaderFormatNames( ));
        try
        {
            File f = new File("ts.jpg");
            m_image = ImageIO.read(f); // 读取图像
            mb_getPixel(0, 0); // 输出图像的一个像素颜色值
            mb_setPixel(new Color(255, 0, 0)); // 修改图像的部分内容(加条红边)
            f = new File("ts.png");
            ImageIO.write(m_image, "png", f); // 保存图像
        }
        catch (Exception e)
        {
            System.err.println("发生异常:" + e);
            e.printStackTrace( );
        } // try-catch结构结束
        System.out.print("当前支持的可写入的图像类型有: ");
        mb_printString(ImageIO.getWriterFormatNames( ));
    } // J_Panel构造方法结束

    public void mb_printString(String [ ] s)
    {
        for (int i=0; i< s.length; i++)
            System.out.print(s[i]+ " ");
        System.out.println( );
    } // 方法mb_printString结束

    public void mb_getPixel(int x, int y)
    {
        Color c = new Color(m_image.getRGB(x, y));
        System.out.print("图像位置(" + x + ", " + y + ")的颜色值为: (");
        System.out.println(c.getRed( ) + ", "
            + c.getGreen( ) + ", " + c.getBlue( ) + ")");
    } // 方法mb_getPixel结束

    public void mb_setPixel(Color c)
    {
        for (int i=0; i< m_image.getWidth( ); i++)
            for (int j=0; j< 20; j++)
                m_image.setRGB(i, j, c.getRGB( ));
    } // 方法mb_setPixel结束

    protected void paintComponent(Graphics g)
    {
        g.drawImage(m_image, 0, 0, 150, 150, this); // 显示图像
    } // 方法paintComponent结束
} // 类J_Panel结束

public class J_Image extends JFrame
{
    public J_Image( )
    {
        super("图像处理例程");
        Container c = getContentPane( );
        c.add(new J_Panel( ), BorderLayout.CENTER);
    } // J_Image构造方法结束

    public static void main(String args[ ])
    {
        J_Image app = new J_Image( );

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(200, 200);
        app.setVisible(true);
    } // 方法main结束
} // 类J_Image结束
