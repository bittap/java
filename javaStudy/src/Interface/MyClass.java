package Interface;

public class MyClass {

	public MyClass() {
		
	}
	public MyClass(RemoteControl rc) {
		System.out.println("��ü ������");
		this.rc = rc;
		System.out.println("MyClass ��ü�� �����Ǿ����ϴ�.");
	}
	
	RemoteControl rc = null;
	
	public void classChange(RemoteControl rc) {
		this.rc = rc;
	}
	
	
	
	
	public static void main(String[] args) {
		MyClass myClass = new MyClass(new Television("Ŭ���� ���� ��"));
		myClass.rc.turnOn();
		myClass.rc.turnOff();
		
		System.out.println("----------------------------");
		
		MyClass myClass2 = new MyClass(new Audio());
		//myClass2.classChange();
		myClass2.rc.turnOn();
		myClass2.rc.turnOff();
	}}
