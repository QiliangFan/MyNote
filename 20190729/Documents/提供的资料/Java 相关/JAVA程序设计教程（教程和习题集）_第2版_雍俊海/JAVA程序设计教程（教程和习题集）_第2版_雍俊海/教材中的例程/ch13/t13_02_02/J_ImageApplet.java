// ////////////////////////////////////////////////////////
// 
// J_ImageApplet.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ͼ����ʾ���̡�
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
// ��Ȩ:
// ʹ�ñ����ӣ���ע������:
//     Ӻ����. Java ������ƽ̳�. ����: �廪��ѧ������, 2007.
// ��Ϸ�ʹ�����̣�����;Ӧ���Ϸ�������Ҳ�Ӧ���κ�������κ�
// �˺�����ʧ��ͬʱ��ע��̲����߼�������û�ж����������κγ�
// ŵ�뱣֤��
// �������õķ�������������:
// ������������̲ĵ�һ������(�򱾳����������̲ĵ������޸�)
//     Ӻ����. Java ������ƽ̳�. ����: �廪��ѧ������, 2007.
//
// Ӻ��������д�����µĽ̲ĺͽ̲�:
//      [1] Ӻ����. Java �������. ����: �廪��ѧ������, 2004.
//      [2] Ӻ����. Java�������ϰ�⼯(���ο���). 
//          ����: �廪��ѧ������, 2006.
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
        // ʵ������ʱ��û����������ͼ��
        System.out.println("ͼ��[0]�Ŀ��Ϊ: " 
            + m_image[0].getWidth(this)); 
        System.out.println("ͼ��[0]�ĸ߶�Ϊ: "
            + m_image[0].getHeight(this));

        m_media = new MediaTracker(this);
        m_media.addImage(m_image[0], 0);
        try
        {
            m_media.waitForID(0);
        }
        catch (Exception e)
        {
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        } // try-catch�ṹ����

        if (m_media.checkID(0, true))
        {
            if (m_media.isErrorID(0))
                System.out.println("�ڼ���ͼ��[0]ʱ����");
            else
                System.out.println("�ɹ�����ͼ��[0]��");
        }
        else
        {
            System.out.println("�޷����ͼ��[0]�ļ��ء�");
        } // if-else�ṹ����

        System.out.println("ͼ��[0]�Ŀ��Ϊ: "
            + m_image[0].getWidth(this));
        System.out.println("ͼ��[0]�ĸ߶�Ϊ: "
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
    } // ����init����

    public void paint(Graphics g)
    { 
        g.drawImage(m_image[0],   0,   0, 150, 150, this);
        g.drawImage(m_image[1], 150,   0, 150, 150, this);
        g.drawImage(m_bufferedImage,   0, 150, 300, 150, this);
    } // ����paint����
} // ��J_ImageApplet����
