package thread;

public class ThreadNameExample {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("메인 스레드 이름 : "+mainThread.getName() );
		
		Thread thread = new Thread();
		System.out.println("작업 스레드 이름 : " + thread.getName());
		
		Thread thread2 = new Thread();
		System.out.println("작업 스레드 이름 : " + thread2.getName());
	}

}
