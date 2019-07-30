// ////////////////////////////////////////////////////////
// 
// J_LabelFrame.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     在框架中添加标签的例程。
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class J_LabelFrame extends JFrame
{
    public J_LabelFrame( )
    {
        super( "框架和标签例程" );
        String [ ] s = {"文本标签", "文字在图标的左侧", "文字在图标的下方"};
        ImageIcon [ ] ic = {null, new ImageIcon( "img1.gif" ),
            new ImageIcon( "img2.gif" )};
        int  [ ] ih  = {0, JLabel.LEFT,   JLabel.CENTER};
        int  [ ] iv  = {0, JLabel.CENTER, JLabel.BOTTOM};
        Container c = getContentPane( );
        c.setLayout( new FlowLayout(FlowLayout.LEFT) );
        for (int i=0; i<3; i++)
        {
            JLabel aLabel = new JLabel( s[i] , ic[i], JLabel.LEFT);
            if (i>0)
            {
                aLabel.setHorizontalTextPosition(ih[i]);
                aLabel.setVerticalTextPosition(iv[i]);
            } // if结构结束
            aLabel.setToolTipText( "第" + (i+1) + "个标签");
            c.add( aLabel );
        } // for循环结束
    } // J_LabelFrame构造方法结束

    public static void main(String args[ ])
    {
        J_LabelFrame app = new J_LabelFrame( );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize( 360, 150 );
        app.setVisible( true );
    } // 方法main结束
} // 类J_LabelFrame结束
