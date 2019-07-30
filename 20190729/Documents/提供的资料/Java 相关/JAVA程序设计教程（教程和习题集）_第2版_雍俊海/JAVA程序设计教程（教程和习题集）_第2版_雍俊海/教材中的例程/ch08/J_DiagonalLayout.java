// ////////////////////////////////////////////////////////
// 
// J_DiagonalLayout.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �����Զ���ĶԽ��߲��ֹ��������̡�
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


import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

public class J_DiagonalLayout implements LayoutManager
{
    public void addLayoutComponent(String name, Component comp)
    {
    } // ����addLayoutComponent����

    public void removeLayoutComponent(Component comp)
    {
    } // ����removeLayoutComponent����

    public Dimension preferredLayoutSize(Container parent)
    {
        Dimension d  = null;
        Insets    s  = parent.getInsets( ); // ���������߿�ĳߴ�
        Dimension dp = new Dimension(s.left + s.right, s.top + s.bottom);
        Component c;
        int n = parent.getComponentCount( );

        for (int i=0; i<n; i++)
        { // ��������������߿���֮�ͼ��߶�֮��
            c = parent.getComponent(i);
            if (c.isVisible( ))
            {
                d = c.getPreferredSize( );
                dp.width += d.width;
                dp.height+= d.height;
            } // if�ṹ����
        } // forѭ������
        return dp;
    } // ����preferredLayoutSize����

    public Dimension minimumLayoutSize(Container parent)
    {
        Dimension d  = null;
        Insets    s  = parent.getInsets( ); // ���������߿�ĳߴ�
        Dimension dp = new Dimension(0, 0);
        Component c;
        int n = parent.getComponentCount( );
        for (int i =0; i<n; i++)
        { // ����������������Ⱥ����߶�
            c = parent.getComponent(i);
            if (c.isVisible( ))
            {
                d = c.getPreferredSize( );
                if (d.width> dp.width)
                    dp.width= d.width;
                if (d.height> dp.height)
                    dp.height= d.height;
            } // if�ṹ����
        } // forѭ������
        dp.width += (s.left + s.right);
        dp.height+= (s.top + s.bottom);
        return dp;
    } // ����minimumLayoutSize����

    public void layoutContainer(Container parent)
    { // ����һ����ʾָ��������������Ĵ�С�����仯ʱ���ñ�����
        int         i;
        int         n = parent.getComponentCount( );
        Component   c;
        Insets      s   = parent.getInsets( ); // ���������߿�ĳߴ�
        Dimension   d;
        Dimension   dp  = parent.getSize( ); // ��������ĳߴ�
        Dimension   dr  = preferredLayoutSize(parent); // ��������ѳߴ�
        Dimension   dc  = new Dimension(s.left, s.top); // ����ĵ�ǰλ��
        Dimension dg
            = new Dimension(dp.width-dr.width, dp.height-dr.height);
        if (n>1)
        { // �������֮��ļ�϶
            dg.width  /= (n-1);
            dg.height /= (n-1);
        } // if�ṹ����
        
        for (i=0 ; i<n ; i++)
        {
            c = parent.getComponent(i);
            if (c.isVisible( ))
            {
                d = c.getPreferredSize( );
                c.setBounds(dc.width, dc.height, d.width, d.height);
                dc.width += (dg.width+d.width);
                dc.height+= (dg.height+d.height);
            } // if�ṹ����
        } // forѭ������
    } // ����layoutContainer����
} // ��J_DiagonalLayout����
