// ////////////////////////////////////////////////////////
// 
// J_ShowKeystore.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ��ʾ��ָ����Կ���еĸ�����Կ��˽Կ��Ϣ�����̡�
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
            // ��ȡϵͳĬ����Կ���·����������
            ks_name = System.getProperty("user.home") + "\\.keystore";
        }
        else ks_name = args[0];
        System.out.println("��Կ��" + ks_name + "��һЩ��Ϣ����:");
        try
        {
            FileInputStream fis = new FileInputStream(ks_name);
            KeyStore ks = KeyStore.getInstance("JKS");
            String password = "ks123456"; // ��Կ�������
            String epw = "key123456";     // ��Կ�������
            String a;       // ��Կ�����
            PrivateKey pk;  // ��Կ��˽Կ
            byte[ ] k;
            if (args.length>1)
                password = args[1]; // �ɳ������ָ����Կ������

            ks.load(fis, password.toCharArray( ));
    
            // ��ȡ����ʾ����Կ���е���Կ�����
            Enumeration<String> e = ks.aliases( ); // ��ȡ������Կ�����
            while (e.hasMoreElements( ))
            {
                a = e.nextElement( ); // ȡ����Կ�����
                System.out.println("��Կ��" + a + "��˽Կ��:");

                // ��ȡ��Կ��˽Կ
                pk = (PrivateKey) ks.getKey(a, epw.toCharArray( ));
                k = pk.getEncoded( );
                System.out.println((new BigInteger(k)).toString(16));
            } // whileѭ������
        }
        catch(Exception e)
        {
            System.err.println("ע: main�����������쳣��");
            System.err.println(e);
            e.printStackTrace( );
        } // try-catch�ṹ����
    } // ����main����
} // ��J_ShowKeystore����
