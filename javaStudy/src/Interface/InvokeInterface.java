package Interface;

public class InvokeInterface {

	public static void main(String[] args) {
		// 인터페이스 호출방법 1
		// 이렇게 호출하면 인터페이스를 사용한것이 아니다.
		InterFaceSon interFaceSon = new InterFaceSon();
		interFaceSon.interfaceMethod();
		System.out.println(interFaceSon.su);
		
		// 인터페이스 호출방법 2
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
