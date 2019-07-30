// ////////////////////////////////////////////////////////
// 
// J_ImageApplet.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     图像显示例程。
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

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class J_ImageApplet extends JApplet
{
    Image m_image[ ] = new Image[2];
    BufferedImage m_bufferedImage;
    MediaTracker m_media;

    public void init( )
    { 
        m_image[0]= getImage(getCodeBase( ), "ts1.gif");
        m_image[1]= getImage(getCodeBase( ), "ts2.gif");
        // 实际上这时并没有真正加载图像
        System.out.println("图像[0]的宽度为: " 
            + m_image[0].getWidth(this)); 
        System.out.println("图像[0]的高度为: "
            + m_image[0].getHeight(this));

        m_media = new MediaTracker(this);
        m_media.addImage(m_image[0], 0);
        try
        {
            m_media.waitForID(0);
        }
        catch (Exception e)
        {
            System.err.println("发生异常:" + e);
            e.printStackTrace( );
        } // try-catch结构结束

        if (m_media.checkID(0, true))
        {
            if (m_media.isErrorID(0))
                System.out.println("在加载图像[0]时出错。");
            else
                System.out.println("成功加载图像[0]。");
        }
        else
        {
            System.out.println("无法完成图像[0]的加载。");
        } // if-else结构结束

        System.out.println("图像[0]的宽度为: "
            + m_image[0].getWidth(this));
        System.out.println("图像[0]的高度为: "
            + m_image[0].getHeight(this));

        m_bufferedImage = new BufferedImage(m_image[0].getWidth(this),
            m_image[0].getHeight(this), BufferedImage.TYPE_INT_RGB);
        Graphics g = m_bufferedImage.createGraphics( );
        g.drawImage(m_image[0], 0, 0,
            m_image[0].getHeight(this), m_image[0].getHeight(this), this);

        Color c = new Color(255, 0, 0);
        for (int i=0; i< m_bufferedImage.getWidth( ); i++)
            for (int j=0; j< 20; j++)
                m_bufferedImage.setRGB(i, j, c.getRGB( ));
    } // 方法init结束

    public void paint(Graphics g)
    { 
        g.drawImage(m_image[0],   0,   0, 150, 150, this);
        g.drawImage(m_image[1], 150,   0, 150, 150, this);
        g.drawImage(m_bufferedImage,   0, 150, 300, 150, this);
    } // 方法paint结束
} // 类J_ImageApplet结束
