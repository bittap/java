package array;

public class AdvancedFor {

	public static void main(String[] args) {
		//���� for��
		int[] intArr = {60,70,80,90,100};
		
		for (int i : intArr) {
			System.out.println(i);
		}
		
		//2�����迭 ���� for��
		int[][] intArr2 = {{1,2,3},{4,5,6}};
		
		for (int[] is : intArr2) {
			for (int is2 : is) {
				System.out.println(is2);
			}
		}
	}

}
