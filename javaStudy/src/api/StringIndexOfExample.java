package api;

public class StringIndexOfExample {

	public static void main(String[] args) {
		String str = "�ڹ� ���α׷���";
		
		int which = str.indexOf("���α׷���");
		System.out.println(which);
		
		if(which == -1) {
			System.out.println("Java��ǪϪʪ��Ǫ���");
		}else {
			System.out.println("�ڹ� å�̱���");
		}
		
	}

}
