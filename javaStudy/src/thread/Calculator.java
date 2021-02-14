package thread;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return this.memory;
	}
	
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			System.out.println(Thread.currentThread().getName() + ":" +this.memory);
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + ":" +this.memory);
		} catch (InterruptedException e) {
			
		}
	}
}
