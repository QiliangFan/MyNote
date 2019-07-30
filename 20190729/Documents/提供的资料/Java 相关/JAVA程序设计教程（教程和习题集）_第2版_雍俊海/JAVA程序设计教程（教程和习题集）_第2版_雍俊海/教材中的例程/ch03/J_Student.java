// ////////////////////////////////////////////////////////
// 
// J_Student.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ��̬��̬�����̡�
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

public class J_Student
{
    public int m_id; // ѧ��
    public int m_age; // ����

    public J_Student( )
    {
        mb_setData(2008010400, 19);
    } // J_Student���췽������

    public J_Student( int id, int age )
    {
        mb_setData(id, age);
    } // J_Student���췽������

    public void mb_setData( int id, int age )
    {
        m_id = id;
        m_age = age;
    } // ����mb_setData����

    public void mb_setData( int id )
    {
        m_id = id;
    } // ����mb_setData����

    public static void main(String args[ ])
    {
        J_Student jack = new J_Student( );
        jack.mb_setData(2008010408);
        J_Student lisa = new J_Student( );
        lisa.mb_setData(2008010428, 18);
        System.out.print("Jack��ѧ����" + jack.m_id);
        System.out.println("��������" + jack.m_age);
        System.out.print("Lisa��ѧ����" + lisa.m_id);
        System.out.println("��������" + lisa.m_age);
    } // ����main����
} // ��J_Student����
