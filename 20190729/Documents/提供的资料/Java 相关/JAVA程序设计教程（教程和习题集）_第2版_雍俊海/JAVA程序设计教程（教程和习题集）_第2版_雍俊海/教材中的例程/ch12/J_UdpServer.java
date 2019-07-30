// ////////////////////////////////////////////////////////
// 
// J_UdpServer.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ����UDPͨѶ���̵ķ������˳���
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
import java.util.Date;

public class J_UdpServer
{
    public static void main(String args[ ])
    {
        DatagramSocket dSocket;
        DatagramPacket inPacket;
        DatagramPacket outPacket;
        InetAddress    cAddr;
        int            cPort;
        byte[ ]         inBuffer= new byte[100];
        byte[ ]         outBuffer;
        String         s;

        try
        {
            dSocket = new DatagramSocket(8000);
            while (true)
            {
                inPacket = new DatagramPacket(inBuffer, inBuffer.length);
                dSocket.receive(inPacket); // �������ݱ�
                cAddr = inPacket.getAddress( );
                cPort = inPacket.getPort( );
                s= new String(inPacket.getData( ), 0, inPacket.getLength( ));
                System.out.println("���յ��ͻ�����Ϣ: " + s);
                System.out.println("�ͻ���������Ϊ: " + cAddr.getHostName( ));
                System.out.println("�ͻ��˶˿�Ϊ: " + cPort);

                Date d = new Date( );
                outBuffer = d.toString( ).getBytes( );
                outPacket = new DatagramPacket(outBuffer, outBuffer.length,
                            cAddr, cPort);
                dSocket.send(outPacket); // �������ݱ�
            } // whileѭ������
        }
        catch (Exception e)
        { 
            System.err.println("�����쳣:" + e);
            e.printStackTrace( );
        } // try-catch�ṹ���� 
    } // ����main����
} // ��J_UdpServer����
