package Interface;

public class InterFaceSon2 implements Interface,Searchable {

	@Override
	public void search(String url) {
		System.out.println(url);
	}

	@Override
	public void interfaceMethod() {
		System.out.println("Interface 인터페이스의 interfaceMethod()를 호출합니다.");
	}
	
}
