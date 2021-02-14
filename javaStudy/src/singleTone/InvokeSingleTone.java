package singleTone;

public class InvokeSingleTone {

	public static void main(String[] args) {
		/* 오류
		SingleTone singleTone = new SingleTone();
		*/
		
		SingleTone singleTone1 = SingleTone.getInstance();
		SingleTone singleTone2 = SingleTone.getInstance();
		
		if(singleTone1 == singleTone2) {
			System.out.println("객체의 메모리위치가 같음");
		}
	}

}
