package array;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		// 2차원배열 선언
		// 첫번째 방법
		int[][] mathScores = new int[2][3];
		
		
		for (int i = 0; i < mathScores.length; i++) {
			for (int j = 0; j < mathScores[i].length; j++) {
				System.out.printf("mathScores[%d][%d]=%d\n",i,j,mathScores[i][j]);
			}
		}
		
		System.out.println("--------------------");
		
		// 두번째 방법
		
		int[][] englishScores = new int[2][];
		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		
		for (int i = 0; i < englishScores.length; i++) {
			for (int j = 0; j < englishScores[i].length; j++) {
				System.out.printf("englishScores[%d][%d]=%d\n",i,j,englishScores[i][j]);
			}
		}
		
		System.out.println("--------------------");
		
		// 세번째 방법
		
		int[][] javaScores = {{95,80},{92,96,80}};
		
		for (int i = 0; i < javaScores.length; i++) {
			for (int j = 0; j < javaScores[i].length; j++) {
				System.out.printf("javaScores[%d][%d]=%d\n",i,j,javaScores[i][j]);
			}
		}
		
		
		
	}

}
