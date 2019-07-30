// ////////////////////////////////////////////////////////
// 
// J_AnimatorTimer.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ������������̡�
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.Timer;

public class J_AnimatorTimer extends JApplet implements ActionListener
{
    int  m_frame = 0; // ��ǰ֡��֡��
    Timer  m_timer; // ��ʱ��
    boolean  m_frozen = false; // ��ʱ��״̬: ��Ϊfalseʱ����ͣ����������
    JLabel  m_label = new JLabel("��1֡", JLabel.CENTER);

    public void init( )
    {
        int delay = 50;
        m_timer = new Timer(delay, this);
        m_timer.setInitialDelay(0);
        m_timer.setCoalesce(true);

        getContentPane( ).add(m_label, BorderLayout.CENTER);
        m_label.addMouseListener(new MouseAdapter( )
        {
            public void mousePressed(MouseEvent e)
            {
                m_frozen = !m_frozen;
                if (m_frozen)
                     mb_stopAnimation( );
                else mb_startAnimation( );
            } // ����mousePressed����
        }); // ������Ϊ��MouseAdapter�������ڲ�����������ҷ������ý���
    } // ����init����

    public void start( )
    { 
        mb_startAnimation( );
    } // ����start����

    public void stop( )
    { 
        mb_stopAnimation( );
    } // ����stop����

    public void actionPerformed(ActionEvent e)
    {
        m_frame++; // ��ǰ֡������1
        m_label.setText("��" + m_frame + "֡"); // ���µ�ǰ֡��
    } // ����actionPerformed����

    public void mb_startAnimation( )
    {
        if (!m_frozen && !m_timer.isRunning( ))
            m_timer.start( );
    } // ����mb_startAnimation����

    public void mb_stopAnimation( )
    {
        if (m_timer.isRunning( ))
            m_timer.stop( );
    } // ����mb_stopAnimation����
} // ��J_AnimatorTimer����
