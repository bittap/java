package anonymous;

public class AnonymousExampleExcute {
	
	Worker worker = new Worker() {
		void start() {
			System.out.println("디자인을 합니다.");
		}
	};
	
	
	void method1(){
		Worker worker2 = new Worker() {
			void start() {
				System.out.println("개발을 합니다.");
			}
		};
		
		worker2.start();
	}
	
	void method2(Worker worker3) {
		worker3.start();
	}
}
