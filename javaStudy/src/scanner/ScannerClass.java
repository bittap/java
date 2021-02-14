package scanner;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 스캐너는 입력받을 때 사용하며 전부사용하면 enter를 누르면 되고 nextline을 통해 값을 받음
		// System.in.read();의 문자를 합칠 수 없는거를 보완하기 위해 탄생
		
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		System.out.println(text);
		
	}

}
