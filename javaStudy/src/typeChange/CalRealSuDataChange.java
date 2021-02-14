package typeChange;

public class CalRealSuDataChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 실수~~~~~~~~~~~
		// 타입이 같으면 상관없음
		float flo1 = 1000.5f;
		float flo2 = 1000.3f;
		float flo3 = flo1+flo2;
		System.out.println(flo3);
		
		// 타입이 다를경우 큰거에 맞춰야함
		float flo4 = 1000.5f;
		double doubleValue = 1000.3;
		double doubleValue2 = flo4+doubleValue;
		System.out.println(doubleValue2);
	}

}
