package api;

public class StringIndexOfExample {

	public static void main(String[] args) {
		String str = "자바 프로그래밍";
		
		int which = str.indexOf("프로그래밍");
		System.out.println(which);
		
		if(which == -1) {
			System.out.println("Java本ではないですね");
		}else {
			System.out.println("자바 책이군요");
		}
		
	}

}
