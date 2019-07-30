// ////////////////////////////////////////////////////////
// 
// J_PrintState.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     СӦ�ó����������ڵ���֤���̡�
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

import java.awt.Graphics;
import javax.swing.JApplet;

public class J_PrintState extends JApplet
{
    public void init( )
    {
        System.out.println("init: ��ʼ��");
    } // ����init����

    public void start( )
    { 
        System.out.println("start: ����");
    } // ����start����

    public void paint(Graphics g)
    {
        g.clearRect(0, 0, getWidth( ), getHeight( )); // ���Ʊ���
        g.drawString("��֤СӦ�ó������������", 20, 40);
        System.out.println("paint: ����");
    } // ����paint����

    public void stop( )
    { 
        System.out.println("stop: ֹͣ");
    } // ����stop����

    public void destroy( )
    { 
        System.out.println("destroy: �ر�");
    } // ����destroy����
} // ��J_PrintState����
