


import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class J_CardLayout
{
    public static void main(String args[ ])
    {
        JFrame app = new JFrame( "��Ƭ���ֹ���������" );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize( 180, 100 );
        Container c = app.getContentPane( );
        CardLayout card = new CardLayout( );
        c.setLayout( card );
        String s;
        JButton b;
        for (int i=0; i<5; i++)
        {
            s = "��ť" + (i+1);
            b = new JButton( s );
            c.add( b, s );
        } // forѭ������
        card.show(c, "��ť3");
        card.next( c );
        app.setVisible( true );
    } // ����main����
} // ��J_CardLayout����
