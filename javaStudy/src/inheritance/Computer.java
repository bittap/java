package inheritance;

public class Computer {
	// 필드 = (가로, 세로 , 부품)
	private int width;
	private int height;
	private String[] part;
	
	// 생성자
	protected Computer(int width,int height, String[] part) {
		this.width = width;
		this.height = height;
		this.part = part;
	}
	
	// 메소드 = 사이즈구하기, 전원키는방식, 부품이 만족되면 동작
	protected int sizeCalculator(int width, int heigth) {
		return width*height;
	}
	
	protected void powerOn() {
		System.out.println("컴퓨터가 켜졌습니다.");
	}
	
	protected void move() {
		for (String part : part) {
			switch (part) {
			case "메모리":
				break;
			case "키보드":
				break;

			default:
				break;
			}
		}
	}
	
	
	
	
	
}
