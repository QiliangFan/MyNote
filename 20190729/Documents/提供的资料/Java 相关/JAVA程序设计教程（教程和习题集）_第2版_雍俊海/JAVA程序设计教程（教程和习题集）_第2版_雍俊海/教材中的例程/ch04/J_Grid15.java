// ////////////////////////////////////////////////////////
// 
// J_Grid15.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ����Ӧ�����̡�������Ϊ15��������Ϸ���⡣
// ����1��9�ľŸ������ظ�������3�w3�������У�ʹ�ø��С�����
// �Լ������Խ����ϵ�������֮�;�Ϊ15��
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

public class J_Grid15
{
    int [ ] [ ] m_board;

    J_Grid15( )
    {
        m_board= new int[3][3];
    } // J_Grid15���췽������

    // ������̵ĸ�����
    private void mb_outputGridRowBoard( )
    {
        int i;
        System.out.print("+");
        for (i=0; i<5; i++)
            System.out.print("-");
        System.out.println("+");
    } // ����mb_outputGridRowBoard����

    // ������̵�������(��i��, iֻ��Ϊ0, 1 �� 2)
    private void mb_outputGridRowBoard(int i)
    {
        int j;
        for (j=0; j < m_board[i].length; j++)
            System.out.print("|" + m_board[i][j]);
        System.out.println("|");
    } // ����mb_outputGridRowBoard����

    // �������
    public void mb_outputGrid( )
    {
        int i;
        mb_outputGridRowBoard( );
        for (i=0; i < m_board.length; i++)
        {
            mb_outputGridRowBoard(i);
            mb_outputGridRowBoard( );
        } // forѭ������
    } // ����mb_outputGrid����

    // ��ʼ������
    private void mb_dataInit( )
    {
        int i, j, k;
        for (i=0, k=1; i < m_board.length; i++)
        for (j=0; j < m_board[i].length; j++, k++)
            m_board[i][j]= k;
    } // ����mb_dataInit����
    
    // ���ݽ������
    // ����ֵ˵��: ������Ϊ���һ������ʱ������true�����򣬷���false
    private boolean mb_dataEnd( )
    {
        int i, j, k;
        for (i=0, k=9; i < m_board.length; i++)
            for (j=0; j < m_board[i].length; j++, k--)
                if (m_board[i][j]!= k)
                    return(false);
        return(true);
    } // ����mb_dataEnd����

    // ȡ��һ������
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
                } // if-else�ṹ����
    } // ����mb_dataNext����

    // ���ݼ��: �ж��������Ƿ�����ͬ������
    // �������д�����ͬ����ʱ������false; ���򣬷��� true
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
    } // ����mb_dataCheckDifferent����

    // ���ݼ��: ���к��Ƿ�Ϊ15
    // �����к;�Ϊ15ʱ������true; ���򣬷���false
    private boolean mb_dataCheckSumRow( )
    {
        int i, j, k;
        for (i=0; i < m_board.length; i++)
        {
            for (j=0, k=0; j < m_board[i].length; j++)
                k+= m_board[i][j];
            if (k!=15)
                return(false);
        } // forѭ������
        return(true);
    } // ����mb_dataCheckSumRow����

    // ���ݼ��: ���к��Ƿ�Ϊ15
    // �����к;�Ϊ15ʱ������true; ���򣬷���false
    private boolean mb_dataCheckSumColumn( )
    {
        int i, j, k;
        for (i=0; i < m_board.length; i++)
        {
            for (j=0, k=0; j < m_board.length; j++)
                k+= m_board[j][i];
            if (k!=15)
                return(false);
        } // forѭ������
        return(true);
    } // ����mb_dataCheckSumColumn����

    private boolean mb_dataCheck( )
    {
        if (!mb_dataCheckDifferent( ))
            return(false);
        if (!mb_dataCheckSumRow( ))
            return(false);
        if (!mb_dataCheckSumColumn( ))
            return(false);
        // ���Խ���֮���Ƿ�Ϊ 15
        if (m_board[0][0]+m_board[1][1]+m_board[2][2]!=15)
            return(false);
        // ���Խ���֮���Ƿ�Ϊ 15
        if (m_board[0][2]+m_board[1][1]+m_board[2][0]!=15)
            return(false);
        return(true);
    } // ����mb_dataCheck����

    // ��Ⲣ�����������
    public void mb_arrange( )
    {
        int n= 1;
        for (mb_dataInit( ); !mb_dataEnd( ); mb_dataNext( ))
        {
            if (mb_dataCheck( ))
            {
                System.out.println("��" + n + "�����:");
                n++;
                mb_outputGrid( );
            } // if�ṹ����
        } // forѭ������
    } // ����mb_arrange����

    public static void main(String args[ ])
    {
        J_Grid15 a= new J_Grid15( );
        a.mb_arrange( );
    } // ����main����
} // ��J_Grid15����
