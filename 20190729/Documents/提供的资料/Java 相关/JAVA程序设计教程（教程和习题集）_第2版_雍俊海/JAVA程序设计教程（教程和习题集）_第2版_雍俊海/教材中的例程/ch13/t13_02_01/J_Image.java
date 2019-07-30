// ////////////////////////////////////////////////////////
// 
// J_Image.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ͼ�����롢��������ش������̡�
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
        System.out.print("��ǰ֧�ֵĿɶ�ȡ��ͼ��������: ");
        mb_printString(ImageIO.getReaderFormatNames( ));
        try
        {
            File f = new File("ts.jpg");
            m_image = ImageIO.read(f); // ��ȡͼ��
            mb_getPixel(0, 0); // ���ͼ���һ��������ɫֵ
            mb_setPixel(new Color(255, 0, 0)); // �޸�ͼ��Ĳ�������(�������)
            f = new File("ts.png");
            ImageIO.write(m_image, "png", f); // ����ͼ��
        }
        catch (Exception e)
        {
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        } // try-catch�ṹ����
        System.out.print("��ǰ֧�ֵĿ�д���ͼ��������: ");
        mb_printString(ImageIO.getWriterFormatNames( ));
    } // J_Panel���췽������

    public void mb_printString(String [ ] s)
    {
        for (int i=0; i< s.length; i++)
            System.out.print(s[i]+ " ");
        System.out.println( );
    } // ����mb_printString����

    public void mb_getPixel(int x, int y)
    {
        Color c = new Color(m_image.getRGB(x, y));
        System.out.print("ͼ��λ��(" + x + ", " + y + ")����ɫֵΪ: (");
        System.out.println(c.getRed( ) + ", "
            + c.getGreen( ) + ", " + c.getBlue( ) + ")");
    } // ����mb_getPixel����

    public void mb_setPixel(Color c)
    {
        for (int i=0; i< m_image.getWidth( ); i++)
            for (int j=0; j< 20; j++)
                m_image.setRGB(i, j, c.getRGB( ));
    } // ����mb_setPixel����

    protected void paintComponent(Graphics g)
    {
        g.drawImage(m_image, 0, 0, 150, 150, this); // ��ʾͼ��
    } // ����paintComponent����
} // ��J_Panel����

public class J_Image extends JFrame
{
    public J_Image( )
    {
        super("ͼ��������");
        Container c = getContentPane( );
        c.add(new J_Panel( ), BorderLayout.CENTER);
    } // J_Image���췽������

    public static void main(String args[ ])
    {
        J_Image app = new J_Image( );

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(200, 200);
        app.setVisible(true);
    } // ����main����
} // ��J_Image����
