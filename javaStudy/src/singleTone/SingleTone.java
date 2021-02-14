package singleTone;

public class SingleTone {
	// 싱글톤
	// 전체 프로그램에서 단 하나의 객체만 만들도록 보장하는것 => new 연산자로 호출 못하게 막아야 한다.
	// 사용이유 : 메모리 절약
	
	// 정적 필드
	private static SingleTone singleTone = new SingleTone();
	
	// 생성자 막기
	private SingleTone() {
		System.out.println("싱글톤 객체가 생성되었습니다.");
	}
	
	static SingleTone getInstance() {
		//singleTone = new SingleTone();
		return singleTone;
	}
}
