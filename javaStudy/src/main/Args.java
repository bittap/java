package main;

public class Args {

	public static void main(String[] args) {
		// args는 main메소드 실행시 입력된 데이터를 받는다.
		// args 넣어서 실행하는 방법 Package Explorer에서 해당 클래스에서 오른쪽마우스 -> run as -> run configuation
		// Argumnets탭에서 값을 넣은 후 apply
		if(args.length <= 2) {
			System.out.println("값의 수가 부족합니다.");
		}
		
		int sum = 0;
		
		for (int i = 0; i < args.length; i++) {
			sum += Integer.parseInt(args[i]);
		}
		System.out.println(sum);
	}

}
