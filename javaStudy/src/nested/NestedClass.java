package nested;

public class NestedClass {
	// 인스턴스 맴버 클라스
	// 필드와 메서드는 선언 가능
	// 정적 필드 및 메서드는 선언 불가
	class A {
		int filed_A = 5;
		//static int filed_static_A = 5;
		
		void method_A() {
			System.out.println("method_A호출");
		}
		
		//static void method_static_A() {
			
		//}
	}
	
	// 내부에서 인스턴스 맴버 클래스 호출
	void method_A() {
		A a = new A();
		a.filed_A = 10;
		a.method_A();
	}
	
	// 정적 맴버 클라스
	// 모든 종류의 필드와 메소드 선언 가능
	static class B {
		int filed_B = 5;
		static int filed_static_B = 5;
		
		void method_B() {
			System.out.println("method_B호출");
		}
		
		static void method_static_B() {
			System.out.println("method_static_B 호출");
		}
		
		
	}
	
	void localMethod() {
		// 로컬 클래스 : method가 실행될 때만 실행되는 클래스
		// 접근제한자 및  static을 붙일 수 없다 메소드 내부에서만 사용하므로
		// 로컬 클래스는 스레드를 위해 주로 사용한다.
		// 로컬 클래스의 필드는 자동적으로 FINAL이 붙는다
		class C {
			int filed_C = 100;
			//static int filed_static_C = 10;
			// final이 붙으므로 변경이 불가하다.
			//int filed_C = 10;
			
			void method_C() {
				System.out.println("method_C호출");
			}
			
			//static void method_static_C() {
				
			//}
		}
		//static class D {
			
		//}
		
		// 로컬래스 호출
		C c = new C();
		c.filed_C = 10;
		c.method_C();
	}
	
	public static void main(String[] args) {
		// 외부에서 내부클라스 호출방법
		// A a  = new A();
		// A.B b = A.new B();
		NestedClass nestedClass = new NestedClass();
		NestedClass.A method_A = nestedClass.new A();
		method_A.filed_A = 10;
		method_A.method_A();
		
		// 외부에서 정적 맴버 클래스 호출방법
		NestedClass.B b = new NestedClass.B();
		b.filed_B = 5;
		b.method_B();
		b.method_static_B();
		
		NestedClass c = new NestedClass();
		c.localMethod();
	}
}
