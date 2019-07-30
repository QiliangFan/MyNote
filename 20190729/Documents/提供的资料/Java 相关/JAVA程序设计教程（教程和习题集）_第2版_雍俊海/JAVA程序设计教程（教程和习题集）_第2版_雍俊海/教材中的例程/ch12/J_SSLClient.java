// ////////////////////////////////////////////////////////
// 
// J_SSLClient.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//      ����SSL�Ŀͻ��˳���
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

import javax.net.ssl.SSLSocketFactory;
import java.net.Socket;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class J_SSLClient
{
    public static void main(String args[ ])
    {
        String host = (args.length>=1 ? args[0] : "localhost");
        int port;

        // ָ��������Կ��
        System.setProperty("javax.net.ssl.trustStore",
            ".\\client.trustStore");

        // ��ȡ�׽��ֹ�����ʵ������
        SSLSocketFactory sf = 
            (SSLSocketFactory)SSLSocketFactory.getDefault( );
        try
        {
            if (args.length>=2)
                port= Integer.parseInt(args[1]);
            else port= 5000;

            // ��ȡ�׽��֣���������˽�������
            Socket s = sf.createSocket(host, port);

            InetAddress sa = s.getInetAddress( );
            InetAddress ca = s.getLocalAddress( );  

            System.out.println("�ͻ��˽��շ���������Ϣ:");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(s.getInputStream( )));
            String str;
            str=br.readLine( );
            System.out.println(str);

            System.out.println("�ͻ�����������˷�����Ϣ:");
            PrintWriter pw = new PrintWriter(s.getOutputStream( ));
            str = 
                "�ͻ���"
                + ca.getHostAddress( ) + "(" + s.getLocalPort( ) + ")"
                + "Ӧ���������"
                + sa.getHostAddress( ) + "(" + s.getPort( ) + ")"
                + "��";
            System.out.println(str);
            pw.println(str);
            pw.flush( );

            pw.close( );
            br.close( );
            s.close( );
        }
        catch(Exception e)
        {
            System.err.println("ע: main�����������쳣��");
            System.err.println(e);
            e.printStackTrace( );
        } // try-catch�ṹ����
    } // ����main����
} // ��J_SSLClient����
