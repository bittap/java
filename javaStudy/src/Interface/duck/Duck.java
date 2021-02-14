package Interface.duck;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public Duck() {
		System.out.println("Duck 생성자 호출");
	}
	// public ___ void display();
	
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
	
	public void swimming() {
		System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도");
	}
	
	
}
