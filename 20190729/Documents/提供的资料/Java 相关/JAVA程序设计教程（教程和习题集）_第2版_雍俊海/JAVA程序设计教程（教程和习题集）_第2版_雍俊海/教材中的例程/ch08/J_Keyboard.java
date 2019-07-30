
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
        super( "键盘事件处理例程" );
        Container c = getContentPane( );

        JTextField tf =  new JTextField("", 15);
        tf.addFocusListener( new FocusListener( )
            {
                public void focusGained(FocusEvent e)
                {
                    System.out.println("获得焦点");
                } // 方法focusGained结束
                public void focusLost(FocusEvent e)
                {
                    System.out.println("失去焦点");
                } // 方法focusLost结束
            } // 实现接口FocusListener的内部类结束
        ); // addFocusListener方法调用结束
        tf.addKeyListener( new KeyAdapter( )
            {
                public void keyTyped(KeyEvent e)
                {
                    System.out.println("键盘事件: " + e.getKeyChar( ));
                } // 方法keyTyped结束
            } // 实现抽象类KeyAdapter的内部子类结束
        ); // addKeyListener方法调用结束
        c.add( tf,  BorderLayout.CENTER );
    } // J_Keyboard构造方法结束

    public static void main(String args[ ])
    {
        J_Keyboard app = new J_Keyboard( );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize( 350, 80 );
        app.setVisible( true );
    } // 方法main结束
} // 类J_Keyboard结束
