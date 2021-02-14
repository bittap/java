package api;

public class StringCharAtExample {

	public static void main(String[] args) {
		String jumin = "930816-104";
		
		char sex = jumin.charAt(7);
		System.out.println(sex);
		switch (sex) {
		case '1':
			System.out.println("남자입니다.");
			break;
		case '3':
			System.out.println("여자입니다.");
			break;
		default:
			break;
		}
	}

}
