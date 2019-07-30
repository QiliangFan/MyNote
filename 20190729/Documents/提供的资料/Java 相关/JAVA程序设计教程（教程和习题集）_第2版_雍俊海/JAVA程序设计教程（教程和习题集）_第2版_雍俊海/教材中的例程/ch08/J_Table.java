
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
import java.util.Vector;

public class J_Table extends JFrame
{
    DefaultTableModel m_data;
    JTable m_view;

    public J_Table( )
    {
        super("���Ӧ��ʾ��");
        Container c = getContentPane( );
        c.setLayout( new FlowLayout( ) );
        int i;

        // ����ĸ���ť
        JButton [ ] b = {new JButton("�����"), new JButton("�����"),
                        new JButton("ɾ����"), new JButton("ɾ����")};
        for (i=0; i<4; i++)
            c.add(b[i]);

        m_data = new DefaultTableModel( ); // ����һ���յ����ݱ��
        m_view = new JTable(m_data);
        m_view.setPreferredScrollableViewportSize(
            new Dimension(300, 150)); // ���ñ�����ʾ�����С
        m_view.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane sPane = new JScrollPane(m_view);
        c.add(sPane);

        b[0].addActionListener( new ActionListener( )
            {
                public void actionPerformed(ActionEvent e)
                {
                    mb_addRow( );
                    System.out.println("���һ��");
                } // ����actionPerformed����
            } // ʵ�ֽӿ�ActionListener���ڲ������
        ); // ����addActionListener���ý���

        b[1].addActionListener( new ActionListener( )
            {
                public void actionPerformed(ActionEvent e)
                {
                    mb_addColumn( );
                    System.out.println("���һ��");
                } // ����actionPerformed����
            } // ʵ�ֽӿ�ActionListener���ڲ������
        ); // ����addActionListener���ý���

        b[2].addActionListener( new ActionListener( )
            {
                public void actionPerformed(ActionEvent e)
                {
                    mb_deleteRow( );
                    System.out.println("ɾ����ǰ��");
                } // ����actionPerformed����
            } // ʵ�ֽӿ�ActionListener���ڲ������
        ); // ����addActionListener���ý���

        b[3].addActionListener( new ActionListener( )
            {
                public void actionPerformed(ActionEvent e)
                {
                    mb_deleteColumn( );
                    System.out.println("ɾ����ǰ��");
                } // ����actionPerformed����
            } // ʵ�ֽӿ�ActionListener���ڲ������
        ); // ����addActionListener���ý���
    } // J_Table���췽������

    public void mb_addColumn( ) // ���һ��
    {
        int cNum = m_data.getColumnCount( );
        int rNum = m_data.getRowCount( );
        String s = "��" + (cNum+1);
        int c = m_view.getSelectedColumn( );
        System.out.println( "��ǰ�к�Ϊ:" + c);
        if (cNum==0 || rNum==0 || c<0)
        {
            m_data.addColumn( s );
            return;
        } // if�ṹ����

        c++;
        Vector<String> vs = mb_getColumnNames( ); // ��ͷ�Ĵ���
        vs.add(c, s);

        Vector data = m_data.getDataVector( );
        for (int i=0; i<data.size( ); i++)
        {
            Vector e = (Vector) data.get(i);
            e.add(c, new String(""));
        } // forѭ������
        m_data.setDataVector(data, vs);
    } // ����mb_addColumn����

    public void mb_addRow( ) // ���һ��
    {
        int cNum = m_data.getColumnCount( );
        if (cNum==0)
            mb_addColumn( );
        int rNum = m_data.getRowCount( );
        int r = mb_getRowCurrent( );
        System.out.println( "��ǰ�к�Ϊ:" + r);
        m_data.insertRow( r, (Vector)null );
    } // ����mb_addRow����

    public void mb_deleteColumn( ) // ɾ��һ��
    {
        int cNum = m_data.getColumnCount( );
        if (cNum==0)
            return;
        int c = m_view.getSelectedColumn( );
        if (c<0)
            c = 0;
        System.out.println( "��ǰ�к�Ϊ:" + c);

        Vector<String> vs = mb_getColumnNames( ); // ��ͷ�Ĵ���
        vs.remove(c);

        Vector data = m_data.getDataVector( );
        for (int i=0; i<data.size( ); i++)
        {
            Vector e = (Vector) data.get(i);
            e.remove(c);
        } // forѭ������
        m_data.setDataVector(data, vs);
    } // ����mb_deleteColumn����

    public void mb_deleteRow( ) // ɾ��һ��
    {
        int rNum = m_data.getRowCount( );
        if (rNum > 0)
        {
            int rEdit = mb_getRowCurrent( );
            m_data.removeRow( rEdit );
        }
    } // ����mb_deleteRow����

    public Vector<String> mb_getColumnNames( ) // ȡ��������
    {
        Vector<String> vs = new Vector<String>( );
        int cNum = m_data.getColumnCount( );
        for (int i=0; i<cNum; i++)
            vs.add(m_data.getColumnName(i));
        return(vs);
    } // ����mb_getColumnNames����

    public int mb_getRowCurrent( ) // ȡ�õ�ǰ�е��к�
    {
        int r=m_view.getSelectedRow( );
        if (r<0)
            r = 0;
        return(r);
    } // ����mb_getRowCurrent����
        
    public static void main(String args[ ])
    {
        JFrame app = new J_Table( );

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(350, 250);
        app.setVisible(true);
    } // ����main����
} // ��J_Table����
