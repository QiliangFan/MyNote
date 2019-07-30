// ////////////////////////////////////////////////////////
// 
// J_SynchronizedStatic.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     �߳�ͬ������: ˵����̬�ĺͷǾ�̬��ͬ��������
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

    public static synchronized void m_methodStatic(int id)
    {
        System.out.println("�߳�" + id + "���뾲̬ͬ������");
        mb_sleep(1000);
        System.out.println("�߳�" + id + "�뿪��̬ͬ������");
    } // ����m_methodStatic����

    public synchronized void m_methodSynchronized(int id)
    {
        System.out.println("�߳�" + id + "����Ǿ�̬ͬ������");
        mb_sleep(1000);
        System.out.println("�߳�" + id + "�뿪�Ǿ�̬ͬ������");
    } // ����m_methodSynchronized����

    public void m_method(int id)
    {
        System.out.println("�߳�" + id + "����Ǿ�̬��ͬ������");
        mb_sleep(1000);
        System.out.println("�߳�" + id + "�뿪�Ǿ�̬��ͬ������");
    } // ����m_method����
} // ��J_Experiment����

public class J_SynchronizedStatic extends Thread
{
    public int m_ID;
    public J_Experiment m_data;

    J_SynchronizedStatic(int id)
    {
        m_ID=id;
    } // J_SynchronizedStatic���췽������

    public void run( )
    {
        System.out.println("�����߳�: " + m_ID);
        m_data.m_methodSynchronized(m_ID);
        m_data.m_methodStatic(m_ID);
        m_data.m_method(m_ID);
        System.out.println("�����߳�: " + m_ID);
    } // ����run����
    
    public static void main(String args[ ])
    {
        int n=2;
        J_SynchronizedStatic [ ] t = new J_SynchronizedStatic[n];
        J_Experiment d = new J_Experiment( );
        for(int i=0; i< n; i++)
        {
            t[i] = new J_SynchronizedStatic(i);
            t[i].m_data = d;
            t[i].start( );
        } // forѭ������
        System.out.println("����main����");
    } // ����main����
} // ��J_SynchronizedStatic����
