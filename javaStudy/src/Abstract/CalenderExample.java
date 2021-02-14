package Abstract;

public abstract class CalenderExample {

	public int year;
	
	public CalenderExample() {
		
	}
	
	public static CalenderExample getInstance() {
		return new GregoreExample();
	}
	
	public void getDate() {
		System.out.println("추상메소드에서 날짜를 출력합니다.");
	}
}
