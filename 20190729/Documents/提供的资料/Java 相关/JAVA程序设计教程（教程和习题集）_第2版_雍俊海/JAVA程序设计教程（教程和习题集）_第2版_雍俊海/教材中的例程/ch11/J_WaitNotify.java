// ////////////////////////////////////////////////////////
// 
// J_WaitNotify.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ����wait��notify��Ա���������߳�ͬ�������̡�
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
    private int m_temperature, m_pressure;
    private boolean m_ready=false;
    
    public synchronized void mb_update(int t, int p)
    {
        System.out.println("������·����ڲ�:");
        if (m_ready) // ǰ����µ����ݻ�û�б�����
        {
            System.out.println("    �ȴ����ݷ������...");
            try
            {
                wait( ); // �ȴ����ݷ���
            }
            catch(Exception e)
            {
                e.printStackTrace( );
                System.err.println(e);
            } // try-catch�ṹ����
            System.out.println("    ������������...");
        } // if������
        m_temperature = t;
        m_pressure    = p;
        System.out.println("�������: �¶�ֵΪ" + t + ", ��ѹֵΪ" + p);
        m_ready=true;
        notify( );
    } // ͬ������mb_update����
    
    public synchronized void mb_analyze( )
    {
        System.out.println("�������ݷ��������ڲ�:");
        if (!m_ready) // ���ݻ�û�и���
        {
            System.out.println("    �ȴ����ݸ������...");
            try
            {
                wait( ); // �ȴ����ݸ���
            }
            catch(Exception e)
            {
                e.printStackTrace( );
                System.err.println(e);
            } // try-catch�ṹ����
            System.out.println("    ������������...");
        } // if������
        int t= m_temperature;
        int p= m_pressure;
        System.out.println("�������: �¶�ֵΪ" + t + ", ��ѹֵΪ" + p);
        m_ready=false;
        notify( );
    } // ͬ������mb_analyze����
} // ��J_Experiment����

class J_Assistant extends Thread
{
    J_Experiment m_data;
    
    public J_Assistant(J_Experiment d)
    {
        m_data= d;
    } // ���췽��J_Assistant����

    public void run( )
    {
        System.out.println("�����߳̿�ʼ����");
        int i, j, k;
        for(k=0; k<3; k++)
        {
            i= (int)(Math.random( ) * 1000);
            j= (int)(Math.random( ) * 1000);
            m_data.mb_update(i, j);
        } // forѭ������
        System.out.println("�����߳̽�������");
    } // ����run����
} // ��J_Assistant����

class J_Analyst extends Thread
{
    J_Experiment m_data;
    
    public J_Analyst(J_Experiment d)
    {
        m_data= d;
    } // ���췽��J_Analyst����
    
    public void run( )
    {
        System.out.println("����Ա�߳̿�ʼ����");
        for(int k=0; k<3; k++)
            m_data.mb_analyze( );
        System.out.println("����Ա�߳̽�������");
    } // ����run����
} // ��J_Analyst����

public class J_WaitNotify
{
    public static void main( String args[ ] )
    { 
        J_Experiment data= new J_Experiment( );
        J_Assistant threadA = new J_Assistant(data);
        J_Analyst   threadB = new J_Analyst(data);
        threadA.start( );
        threadB.start( );
        System.out.println("����main����");
    } // ����main����
} // ��J_WaitNotify����
