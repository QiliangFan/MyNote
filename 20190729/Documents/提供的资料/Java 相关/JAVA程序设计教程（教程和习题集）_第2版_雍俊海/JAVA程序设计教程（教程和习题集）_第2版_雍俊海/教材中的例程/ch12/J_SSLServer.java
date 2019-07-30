// ////////////////////////////////////////////////////////
// 
// J_SSLServer.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ����SSL�ķ������˳���
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

import javax.net.ssl.SSLServerSocketFactory;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class J_SSLServer
{
    public static void main(String args[ ])
    {
        // ָ����Կ�⼰������
        System.setProperty("javax.net.ssl.keyStore", ".\\new.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "ks123456");

        // ��ȡ���������׽��ֹ�����ʵ������
        SSLServerSocketFactory ssf = (SSLServerSocketFactory)
            SSLServerSocketFactory.getDefault( );
        try
        {
            // �������������׽���
            ServerSocket ss = ssf.createServerSocket(5000);

            int i=0;
            while (true)
            {
                System.out.println("[" + (++i)
                    + "]: �ȴ����Կͻ��˵�����... ...");
                Socket s = ss.accept( ); // �������ȴ����Կͻ��˵�����
                PrintWriter pw = new PrintWriter(s.getOutputStream( ));
                InetAddress sa = s.getInetAddress( );
                InetAddress ca = s.getLocalAddress( );  

                String str;
                System.out.println("����������ͻ��˷�����Ϣ:");
                str = 
                    "����"
                    + ca.getHostAddress( ) + "(" + s.getLocalPort( ) + ")"
                    + "��"
                    + sa.getHostAddress( ) + "(" + s.getPort( ) + ")"
                    + "�������ʺ�";
                System.out.println(str);
                pw.println(str);
                pw.flush( );

                System.out.println("�������˽��տͻ�����Ϣ:");
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream( )));

                str=br.readLine( );
                System.out.println(str);

                br.close( );
                pw.close( );
                s.close( );
            } // whileѭ������
        }
        catch(Exception e)
        {
            System.err.println("ע: main�����������쳣��");
            System.err.println(e);
            e.printStackTrace( );
        } // try-catch�ṹ����
    } // ����main����
} // ��J_SSLServer����
