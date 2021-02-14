package Interface.duck;

public class DuckSimulation {

	public static void main(String[] args) {
		MallardDuck md = new MallardDuck(); // �������� ���� �� ����.
		md.performFly();
		md.performQuack();
		md.swimming();
		
		Duck myDuck = new MallardDuck();
		myDuck.performFly();
		myDuck.performQuack();
		myDuck.swimming();
	}

}
