// ////////////////////////////////////////////////////////
// 
// J_System.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ϵͳ������Ϣ��ʾ���̡�
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

public class J_System
{
    public static void main(String args[ ])
    {
        String s[ ] = {"file.separator", "java.class.path",
            "java.class.version", "java.compiler", "java.ext.dirs",
            "java.home", "java.io.tmpdir", "java.library.path",
            "java.specification.name", "java.specification.vendor",
            "java.specification.version", "java.vendor",
            "java.vendor.url", "java.version", "java.vm.name",
            "java.vm.specification.name",
            "java.vm.specification.vendor",
            "java.vm.specification.version",
            "java.vm.vendor", "java.vm.version", "line.separator",
            "os.arch", "os.name", "os.version", "path.separator",
            "user.dir", "user.home", "user.name"};
        String r;
        for (int i=0; i<s.length; i++)
        {
            try
            {
                r = System.getProperty(s[i]);
            }
            catch (Exception e)
            {
                r = "�����쳣" + e;
            } // try-catch�ṹ����
            System.out.println(s[i] + ": " + r);
        } // forѭ������
    } // ����main����
} // ��J_System����
