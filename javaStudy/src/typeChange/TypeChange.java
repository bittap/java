package typeChange;

public class TypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �ڵ�Ÿ�Ժ�ȯ
		// ū ������ Ÿ�� = ���� ������ Ÿ��
		long longValue = 500000;
		double doubleValue = longValue;
		System.out.println(doubleValue);
		
		// ����Ÿ�Ժ�ȯ
		// ���� ������ Ÿ�� = (���� ������ Ÿ��) ū ������ Ÿ��
		int intValue = 44032;
		char charValue = (char) intValue;
		System.out.println(charValue);
		
		long longValue2 = 500;
		int intValue2 = (int) longValue2;
		System.out.println(longValue2);
		
		// �Ǽ�Ÿ���� ������ ��ȯ�ϸ� �Ҽ����� ��������.
		double doubleVlue = 1000.3;
		int double_int = (int)doubleVlue;
		System.out.println(double_int);
		
		long su = 50000000000L;
		int ss = (int) su;
		System.out.println(ss);
		

		
	}

}
