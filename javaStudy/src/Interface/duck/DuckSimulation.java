package Interface.duck;

public class DuckSimulation {

	public static void main(String[] args) {
		MallardDuck md = new MallardDuck(); // 다형성을 누릴 수 없다.
		md.performFly();
		md.performQuack();
		md.swimming();
		
		Duck myDuck = new MallardDuck();
		myDuck.performFly();
		myDuck.performQuack();
		myDuck.swimming();
	}

}
