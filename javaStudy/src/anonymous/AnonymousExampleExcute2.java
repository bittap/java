package anonymous;

public class AnonymousExampleExcute2 {
	Vehicle vehicle;
	
	Vehicle field = new Vehicle() {
		
		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");
		}
	};
	
	void method1(){
		Vehicle filed2 = new Vehicle() {
			
			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		};
		
		filed2.run();
	}
	
	void method2(Vehicle vehicle) {
		vehicle.run();
	}
}
