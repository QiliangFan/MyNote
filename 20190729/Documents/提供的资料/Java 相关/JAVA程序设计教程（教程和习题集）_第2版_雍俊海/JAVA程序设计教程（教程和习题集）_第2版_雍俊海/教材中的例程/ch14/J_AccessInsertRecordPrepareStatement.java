// ////////////////////////////////////////////////////////
// 
//  J_AccessInsertRecordPrepareStatement.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     通过预编译SQL语句给数据库表“学生成绩”添加数据(记录)的例程。
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
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class J_AccessInsertRecordPrepareStatement
{
    public static void main(String args[ ])
    {
        try
        {
            // 加载JDBC-ODBC桥驱动程序
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            // 通过数据源与数据库建立起连接
            Connection c
            =DriverManager.getConnection("jdbc:odbc:studentDatabase");
            // 创建预编译SQL语句
            PreparedStatement ps=c.prepareStatement(
                "insert into 学生成绩 values(?, ?, ?)"); 
            // 添加记录
            ps.setInt(1, 2008010444);
            ps.setString(2, "Jim");
            ps.setInt(3, 60);
            ps.executeUpdate( );
            
            // 添加记录
            ps.setInt(1, 2008010445);
            ps.setString(2, "Jack");
            ps.setInt(3, 100);
            ps.executeUpdate( );

            ps.close( );
            c.close( );
            System.out.println("给数据库表\"学生成绩\"增加两行记录");
        }
        catch (Exception e)
        {
            System.err.println("异常: " + e.getMessage( ));
        } // try-catch结构结束
    } // 方法main结束
} // 类J_AccessInsertRecordPrepareStatement结束
