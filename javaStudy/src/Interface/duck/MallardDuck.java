package Interface.duck;

public class MallardDuck extends Duck {

	public MallardDuck() {
		flyBehavior = new FlyWithWing();
		quackBehavior = new Quack();
	}
	
	@Override
	public void swimming() {
		System.out.println("저는 물오리 입니다.");
	}
}
