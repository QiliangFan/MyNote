// ////////////////////////////////////////////////////////
// 
// J_Hanoi.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ���õݹ���⺺ŵ��(Tower of Hanoi)��������̡�
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

public class J_Hanoi
{
    public static void mb_hanoi(int n, char start, char temp, char end)
    {
        if (n<=1)
            System.out.println("���̴�" + start + "�Ƶ�" + end);
        else
        {
            mb_hanoi(n-1, start, end, temp);
            System.out.println("���̴�" + start + "�Ƶ�" + end);
            mb_hanoi(n-1, temp, start, end);
        } // if-else�ṹ����
    } // ����mb_hanoi����

    public static void main(String args[ ])
    {
        mb_hanoi(3, 'S', 'T', 'E');
    } // ����main����
} // ��J_Hanoi����
