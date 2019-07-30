// ////////////////////////////////////////////////////////
// 
//  J_Jdbc4.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     创建数据库表: “学科代码”，并给数据库表添加一条记录。
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

import com.inet.tds.PDataSource;
import java.sql.Connection;
import java.sql.Statement;

public class J_Jdbc4
{
    public static void main(String args[ ])
    {
        try
        {
            // 创建数据源
            PDataSource dataSource = new PDataSource( );
            // 指定数据库服务器所在的IP地址
            dataSource.setServerName("127.0.0.1");
            // 指定数据库服务器实例名
            dataSource.setInstanceName("student");
            // 指定要使用的数据库名称
            dataSource.setDatabaseName("tempdb");
            // 指定数据库服务器帐号
            dataSource.setUser("sa");
            // 指定数据库服务器帐号密码
            dataSource.setPassword("password");

            // 通过数据源与数据库建立起连接
            Connection c = dataSource.getConnection( );
            Statement s=c.createStatement( ); // 创建SQL语句对象
            // 创建数据库表: 学科代码
            s.executeUpdate(
                "create table 学科代码(代码 integer, 学科 char(40))");
            // 添加记录
            s.executeUpdate(
                "insert into 学科代码 values(0812, '计算机科学与技术')");
            s.close( );
            c.close( );
            System.out.println("创建数据库表: 学科代码，并添加记录");
        }
        catch (Exception e)
        {
            System.err.println("异常: " + e.getMessage( ));
        }  // try-catch结构结束
    } // 方法main结束
} // 类J_Jdbc4结束
