package typeChange;

public class CalJungSuDataChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ������� �����ϸ� btye short Ÿ���� int�� �ڵ���ȯ��
		byte sum1 = 10;
		short sum2 = 20;
		int sum = sum1+sum2;
		System.out.println("������� ������ int:"+sum);
		
		byte result = 10+20;
		System.out.println("�ǿ����ڰ� byte�� �ƴϸ� �������:"+result);
		
		// ����� ����� ����ū ���������� ������ �ٲ�
		byte sum3 = 10;
		int sum4 = 1000;
		long sum5 = 10000;
		
		long sum6 = sum3+sum4+sum5;
		System.out.println(sum6);
	}

}
