// ////////////////////////////////////////////////////////
// 
// J_Lines.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     组合框、列表框、文本区域和滚动窗格例程。
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


import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class J_Lines extends JFrame
{
    public J_Lines( )
    {
        super( "多行组件例程" );
        Container c = getContentPane( );
        c.setLayout( new FlowLayout( ) );

        String [] s = {"选项1", "选项2", "选项3"};
        JComboBox cb = new JComboBox( s );
        JList t = new JList( s );
        JTextArea ta = new JTextArea("1\n2\n3\n4\n5", 3, 10);
        JScrollPane sta = new JScrollPane( ta );
        c.add( cb );
        c.add( t );
        c.add( sta );
    } // J_Lines构造方法结束

    public static void main(String args[ ])
    {
        J_Lines app = new J_Lines( );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize( 250, 120 );
        app.setVisible( true );
    } // 方法main结束
} // 类J_Lines结束
