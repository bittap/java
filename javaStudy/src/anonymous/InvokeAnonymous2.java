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
						System.out.println("SmartTv�� ŵ�ϴ�.");
					}
					
					@Override
					public void turnOff() {
						System.out.println("SmartTv�� ���ϴ�.");
					}
				}
		);
		
		Button button = new Button();
		button.setOnclickListener(new Button.OnclickListener() {
			
			@Override
			public void setOnclike() {
				System.out.println("�����ϴ�.");
			}
		});
		
		Window window = new Window();
	}

}
