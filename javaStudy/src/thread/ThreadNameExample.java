package thread;

public class ThreadNameExample {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("���� ������ �̸� : "+mainThread.getName() );
		
		Thread thread = new Thread();
		System.out.println("�۾� ������ �̸� : " + thread.getName());
		
		Thread thread2 = new Thread();
		System.out.println("�۾� ������ �̸� : " + thread2.getName());
	}

}
