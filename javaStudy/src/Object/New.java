package Object;

public class New {

	public static void main(String[] args) {
		
		// new 연사자 = 객체 생성 연산자
		String str1 = new String("김태영");
		String str2 = new String("김태영");
		
		if(str1 != str2) {
			System.out.println("같은 힙영역을 사용하는것이 아니므로 false");
		}
	}

}
