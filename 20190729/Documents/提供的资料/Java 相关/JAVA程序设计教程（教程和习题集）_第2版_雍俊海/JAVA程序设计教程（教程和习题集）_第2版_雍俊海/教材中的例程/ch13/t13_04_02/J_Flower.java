// ////////////////////////////////////////////////////////
// 
// J_Flower.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ������������̡����������š�
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
    int  m_frame = 0; // ��ǰ֡��֡��
    Timer  m_timer; // ��ʱ��
    boolean  m_frozen = false; // ��ʱ��״̬: ��Ϊfalseʱ����ͣ����������

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
            } // ����mousePressed����
        }); // ������Ϊ��MouseAdapter�������ڲ�����������ҷ������ý���
    } // ����init����

    public void start( )
    { 
        mb_startAnimation( );
    } // ����start����

    public void stop( )
    { 
        mb_stopAnimation( );
    } // ����stop����

    public void actionPerformed(ActionEvent e)
    {
        m_frame++; // ��ǰ֡������1
        repaint( ); // ���µ�ǰ֡
    } // ����actionPerformed����

    public void mb_startAnimation( )
    {
        if (!m_frozen && !m_timer.isRunning( ))
            m_timer.start( );
    } // ����mb_startAnimation����

    public void mb_stopAnimation( )
    {
        if (m_timer.isRunning( ))
            m_timer.stop( );
    } // ����mb_stopAnimation����

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
        g2d.fill( new Rectangle2D.Double( 0, 0, 320,  300)); // ���Ʊ���

        g2d.setColor( Color.magenta ); // ����С��
        g2d.fill( new Ellipse2D.Double( 160-b_2, 150-a_2, b, a));
        g2d.fill( new Ellipse2D.Double( 160-a_2, 150-b_2, a, b ));		
        g2d.setColor( Color.orange );
        g2d.fill( new Ellipse2D.Double( 160-b_2, 150-b_2, b, b ));

        g2d.setPaint(Color.white); // ��ʾ��ǰ֡��
        g2d.fill( new Rectangle2D.Double( 0, 300, 320, 20 ) );
        g2d.setColor(Color.black);
        g2d.drawString(""+m_frame, 150, 315);
    } // ����paint����
} // ��J_Flower����
