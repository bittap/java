package Abstract;

public class InvokeAbstract {

	public static void main(String[] args) {
		
		// 추상메소드 호출 첫번째 방법
		AbstractSon abstractSon = new AbstractSon("김태영");
		
		abstractSon.turnOn();
		abstractSon.internetSearch();
		abstractSon.turnOff();
		
		// 추상메소드 호출 두번째 방법
		Abstract abstract1 = null;
		abstract1 = new AbstractSon("김태영");
		abstract1.turnOn();
		abstract1.turnOff();
		
		// 추상메소드 호출 세번째 방법
		turnOff(new AbstractSon("김태영"));
	}
	
	public static void turnOff(Abstract abstract1) {
		abstract1.turnOff();
	}

}
