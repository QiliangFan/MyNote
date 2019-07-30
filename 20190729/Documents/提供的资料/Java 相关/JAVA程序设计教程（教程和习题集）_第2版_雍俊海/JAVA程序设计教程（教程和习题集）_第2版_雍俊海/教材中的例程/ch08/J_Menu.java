// ////////////////////////////////////////////////////////
// 
// J_Menu.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ����˵����̡�
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class J_Menu extends JFrame
{
    public J_Menu( )
    {
        super("����˵�Ӧ��ʾ��");
        JMenuBar mBar = new JMenuBar( );
        setJMenuBar(mBar); // ���ò˵���

        JMenu [ ] m = { new JMenu("�ļ�(F)"), new JMenu("�༭(E)") };
        char  [ ][ ] mC = {{'F', 'E'}, {'O', 'S'}, {'C', 'V'}};
        JMenuItem [ ] [ ] mI =
        {
            {new JMenuItem("��(O)"), new JMenuItem("����(S)")},
            {new JMenuItem("����(C)"), new JMenuItem("ճ��(V)")}
        };
        int i, j;
        
        for (i=0; i < m.length; i++)
        {
            mBar.add(m[i]); // �������ʽ�˵�
            m[i].setMnemonic(mC[0][i]); // �������Ƿ�
            for (j=0; j < mI[i].length; j++)
            {
                m[i].add(mI[i][j]); // �������ʽ�˵���
                mI[i][j].setMnemonic(mC[i+1][j]); // �������Ƿ�
                mI[i][j].setAccelerator( // ���ÿ�ݼ�
                    KeyStroke.getKeyStroke("ctrl " + mC[i+1][j]));
                mI[i][j].addActionListener( new ActionListener( )
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            JMenuItem mItem = (JMenuItem)e.getSource( );
                            System.out.println("���в˵���: "
                                + mItem.getText( ));
                        } // ����actionPerformed����
                    } // ʵ�ֽӿ�ActionListener���ڲ������
                ); // ����addActionListener���ý���
            } // �ڲ�forѭ������
        } // �ⲿforѭ������
        m[0].insertSeparator(1); 
    } // J_Menu���췽������
    
    public static void main(String args[ ])
    {
        JFrame app = new J_Menu( );

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(250, 120);
        app.setVisible(true);
    } // ����main����
} // ��J_Menu����
