package api;

public class SystemTimeExample {

	public static void main(String[] args) {
		long time1 = System.nanoTime();
		
		for (int i = 0; i < 100000; i++) {
			
		}
		
		long time2 = System.nanoTime();
		
		System.out.printf("%d�� �ҿ�Ǿ����ϴ�.",time2-time1);
	}

}
