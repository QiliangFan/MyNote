// ////////////////////////////////////////////////////////
// 
// J_InnerTest.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ʵ���ڲ������̡�
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

class J_Test
{
    int m_dataOuter = 1;
    static int m_dataOuterStatic  = 2;

    class J_Inner
    {
        int m_data;
        static final int m_dataStatic = 4;
    
        public J_Inner( )
        {
            m_data = 3;
        } // J_Inner���췽������
    
        public void mb_method( )
        {
            System.out.println( "m_dataOuter=" + m_dataOuter );
            System.out.println( "m_dataOuterStatic="
                + m_dataOuterStatic );
            System.out.println( "m_data=" + m_data );
            System.out.println( "m_dataStatic=" + m_dataStatic );
            mb_methodOuter( );
        } // ����mb_method����
    } // �ڲ���J_Inner����

    public void mb_methodOuter( )
    {
        System.out.println( "mb_methodOuter" );
    } // ����mb_methodOuter����

} // ��J_Test����

public class J_InnerTest
{
    public static void main(String args[ ])
    {
        J_Test a = new J_Test( );
        J_Test.J_Inner b = a.new J_Inner( );
        b.mb_method( );
    } // ����main����
} // ��J_InnerTest����
