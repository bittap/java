package thread;

public class PrintThread extends Thread {
	private boolean stopFlag;
	
	public void setStopFlag(boolean stopFlag) {
		this.stopFlag = stopFlag;
	}
	
	@Override
	public void run() {
		
		while (!stopFlag) {
			System.out.println("ȣ�� �մϴ�.");
		}
		
		System.out.println("�ڿ�����");
		System.out.println("��������");
	}
}
