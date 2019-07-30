// ////////////////////////////////////////////////////////
// 
// J_Finalize.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ʵ�������������ڵ����̡�
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

class J_Book
{
    public int m_id; // ��ı��

    public J_Book( int i )
    {
        m_id = i;
    } // J_Book���췽������

    protected void finalize( )
    {
        switch (m_id)
        {
        case 1:
            System.out.print( "��Ʈ��" );
            break;
        case 2:
            System.out.print( "��Java������ƽ̡̳�" );
            break;
        case 3:
            System.out.print( "��������ա�" );
            break;
        default:
            System.out.print( "δ֪�鼮" );
            break;
        } // switch������
        System.out.println( "����Ӧ��ʵ������洢��Ԫ������" );
    } // ����finalize����
} // ��J_Book����

public class J_Finalize
{
    public static void main(String args[ ])
    {
        J_Book book1= new J_Book( 1 );
        new J_Book( 2 );
        new J_Book( 3 );
        System.gc( ); // ����������������
    } // ����main����
} // ��J_Finalize����
