// ////////////////////////////////////////////////////////
// 
// J_Audio.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ���������벥��СӦ�ó������̡�
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

import java.applet.AudioClip;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class J_Audio extends JApplet implements ActionListener, ItemListener
{
    private AudioClip m_soundFirst,  m_soundSecond, m_soundCurrent;
    private JButton   m_buttonPlay,  m_buttonLoop,  m_buttonStop;
    private JComboBox m_comboChoose;

    public void init( ) // �ڱ������н�������ͼ���û����棬����ȡ������Դ
    {
        Container container = getContentPane( );
        container.setLayout( new FlowLayout( ) );

        String choices[ ] = { "hi", "bark" };
        m_comboChoose = new JComboBox( choices );
        m_comboChoose.addItemListener( this );
        container.add( m_comboChoose );

        m_buttonPlay = new JButton( "����" );
        m_buttonPlay.addActionListener( this );
        container.add( m_buttonPlay );
        
        m_buttonLoop = new JButton( "ѭ������" );
        m_buttonLoop.addActionListener( this );
        container.add( m_buttonLoop );
        
        m_buttonStop = new JButton( "��ͣ����" );
        m_buttonStop.addActionListener( this );
        container.add( m_buttonStop );
        
        m_soundFirst = getAudioClip( getDocumentBase( ), "hi.au" );
        m_soundSecond = getAudioClip( getDocumentBase( ), "bark.au" );
        m_soundCurrent = m_soundFirst;
    } // ����init����

    public void stop( )
    {
        m_soundCurrent.stop( ); // ��ֹ�����Ĳ���
    } // ����stop����

    public void itemStateChanged(ItemEvent e)
    {
        m_soundCurrent.stop( );
        m_soundCurrent=(m_comboChoose.getSelectedIndex( ) == 0 ? 
            m_soundFirst : m_soundSecond);
    } // ����itemStateChanged����

    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource( ) == m_buttonPlay ) 
            m_soundCurrent.play( );
        else if ( e.getSource( ) == m_buttonLoop ) 
            m_soundCurrent.loop( );
        else if ( e.getSource( ) == m_buttonStop ) 
            m_soundCurrent.stop( );
    } // ����actionPerformed����
} // ��J_Audio����
