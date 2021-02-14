package array;

public class ArrayCopy {

	public static void main(String[] args) {
		// 배열 복사
		
		int[] oldIntArray = {70,60,50};
		
		int[] newIntArray = new int[3];
		
		System.arraycopy(oldIntArray, 0, newIntArray, 0, oldIntArray.length);
		
		for (int i = 0; i < newIntArray.length; i++) {
			System.out.println(newIntArray[i]);
		}
		
	
		
	}

}
