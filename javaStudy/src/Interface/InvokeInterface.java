package Interface;

public class InvokeInterface {

	public static void main(String[] args) {
		// �������̽� ȣ���� 1
		// �̷��� ȣ���ϸ� �������̽��� ����Ѱ��� �ƴϴ�.
		InterFaceSon interFaceSon = new InterFaceSon();
		interFaceSon.interfaceMethod();
		System.out.println(interFaceSon.su);
		
		// �������̽� ȣ���� 2
		Interface interface1;
		interface1 = new InterFaceSon();
		interface1.interfaceMethod();
		
		
		
		InterFaceSon2 interFaceSon2 = new InterFaceSon2();
		Interface interface2 = interFaceSon2;
		Searchable searchable = interFaceSon2;
		
		interface2.interfaceMethod();
		searchable.search("http://naver.com");
	}

}
