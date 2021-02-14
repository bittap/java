package labelBreak;

public class LabelBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// break
		int x = 0;
		for(int i = 0; i<10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println("x="+(++x));
				// 단순 break 사용시 하나의 for문 밖에 종료시킬 수 없다.
				break;
			}
		}
		// 이중for문 이상일 때 종료지점을 선언하는것
		int y = 0;
		outter : for(int i = 0; i<10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println("y="+(++y));
				break outter;
			}
		}
	}

}
