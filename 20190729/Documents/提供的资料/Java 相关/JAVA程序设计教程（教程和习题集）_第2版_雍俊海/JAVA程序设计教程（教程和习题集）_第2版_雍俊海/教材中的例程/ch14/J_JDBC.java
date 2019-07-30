// ////////////////////////////////////////////////////////
// 
//  J_JDBC.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     利用名称绑定连接数据库，给学科代码数据库表增加两行记录的例程。
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
            // 建立命名服务上下文
            Context ctx = new InitialContext( );
            // 指定JNDI服务提供者
            ctx.addToEnvironment(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.fscontext.RefFSContextFactory");

            // 通过命名服务获取数据源
            DataSource dataSource
                = (DataSource)ctx.lookup("NameOfDataSource");


            // 通过数据源与数据库建立起连接
            Connection c = dataSource.getConnection( );
            Statement s=c.createStatement( ); // 创建SQL语句对象

            // 添加记录
            s.executeUpdate(
                "insert into 学科代码 values(0601, '历史学')");
            s.executeUpdate(
                "insert into 学科代码 values(0504, '艺术学')");

            s.close( );
            c.close( );
            System.out.println(
                "利用名称绑定连接数据库，给学科代码数据库表增加两行记录");
        }
        catch (Exception e)
        {
            System.err.println("异常: " + e.getMessage( ));
        } // try-catch结构结束
    } // 方法main结束
} // 类J_JDBC结束
