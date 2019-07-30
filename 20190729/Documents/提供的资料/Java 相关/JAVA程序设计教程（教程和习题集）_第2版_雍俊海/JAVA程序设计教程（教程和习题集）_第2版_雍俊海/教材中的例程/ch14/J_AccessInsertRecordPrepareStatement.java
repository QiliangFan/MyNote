// ////////////////////////////////////////////////////////
// 
//  J_AccessInsertRecordPrepareStatement.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ͨ��Ԥ����SQL�������ݿ��ѧ���ɼ����������(��¼)�����̡�
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
import java.sql.PreparedStatement;

public class J_AccessInsertRecordPrepareStatement
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
            // ����Ԥ����SQL���
            PreparedStatement ps=c.prepareStatement(
                "insert into ѧ���ɼ� values(?, ?, ?)"); 
            // ��Ӽ�¼
            ps.setInt(1, 2008010444);
            ps.setString(2, "Jim");
            ps.setInt(3, 60);
            ps.executeUpdate( );
            
            // ��Ӽ�¼
            ps.setInt(1, 2008010445);
            ps.setString(2, "Jack");
            ps.setInt(3, 100);
            ps.executeUpdate( );

            ps.close( );
            c.close( );
            System.out.println("�����ݿ��\"ѧ���ɼ�\"�������м�¼");
        }
        catch (Exception e)
        {
            System.err.println("�쳣: " + e.getMessage( ));
        } // try-catch�ṹ����
    } // ����main����
} // ��J_AccessInsertRecordPrepareStatement����
