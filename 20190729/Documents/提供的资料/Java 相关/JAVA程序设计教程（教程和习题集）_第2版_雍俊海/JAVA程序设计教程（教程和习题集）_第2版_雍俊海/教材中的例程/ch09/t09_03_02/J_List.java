// ////////////////////////////////////////////////////////
// 
// J_List.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     同时是应用程序与小应用程序的图像显示例程。
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
// 版权:
// 使用本例子，请注明引用:
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
// 请合法使用例程，其用途应当合法有益而且不应对任何人造成任何
// 伤害或损失。同时请注意教材作者及出版社没有对例程做出任何承
// 诺与保证。
// 具体引用的方法及例子如下:
// 本程序是下面教材的一个例程(或本程序基于下面教材的例程修改)
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
//
// 雍俊海还编写过如下的教材和教参:
//      [1] 雍俊海. Java 程序设计. 北京: 清华大学出版社, 2004.
//      [2] 雍俊海. Java程序设计习题集(含参考答案). 
//          北京: 清华大学出版社, 2006.
//
// ////////////////////////////////////////////////////////

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class J_List extends JApplet
{
    private String    m_items[ ] = { "snow.gif", "flag.gif" , "rain.gif"};
    private JList     m_list    = new JList( m_items );
    private JLabel    m_label   = new JLabel( );
    private Icon      m_icons[ ] = new ImageIcon[3];
    private Image     m_image[ ] = null;
    Container m_container = null;

    public void init( )
    {
        int i;
        if (m_image == null)
        {
            m_image = new Image[3];
            for (i=0; i< 3; i++)
                m_image[i] = getImage(getCodeBase( ), m_items[i]);
        } // if结构结束
        for (i=0; i< 3; i++)
            m_icons[i] = new ImageIcon(m_image[i]);
        if (m_container == null)
            m_container = getContentPane( );
        m_container.setLayout(new BorderLayout( ));
        m_container.add( m_list, BorderLayout.WEST );
        m_list.setSelectedIndex(0);
        m_list.addListSelectionListener(new ListSelectionListener( )
            {
                public void valueChanged(ListSelectionEvent e )
                {
                    int s = m_list.getAnchorSelectionIndex( );
                    m_label.setIcon( m_icons[ s ] );
                } // 方法valueChanged结束
            } // 实现接口ListSelectionListener的内部类结束
        ); // addListSelectionListener方法调用结束
        m_container.add( m_label, BorderLayout.EAST );
        m_label.setIcon( m_icons[ 0 ] );
    } // 方法init结束

    public static void main( String args[ ] )
    { 
        JFrame f = new JFrame("应用程序");
        J_List app = new J_List( );

        app.m_container= f.getContentPane( );
        app.m_image = new Image[3];
        try
        {
            for (int i=0; i< 3; i++)
                app.m_image[i] = ImageIO.read( new File(app.m_items[i]) );
        }
        catch (Exception e)
        {
            System.err.println("发生异常:" + e);
            e.printStackTrace( );
        } // try-catch结构结束
        app.init( );
        f.setSize(200, 110);
        f.setVisible( true );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // 方法main结束
} // 类J_List结束
