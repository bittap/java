package This;

public class This {
	String name = "���¿�";
	int age = 27;
	
	public This(String name, int age) {
		// this�� �Ⱥ��̸� �Ű������� ����Ų��.
		// �ڹٹ��� ������ �׷��� ���� this�� �Ⱥٿ��� ������ �ȳ���.
		// this.���� = �ʵ带 ����Ŵ
		this.name = name;
		this.age = age;
		System.out.printf("name : %s, age : %d",name,age);
	}

}
