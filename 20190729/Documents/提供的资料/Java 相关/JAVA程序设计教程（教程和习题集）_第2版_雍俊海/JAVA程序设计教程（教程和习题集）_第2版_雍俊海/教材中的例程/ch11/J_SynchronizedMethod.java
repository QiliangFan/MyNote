// ////////////////////////////////////////////////////////
// 
// J_SynchronizedMethod.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �߳�ͬ������: ˵����ͬһ�������еĶ��ͬ�����������л��ơ�
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


class J_Experiment
{
    public static void mb_sleep(long millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {
            System.err.println("�쳣InterruptedException: " + e);
            e.printStackTrace( );
        } // try-catch�ṹ����
    } // ����mb_sleep����

    public synchronized void m_method1(int id)
    {
        System.out.println("�߳�" + id + "���뷽��1");
        mb_sleep(1000);
        System.out.println("�߳�" + id + "�뿪����1");
    } // ����m_method1����

    public synchronized void m_method2(int id)
    {
        System.out.println("�߳�" + id + "���뷽��2");
        mb_sleep(1000);
        System.out.println("�߳�" + id + "�뿪����2");
    } // ����m_method2����
} // ��J_Experiment����

public class J_SynchronizedMethod extends Thread
{
    public int m_ID;
    public J_Experiment m_data;

    J_SynchronizedMethod(int id)
    {
        m_ID=id;
    } // J_SynchronizedMethod���췽������

    public void run( )
    {
        System.out.println("�����߳�: " + m_ID);
        m_data.m_method1(m_ID);
        m_data.m_method2(m_ID);
        System.out.println("�����߳�: " + m_ID);
    } // ����run����
    
    public static void main(String args[ ])
    {
        int n=2;
        J_SynchronizedMethod [ ] t = new J_SynchronizedMethod[n];
        J_Experiment d = new J_Experiment( );
        for(int i=0; i< n; i++)
        {
            t[i] = new J_SynchronizedMethod(i);
            t[i].m_data = d;
            t[i].start( );
        } // forѭ������
        System.out.println("����main����");
    } // ����main����
} // ��J_SynchronizedMethod����
