package anonymous;

public class InvokeAnonymous {

	public static void main(String[] args) {
		Anonymous anonymous = new Anonymous();
		// 익명객체의 필드 사용
		anonymous.filed.wake();
		// 익명객체의 로컬 변수 사용
		anonymous.method1();
		// 익명객체의 매개값 사용
		anonymous.method2(
			new Person() {
				void study() {
					System.out.println("공부합니다.");
				}	
				@Override
				void wake() {
					System.out.println("8시에 일어납니다.");
					study();
				}
			}
		);
	}

}
