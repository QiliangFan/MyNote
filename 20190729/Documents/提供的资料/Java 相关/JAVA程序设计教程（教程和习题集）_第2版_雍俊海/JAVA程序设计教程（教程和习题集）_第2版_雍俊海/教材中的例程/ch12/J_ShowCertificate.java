// ////////////////////////////////////////////////////////
// 
// J_ShowCertificate.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ��ʾ����֤���ļ���Ϣ�����̡�
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
            System.out.println("��������ṩ����: ����֤����ļ�����");
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
                System.out.println("֤������:");

                System.out.println("�汾��: " + xcert.getVersion( ));
                System.out.println("���к�: " 
                    + xcert.getSerialNumber( ).toString(16));
                System.out.println("������: " 
                    + xcert.getSubjectX500Principal( ));
                System.out.println("������: " 
                    + xcert.getIssuerX500Principal( ));
                System.out.println("��Ч����ʼʱ��: " + xcert.getNotBefore( ));
                System.out.println("��Ч����ֹʱ��: " + xcert.getNotAfter( ));
                System.out.println("ǩ���㷨: " + xcert.getSigAlgName( ));
                byte[ ] sig = xcert.getSignature( );
                System.out.println("ǩ��: "
                    + (new BigInteger(sig)).toString(16));
                byte[ ] k = xcert.getPublicKey( ).getEncoded( );
                System.out.println("��Կ: " 
                    + (new BigInteger(k)).toString(16));
            } // whileѭ������
            bis.close( );
        }
        catch(Exception e)
        {
            System.err.println("ע: main�����������쳣��");
            System.err.println(e);
            e.printStackTrace( );
        } // try-catch�ṹ����
    } // ����main����
} // ��J_ShowCertificate����
