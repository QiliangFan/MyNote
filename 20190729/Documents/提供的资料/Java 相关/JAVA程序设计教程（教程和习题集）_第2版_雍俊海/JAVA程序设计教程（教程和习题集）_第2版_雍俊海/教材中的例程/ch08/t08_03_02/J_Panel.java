// ////////////////////////////////////////////////////////
// 
// J_Panel.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ���ֻ�������̡�
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

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;
import javax.swing.JPanel;

public class J_Panel extends JPanel
{
    private Vector<Vector<Point>> m_vectorSet
        = new Vector<Vector<Point>>( );

    public J_Panel( )
    {
        addMouseListener( new MouseAdapter( )
            {
                public void mousePressed(MouseEvent e)
                {
                    Point p= new Point(e.getX( ), e.getY( ));
                    Vector<Point> v= new Vector<Point>( ); // �µıʻ�
                    v.add(p); // ��ӱʻ������
                    m_vectorSet.add(v);
                } // ����mousePressed����
            } // ʵ�ֳ�����MouseAdapter���ڲ��������
        ); // addMouseListener�������ý���
        addMouseMotionListener( new MouseMotionAdapter( )
            {
                public void mouseDragged(MouseEvent e) 
                {
                    Point p= new Point(e.getX( ), e.getY( ));
                    int n= m_vectorSet.size( )-1;
                    Vector<Point> v= m_vectorSet.get(n);
                    v.add(p); // ��ӱʻ����м����յ�
                    repaint( );
                } // ����mouseDragged����
            } // ʵ�ֳ�����MouseMotionAdapter���ڲ��������
        ); // addMouseMotionListener�������ý���
    } // J_Panel���췽������

    protected void paintComponent(Graphics g)
    {
        g.clearRect(0 , 0, getWidth( ), getHeight( )); // �������
        Vector<Point> v;
        Point s, t;
        int i, j, m;
        int n = m_vectorSet.size( );
        for (i=0; i<n; i++)
        {
            v = m_vectorSet.get(i);
            m = v.size( )-1;
            for (j=0; j<m; j++)
            {
                s = (Point)v.get(j);
                t = (Point)v.get(j+1);
                g.drawLine(s.x, s.y, t.x, t.y);
            } // �ڲ�forѭ������
        } // �ⲿforѭ������
    } // ����paintComponent����

    public Dimension getPreferredSize( )
    {
        return new Dimension( 250, 120 );
    } // ����getPreferredSize����
} // ��J_Panel����
