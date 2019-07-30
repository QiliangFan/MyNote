// ////////////////////////////////////////////////////////
// 
// J_BufferedInputStream.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ���벻�������ڶ�ȡ����ʱ��Ч�ʱȽ����̡�
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

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Date;

public class J_BufferedInputStream
{
    private static String m_fileName = "J_BufferedInputStream.class";

    public static void main(String args[ ])
    {
        try
        {
            int i, ch;
            i = 0;
            Date d1= new Date( );
            FileInputStream f = new FileInputStream(m_fileName);
            while ((ch=f.read( )) != -1) // read entire file
                i++;
            f.close( );
            Date d2= new Date( );

            long t = d2.getTime( ) - d1.getTime( ); // ��λ(����)
            System.out.printf("��ȡ�ļ�%1$s(��%2$d�ֽ�)%n",
                m_fileName, i);
            System.out.printf("��������ķ�����Ҫ%1$d����%n", t);

            i = 0;
            d1= new Date( );
            f = new FileInputStream(m_fileName);
            BufferedInputStream fb = new BufferedInputStream(f);
            while ((ch=fb.read( )) != -1) // read entire file
                i++;
            fb.close( );
            d2= new Date( );
            
            t = d2.getTime( ) - d1.getTime( ); // ��λ(����)
            System.out.printf("������ķ�����Ҫ%1$d����%n", t);
        }
        catch (Exception e)
        {
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        } // try-catch�ṹ����
    } // ����main����
} // ��J_BufferedInputStream����
