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
			
			System.out.println("1.학생수 | 2. 점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			
			System.out.println("------------------------------------------");
			System.out.println("선택> "+selectNo);
			

			
			switch (selectNo) {
			case 1:
				System.out.print("학생수>");
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
				System.out.println("최고 점수:" + max);
				System.out.println("평균 점수:" + avg);
				break;
			case 5:
				run = false;
				System.out.println("프로그램 종료");
				break;
			}
			
			selectNo++;
			
			
			
		}
	}

}
