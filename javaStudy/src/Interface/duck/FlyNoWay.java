package Interface.duck;

public class FlyNoWay implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("저는 날 수가 없어요");
	}
}
