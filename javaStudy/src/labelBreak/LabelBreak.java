package labelBreak;

public class LabelBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// break
		int x = 0;
		for(int i = 0; i<10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println("x="+(++x));
				// �ܼ� break ���� �ϳ��� for�� �ۿ� �����ų �� ����.
				break;
			}
		}
		// ����for�� �̻��� �� ���������� �����ϴ°�
		int y = 0;
		outter : for(int i = 0; i<10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println("y="+(++y));
				break outter;
			}
		}
	}

}
