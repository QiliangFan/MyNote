
public class J_Identifier
{
    public static void main(String args[ ])
    {
        char c = 'è';  
        if (Character.isJavaIdentifierStart(c))
            System.out.println("�ַ�\'"+c+"\'��������ʶ�������ַ�");
        else
            System.out.println("�ַ�\'"+c+"\'����������ʶ�������ַ�");
        if (Character.isJavaIdentifierPart(c))
            System.out.println("�ַ�\'"+c
                +"\'��������ʶ�������ַ��������ַ�");
        else
            System.out.println("�ַ�\'"+c
                +"\'����������ʶ�������ַ��������ַ�");
    } // ����main����
} // ��J_Identifier����
