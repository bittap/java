package Interface;

public class Audio implements RemoteControl {
	
	public Audio() {
		System.out.println("Audio��ü�� �����Ǿ����ϴ�.");
	}
	@Override
	public void turnOff() {
		System.out.println("Audio�� ���ϴ�.");
	}
	@Override
	public void turnOn() {
		System.out.println("Audio�� ŵ�ϴ�.");
	}

}
