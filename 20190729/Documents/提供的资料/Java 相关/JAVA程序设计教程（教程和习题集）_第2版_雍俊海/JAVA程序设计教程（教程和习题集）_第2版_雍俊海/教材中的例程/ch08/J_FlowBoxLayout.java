// ////////////////////////////////////////////////////////
// 
// J_FlowBoxLayout.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ��ϲ��ַ�ʽ���̡�
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
// ��Ȩ:
// ʹ�ñ����ӣ���ע������:
//     Ӻ����. Java ������ƽ̳�. ����: �廪��ѧ������, 2007.
// ��Ϸ�ʹ�����̣�����;Ӧ���Ϸ�������Ҳ�Ӧ���κ�������κ�
// �˺�����ʧ��ͬʱ��ע��̲����߼�������û�ж����������κγ�
// ŵ�뱣֤��
// �������õķ�������������:
// ������������̲ĵ�һ������(�򱾳����������̲ĵ������޸�)
//     Ӻ����. Java ������ƽ̳�. ����: �廪��ѧ������, 2007.
//
// Ӻ��������д�����µĽ̲ĺͽ̲�:
//      [1] Ӻ����. Java �������. ����: �廪��ѧ������, 2004.
//      [2] Ӻ����. Java�������ϰ�⼯(���ο���). 
//          ����: �廪��ѧ������, 2006.
//
// ////////////////////////////////////////////////////////


import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class J_FlowBoxLayout
{
    public static void main(String args[ ])
    {
        JFrame app = new JFrame( "��ϲ��ַ�ʽ����" );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize( 215, 150 );
        Container c = app.getContentPane( );
        c.setLayout(new FlowLayout( ));
        JPanel [ ] p = new JPanel[3];
        int i;
        for (i=0; i<3; i++)
        {
            p[i]= new JPanel( );
            p[i].setLayout(new BoxLayout(p[i], BoxLayout.X_AXIS));
            c.add( p[i] );
        } // forѭ������
        String s;
        JButton b;
        int [ ] pj = {0, 1, 1, 2, 2, 2};
        for (i=0; i<6; i++)
        {
            s = "��ť" + (i+1);
            b = new JButton( s );
            p[pj[i]].add( b );
        } // forѭ������
        app.setVisible( true );
    } // ����main����
} // ��J_FlowBoxLayout����
