package api;

import java.util.HashMap;

public class StudentExample {

	public static void main(String[] args) {
		HashMap<Student, String> hashMap = new HashMap<Student, String>();
		
		hashMap.put(new Student("2"), "95");
		
		String score = hashMap.get(new Student("2"));
		System.out.println("2번 학생의 총점"+score);
	}

}
