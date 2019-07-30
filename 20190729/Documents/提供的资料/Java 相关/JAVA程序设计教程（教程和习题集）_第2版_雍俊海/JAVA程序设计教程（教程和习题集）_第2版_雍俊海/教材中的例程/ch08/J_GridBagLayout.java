// ////////////////////////////////////////////////////////
// 
// J_GridBagLayout.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ��������ֹ��������̡�
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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class J_GridBagLayout
{
    public static void main(String args[ ])
    {
        JFrame app = new JFrame( "��������ֹ���������" );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize( 320, 160 );
        Container c = app.getContentPane( );
        GridBagLayout gr = new GridBagLayout( );
        c.setLayout( gr );
        int [ ] gx = {0, 1, 2, 3, 1, 0, 0, 2};
        int [ ] gy = {0, 0, 0, 0, 1, 2, 3, 2};
        int [ ] gw = {1, 1, 1, 1, GridBagConstraints.REMAINDER, 2, 2, 2};
        int [ ] gh = {2, 1, 1, 1, 1, 1, 1, 2};
        GridBagConstraints gc = new GridBagConstraints( );
        String s;
        JButton b;
        for (int i=0; i < gx.length; i++)
        {
            s = "��ť" + (i+1);
            b = new JButton( s );
            gc.gridx = gx[i];
            gc.gridy = gy[i];
            gc.gridwidth = gw[i];
            gc.gridheight = gh[i];
            gc.fill = GridBagConstraints.BOTH;
            gr.setConstraints(b, gc);
            c.add( b );
        } // forѭ������
        app.setVisible( true );
    } // ����main����
} // ��J_GridBagLayout����
