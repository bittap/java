package inheritance;

public class Computer {
	// �ʵ� = (����, ���� , ��ǰ)
	private int width;
	private int height;
	private String[] part;
	
	// ������
	protected Computer(int width,int height, String[] part) {
		this.width = width;
		this.height = height;
		this.part = part;
	}
	
	// �޼ҵ� = ������ϱ�, ����Ű�¹��, ��ǰ�� �����Ǹ� ����
	protected int sizeCalculator(int width, int heigth) {
		return width*height;
	}
	
	protected void powerOn() {
		System.out.println("��ǻ�Ͱ� �������ϴ�.");
	}
	
	protected void move() {
		for (String part : part) {
			switch (part) {
			case "�޸�":
				break;
			case "Ű����":
				break;

			default:
				break;
			}
		}
	}
	
	
	
	
	
}
