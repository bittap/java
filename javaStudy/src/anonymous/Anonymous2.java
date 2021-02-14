package anonymous;

public class Anonymous2 {
	
	RemoteControl field = new RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("Tv¸¦ ÄÕ´Ï´Ù.");
		}
		
		@Override
		public void turnOff() {
			System.out.println("Tv¸¦ ²ü´Ï´Ù.");
		}
	}; 
	
	void method1() {
		RemoteControl local = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("¿Àµð¸¦ Åµ´Ï´Ù.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("¿Àµð¸¦ ²ü´Ï´Ù.");
			}
		};
		local.turnOn();
	}
	
	void method2(RemoteControl remoteControl) {
		remoteControl.turnOn();
	}
}
