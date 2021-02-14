package exception;

public class Throws {

	public static void main(String[] args) {
		Throws throws1 = new Throws();
		throws1.method1();
		
	}
	
	public void method1()  {
		try {
			method2();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void method2() throws Exception {
		Class cl = Class.forName("java.lang.thorws2"); 
	}

}
