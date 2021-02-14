package array;

public class ParameterArray {

	public static void main(String[] args) {
		int[] values = new int[] {90,70,80};
		ParameterArray parameterArray = new ParameterArray();
		parameterArray.sum1(values);
		parameterArray.sum2(90,70,80);
	}
	
	int sum1(int[] values) {
		int sum = 0;
		for (int i : values) {
			sum += i;
		}
		System.out.println(sum);
		return sum;
	}
	// �Ű������� �迭 ������� �޴¹��
	int sum2(int ... values) {
		int sum = 0;
		for (int i : values) {
			sum += i;
		}
		System.out.println(sum);
		return sum;
	}

}
