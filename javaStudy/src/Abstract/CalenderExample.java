package Abstract;

public abstract class CalenderExample {

	public int year;
	
	public CalenderExample() {
		
	}
	
	public static CalenderExample getInstance() {
		return new GregoreExample();
	}
	
	public void getDate() {
		System.out.println("�߻�޼ҵ忡�� ��¥�� ����մϴ�.");
	}
}
