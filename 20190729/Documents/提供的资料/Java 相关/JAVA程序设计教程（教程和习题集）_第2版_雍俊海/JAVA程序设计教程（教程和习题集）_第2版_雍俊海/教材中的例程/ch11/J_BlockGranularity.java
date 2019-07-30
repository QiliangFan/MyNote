// ////////////////////////////////////////////////////////
// 
// J_BlockGranularity.java
// 
// ������: Ӻ����
// ////////////////////////////////////////////////////////
// ���:
//     ͨ��ʵ�������Ҿ�����Сͬ�����ȵ��߳�ͬ�����̡�
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


public class J_BlockGranularity extends Thread
{
    public static int m_data=0;
    public static int m_times=1000;
    public int m_ID;
    public boolean m_done;

    J_BlockGranularity(int id)
    {
        m_ID=id;
    } // J_BlockGranularity���췽������

    public void run( )
    {
        m_done=false;
        int d= ((m_ID % 2==0) ? 1 : -1);
        System.out.println("�����߳�: " + m_ID + "(����Ϊ: " + d + ")");
        try
        {
            for(int i=0; i<m_times; i++)
            for(int j=0; j<m_times; j++)
                synchronized(Class.forName("J_BlockGranularity"))
                {
                    m_data+=d;
                } // ͬ���������
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace( );
            System.err.println(e);
        } // try-catch�ṹ����
        
        m_done=true;
        System.out.println("�����߳�: " + m_ID);
    } // ����run����
    
    public static void main(String args[ ])
    {
        J_BlockGranularity t1 = new J_BlockGranularity(1);
        J_BlockGranularity t2 = new J_BlockGranularity(2);
        t1.m_done=false;
        t2.m_done=false;
        t1.start( );
        t2.start( );
        while ( !t1.m_done || !t2.m_done ) // �ȴ������߳����н���
            ;
        System.out.println("���: m_data=" + m_data);
    } // ����main����
} // ��J_BlockGranularity����
