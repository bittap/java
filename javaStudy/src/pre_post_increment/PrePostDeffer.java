package pre_post_increment;

import java.util.Scanner;

public class PrePostDeffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		int selectNo = 1;
		Scanner scanner = new Scanner(System.in);
		
		while (run) {
			System.out.println("------------------------------------------");
			
			System.out.println("1.�л��� | 2. �����Է� | 3.��������Ʈ | 4.�м� | 5.����");
			
			System.out.println("------------------------------------------");
			System.out.println("����> "+selectNo);
			

			
			switch (selectNo) {
			case 1:
				System.out.print("�л���>");
				studentNum = Integer.parseInt(scanner.nextLine());
				break;
			case 2:
				scores = new int[studentNum];
				for (int i = 0; i < studentNum; i++) {
					System.out.print("scores[i]>");
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
				break;
			case 3:
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores["+i+"]>"+ scores[i]);
				}
				break;
			case 4:
				int max = 0;
				int sum = 0;
				double avg = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i]; 
					if(max < scores[i]) max = scores[i];
				}
				avg = (double)sum/scores.length;
				System.out.println("�ְ� ����:" + max);
				System.out.println("��� ����:" + avg);
				break;
			case 5:
				run = false;
				System.out.println("���α׷� ����");
				break;
			}
			
			selectNo++;
			
			
			
		}
	}

}
