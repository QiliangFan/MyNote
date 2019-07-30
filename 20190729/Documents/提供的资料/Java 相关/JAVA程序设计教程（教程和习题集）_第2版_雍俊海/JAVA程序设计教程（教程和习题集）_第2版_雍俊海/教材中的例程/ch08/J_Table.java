
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
        super("表格应用示例");
        Container c = getContentPane( );
        c.setLayout( new FlowLayout( ) );
        int i;

        // 添加四个按钮
        JButton [ ] b = {new JButton("添加行"), new JButton("添加列"),
                        new JButton("删除行"), new JButton("删除列")};
        for (i=0; i<4; i++)
            c.add(b[i]);

        m_data = new DefaultTableModel( ); // 创建一个空的数据表格
        m_view = new JTable(m_data);
        m_view.setPreferredScrollableViewportSize(
            new Dimension(300, 150)); // 设置表格的显示区域大小
        m_view.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane sPane = new JScrollPane(m_view);
        c.add(sPane);

        b[0].addActionListener( new ActionListener( )
            {
                public void actionPerformed(ActionEvent e)
                {
                    mb_addRow( );
                    System.out.println("添加一行");
                } // 方法actionPerformed结束
            } // 实现接口ActionListener的内部类结束
        ); // 方法addActionListener调用结束

        b[1].addActionListener( new ActionListener( )
            {
                public void actionPerformed(ActionEvent e)
                {
                    mb_addColumn( );
                    System.out.println("添加一列");
                } // 方法actionPerformed结束
            } // 实现接口ActionListener的内部类结束
        ); // 方法addActionListener调用结束

        b[2].addActionListener( new ActionListener( )
            {
                public void actionPerformed(ActionEvent e)
                {
                    mb_deleteRow( );
                    System.out.println("删除当前行");
                } // 方法actionPerformed结束
            } // 实现接口ActionListener的内部类结束
        ); // 方法addActionListener调用结束

        b[3].addActionListener( new ActionListener( )
            {
                public void actionPerformed(ActionEvent e)
                {
                    mb_deleteColumn( );
                    System.out.println("删除当前列");
                } // 方法actionPerformed结束
            } // 实现接口ActionListener的内部类结束
        ); // 方法addActionListener调用结束
    } // J_Table构造方法结束

    public void mb_addColumn( ) // 添加一列
    {
        int cNum = m_data.getColumnCount( );
        int rNum = m_data.getRowCount( );
        String s = "列" + (cNum+1);
        int c = m_view.getSelectedColumn( );
        System.out.println( "当前列号为:" + c);
        if (cNum==0 || rNum==0 || c<0)
        {
            m_data.addColumn( s );
            return;
        } // if结构结束

        c++;
        Vector<String> vs = mb_getColumnNames( ); // 表头的处理
        vs.add(c, s);

        Vector data = m_data.getDataVector( );
        for (int i=0; i<data.size( ); i++)
        {
            Vector e = (Vector) data.get(i);
            e.add(c, new String(""));
        } // for循环结束
        m_data.setDataVector(data, vs);
    } // 方法mb_addColumn结束

    public void mb_addRow( ) // 添加一行
    {
        int cNum = m_data.getColumnCount( );
        if (cNum==0)
            mb_addColumn( );
        int rNum = m_data.getRowCount( );
        int r = mb_getRowCurrent( );
        System.out.println( "当前行号为:" + r);
        m_data.insertRow( r, (Vector)null );
    } // 方法mb_addRow结束

    public void mb_deleteColumn( ) // 删除一列
    {
        int cNum = m_data.getColumnCount( );
        if (cNum==0)
            return;
        int c = m_view.getSelectedColumn( );
        if (c<0)
            c = 0;
        System.out.println( "当前列号为:" + c);

        Vector<String> vs = mb_getColumnNames( ); // 表头的处理
        vs.remove(c);

        Vector data = m_data.getDataVector( );
        for (int i=0; i<data.size( ); i++)
        {
            Vector e = (Vector) data.get(i);
            e.remove(c);
        } // for循环结束
        m_data.setDataVector(data, vs);
    } // 方法mb_deleteColumn结束

    public void mb_deleteRow( ) // 删除一行
    {
        int rNum = m_data.getRowCount( );
        if (rNum > 0)
        {
            int rEdit = mb_getRowCurrent( );
            m_data.removeRow( rEdit );
        }
    } // 方法mb_deleteRow结束

    public Vector<String> mb_getColumnNames( ) // 取得列名称
    {
        Vector<String> vs = new Vector<String>( );
        int cNum = m_data.getColumnCount( );
        for (int i=0; i<cNum; i++)
            vs.add(m_data.getColumnName(i));
        return(vs);
    } // 方法mb_getColumnNames结束

    public int mb_getRowCurrent( ) // 取得当前行的行号
    {
        int r=m_view.getSelectedRow( );
        if (r<0)
            r = 0;
        return(r);
    } // 方法mb_getRowCurrent结束
        
    public static void main(String args[ ])
    {
        JFrame app = new J_Table( );

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(350, 250);
        app.setVisible(true);
    } // 方法main结束
} // 类J_Table结束
