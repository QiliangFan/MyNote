// ////////////////////////////////////////////////////////
// 
// J_ShowKeystore.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     显示在指定密钥库中的各个密钥项私钥信息的例程。
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

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Enumeration;
import java.math.BigInteger;

public class J_ShowKeystore
{
    public static void main(String args[ ])
    {
        String ks_name;
        if (args.length<1)
        {
            // 获取系统默认密钥库的路径及其名称
            ks_name = System.getProperty("user.home") + "\\.keystore";
        }
        else ks_name = args[0];
        System.out.println("密钥库" + ks_name + "的一些信息如下:");
        try
        {
            FileInputStream fis = new FileInputStream(ks_name);
            KeyStore ks = KeyStore.getInstance("JKS");
            String password = "ks123456"; // 密钥库的密码
            String epw = "key123456";     // 密钥项的密码
            String a;       // 密钥项别名
            PrivateKey pk;  // 密钥项私钥
            byte[ ] k;
            if (args.length>1)
                password = args[1]; // 由程序参数指定密钥库密码

            ks.load(fis, password.toCharArray( ));
    
            // 获取并显示在密钥库中的密钥项别名
            Enumeration<String> e = ks.aliases( ); // 获取各个密钥项别名
            while (e.hasMoreElements( ))
            {
                a = e.nextElement( ); // 取出密钥项别名
                System.out.println("密钥项" + a + "的私钥是:");

                // 获取密钥项私钥
                pk = (PrivateKey) ks.getKey(a, epw.toCharArray( ));
                k = pk.getEncoded( );
                System.out.println((new BigInteger(k)).toString(16));
            } // while循环结束
        }
        catch(Exception e)
        {
            System.err.println("注: main方法发生了异常。");
            System.err.println(e);
            e.printStackTrace( );
        } // try-catch结构结束
    } // 方法main结束
} // 类J_ShowKeystore结束
