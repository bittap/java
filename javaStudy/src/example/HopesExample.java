package example;

import java.util.Scanner;

public class HopesExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		
		Company company = Company.valueOf(name);
		
		Hopes hopes = new Hopes(name, company.getCid(), company.getDepart(), company.getPosition());
		
		System.out.printf("������ �̸��� %s, �����ȣ�� %d, �μ��� %s, ������ %s�Դϴ�.\n",hopes.name,hopes.cid,hopes.depart,hopes.position);
	}

}
