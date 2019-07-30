// ////////////////////////////////////////////////////////
// 
// J_MDI.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     随手画多文档例程。
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class J_MDI extends JFrame
{
    private JDesktopPane m_desktop= new JDesktopPane( );
    private int m_count = 0;

    public J_MDI( )
    {
        super("MDI Example");
        JMenuBar  theMenuBar  = new JMenuBar( );
        JMenu     theMenuFile = new JMenu("File");
        JMenuItem theMenuItem = new JMenuItem("New");

        setJMenuBar(theMenuBar);
        theMenuBar.add(theMenuFile);
        theMenuFile.add(theMenuItem);
        theMenuFile.setMnemonic('F');
        theMenuItem.setMnemonic('N');

        Container theContainer= getContentPane( );
        theContainer.add(m_desktop);

        theMenuItem.addActionListener( new ActionListener( )
            {
                public void actionPerformed(ActionEvent e)
                {
                    String s= "Document " + m_count;
                    m_count++;
                    JInternalFrame theInternalFrame
                        =new JInternalFrame(s, true, true, true, true);
                    J_Panel thePanel = new J_Panel( );
                    Container c = theInternalFrame.getContentPane( );
                    c.setLayout(new BorderLayout( ));
                    c.add( thePanel, BorderLayout.CENTER );
                    theInternalFrame.pack( );

                    m_desktop.add( theInternalFrame );
                    theInternalFrame.setVisible( true );
                } // 方法actionPerformed结束
            } // 实现接口ActionListener的内部类结束
        ); // ActionListener方法调用结束
    } // J_MDI构造方法结束

    public static void main(String args[ ])
    {
        JFrame app = new J_MDI( );
        Container cp = app.getContentPane( );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400, 250);
        app.setVisible(true);
    } // 方法main结束
} // 类J_MDI结束
