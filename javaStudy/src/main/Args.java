package main;

public class Args {

	public static void main(String[] args) {
		// args�� main�޼ҵ� ����� �Էµ� �����͸� �޴´�.
		// args �־ �����ϴ� ��� Package Explorer���� �ش� Ŭ�������� �����ʸ��콺 -> run as -> run configuation
		// Argumnets�ǿ��� ���� ���� �� apply
		if(args.length <= 2) {
			System.out.println("���� ���� �����մϴ�.");
		}
		
		int sum = 0;
		
		for (int i = 0; i < args.length; i++) {
			sum += Integer.parseInt(args[i]);
		}
		System.out.println(sum);
	}

}
