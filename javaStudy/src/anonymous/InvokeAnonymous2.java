package anonymous;

public class InvokeAnonymous2 {

	public static void main(String[] args) {
		Anonymous2 anonymous2 = new Anonymous2();
		
		anonymous2.field.turnOn();
		
		anonymous2.method1();
		
		anonymous2.method2(
				new RemoteControl() {
					
					@Override
					public void turnOn() {
						System.out.println("SmartTv를 킵니다.");
					}
					
					@Override
					public void turnOff() {
						System.out.println("SmartTv를 끕니다.");
					}
				}
		);
		
		Button button = new Button();
		button.setOnclickListener(new Button.OnclickListener() {
			
			@Override
			public void setOnclike() {
				System.out.println("만집니다.");
			}
		});
		
		Window window = new Window();
	}

}
