// ////////////////////////////////////////////////////////
// 
// J_ReadData.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �ӿ���̨���ڶ������ݵ����̡�
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

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class J_ReadData
{
    // �����ʾ��Ϣ
    public static void mb_printIinfo( )
    {
        System.out.println("�����������Ǹ�����?");
        System.out.println("\t0: �˳�; 1: ����; 2: ������");
    } // ����mb_printIinfo����

    // ��������������
    public static int mb_getInt( BufferedReader f )
    {
        try
        {
            String s = f.readLine( );
            int i = Integer.parseInt( s );
            return i;
        }
        catch (Exception e)
        {
            return -1;
        } // try-catch�ṹ����
    } // ����mb_getInt����

    // ���ܸ�����������
    public static double mb_getDouble( BufferedReader f )
    {
        try
        {
            String s = f.readLine( );
            double d = Double.parseDouble( s );
            return d;
        }
        catch (Exception e)
        {
            return 0d;
        } // try-catch�ṹ����
    } // ����mb_getDouble����

    public static void main(String args[ ])
    {
        int i;
        double d;
        try
        {
            BufferedReader f = 
                new BufferedReader(new InputStreamReader( System.in ));
            do
            {
                mb_printIinfo( );
                i = mb_getInt( f );
                if (i==0)
                    break;
                else if (i==1)
                {
                    System.out.print("\t����������: ");
                    i = mb_getInt( f );
                    System.out.println("\t��������: " + i);
                }
                else if (i==2)
                {
                    System.out.print("\t�����븡����: ");
                    d = mb_getDouble( f );
                    System.out.println("\t���븡����: " + d);
                } // if-else�ṹ����
            }
            while (true); // do-whileѭ������
            f.close( );
        }
        catch (Exception e)
        {
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        } // try-catch�ṹ����
    } // ����main����
} // ��J_ReadData����
