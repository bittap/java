package question;

public class CosQuestion1 {

	public static void main(String[] args) {
		System.out.println(solution(12));
	}
	
	public static int solution(int num) {
		num = num+1;
		String sNum = String.valueOf(num);
		char[] charNumArr = sNum.toCharArray();
		String outNum = "";
		
		for (int i = 0; i < charNumArr.length; i++) {
			if(charNumArr[i] == '0') {
				charNumArr[i] = '1';
			}
			outNum = outNum+charNumArr[i];
		}
		
		return Integer.parseInt(outNum);
	}

}
