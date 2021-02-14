package nested;

public class NestedClass {
	// �ν��Ͻ� �ɹ� Ŭ��
	// �ʵ�� �޼���� ���� ����
	// ���� �ʵ� �� �޼���� ���� �Ұ�
	class A {
		int filed_A = 5;
		//static int filed_static_A = 5;
		
		void method_A() {
			System.out.println("method_Aȣ��");
		}
		
		//static void method_static_A() {
			
		//}
	}
	
	// ���ο��� �ν��Ͻ� �ɹ� Ŭ���� ȣ��
	void method_A() {
		A a = new A();
		a.filed_A = 10;
		a.method_A();
	}
	
	// ���� �ɹ� Ŭ��
	// ��� ������ �ʵ�� �޼ҵ� ���� ����
	static class B {
		int filed_B = 5;
		static int filed_static_B = 5;
		
		void method_B() {
			System.out.println("method_Bȣ��");
		}
		
		static void method_static_B() {
			System.out.println("method_static_B ȣ��");
		}
		
		
	}
	
	void localMethod() {
		// ���� Ŭ���� : method�� ����� ���� ����Ǵ� Ŭ����
		// ���������� ��  static�� ���� �� ���� �޼ҵ� ���ο����� ����ϹǷ�
		// ���� Ŭ������ �����带 ���� �ַ� ����Ѵ�.
		// ���� Ŭ������ �ʵ�� �ڵ������� FINAL�� �ٴ´�
		class C {
			int filed_C = 100;
			//static int filed_static_C = 10;
			// final�� �����Ƿ� ������ �Ұ��ϴ�.
			//int filed_C = 10;
			
			void method_C() {
				System.out.println("method_Cȣ��");
			}
			
			//static void method_static_C() {
				
			//}
		}
		//static class D {
			
		//}
		
		// ���÷��� ȣ��
		C c = new C();
		c.filed_C = 10;
		c.method_C();
	}
	
	public static void main(String[] args) {
		// �ܺο��� ����Ŭ�� ȣ����
		// A a  = new A();
		// A.B b = A.new B();
		NestedClass nestedClass = new NestedClass();
		NestedClass.A method_A = nestedClass.new A();
		method_A.filed_A = 10;
		method_A.method_A();
		
		// �ܺο��� ���� �ɹ� Ŭ���� ȣ����
		NestedClass.B b = new NestedClass.B();
		b.filed_B = 5;
		b.method_B();
		b.method_static_B();
		
		NestedClass c = new NestedClass();
		c.localMethod();
	}
}
