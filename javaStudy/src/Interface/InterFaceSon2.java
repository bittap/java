package Interface;

public class InterFaceSon2 implements Interface,Searchable {

	@Override
	public void search(String url) {
		System.out.println(url);
	}

	@Override
	public void interfaceMethod() {
		System.out.println("Interface �������̽��� interfaceMethod()�� ȣ���մϴ�.");
	}
	
}
