package Interface;

public class Audio implements RemoteControl {
	
	public Audio() {
		System.out.println("Audio객체가 생성되었습니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}
	@Override
	public void turnOn() {
		System.out.println("Audio를 킵니다.");
	}

}
