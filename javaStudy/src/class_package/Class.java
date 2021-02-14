package class_package;

public class Class {

	public static void main(String[] args) {
		
		// 클래스로부터 만들어진 해당 객체를 인스턴스
		String str = 
		// 클래스로부터 해당 객체를 만드는 것을 인스턴스화
		new String("김태영");
		
		// 객체생성방법 1
		ExampleClass eclass;
		eclass = new ExampleClass();
		
		// 객체생성방법 2
		ExampleClass eclass1 = new ExampleClass();
		
		ExampleClass eclass2 = new ExampleClass(18, "사사키노조미");
	}

}
