package thread;

public class BeepPrintExample2 {

	public static void main(String[] args) {
		
		Runnable task = new Task();
		Thread thread = new Thread(task);
		thread.start();
		
		for (int i = 0; i < 5; i++) {	
			System.out.println("¶ò");
			try {
				thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("interrupt È£Ãâ");
			}
		}
	}

}
