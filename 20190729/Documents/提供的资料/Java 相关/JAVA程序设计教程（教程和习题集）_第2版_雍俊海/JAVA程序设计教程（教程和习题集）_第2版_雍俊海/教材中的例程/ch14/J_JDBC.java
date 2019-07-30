// ////////////////////////////////////////////////////////
// 
//  J_JDBC.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �������ư��������ݿ⣬��ѧ�ƴ������ݿ���������м�¼�����̡�
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
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class J_JDBC
{
    public static void main(String args[ ])
    {
        try
        {
            // ������������������
            Context ctx = new InitialContext( );
            // ָ��JNDI�����ṩ��
            ctx.addToEnvironment(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.fscontext.RefFSContextFactory");

            // ͨ�����������ȡ����Դ
            DataSource dataSource
                = (DataSource)ctx.lookup("NameOfDataSource");


            // ͨ������Դ�����ݿ⽨��������
            Connection c = dataSource.getConnection( );
            Statement s=c.createStatement( ); // ����SQL������

            // ��Ӽ�¼
            s.executeUpdate(
                "insert into ѧ�ƴ��� values(0601, '��ʷѧ')");
            s.executeUpdate(
                "insert into ѧ�ƴ��� values(0504, '����ѧ')");

            s.close( );
            c.close( );
            System.out.println(
                "�������ư��������ݿ⣬��ѧ�ƴ������ݿ���������м�¼");
        }
        catch (Exception e)
        {
            System.err.println("�쳣: " + e.getMessage( ));
        } // try-catch�ṹ����
    } // ����main����
} // ��J_JDBC����
