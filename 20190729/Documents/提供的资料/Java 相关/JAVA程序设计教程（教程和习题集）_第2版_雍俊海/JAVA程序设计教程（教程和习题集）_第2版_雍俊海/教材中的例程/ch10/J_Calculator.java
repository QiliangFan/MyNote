// ////////////////////////////////////////////////////////
// 
// J_Calculator.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �ӷ���˷����������̡�
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
 * ��������
 * <p>
 * �������ӷ���˷���
 *
 * @author Ӻ����
 * @version 2.0
 * @since J2SE 1.6
 */
public class J_Calculator
{
    /** 
     * ����n�γ˷��� 
     * @param n �˷��Ĵ�����
     * @return ���һ�γ˷��Ľ����
     */
    public static int mb_multiply(int n)
    {
        int i, m;
        m = 1;
        for (i=1; i<=n; i++)
            m = i * n;
        return m;
    } // ����mb_multiply����

    /** 
     * ����n�μӷ��� 
     * @param n �ӷ��Ĵ�����
     * @return ���һ�μӷ��Ľ����
     */
    public static int mb_add(int n)
    {
        int i, s;
        s = 0;
        for (i=1; i<=n; i++)
            s = i + n;
        return s;
    } // ����mb_add����
} // ��J_Calculator����
