// ////////////////////////////////////////////////////////
// 
// J_Timer.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     计时器例程。
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

package cn.edu.tsinghua.example;

import java.util.Date;

/**
 * 计时器。
 * <p>
 * 计时器可以记录开始的时间和终止的时间，
 * 并能计算出所花费的时间。
 *
 * @author 雍俊海
 * @version 2.0
 * @since J2SE 1.6
 */
public class J_Timer
{
    /** 
     * 起始时间。 
     */
    private Date m_start;

    /** 
     * 终止时间。 
     */
    private Date m_end;

    /** 
     * 设置起始时间。 
     */
    public void mb_setStart( )
    {
        m_start = new Date( );
    } // 方法mb_setStart结束

    /** 
     * 设置终止时间。 
     */
    public void mb_setEnd( )
    {
        m_end = new Date( );
    } // 方法mb_setEnd结束

    /** 
     * 计算花费的时间。 
     * <p>
     * 花费的时间 = 终止时间 - 起始时间。
     * @return 花费的时间。
     */
    public long mb_getTime( )
    {
        return(m_end.getTime( ) - m_start.getTime( ) );
    } // 方法mb_getTime结束
} // 类J_Timer结束
