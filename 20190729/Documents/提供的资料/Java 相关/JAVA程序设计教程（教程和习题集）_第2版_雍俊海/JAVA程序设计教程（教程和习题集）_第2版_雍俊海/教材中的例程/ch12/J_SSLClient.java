// ////////////////////////////////////////////////////////
// 
// J_SSLClient.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//      基于SSL的客户端程序。
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

        // 指定信任密钥库
        System.setProperty("javax.net.ssl.trustStore",
            ".\\client.trustStore");

        // 获取套接字工厂的实例对象
        SSLSocketFactory sf = 
            (SSLSocketFactory)SSLSocketFactory.getDefault( );
        try
        {
            if (args.length>=2)
                port= Integer.parseInt(args[1]);
            else port= 5000;

            // 获取套接字，与服务器端建立连接
            Socket s = sf.createSocket(host, port);

            InetAddress sa = s.getInetAddress( );
            InetAddress ca = s.getLocalAddress( );  

            System.out.println("客户端接收服务器端信息:");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(s.getInputStream( )));
            String str;
            str=br.readLine( );
            System.out.println(str);

            System.out.println("客户端向服务器端发送信息:");
            PrintWriter pw = new PrintWriter(s.getOutputStream( ));
            str = 
                "客户端"
                + ca.getHostAddress( ) + "(" + s.getLocalPort( ) + ")"
                + "应答服务器端"
                + sa.getHostAddress( ) + "(" + s.getPort( ) + ")"
                + "。";
            System.out.println(str);
            pw.println(str);
            pw.flush( );

            pw.close( );
            br.close( );
            s.close( );
        }
        catch(Exception e)
        {
            System.err.println("注: main方法发生了异常。");
            System.err.println(e);
            e.printStackTrace( );
        } // try-catch结构结束
    } // 方法main结束
} // 类J_SSLClient结束
