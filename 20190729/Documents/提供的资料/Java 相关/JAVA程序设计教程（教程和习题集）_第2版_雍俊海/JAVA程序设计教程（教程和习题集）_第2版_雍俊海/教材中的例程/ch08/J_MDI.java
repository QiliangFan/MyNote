// ////////////////////////////////////////////////////////
// 
// J_MDI.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ���ֻ����ĵ����̡�
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class J_MDI extends JFrame
{
    private JDesktopPane m_desktop= new JDesktopPane( );
    private int m_count = 0;

    public J_MDI( )
    {
        super("MDI Example");
        JMenuBar  theMenuBar  = new JMenuBar( );
        JMenu     theMenuFile = new JMenu("File");
        JMenuItem theMenuItem = new JMenuItem("New");

        setJMenuBar(theMenuBar);
        theMenuBar.add(theMenuFile);
        theMenuFile.add(theMenuItem);
        theMenuFile.setMnemonic('F');
        theMenuItem.setMnemonic('N');

        Container theContainer= getContentPane( );
        theContainer.add(m_desktop);

        theMenuItem.addActionListener( new ActionListener( )
            {
                public void actionPerformed(ActionEvent e)
                {
                    String s= "Document " + m_count;
                    m_count++;
                    JInternalFrame theInternalFrame
                        =new JInternalFrame(s, true, true, true, true);
                    J_Panel thePanel = new J_Panel( );
                    Container c = theInternalFrame.getContentPane( );
                    c.setLayout(new BorderLayout( ));
                    c.add( thePanel, BorderLayout.CENTER );
                    theInternalFrame.pack( );

                    m_desktop.add( theInternalFrame );
                    theInternalFrame.setVisible( true );
                } // ����actionPerformed����
            } // ʵ�ֽӿ�ActionListener���ڲ������
        ); // ActionListener�������ý���
    } // J_MDI���췽������

    public static void main(String args[ ])
    {
        JFrame app = new J_MDI( );
        Container cp = app.getContentPane( );
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400, 250);
        app.setVisible(true);
    } // ����main����
} // ��J_MDI����
