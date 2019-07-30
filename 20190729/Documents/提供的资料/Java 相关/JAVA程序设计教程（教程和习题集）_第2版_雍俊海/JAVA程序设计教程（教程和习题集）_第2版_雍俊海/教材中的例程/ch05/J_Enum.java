// ////////////////////////////////////////////////////////
// 
// J_Enum.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ö�����̡�
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

enum E_SEASON
{
    ����, �ļ�, �＾, ���� 
} // ö��E_SEASON����

public class J_Enum
{
    public static void main(String args[ ])
    {
        E_SEASON [ ] sa = E_SEASON.values( );
        for ( int i=0; i< sa.length; i++ )
        {
            switch(sa[i])
            {
            case ����:
                System.out.println("����������");
                break;
            case �ļ�:
                System.out.println("�ļ����ޱ�");
                break;
            case �＾:
                System.out.println("�＾������");
                break;
            case ����:
                System.out.println("����ѩ����");
                break;                
            } // switch�ṹ����
        } // forѭ������
    } // ����main����
} // ��J_Enum����
