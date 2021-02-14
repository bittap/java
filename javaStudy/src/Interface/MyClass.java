package Interface;

public class MyClass {

	public MyClass() {
		
	}
	public MyClass(RemoteControl rc) {
		System.out.println("객체 생성전");
		this.rc = rc;
		System.out.println("MyClass 객체가 생성되었습니다.");
	}
	
	RemoteControl rc = null;
	
	public void classChange(RemoteControl rc) {
		this.rc = rc;
	}
	
	
	
	
	public static void main(String[] args) {
		MyClass myClass = new MyClass(new Television("클래스 선언 시"));
		myClass.rc.turnOn();
		myClass.rc.turnOff();
		
		System.out.println("----------------------------");
		
		MyClass myClass2 = new MyClass(new Audio());
		//myClass2.classChange();
		myClass2.rc.turnOn();
		myClass2.rc.turnOff();
	}}
