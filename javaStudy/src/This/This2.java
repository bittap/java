package This;

public class This2 {
	String company = "�����ڵ���";
	String model;
	String color;
	int maxSpeed;
	
	public This2() {
		
	}
	
	public This2(String model) {
		// �ٸ� ������ ȣ��
		this(model,"����",250);
	}
	
	public This2(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	

}
