package thread;

import java.awt.Toolkit;

public class BeepPrintExample3 {

	public static void main(String[] args) {
		Thread thread = new Thread(
				new Runnable() {
					@Override
					public void run() {
						for (int i = 0; i < 5; i++) {
							Toolkit toolkit = Toolkit.getDefaultToolkit();
							toolkit.beep();
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								
								e.printStackTrace();
							}
						}
					}
				}
		);
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("¶ò");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}
