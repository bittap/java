package question;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeTest_MaraTon {
	
	public static String Solution(String[] participant, String[] completion) {
        String answer = "";
        return answer;
	}
	
	public static boolean nameCheck(String name) {
		Pattern p = Pattern.compile("^([a-z]){1,20}$");
		Matcher m = p.matcher(name);
		
		if(m.find()) {
			return true;
		}else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("참가자를 입력해주세요.");
		System.out.println("종료시에는 quit를 입력해주세요.");
		int count = 1;
		String[] participant = new String[] {};
		while (true) {
			String name = scanner.nextLine();
			if(nameCheck(name)) {
				participant[count-1] = name;
				count++;
				
				if(count == 10000 || name == "quit") {
					break;
				}
				
			}else {
				System.out.println("참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.");
			}
			 
		}

		//String[] participant = name.split(",");
		
		
		String[] completion = new String[participant.length-1];
	}

}
