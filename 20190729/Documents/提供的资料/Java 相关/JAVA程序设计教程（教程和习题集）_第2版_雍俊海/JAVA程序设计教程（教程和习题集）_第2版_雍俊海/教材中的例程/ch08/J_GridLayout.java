

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class J_GridLayout
{
    public static void main(String args[ ])
    {
        JFrame app = new JFrame( "���񲼾ֹ���������" );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize( 520, 120 );
        Container c = app.getContentPane( );
        c.setLayout( new GridLayout(2, 5) );
        String s;
        JButton b;
        for (int i=0; i<5; i++)
        {
            s = "��ť" + (i+1);
            b = new JButton( s );
            c.add( b );
        } // forѭ������
        app.setVisible( true );
    } // ����main����
} // ��J_GridLayout����
