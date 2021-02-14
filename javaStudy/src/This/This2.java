package This;

public class This2 {
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	public This2() {
		
	}
	
	public This2(String model) {
		// 다른 생성자 호출
		this(model,"은색",250);
	}
	
	public This2(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	

}
