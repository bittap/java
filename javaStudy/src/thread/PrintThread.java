package thread;

public class PrintThread extends Thread {
	private boolean stopFlag;
	
	public void setStopFlag(boolean stopFlag) {
		this.stopFlag = stopFlag;
	}
	
	@Override
	public void run() {
		
		while (!stopFlag) {
			System.out.println("호출 합니다.");
		}
		
		System.out.println("자원정리");
		System.out.println("실행종료");
	}
}
