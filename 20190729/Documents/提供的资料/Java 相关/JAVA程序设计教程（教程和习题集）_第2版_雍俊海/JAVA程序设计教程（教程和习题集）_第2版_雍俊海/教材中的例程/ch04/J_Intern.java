// ////////////////////////////////////////////////////////
// 
// J_Intern.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �ַ��������̡�
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

public class J_Intern
{
    public static void main(String args[ ])
    {
        String s1 = "123456"; // �ַ���ֱ����
        String s2 = "123456"; // �ַ���ֱ����
        String s3 = "123" + "456"; // �ⲻ���ַ���ֱ����
        String a0 = "123";
        String s4 = a0 + "456"; // �ⲻ���ַ���ֱ����
        String s5 = new String("123456"); // �ⲻ���ַ���ֱ����
        String s6 = s5.intern( );
        System.out.println("s2" + ((s2==s1) ? "==" : "!=") +"s1");
        System.out.println("s3" + ((s3==s1) ? "==" : "!=") +"s1");
        System.out.println("s4" + ((s4==s1) ? "==" : "!=") +"s1");
        System.out.println("s5" + ((s5==s1) ? "==" : "!=") +"s1");
        System.out.println("s6" + ((s6==s1) ? "==" : "!=") +"s1");
    } // ����main����
} // ��J_Intern����
