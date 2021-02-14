package Final;


// final  클래스
// 최종적인 클래스라는 의미로 상속불가
public class Final {
	
	// final 필드
	// 한번 선언하면 수정이 불가능
	// 필드 선언시 값을 넣지 않으면 생성자에서 값을 넣어주지 않으면 오류가 발생한다.
	final String nation = "korea";
	final String ssn;
	String name;
	
	public Final() {
		ssn = "930816";
	}
	
	// final 메소드
	public static void main(String[] args) {
		Final finalClass = new Final();
		System.out.println(finalClass.ssn);
	}

}
