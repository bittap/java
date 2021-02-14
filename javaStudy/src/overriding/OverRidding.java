package overriding;

import inheritance.Computer;

public class OverRidding extends Computer {
	String kind;
	// �������̵� 
	// �������̵� : ��ӽ� �ش� �޼ҵ带 �ڽĸ޼ҵ忡�� �ڱ⿡ �°� �����ϴ°�
	// ��Ģ
	// 1 �θ��� �޼ҵ�� ������ �ñ״�ó(����Ÿ��, �޼ҵ� �̸�, �Ű� ���� ���)�� ��������
	// 2 ���������� �� ���ϰ� �� �� ���� public -> proteced��
	// 3 ���ο�ܸ� throws�� �� ����.
	public OverRidding(int width, int height, String[] part,String kind) {
		super(width,height,part);
		this.kind = kind;
	}
	
	@Override
	protected void powerOn() {
		if(!kind.equals("��ǻ��")) {
			System.out.printf("%s�� �������ϴ�.",kind);
		}else {
			super.powerOn();
		}
	}
	
	public static void main(String[] args) {
		OverRidding override = new OverRidding(50, 40, new String[] {"�޸�"}, "�ڵ���");
		override.powerOn();
	}
	
}
