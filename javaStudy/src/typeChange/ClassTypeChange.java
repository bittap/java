package typeChange;

class A{};

class B extends A{};

class C extends A{};

class D extends B{};

class E extends C{};

class Parent{
	public Parent() {
		System.out.println("난 엄마야");
	}
	public void method1() {
		System.out.println("method1호출");
	}
	public void method2() {
		System.out.println("method2호출");
	}
}

class Children extends Parent{
	int su = 5;
	
	public Children(int su) {
		this.su = su;
		System.out.println("난 자식이야");
	}
	
	@Override
	public void method2() {
		System.out.println("method2를 오버라이딩한놈 호출");
	}
	
	public void method3() {
		System.out.println("method3호출");
	}
}

public class ClassTypeChange {

	public static void main(String[] args) {
		// 클래스 타입변환
		// 자동변환
		// 부모타입변수 = 자식타입
		
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		
		Children children = new Children(5);
		System.out.println(children.su);
		Parent parent = children;
		
		parent.method1();
		// 오버라이딩한 메소드를 호출시는 부모에있는게 아니라 오버라이딩된 메소드를 호출한다.
		parent.method2();
		// 자식에 있는것은 사용할 수 없다.
		//parent.method3();
		
		// 클래스 강제타입변환
		// 자식 -> 부모로 자동변환된 클래스를 자식타입으로 변환할 떄사용
		// 부모타입에는 필드 메소드밖에 사용불가
		
		Parent parent2 = new Children(10);
		Children children3 = (Children)parent2;
		children3.method1();
		
		Parent parent3 = new Parent();
		Children children4 = (Children)parent3;
		children4.method2();
		
	}

}
