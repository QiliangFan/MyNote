// ////////////////////////////////////////////////////////
// 
// J_Book.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ���������ĳ�Ա��ͳ�Ա�����ľ�̬������Ǿ�̬�������̡�
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

public class J_Book
{
    public int m_id; // ��ı��
    public static int m_bookNumber = 0; // �������

    public J_Book( )
    {
        m_bookNumber ++;
    } // J_Book���췽������

    public void mb_info( )
    {
        System.out.println( "��ǰ��ı���ǣ�" + m_id);
    } // ����mb_info����

    public static void mb_infoStatic( )
    {
        System.out.println( "��������ǣ�" + m_bookNumber);
    } // ����mb_infoStatic����

    public static void main(String args[ ])
    {
        J_Book a = new J_Book( );
        J_Book b = new J_Book( );
        a.m_id = 1101;
        b.m_id = 1234;
        System.out.print( "����a��Ӧ��");
        a.mb_info( );
        System.out.print( "����b��Ӧ��");
        b.mb_info( );
        J_Book.mb_infoStatic( );
        System.out.println( "�Ƚ�(a.m_bookNumber==J_Book.m_bookNumber)"
            + "�Ľ���ǣ�" + (a.m_bookNumber==J_Book.m_bookNumber));
        System.out.println( "�Ƚ�(b.m_bookNumber==J_Book.m_bookNumber)"
            + "�Ľ���ǣ�" + (b.m_bookNumber==J_Book.m_bookNumber));
    } // ����main����
} // ��J_Book����

