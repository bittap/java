package typeChange;

public class Car {
	
	Tire frontLeftTire = new Tire(6, "앞왼쪽");
	Tire frontRightTire = new Tire(2,"앞오른쪽");
	Tire backLeftTire = new Tire(3,"뒤왼쪽");
	Tire backRightTire = new Tire(4,"뒤오른쪽");
	
	public int run() {
		System.out.println("자동차가 달립니다.");
		
		if(frontLeftTire.roll() == false) {stop(frontLeftTire.location); return 1;}
		if(frontRightTire.roll() == false) {stop(frontRightTire.location); return 2;}
		if(backLeftTire.roll() == false) {stop(backLeftTire.location); return 3;}
		if(backRightTire.roll() == false) {stop(backRightTire.location); return 4;}
		return 0;
			
	}
	
	public void stop(String name) {
		System.out.println(name+"의 원인으로 자동차가 멈춤니다.");
	}
}
