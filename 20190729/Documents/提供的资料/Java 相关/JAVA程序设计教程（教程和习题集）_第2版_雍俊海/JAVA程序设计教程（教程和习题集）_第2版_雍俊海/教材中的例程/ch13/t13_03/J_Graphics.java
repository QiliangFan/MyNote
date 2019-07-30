// ////////////////////////////////////////////////////////
// 
// J_Graphics.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ���弰ͼ����ʾ���̡�
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
        Font bakF = g2d.getFont( ); // ����ԭ������������
        g2d.setFont(new Font("Serif", Font.ITALIC|Font.BOLD, 14 ) );
        g2d.drawString("��������", 0, 0);
        g2d.setFont(bakF);  // �ָ�������������

        g2d.rotate(-Math.PI/2);
        g2d.translate( 40, -20 );
        g2d.draw(new Arc2D.Double(0, 30, 40, 40, 0, 360, Arc2D.OPEN));
        g2d.translate( 70, 0 );
        g2d.draw(new QuadCurve2D.Double(0, 30, 20, 130, 40, 30));
        g2d.translate( 70, 0 );
        g2d.draw(new Ellipse2D.Double(0, 10, 40, 80));
        g2d.translate( 70, 0 );
        g2d.draw(new Polygon(x, y, x.length));
    } // ����paintComponent����
} // ��J_Panel����

public class J_Graphics extends JFrame
{
    public J_Graphics( )
    {
        super("���弰ͼ����ʾ����");
        Container c = getContentPane( );
        c.add(new J_Panel( ), BorderLayout.CENTER);
    } // J_Graphics���췽������

    public static void main(String args[ ])
    {
        J_Graphics app = new J_Graphics( );

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(540, 160);
        app.setVisible(true);
    } // ����main����
} // ��J_Graphics����
