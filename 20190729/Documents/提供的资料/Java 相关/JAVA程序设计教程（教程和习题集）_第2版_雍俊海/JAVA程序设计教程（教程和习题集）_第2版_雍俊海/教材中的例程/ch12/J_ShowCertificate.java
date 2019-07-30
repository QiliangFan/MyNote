// ////////////////////////////////////////////////////////
// 
// J_ShowCertificate.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     显示数字证书文件信息的例程。
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

import java.security.cert.CertificateFactory;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.math.BigInteger;

public class J_ShowCertificate
{
    public static void main(String args[ ])
    {
        if (args.length<1)
        {
            System.out.println("请给程序提供参数: 数字证书的文件名。");
            return;
        }
        try
        {
            FileInputStream fis = new FileInputStream(args[0]);
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            CertificateFactory cf = 
                CertificateFactory.getInstance("X.509");
            
            while (bis.available( ) > 0)
            {
                Certificate cert = cf.generateCertificate(bis);
                X509Certificate xcert= (X509Certificate) cert;
                System.out.println("证书内容:");

                System.out.println("版本号: " + xcert.getVersion( ));
                System.out.println("序列号: " 
                    + xcert.getSerialNumber( ).toString(16));
                System.out.println("所有者: " 
                    + xcert.getSubjectX500Principal( ));
                System.out.println("发照者: " 
                    + xcert.getIssuerX500Principal( ));
                System.out.println("有效期起始时间: " + xcert.getNotBefore( ));
                System.out.println("有效期终止时间: " + xcert.getNotAfter( ));
                System.out.println("签名算法: " + xcert.getSigAlgName( ));
                byte[ ] sig = xcert.getSignature( );
                System.out.println("签名: "
                    + (new BigInteger(sig)).toString(16));
                byte[ ] k = xcert.getPublicKey( ).getEncoded( );
                System.out.println("公钥: " 
                    + (new BigInteger(k)).toString(16));
            } // while循环结束
            bis.close( );
        }
        catch(Exception e)
        {
            System.err.println("注: main方法发生了异常。");
            System.err.println(e);
            e.printStackTrace( );
        } // try-catch结构结束
    } // 方法main结束
} // 类J_ShowCertificate结束
