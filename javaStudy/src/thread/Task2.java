package thread;

import java.awt.Toolkit;

public class Task2 extends Thread{
	

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			toolkit.beep();
		}
		
	}
	
}
