// ////////////////////////////////////////////////////////
// 
//  J_AccessModifyRecord.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �������ݿ��ѧ���ɼ�����ѧ��Ϊ2008010441��ѧ��������Ϊ"Jenny"�����̡�
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class J_AccessModifyRecord
{
    public static void main(String args[ ])
    {
        try
        {
            // ����JDBC-ODBC����������
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            // ͨ������Դ�����ݿ⽨��������
            Connection c
            =DriverManager.getConnection("jdbc:odbc:studentDatabase");
            Statement s=c.createStatement( ); // ����SQL������
            // ���¼�¼
            s.executeUpdate(
                "update ѧ���ɼ� set ����='Jenny' where ѧ��=2008010441");
            s.close( );
            c.close( );
            System.out.println("�������ݿ��\"ѧ���ɼ�\""+
                "��ѧ��Ϊ2008010441��ѧ��������Ϊ\"Jenny\"");
        }
        catch (Exception e)
        {
            System.err.println("�쳣: " + e.getMessage( ));
        } // try-catch�ṹ����
    } // ����main����
} // ��J_AccessModifyRecord����
