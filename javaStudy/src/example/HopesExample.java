package example;

import java.util.Scanner;

public class HopesExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		
		Company company = Company.valueOf(name);
		
		Hopes hopes = new Hopes(name, company.getCid(), company.getDepart(), company.getPosition());
		
		System.out.printf("귀하의 이름은 %s, 사원번호는 %d, 부서는 %s, 직급은 %s입니다.\n",hopes.name,hopes.cid,hopes.depart,hopes.position);
	}

}
