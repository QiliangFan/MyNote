// ////////////////////////////////////////////////////////
// 
// J_SSLKeyManagerFactory.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//      �Զ�����Կ�����������ࡣ
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

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import java.security.KeyStore;

public class J_SSLKeyManagerFactory extends KeyManagerFactorySpi
{
    public String m_alias;      // ��Կ��ı���
    public KeyStore m_keystore; // ��Կ��
    public char[ ] m_storepass; // ��Կ�������
    public char[ ] m_keypass;   // ��Կ�������

    public J_SSLKeyManagerFactory( )
    {
        m_alias = System.getProperty("Self.alias");
        m_keypass = System.getProperty("Self.keypass").toCharArray( );
    } // ���췽��J_SSLKeyManagerFactory����

    public J_SSLKeyManagerFactory(String alias, char[ ] keypass)
    {
        m_alias = alias;
        m_keypass = keypass;
    } // ���췽��J_SSLKeyManagerFactory����

    protected KeyManager[ ] engineGetKeyManagers( )
    {
        J_SSLKeyManager [ ] skm = new J_SSLKeyManager[1];
        skm[0] = new J_SSLKeyManager(m_keystore, m_alias,
            m_storepass, m_keypass);
        return(skm);
    } // ����engineGetKeyManagers����

    protected void engineInit(KeyStore ks, char[ ] password)
    {
        m_keystore = ks;
        m_storepass = password;
    } // ����engineInit����

    // ����ķ���û��ʵ��
    protected void engineInit(ManagerFactoryParameters spec)
    {
    } // ����engineInit����
} // ��J_SSLKeyManagerFactory����
