// ////////////////////////////////////////////////////////
// 
// J_UdpClient.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ����UDPͨѶ���̵Ŀͻ��˳���
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

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class J_UdpClient
{
    public static void main(String args[ ])
    {
        DatagramPacket inPacket;
        InetAddress    sAddr;
        byte[ ]         inBuffer= new byte[100];

        try
        {
            DatagramSocket dSocket = new DatagramSocket( );
            if ( args.length == 0 )
                sAddr = InetAddress.getByName("127.0.0.1");
            else sAddr = InetAddress.getByName(args[0]);
            String s = "��������";
            byte[ ] outBuffer= s.getBytes( );
            DatagramPacket outPacket= new DatagramPacket(
                outBuffer, outBuffer.length, sAddr, 8000);
            dSocket.send(outPacket); // �������ݱ�

            inPacket= new DatagramPacket(inBuffer, inBuffer.length);
            dSocket.receive(inPacket); // �������ݱ�
            s= new String (inPacket.getData( ), 0, inPacket.getLength( ));
            System.out.println("���յ�����������Ϣ: " + s);

            dSocket.close( );
        }
        catch (Exception e)
        { 
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        } // try-catch�ṹ���� 
    } // ����main����
} // ��J_UdpClient����
