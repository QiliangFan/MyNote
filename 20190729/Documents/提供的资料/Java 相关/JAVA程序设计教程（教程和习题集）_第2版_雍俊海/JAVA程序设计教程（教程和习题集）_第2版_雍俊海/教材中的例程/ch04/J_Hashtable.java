// ////////////////////////////////////////////////////////
// 
// J_Hashtable.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     通过哈希表形成数组下标与值之间的双向映射。
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

import java.util.Hashtable;

public class J_Hashtable
{
    public static void main(String args[ ])
    {
        String [ ] sa = {"Mary", "Tom", "John", "James", "Louis", "Jim", 
                      "Rose", "Ann", "Liza", "Betty", "Henry", "Albert"};
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>( );

        // 往哈希表中添加元素，并使得关键字与值之间建立起映射关系
        int i;
        for (i=0; i < sa.length; i++)
            ht.put(sa[i], new Integer(i));

        // 通过下标获得姓名(字符串值)
        i=8;
        System.out.println(
            "在sa数组中，下标为" + i + "的字符串是\"" + sa[i] + "\"");

        // 通过哈希表，直接获得姓名(字符串值)的数组下标
        String s=sa[i];
        System.out.println("在sa数组中，\"" + s + "\"的下标是" + ht.get(s));
    } // 方法main结束
} // 类J_Hashtable结束
