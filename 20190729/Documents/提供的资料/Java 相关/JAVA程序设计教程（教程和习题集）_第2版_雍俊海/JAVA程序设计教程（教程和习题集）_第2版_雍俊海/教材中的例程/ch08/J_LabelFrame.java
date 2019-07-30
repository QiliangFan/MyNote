// ////////////////////////////////////////////////////////
// 
// J_LabelFrame.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �ڿ������ӱ�ǩ�����̡�
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class J_LabelFrame extends JFrame
{
    public J_LabelFrame( )
    {
        super( "��ܺͱ�ǩ����" );
        String [ ] s = {"�ı���ǩ", "������ͼ������", "������ͼ����·�"};
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
            } // if�ṹ����
            aLabel.setToolTipText( "��" + (i+1) + "����ǩ");
            c.add( aLabel );
        } // forѭ������
    } // J_LabelFrame���췽������

    public static void main(String args[ ])
    {
        J_LabelFrame app = new J_LabelFrame( );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize( 360, 150 );
        app.setVisible( true );
    } // ����main����
} // ��J_LabelFrame����
