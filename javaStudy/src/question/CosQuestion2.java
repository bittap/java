package question;

public class CosQuestion2 {

	public static void main(String[] args) {
		solution(2);
	}
	
	public static int solution(int n) {
		if(n < 1 || n > 100) {
			throw new IllegalArgumentException("������ ������ 1���� 100���� �Դϴ�.");
		}else {
			int sum = 0;
			int startNumber = 1;
			int[][] swirlArr = new int[n][n];
			boolean whFlag = true; // ���� ���� �÷��� -> T = "����", F = "����";
			int i = 1,j = 1;
			
			
			if(i != n) {
				for (j = 1; j <= swirlArr.length; i++) {
					swirlArr[i][j] = startNumber;
					System.out.print(startNumber);
					startNumber++;
					if(j == n) {
						i++;
					}
				}
			}else {
				for (i; i <= swirlArr.length; i++) {
					swirlArr[i][j] = startNumber;
					System.out.print(startNumber);
					startNumber++;
					if(j == n) {
						i++;
					}
				}
			}
			

			
			for (j = 1; j <= swirlArr.length; i++) {
				swirlArr[i][j] = startNumber;
				System.out.print(startNumber);
				startNumber++;
			}
			
			for (int z = 0; z <= (n*2)+1; z++) {
				if(z == 0) {
					for (j = 1; j <= swirlArr.length; i++) {
						swirlArr[i][j] = startNumber;
						System.out.print(startNumber);
						startNumber++;
					}
				}else {
					
				}

				if(z == 1) {
					n��
				}
				if(z == 2 || z == 3) {
					n-1
				}
				if(z == 4 || z == 5) {
					n-2
				}
				if(whFlag == true) { // ����
					whFlag = false;
				}else { // ����
					whFlag = true;
				}


			}
			return sum;
		}
	}

}
