package thread;

public class User1 extends Thread {
	private Calculator calCulator;
	
	public void setCalCulator(Calculator calCulator) {
		this.setName("User1");
		this.calCulator = calCulator;
	}
	
	@Override
	public void run() {
		calCulator.setMemory(100);
	}
}
