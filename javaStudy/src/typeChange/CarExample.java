package typeChange;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=1; i<=5; i++) {
			int problemLocation = car.run();
			
			switch (problemLocation) {
			case 1:
				System.out.println("�� ���� HanKookTire�� ��ü");
				car.frontLeftTire = new HanKookTire(15, "�� ����");
				break;
			case 2:
				System.out.println("�� ������ HanKookTire�� ��ü");
				car.frontRightTire = new HanKookTire(15, "�� ������");
				break;
			case 3:
				System.out.println("�� ���� KumhoTire�� ��ü");
				car.backLeftTire = new HanKookTire(15, "�� ����");
				break;
			case 4:
				System.out.println("�� ���� KumhoTire�� ��ü");
				car.backRightTire = new HanKookTire(15, "�� ����");
				break;

			default:
				break;
			}
			
			System.out.println("------------------");
		}
	}

}
