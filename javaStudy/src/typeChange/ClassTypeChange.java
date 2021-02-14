package typeChange;

class A{};

class B extends A{};

class C extends A{};

class D extends B{};

class E extends C{};

class Parent{
	public Parent() {
		System.out.println("�� ������");
	}
	public void method1() {
		System.out.println("method1ȣ��");
	}
	public void method2() {
		System.out.println("method2ȣ��");
	}
}

class Children extends Parent{
	int su = 5;
	
	public Children(int su) {
		this.su = su;
		System.out.println("�� �ڽ��̾�");
	}
	
	@Override
	public void method2() {
		System.out.println("method2�� �������̵��ѳ� ȣ��");
	}
	
	public void method3() {
		System.out.println("method3ȣ��");
	}
}

public class ClassTypeChange {

	public static void main(String[] args) {
		// Ŭ���� Ÿ�Ժ�ȯ
		// �ڵ���ȯ
		// �θ�Ÿ�Ժ��� = �ڽ�Ÿ��
		
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
		// �������̵��� �޼ҵ带 ȣ��ô� �θ��ִ°� �ƴ϶� �������̵��� �޼ҵ带 ȣ���Ѵ�.
		parent.method2();
		// �ڽĿ� �ִ°��� ����� �� ����.
		//parent.method3();
		
		// Ŭ���� ����Ÿ�Ժ�ȯ
		// �ڽ� -> �θ�� �ڵ���ȯ�� Ŭ������ �ڽ�Ÿ������ ��ȯ�� �����
		// �θ�Ÿ�Կ��� �ʵ� �޼ҵ�ۿ� ���Ұ�
		
		Parent parent2 = new Children(10);
		Children children3 = (Children)parent2;
		children3.method1();
		
		Parent parent3 = new Parent();
		Children children4 = (Children)parent3;
		children4.method2();
		
	}

}
