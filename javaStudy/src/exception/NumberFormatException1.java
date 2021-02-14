package exception;

public class NumberFormatException1 {

	public static void main(String[] args) {
		String str1 = "100";
		String str2 = "a100";
		
		System.out.println(Integer.parseInt(str1));
		System.out.println(Integer.parseInt(str2));
	}

}
