package Interface;

public interface Interface {
	// 인터페이스 객체를 생성할 수 없기 떄문에 생성자를 가질 수 없다.
	
	// 필드
	// 인터페이스는 데이터를 저장할 수 없지만 상수필드는 가능하다
	// 그러므로 타입 상수이름 = 값을 할시 
	// [public static final]이 자동적으로 붙는다.
	
	int su = 10; // == public static final in su = 10;
	
	// 메소드
	// 인터페이스에서 메소드 선언시에는 public abstract가 자동적으로 붙는다
	// 최종적으로 객체에서 실행되기 떄문에 실행부를 작성하지 않는다.
	
	void interfaceMethod(); // = public abstract void interfaceMethod();
}
