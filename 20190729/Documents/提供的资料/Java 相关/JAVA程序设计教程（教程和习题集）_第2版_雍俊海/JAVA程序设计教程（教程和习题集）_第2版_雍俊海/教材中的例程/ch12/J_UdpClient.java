// ////////////////////////////////////////////////////////
// 
// J_UdpClient.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     基于UDP通讯例程的客户端程序。
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
// 版权:
// 使用本例子，请注明引用:
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
// 请合法使用例程，其用途应当合法有益而且不应对任何人造成任何
// 伤害或损失。同时请注意教材作者及出版社没有对例程做出任何承
// 诺与保证。
// 具体引用的方法及例子如下:
// 本程序是下面教材的一个例程(或本程序基于下面教材的例程修改)
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
//
// 雍俊海还编写过如下的教材和教参:
//      [1] 雍俊海. Java 程序设计. 北京: 清华大学出版社, 2004.
//      [2] 雍俊海. Java程序设计习题集(含参考答案). 
//          北京: 清华大学出版社, 2006.
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
            String s = "请求连接";
            byte[ ] outBuffer= s.getBytes( );
            DatagramPacket outPacket= new DatagramPacket(
                outBuffer, outBuffer.length, sAddr, 8000);
            dSocket.send(outPacket); // 发送数据报

            inPacket= new DatagramPacket(inBuffer, inBuffer.length);
            dSocket.receive(inPacket); // 接收数据报
            s= new String (inPacket.getData( ), 0, inPacket.getLength( ));
            System.out.println("接收到服务器端信息: " + s);

            dSocket.close( );
        }
        catch (Exception e)
        { 
            System.err.println("发生异常:" + e);
            e.printStackTrace( );
        } // try-catch结构结束 
    } // 方法main结束
} // 类J_UdpClient结束
