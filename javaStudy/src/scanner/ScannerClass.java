package scanner;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ��ĳ�ʴ� �Է¹��� �� ����ϸ� ���λ���ϸ� enter�� ������ �ǰ� nextline�� ���� ���� ����
		// System.in.read();�� ���ڸ� ��ĥ �� ���°Ÿ� �����ϱ� ���� ź��
		
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		System.out.println(text);
		
	}

}
