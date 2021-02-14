package class_package;

public class ExampleClass {
	String name = "김태영";
	int age = 27;

	public ExampleClass() {
		System.out.println("객체생성");
	}
	
	public ExampleClass(int age,String name) {
		System.out.printf("나이: %d, 이름: %s",age,name);
	}

}
