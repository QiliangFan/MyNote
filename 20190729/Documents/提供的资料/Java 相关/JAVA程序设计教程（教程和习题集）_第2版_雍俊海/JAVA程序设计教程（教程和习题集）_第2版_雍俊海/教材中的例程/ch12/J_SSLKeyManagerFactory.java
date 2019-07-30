// ////////////////////////////////////////////////////////
// 
// J_SSLKeyManagerFactory.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//      自定义密钥管理器工厂类。
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

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import java.security.KeyStore;

public class J_SSLKeyManagerFactory extends KeyManagerFactorySpi
{
    public String m_alias;      // 密钥项的别名
    public KeyStore m_keystore; // 密钥库
    public char[ ] m_storepass; // 密钥库的密码
    public char[ ] m_keypass;   // 密钥项的密码

    public J_SSLKeyManagerFactory( )
    {
        m_alias = System.getProperty("Self.alias");
        m_keypass = System.getProperty("Self.keypass").toCharArray( );
    } // 构造方法J_SSLKeyManagerFactory结束

    public J_SSLKeyManagerFactory(String alias, char[ ] keypass)
    {
        m_alias = alias;
        m_keypass = keypass;
    } // 构造方法J_SSLKeyManagerFactory结束

    protected KeyManager[ ] engineGetKeyManagers( )
    {
        J_SSLKeyManager [ ] skm = new J_SSLKeyManager[1];
        skm[0] = new J_SSLKeyManager(m_keystore, m_alias,
            m_storepass, m_keypass);
        return(skm);
    } // 方法engineGetKeyManagers结束

    protected void engineInit(KeyStore ks, char[ ] password)
    {
        m_keystore = ks;
        m_storepass = password;
    } // 方法engineInit结束

    // 下面的方法没有实现
    protected void engineInit(ManagerFactoryParameters spec)
    {
    } // 方法engineInit结束
} // 类J_SSLKeyManagerFactory结束
