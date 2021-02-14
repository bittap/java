package overriding;

import inheritance.Computer;

public class OverRidding extends Computer {
	String kind;
	// 오버라이딩 
	// 오버라이딩 : 상속시 해당 메소드를 자식메소드에서 자기에 맞게 수정하는것
	// 규칙
	// 1 부모의 메소드와 동일한 시그니처(리턴타입, 메소드 이름, 매개 변수 목록)을 가져야함
	// 2 접근제한을 더 강하게 할 수 없다 public -> proteced로
	// 3 새로운예외를 throws할 수 없다.
	public OverRidding(int width, int height, String[] part,String kind) {
		super(width,height,part);
		this.kind = kind;
	}
	
	@Override
	protected void powerOn() {
		if(!kind.equals("컴퓨터")) {
			System.out.printf("%s가 켜졌습니다.",kind);
		}else {
			super.powerOn();
		}
	}
	
	public static void main(String[] args) {
		OverRidding override = new OverRidding(50, 40, new String[] {"메모리"}, "핸드폰");
		override.powerOn();
	}
	
}
