package test;

class A {
	String aField = "class A";
	
	void methodA() {
		System.out.println(aField);
	}
}

class B extends A {
	String bField = "class B";
	
	void methodB() {
		System.out.println(bField);
	}
}

public class Test2 {

	public static void main(String[] args) {
		A a = new B();
	}

}
