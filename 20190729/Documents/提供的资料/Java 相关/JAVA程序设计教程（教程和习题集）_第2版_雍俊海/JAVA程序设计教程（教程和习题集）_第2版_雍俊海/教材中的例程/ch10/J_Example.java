// ////////////////////////////////////////////////////////
// 
// J_Example.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �ӷ���˷�����Ч�ʱȽ����̡�
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

package cn.edu.tsinghua.example;

/**
 * �Ƚϼӷ���˷�����Ч�ʡ�
 *
 * @author Ӻ����
 * @version 2.0
 * @since J2SE 1.6
 */
public class J_Example
{
    /** 
     * �Ƚϼӷ���˷�����Ч�ʡ� 
     * @param args ����Ĳ���������û��ʵ�ʵĺ��塣
     */
    public static void main(String args[ ])
    {
        int n=100000000; // �������

        J_Timer t = new J_Timer( ); // ����ӷ���ʱ�����
        t.mb_setStart( );
        J_Calculator.mb_add( n );
        t.mb_setEnd( );
        long t1 = t.mb_getTime( );

        t.mb_setStart( ); // ����˷���ʱ�����
        J_Calculator.mb_multiply( n );
        t.mb_setEnd( );
        long t2 = t.mb_getTime( );

        // ����ȽϽ��
        System.out.println("����" + n + "�μӷ���Ҫ" + t1 +"����");
        System.out.println("����" + n + "�γ˷���Ҫ" + t2 +"����");
        if (t1 < t2)
            System.out.println("����: �ӷ���");
        else if (t1 > t2)
            System.out.println("����: �˷���");
        else
            System.out.println("����: �ӷ���˷�һ����");
    } // ����main����
} // ��J_Example����
