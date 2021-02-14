package typeChange;

public class HanKookTire extends Tire {
	
	public HanKookTire(int maxRotation,String location) {
		super(maxRotation,location);
	}
	
	@Override
	public boolean roll() {
		accumulatedRotation++;
		
		if(accumulatedRotation < maxRotation) {
			System.out.printf("HanKookTire ���� ȸ����:%d\n",maxRotation-accumulatedRotation);
			return true;
		}else {
			System.out.println("HanKookTire ��ũ");
			return false;
		}
	}
	
	
}
