package Interface.duck;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public Duck() {
		System.out.println("Duck ������ ȣ��");
	}
	// public ___ void display();
	
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
	
	public void swimming() {
		System.out.println("��� ������ ���� ��ϴ�. ��¥ ������");
	}
	
	
}
