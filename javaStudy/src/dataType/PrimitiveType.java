package dataType;

public class PrimitiveType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ����  -> byte,short,char,int,long
		System.out.println("Byte�� ����:"+Byte.MIN_VALUE+"~"+Byte.MAX_VALUE);
		System.out.println("short�� ����:"+Short.MIN_VALUE+"~"+Short.MAX_VALUE);
		System.out.println("int�� ����:"+Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
		System.out.println("long�� ����:"+Long.MIN_VALUE+"~"+Long.MAX_VALUE);
		
		// ���� -> char, string
		/* 
		char = 2byteŸ���� ���ڷ� �����ڵ�ε� �����ϴ�.
		���� ����ǥ�� ǥ���Ѵ�
		*/ 
		char ch = 65;
		System.out.println("char:"+ch); // �����ڵ�
		char ch2 = 'A';
		System.out.println("char:"+ch2);
		/*
		String = ���ڿ� ǥ��
		 */
		String str = "�¿�";
		System.out.println("String:"+str);
		// �Ǽ� -> float, double
		// ** �ڹٴ� �Ǽ� ���ͷ��� �⺻������ double Ÿ������ �����ϹǷ� �� �ڿ� �ҹ��� f �Ǵ� �빮�� F�� ������ ������ �����߻�
		//float flo = 3.14; // ����
		double dou = 3.14;
		System.out.println("float�� ����:"+Float.MIN_VALUE+"~"+Float.MAX_VALUE);
		System.out.println("double�� ����:"+Double.MIN_VALUE+"~"+Double.MAX_VALUE);
		
		// �� -> boolean true, false
		
		
	}

}
