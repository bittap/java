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
			System.out.printf("남은 회전수:%d\n",maxRotation-accumulatedRotation);
			return true;
		}else {
			System.out.println("펑크");
			return false;
		}
		
	}
}
