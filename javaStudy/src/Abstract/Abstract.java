package Abstract;

public abstract class Abstract {
	// 추상메소드는 개발시 설계자가 만드는 설계도와 같다.
	// 무조건 상속을 받아서 사용한다. new 연산자로 접근 불가
	public String owner;
	
	public Abstract(String owner) {
		this.owner=owner;
	}
	
	public void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	// 각 기기마다 turnoff방법은 다르다 따라서 무조건 자식클래스에서 재정의하게 만들기위해 다음과같이 정의한다.
	// [public / protected] abstarct 리턴타입 메소드이름(매개변수);
	protected abstract void turnOff();
}
