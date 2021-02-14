package typeChange;

public class Tire {
	public int maxRotation;
	public int accumulatedRotation;
	public String location;
	
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	public boolean roll() {
		
		accumulatedRotation++;
		
		if(accumulatedRotation < maxRotation) {
			System.out.printf("���� ȸ����:%d\n",maxRotation-accumulatedRotation);
			return true;
		}else {
			System.out.println("��ũ");
			return false;
		}
		
	}
}
