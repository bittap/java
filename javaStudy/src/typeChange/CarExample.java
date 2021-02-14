package typeChange;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=1; i<=5; i++) {
			int problemLocation = car.run();
			
			switch (problemLocation) {
			case 1:
				System.out.println("앞 왼쪽 HanKookTire로 교체");
				car.frontLeftTire = new HanKookTire(15, "앞 왼쪽");
				break;
			case 2:
				System.out.println("앞 오른쪽 HanKookTire로 교체");
				car.frontRightTire = new HanKookTire(15, "앞 오른쪽");
				break;
			case 3:
				System.out.println("뒤 왼쪽 KumhoTire로 교체");
				car.backLeftTire = new HanKookTire(15, "뒤 왼쪽");
				break;
			case 4:
				System.out.println("뒤 왼쪽 KumhoTire로 교체");
				car.backRightTire = new HanKookTire(15, "뒤 왼쪽");
				break;

			default:
				break;
			}
			
			System.out.println("------------------");
		}
	}

}
