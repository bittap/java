package exception;

public class TryCatchFinalyExample2{

	public static void main(String[] args) {
		String str1 = "100";
		String str2 = "a100";
		
		try {
			//int value2 = Integer.parseInt(str2);
			System.out.println(Integer.parseInt(str1));
			System.out.println(Integer.parseInt(str2));
		} catch (NumberFormatException e) {
			System.out.println(e);
		}finally {
			
		}
	}

}
