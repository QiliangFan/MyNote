// ////////////////////////////////////////////////////////
// 
//  J_AccessShowRecord.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ��ʾ���ݿ��ѧ���ɼ����ļ�¼��Ϣ�����̡�
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
import java.sql.ResultSet;
import java.sql.Statement;

public class J_AccessShowRecord
{
    public static void mb_ShowRecord(ResultSet r)
    {
        try
        {
            r.last( );
            System.out.println("���ݿ����" + r.getRow( ) + "�м�¼");
            r.beforeFirst( );
            while (r.next( ))
            {
                System.out.println("��" + r.getRow( ) + "�м�¼Ϊ:");
                System.out.print  ("\tѧ��Ϊ: " + r.getInt("ѧ��"));
                System.out.print  ("\t����Ϊ: " + r.getString("����"));
                System.out.println("\t�ɼ�Ϊ: " + r.getInt("�ɼ�"));
            } // whileѭ������
        }
        catch (Exception e)
        {
            System.err.println("�쳣: " + e.getMessage( ));
        } // try-catch�ṹ����
    } // ����mb_ShowRecord����

    public static void main(String args[ ])
    {
        try
        {
            // ����JDBC-ODBC����������
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            // ͨ������Դ�����ݿ⽨��������
            Connection c
            =DriverManager.getConnection("jdbc:odbc:studentDatabase");
            // ����SQL������
            Statement s=c.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
            // ��ȡ���ݿ������
            ResultSet r=s.executeQuery("select * from ѧ���ɼ�");
            mb_ShowRecord(r);
            s.close( );
            c.close( );
        }
        catch (Exception e)
        {
            System.err.println("�쳣: " + e.getMessage( ));
        } // try-catch�ṹ����
    } // ����main����
} // ��J_AccessShowRecord����
