// ////////////////////////////////////////////////////////
// 
// J_Digit.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     小应用程序图形用户界面例程——输入数字。
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
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextField;

public class J_Digit extends JApplet implements ActionListener
{
    private JTextField m_textField= new JTextField( );

    public void init( )
    {
        Container c = getContentPane( );
        JButton b;
        String [ ] s= {BorderLayout.SOUTH, BorderLayout.EAST,
                      BorderLayout.NORTH, BorderLayout.WEST};
        for (int i=0; i<4; i++)
        {
            b= new JButton(""+i);
            c.add(b, s[i]);
            b.addActionListener(this);
        } // for循环结束
        c.add(m_textField, BorderLayout.CENTER);
    } // 方法init结束

    public void actionPerformed(ActionEvent e)
    {
        String s= m_textField.getText( )+e.getActionCommand( );
        m_textField.setText(s);
    } // 方法actionPerformed结束
} // 类J_Digit结束
