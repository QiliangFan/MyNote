
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class J_Keyboard extends JFrame
{
    public J_Keyboard( )
    {
        super( "�����¼���������" );
        Container c = getContentPane( );

        JTextField tf =  new JTextField("", 15);
        tf.addFocusListener( new FocusListener( )
            {
                public void focusGained(FocusEvent e)
                {
                    System.out.println("��ý���");
                } // ����focusGained����
                public void focusLost(FocusEvent e)
                {
                    System.out.println("ʧȥ����");
                } // ����focusLost����
            } // ʵ�ֽӿ�FocusListener���ڲ������
        ); // addFocusListener�������ý���
        tf.addKeyListener( new KeyAdapter( )
            {
                public void keyTyped(KeyEvent e)
                {
                    System.out.println("�����¼�: " + e.getKeyChar( ));
                } // ����keyTyped����
            } // ʵ�ֳ�����KeyAdapter���ڲ��������
        ); // addKeyListener�������ý���
        c.add( tf,  BorderLayout.CENTER );
    } // J_Keyboard���췽������

    public static void main(String args[ ])
    {
        J_Keyboard app = new J_Keyboard( );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize( 350, 80 );
        app.setVisible( true );
    } // ����main����
} // ��J_Keyboard����
