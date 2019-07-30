// ////////////////////////////////////////////////////////
// 
// J_Url.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ����ͳһ��Դ��λ��ַ(URL)���̡�
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

import java.net.URL;
import java.net.MalformedURLException;

public class J_Url
{
    public static void main(String args[ ])
    {
        try
        {
            URL u = new URL("http://www.tsinghua.edu.cn/chn/index.htm"); 
            System.out.println("��URL(" + u + ")����:"); 
            System.out.println("Э����" + u.getProtocol( )); 
            System.out.println("��������" + u.getHost( )); 
            System.out.println("�ļ�����" + u.getFile( )); 
            System.out.println("�˿ں���" + u.getPort( )); 
            System.out.println("������" + u.getRef( )); 
        }
        catch (MalformedURLException e)
        { 
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        } // try-catch�ṹ���� 
    } // ����main����
} // ��J_Url����
