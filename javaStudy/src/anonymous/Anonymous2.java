package anonymous;

public class Anonymous2 {
	
	RemoteControl field = new RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("Tv�� �մϴ�.");
		}
		
		@Override
		public void turnOff() {
			System.out.println("Tv�� ���ϴ�.");
		}
	}; 
	
	void method1() {
		RemoteControl local = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("���� ŵ�ϴ�.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("���� ���ϴ�.");
			}
		};
		local.turnOn();
	}
	
	void method2(RemoteControl remoteControl) {
		remoteControl.turnOn();
	}
}
