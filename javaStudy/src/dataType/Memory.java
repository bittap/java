package dataType;

public class Memory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 메모리영역에는
		// 메소드 영역, 힙 영역, JVM스택 영역이 있다.
		
		// 메소드 영역 : JVM이 시작할 때 생성되고 모든 스레드가 공유하는 영역
		// 메소드 영역에는 코드에서 사용되는 클래스들을 클래스 로더로 읽어 클래스별로 정적 필드와 상수, 메소드 코드, 생성자코드 등을 분류해서 저장
		
		// 힙 영역 : 객체와 배열이 생성되는 영역
		
		
		// JVM스택 영역 : 메소드를 호출할 때마다 프레임을 추가하고 메소드가 종료되면 해당 프레임을 제거하는 동작을 수행
		char v1 = 'A'; // 스택영역에 v1 생성
		
		// if문 종료시 해당 영역 삭제
		if (v1 == 'A') {
			int v2 = 100;
			double v3 = 3.14;
		}
		
		
	}

}
