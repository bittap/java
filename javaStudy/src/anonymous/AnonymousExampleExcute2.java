package anonymous;

public class AnonymousExampleExcute2 {
	Vehicle vehicle;
	
	Vehicle field = new Vehicle() {
		
		@Override
		public void run() {
			System.out.println("�����Ű� �޸��ϴ�.");
		}
	};
	
	void method1(){
		Vehicle filed2 = new Vehicle() {
			
			@Override
			public void run() {
				System.out.println("�¿����� �޸��ϴ�.");
			}
		};
		
		filed2.run();
	}
	
	void method2(Vehicle vehicle) {
		vehicle.run();
	}
}
