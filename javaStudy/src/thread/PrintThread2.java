package thread;

public class PrintThread2 extends Thread {
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("���� ��");
				Thread.sleep(1);
			}
		}catch (InterruptedException e) {
			System.out.println("�ͼ��ǹ߻�");
		}
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	}

}
