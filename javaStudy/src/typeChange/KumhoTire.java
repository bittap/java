package typeChange;

public class KumhoTire extends Tire {

	public KumhoTire(int maxRotation,String location) {
		super(maxRotation,location);
	}
	
	@Override
	public boolean roll() {
		accumulatedRotation++;
		
		if(accumulatedRotation < maxRotation) {
			System.out.printf("KumhoTire 남은 회전수:%d\n",maxRotation-accumulatedRotation);
			return true;
		}else {
			System.out.println("KumhoTire 펑크");
			return false;
		}
	}
}
