package Interface;

public class Television implements RemoteControl {
	
	public Television(String const12) {
		System.out.println("�ڷ����� ��ü�� �����Ǿ����ϴ�."+const12);
	}
	@Override
	public void turnOff() {
		System.out.println("Tv�� ���ϴ�.");
	}
	
	@Override
	public void turnOn() {
		System.out.println("Tv�� ŵ�ϴ�.");
	}
	
	public void tv() {
		System.out.println("�̰Ŵ�  TV���� �ִ� �޼ҵ忩");
	}
}
