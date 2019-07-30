// ////////////////////////////////////////////////////////
// 
// J_Example.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     for���ļ�д�������������е�Ӧ�����̡�
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

public class J_Example
{
    public static void main(String args[ ])
    {
        int [ ] a = {10, 20, 30, 40, 50};
        int s = 0;
        for ( int c : a)
            s += c; // ������Ҫע��c�������Ԫ�أ���������Ӧ���±�
        System.out.println("����a��Ԫ��֮�͵���" + s);

        s = 0;
        for ( int i=1; i<=a.length; i++ )
            s += i;
        System.out.println("��1һֱ�ӵ�����a��Ԫ�س��ȣ��������" + s);

        s = 0;
        int [ ] ca = a;
        for ( int i=0; i< ca.length; i++ )
        {
            int c = ca[i];
            s += c;
        } // forѭ������
        System.out.println("����a��Ԫ��֮�͵���" + s);
    } // ����main����
} // ��J_Example����
