package dataType;

public class ReferenceTypeCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ���� ���������� ==, != ������   
		// �������� ���� �ּҸ� �����ִ��ĸ� ���ϴ°Ŵ� 
		int[] intArr1 = {10,20,30};
		int[] intArr2 = {10,20,30};
		
		if(intArr1 != intArr2) {
			System.out.println("��ü������ �޸� �������� ���Ѵ�.");
		}
		
		// �ڹٴ� ���ڿ� ���ͷ��� ���� ��� ���� �������� �����Ѵ�.
		String str1 = "���¿�";
		String str2 = "���¿�";
		
		if(str1 == str2) {
			System.out.println("���ڿ��� ���ͷ��� ���� ��� ���� �������� �����Ѵ�. �� ���ÿ� ����Ǵ� �޸𸮹������� ����");
		}
	}

}
