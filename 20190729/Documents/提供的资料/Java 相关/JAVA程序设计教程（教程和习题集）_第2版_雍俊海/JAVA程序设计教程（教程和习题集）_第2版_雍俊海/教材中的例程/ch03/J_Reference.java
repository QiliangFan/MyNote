// ////////////////////////////////////////////////////////
// 
// J_Reference.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ������������ֵ�������̡�
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

class J_Time
{
    public int m_month = 1;
} // ��J_Time����

public class J_Reference
{
    public static void mb_method( J_Time t )
    {
        System.out.println("��t.m_month++֮ǰt.m_month=" + t.m_month);
        t.m_month++;
        System.out.println("��t.m_month++֮��t.m_month=" + t.m_month);
    } // ����mb_method����

    public static void main(String args[ ])
    {
        J_Time a = new J_Time( );
        System.out.println("�ڷ�������֮ǰa.m_month=" + a.m_month);
        mb_method( a );
        System.out.println("�ڷ�������֮��a.m_month=" + a.m_month);
    } // ����main����
} // ��J_Reference����
