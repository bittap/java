package exception;

public class TryCatchFinalyExample {

	public static void main(String[] args) {
		
		try {
			Class class1 = Class.forName("java.lang.string2");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}

}
