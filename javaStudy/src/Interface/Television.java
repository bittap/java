package Interface;

public class Television implements RemoteControl {
	
	public Television(String const12) {
		System.out.println("텔레비전 객체가 생성되었습니다."+const12);
	}
	@Override
	public void turnOff() {
		System.out.println("Tv을 끕니다.");
	}
	
	@Override
	public void turnOn() {
		System.out.println("Tv를 킵니다.");
	}
	
	public void tv() {
		System.out.println("이거는  TV에만 있는 메소드여");
	}
}
