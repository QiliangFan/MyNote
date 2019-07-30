// ////////////////////////////////////////////////////////
// 
// J_Hashtable.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ͨ����ϣ���γ������±���ֵ֮���˫��ӳ�䡣
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

import java.util.Hashtable;

public class J_Hashtable
{
    public static void main(String args[ ])
    {
        String [ ] sa = {"Mary", "Tom", "John", "James", "Louis", "Jim", 
                      "Rose", "Ann", "Liza", "Betty", "Henry", "Albert"};
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>( );

        // ����ϣ�������Ԫ�أ���ʹ�ùؼ�����ֵ֮�佨����ӳ���ϵ
        int i;
        for (i=0; i < sa.length; i++)
            ht.put(sa[i], new Integer(i));

        // ͨ���±�������(�ַ���ֵ)
        i=8;
        System.out.println(
            "��sa�����У��±�Ϊ" + i + "���ַ�����\"" + sa[i] + "\"");

        // ͨ����ϣ��ֱ�ӻ������(�ַ���ֵ)�������±�
        String s=sa[i];
        System.out.println("��sa�����У�\"" + s + "\"���±���" + ht.get(s));
    } // ����main����
} // ��J_Hashtable����
