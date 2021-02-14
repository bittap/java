package typeChange;

public class CalJungSuDataChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 연산식을 실행하면 btye short 타입은 int로 자동변환됨
		byte sum1 = 10;
		short sum2 = 20;
		int sum = sum1+sum2;
		System.out.println("연삭식은 무조건 int:"+sum);
		
		byte result = 10+20;
		System.out.println("피연산자가 byte가 아니면 상관없음:"+result);
		
		// 연산식 실행시 가장큰 변수쪽으로 형으로 바뀜
		byte sum3 = 10;
		int sum4 = 1000;
		long sum5 = 10000;
		
		long sum6 = sum3+sum4+sum5;
		System.out.println(sum6);
	}

}
