package anonymous;

public class AnonymousExampleExcute {
	
	Worker worker = new Worker() {
		void start() {
			System.out.println("�������� �մϴ�.");
		}
	};
	
	
	void method1(){
		Worker worker2 = new Worker() {
			void start() {
				System.out.println("������ �մϴ�.");
			}
		};
		
		worker2.start();
	}
	
	void method2(Worker worker3) {
		worker3.start();
	}
}
