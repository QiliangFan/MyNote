// ////////////////////////////////////////////////////////
// 
// J_DrawSin.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �����������ߵ�СӦ�ó���ͼ���û��������̡�
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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JPanel;

class J_Panel extends JPanel
{
    protected void paintComponent(Graphics g)
    {
        double d, tx;
        int    x, y, x0, y0;

        d= Math.PI/100; // �����߷ֳ�ΪԼ200��
        x0=y0=0;
        for (tx=0, x=20; tx <= 2*Math.PI; tx+=d, x++)
        { // ���߻���
            y= 120-(int)(Math.sin(tx)*50+60); // ���š�ƽ�ơ��Գ�
            if (x>20)
                g.drawLine(x0, y0, x, y); // �����߷ֳ�Ϊ�߶Σ�Ȼ����λ���
            x0= x;
            y0= y;
        } // forѭ������
        g.drawString("y=sin(x)", 10, 70);
    } // ����paintComponent����
} // ��J_Panel����

public class J_DrawSin extends JApplet
{
    public void init( )
    {
        Container c = getContentPane( );
        c.add(new J_Panel( ), BorderLayout.CENTER);
    } // ����init����
} // ��J_DrawSin����
