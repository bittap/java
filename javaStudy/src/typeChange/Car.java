package typeChange;

public class Car {
	
	Tire frontLeftTire = new Tire(6, "�տ���");
	Tire frontRightTire = new Tire(2,"�տ�����");
	Tire backLeftTire = new Tire(3,"�ڿ���");
	Tire backRightTire = new Tire(4,"�ڿ�����");
	
	public int run() {
		System.out.println("�ڵ����� �޸��ϴ�.");
		
		if(frontLeftTire.roll() == false) {stop(frontLeftTire.location); return 1;}
		if(frontRightTire.roll() == false) {stop(frontRightTire.location); return 2;}
		if(backLeftTire.roll() == false) {stop(backLeftTire.location); return 3;}
		if(backRightTire.roll() == false) {stop(backRightTire.location); return 4;}
		return 0;
			
	}
	
	public void stop(String name) {
		System.out.println(name+"�� �������� �ڵ����� ����ϴ�.");
	}
}
