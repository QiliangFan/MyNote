// ////////////////////////////////////////////////////////
// 
// J_DiagonalLayout.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     创建自定义的对角线布局管理器例程。
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
// 版权:
// 使用本例子，请注明引用:
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
// 请合法使用例程，其用途应当合法有益而且不应对任何人造成任何
// 伤害或损失。同时请注意教材作者及出版社没有对例程做出任何承
// 诺与保证。
// 具体引用的方法及例子如下:
// 本程序是下面教材的一个例程(或本程序基于下面教材的例程修改)
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
//
// 雍俊海还编写过如下的教材和教参:
//      [1] 雍俊海. Java 程序设计. 北京: 清华大学出版社, 2004.
//      [2] 雍俊海. Java程序设计习题集(含参考答案). 
//          北京: 清华大学出版社, 2006.
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
    } // 方法addLayoutComponent结束

    public void removeLayoutComponent(Component comp)
    {
    } // 方法removeLayoutComponent结束

    public Dimension preferredLayoutSize(Container parent)
    {
        Dimension d  = null;
        Insets    s  = parent.getInsets( ); // 容器四条边框的尺寸
        Dimension dp = new Dimension(s.left + s.right, s.top + s.bottom);
        Component c;
        int n = parent.getComponentCount( );

        for (int i=0; i<n; i++)
        { // 计算组件及容器边框宽度之和及高度之和
            c = parent.getComponent(i);
            if (c.isVisible( ))
            {
                d = c.getPreferredSize( );
                dp.width += d.width;
                dp.height+= d.height;
            } // if结构结束
        } // for循环结束
        return dp;
    } // 方法preferredLayoutSize结束

    public Dimension minimumLayoutSize(Container parent)
    {
        Dimension d  = null;
        Insets    s  = parent.getInsets( ); // 容器四条边框的尺寸
        Dimension dp = new Dimension(0, 0);
        Component c;
        int n = parent.getComponentCount( );
        for (int i =0; i<n; i++)
        { // 计算各个组件的最大宽度和最大高度
            c = parent.getComponent(i);
            if (c.isVisible( ))
            {
                d = c.getPreferredSize( );
                if (d.width> dp.width)
                    dp.width= d.width;
                if (d.height> dp.height)
                    dp.height= d.height;
            } // if结构结束
        } // for循环结束
        dp.width += (s.left + s.right);
        dp.height+= (s.top + s.bottom);
        return dp;
    } // 方法minimumLayoutSize结束

    public void layoutContainer(Container parent)
    { // 当第一次显示指定容器或该容器的大小发生变化时调用本方法
        int         i;
        int         n = parent.getComponentCount( );
        Component   c;
        Insets      s   = parent.getInsets( ); // 容器四条边框的尺寸
        Dimension   d;
        Dimension   dp  = parent.getSize( ); // 容器本身的尺寸
        Dimension   dr  = preferredLayoutSize(parent); // 容器的最佳尺寸
        Dimension   dc  = new Dimension(s.left, s.top); // 组件的当前位置
        Dimension dg
            = new Dimension(dp.width-dr.width, dp.height-dr.height);
        if (n>1)
        { // 计算组件之间的间隙
            dg.width  /= (n-1);
            dg.height /= (n-1);
        } // if结构结束
        
        for (i=0 ; i<n ; i++)
        {
            c = parent.getComponent(i);
            if (c.isVisible( ))
            {
                d = c.getPreferredSize( );
                c.setBounds(dc.width, dc.height, d.width, d.height);
                dc.width += (dg.width+d.width);
                dc.height+= (dg.height+d.height);
            } // if结构结束
        } // for循环结束
    } // 方法layoutContainer结束
} // 类J_DiagonalLayout结束
