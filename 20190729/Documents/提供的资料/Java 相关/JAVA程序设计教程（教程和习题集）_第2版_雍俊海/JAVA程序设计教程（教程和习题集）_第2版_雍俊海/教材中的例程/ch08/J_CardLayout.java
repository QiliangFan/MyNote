


import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class J_CardLayout
{
    public static void main(String args[ ])
    {
        JFrame app = new JFrame( "卡片布局管理器例程" );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize( 180, 100 );
        Container c = app.getContentPane( );
        CardLayout card = new CardLayout( );
        c.setLayout( card );
        String s;
        JButton b;
        for (int i=0; i<5; i++)
        {
            s = "按钮" + (i+1);
            b = new JButton( s );
            c.add( b, s );
        } // for循环结束
        card.show(c, "按钮3");
        card.next( c );
        app.setVisible( true );
    } // 方法main结束
} // 类J_CardLayout结束
