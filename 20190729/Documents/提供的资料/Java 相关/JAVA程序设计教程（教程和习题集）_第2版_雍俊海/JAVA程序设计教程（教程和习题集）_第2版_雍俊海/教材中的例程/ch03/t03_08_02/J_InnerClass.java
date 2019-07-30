// ////////////////////////////////////////////////////////
// 
// J_InnerClass.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ������Ϊ��Ķ������̡�
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

abstract class J_Class
{
    int m_data;

    public J_Class( int i )
    {
        m_data = i;
    } // J_Class���췽������

    public abstract void mb_method( );
} // ��J_Class����

class J_Anonymity extends J_Class
{
    public J_Anonymity( int i )
    {
        super(i);
    } // J_Anonymity���췽������

    public void mb_method( )
    {
        System.out.println( "m_data=" + m_data );
    } // ����mb_method����
} // ��J_Anonymity����

public class J_InnerClass
{
    public static void main(String args[ ])
    {
        J_Class b = new J_Anonymity( 5 );
        b.mb_method( );
    } // ����main����
} // ��J_InnerClass����
