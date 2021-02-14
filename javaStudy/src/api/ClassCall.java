package api;

public class ClassCall {

	public static void main(String[] args) {
		// 클래스 호출 방법
		// 1
		Class class1 = java.lang.String.class;
		System.out.println(class1.toString());
		
		// 2
		try {
			Class class2 = Class.forName("java.lang.String");
			System.out.println(class2.toString());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		// 3
		String str = "김자바";
		Class class3 = str.getClass();
		System.out.println(class3.toString());
		
		
		
	}

}
