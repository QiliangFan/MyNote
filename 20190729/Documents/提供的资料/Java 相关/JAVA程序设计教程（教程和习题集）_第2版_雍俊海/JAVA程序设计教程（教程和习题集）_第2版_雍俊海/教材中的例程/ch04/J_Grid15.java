// ////////////////////////////////////////////////////////
// 
// J_Grid15.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     数组应用例程——求解和为15的棋盘游戏问题。
// 将从1到9的九个数不重复地填入3╳3的棋盘中，使得各行、各列
// 以及两个对角线上的三个数之和均为15。
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

public class J_Grid15
{
    int [ ] [ ] m_board;

    J_Grid15( )
    {
        m_board= new int[3][3];
    } // J_Grid15构造方法结束

    // 输出棋盘的格线行
    private void mb_outputGridRowBoard( )
    {
        int i;
        System.out.print("+");
        for (i=0; i<5; i++)
            System.out.print("-");
        System.out.println("+");
    } // 方法mb_outputGridRowBoard结束

    // 输出棋盘的数据行(第i行, i只能为0, 1 或 2)
    private void mb_outputGridRowBoard(int i)
    {
        int j;
        for (j=0; j < m_board[i].length; j++)
            System.out.print("|" + m_board[i][j]);
        System.out.println("|");
    } // 方法mb_outputGridRowBoard结束

    // 输出棋盘
    public void mb_outputGrid( )
    {
        int i;
        mb_outputGridRowBoard( );
        for (i=0; i < m_board.length; i++)
        {
            mb_outputGridRowBoard(i);
            mb_outputGridRowBoard( );
        } // for循环结束
    } // 方法mb_outputGrid结束

    // 初始化数据
    private void mb_dataInit( )
    {
        int i, j, k;
        for (i=0, k=1; i < m_board.length; i++)
        for (j=0; j < m_board[i].length; j++, k++)
            m_board[i][j]= k;
    } // 方法mb_dataInit结束
    
    // 数据结束检测
    // 返回值说明: 当数据为最后一个数据时，返回true；否则，返回false
    private boolean mb_dataEnd( )
    {
        int i, j, k;
        for (i=0, k=9; i < m_board.length; i++)
            for (j=0; j < m_board[i].length; j++, k--)
                if (m_board[i][j]!= k)
                    return(false);
        return(true);
    } // 方法mb_dataEnd结束

    // 取下一个数据
    private void mb_dataNext( )
    {
        int i, j;
        for (i= m_board.length-1; i>=0 ; i--)
            for (j= m_board[i].length-1; j>=0 ; j--)
                if (m_board[i][j]==9)
                    m_board[i][j]=1;
                else
                {
                    m_board[i][j]++;
                    return;
                } // if-else结构结束
    } // 方法mb_dataNext结束

    // 数据检测: 判断数据中是否含有相同的数字
    // 当数据中存在相同数字时，返回false; 否则，返回 true
    private boolean mb_dataCheckDifferent( )
    {
        int i, j;
        int [ ] digit= new int [10];
        for (i=0; i < m_board.length; i++)
            for (j=0; j < m_board[i].length; j++)
                digit[m_board[i][j]]= 1;
        for (i=1, j=0; i < digit.length; i++)
            j+=digit[i];
        if (j==9)
            return(true);
        return(false);
    } // 方法mb_dataCheckDifferent结束

    // 数据检测: 各行和是否为15
    // 当各行和均为15时，返回true; 否则，返回false
    private boolean mb_dataCheckSumRow( )
    {
        int i, j, k;
        for (i=0; i < m_board.length; i++)
        {
            for (j=0, k=0; j < m_board[i].length; j++)
                k+= m_board[i][j];
            if (k!=15)
                return(false);
        } // for循环结束
        return(true);
    } // 方法mb_dataCheckSumRow结束

    // 数据检测: 各列和是否为15
    // 当各列和均为15时，返回true; 否则，返回false
    private boolean mb_dataCheckSumColumn( )
    {
        int i, j, k;
        for (i=0; i < m_board.length; i++)
        {
            for (j=0, k=0; j < m_board.length; j++)
                k+= m_board[j][i];
            if (k!=15)
                return(false);
        } // for循环结束
        return(true);
    } // 方法mb_dataCheckSumColumn结束

    private boolean mb_dataCheck( )
    {
        if (!mb_dataCheckDifferent( ))
            return(false);
        if (!mb_dataCheckSumRow( ))
            return(false);
        if (!mb_dataCheckSumColumn( ))
            return(false);
        // 检测对角线之和是否为 15
        if (m_board[0][0]+m_board[1][1]+m_board[2][2]!=15)
            return(false);
        // 检测对角线之和是否为 15
        if (m_board[0][2]+m_board[1][1]+m_board[2][0]!=15)
            return(false);
        return(true);
    } // 方法mb_dataCheck结束

    // 求解并输出棋盘问题
    public void mb_arrange( )
    {
        int n= 1;
        for (mb_dataInit( ); !mb_dataEnd( ); mb_dataNext( ))
        {
            if (mb_dataCheck( ))
            {
                System.out.println("第" + n + "个结果:");
                n++;
                mb_outputGrid( );
            } // if结构结束
        } // for循环结束
    } // 方法mb_arrange结束

    public static void main(String args[ ])
    {
        J_Grid15 a= new J_Grid15( );
        a.mb_arrange( );
    } // 方法main结束
} // 类J_Grid15结束
