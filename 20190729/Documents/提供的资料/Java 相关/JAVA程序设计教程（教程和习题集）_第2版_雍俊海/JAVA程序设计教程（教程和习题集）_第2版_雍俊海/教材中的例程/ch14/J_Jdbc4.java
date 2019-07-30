// ////////////////////////////////////////////////////////
// 
//  J_Jdbc4.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �������ݿ��: ��ѧ�ƴ��롱���������ݿ�����һ����¼��
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

import com.inet.tds.PDataSource;
import java.sql.Connection;
import java.sql.Statement;

public class J_Jdbc4
{
    public static void main(String args[ ])
    {
        try
        {
            // ��������Դ
            PDataSource dataSource = new PDataSource( );
            // ָ�����ݿ���������ڵ�IP��ַ
            dataSource.setServerName("127.0.0.1");
            // ָ�����ݿ������ʵ����
            dataSource.setInstanceName("student");
            // ָ��Ҫʹ�õ����ݿ�����
            dataSource.setDatabaseName("tempdb");
            // ָ�����ݿ�������ʺ�
            dataSource.setUser("sa");
            // ָ�����ݿ�������ʺ�����
            dataSource.setPassword("password");

            // ͨ������Դ�����ݿ⽨��������
            Connection c = dataSource.getConnection( );
            Statement s=c.createStatement( ); // ����SQL������
            // �������ݿ��: ѧ�ƴ���
            s.executeUpdate(
                "create table ѧ�ƴ���(���� integer, ѧ�� char(40))");
            // ��Ӽ�¼
            s.executeUpdate(
                "insert into ѧ�ƴ��� values(0812, '�������ѧ�뼼��')");
            s.close( );
            c.close( );
            System.out.println("�������ݿ��: ѧ�ƴ��룬����Ӽ�¼");
        }
        catch (Exception e)
        {
            System.err.println("�쳣: " + e.getMessage( ));
        }  // try-catch�ṹ����
    } // ����main����
} // ��J_Jdbc4����
