package compare;

public class dataTypeCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �ڹٴ� �⺻ Ÿ���� == String�� String.equals("���ڿ�")
		
		String str = "���";
		String str2 = "���";
		
		if(str.equals(str2)) {
			System.out.println("���ڿ� ��ġ�� equals");
		}
		
		int su1 = 10;
		int su2 = 10;
		
		if(su1 == su2) {
			System.out.println("�Ǽ� ��ġ�� ==");
		}
		
		float flo = 10.5f;
		double dou = 10.5;
		
		if(flo == dou) {
			System.out.println("�Ǽ� ��ġ�� ==");
		}
		
		boolean trueBoolean1 = true;
		boolean trueBoolean2 = true;
		
		if(trueBoolean1 == trueBoolean2) {
			System.out.println("�Ҹ� ��ġ�� ==");
		}
	}

}
