// ////////////////////////////////////////////////////////
// 
// J_WeakHashMap.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ��WeakHashMap���Զ�ȥ��һЩ�������á�Ԫ��(�ؼ��ּ���Ӧ��ֵ)�����̡�
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

import java.util.WeakHashMap;

public class J_WeakHashMap
{
    public static void main(String args[ ]) throws Exception
    {
        // ����WeakHashMapʵ������
        int s=800; // ����WeakHashMapʵ����������ӵ�Ԫ�صĸ���
        WeakHashMap<String, String> ht
            = new WeakHashMap<String, String>(s*4/3, 0.75f);

        // ��WeakHashMapʵ���������Ԫ��(�ؼ��ּ���ֵ)
        int i;
        for (i=0; i<s; i++)
            ht.put(("key"+i), ("value"+i));
        System.out.println("�ڸ����������ʱ������ϣ��Ԫ�ظ�����" + ht.size( ));

        // ����Ѿ�����WeakHashMapʵ�������е�Ԫ�أ�����ȴ�����ϣ��ɾ��Ԫ��
        for (i=0; i<s; )
        {
            if (!ht.containsKey("key"+i))
                System.out.print("key" + i + "; ");
            if (ht.size( )!=s)
                i++;
        } // forѭ������
        System.out.println("");
        System.out.println("һ��ʱ��֮������ϣ��Ԫ�ظ�����" + ht.size( ));
    } // ����main����
} // ��J_WeakHashMap����
