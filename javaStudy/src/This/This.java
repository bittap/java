package This;

public class This {
	String name = "김태영";
	int age = 27;
	
	public This(String name, int age) {
		// this를 안붙이면 매개변수를 가리킨다.
		// 자바버전 떄문에 그런지 몰라도 this를 안붙여도 에러가 안난다.
		// this.변수 = 필드를 가리킴
		this.name = name;
		this.age = age;
		System.out.printf("name : %s, age : %d",name,age);
	}

}
