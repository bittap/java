package thread;

public class MovieThread extends Thread {
	
	@Override
	public void run() {
		while (true) {
			System.out.println("�������� ����մϴ�.");
			if(isInterrupted()) {
				break;
			}
		}
	}
}
