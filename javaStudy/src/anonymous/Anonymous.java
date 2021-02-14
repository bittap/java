package anonymous;

public class Anonymous {
	// 익명 클래스는 해당위치에서 만 실행하므로 이름을 붙이기 귀찮을 때 사용한다.
	// 부모클래스 [필드|변수] = new 부모클래스(매개변수){}
	Parent parent = new Parent() {
		int childField;
		void childMethod() {
			
		}
		@Override
		void parentMethod() {
			super.parentMethod();
		}
	};
	
	// 메소드 내부에서 익명클래스 정의
	void method() {
		Parent parent = new Parent() {
			int childField;
			void childMethod() {
				
			}
			@Override
			void parentMethod() {
				super.parentMethod();
			}
		};
	}
	
	Person filed = new Person() {
		void work() {
			System.out.println("출근합니다.");
		}
		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
			work();
		}
	};
	
	void method1() {
		Person localVar = new Person() {
			void work() {
				System.out.println("산책합니다.");
			}
			@Override
			void wake() {
				System.out.println("7시에 일어납니다.");
				work();
			}
		};
		localVar.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}

	
}
