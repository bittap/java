package singleTone;

public class InvokeSingleTone {

	public static void main(String[] args) {
		/* ����
		SingleTone singleTone = new SingleTone();
		*/
		
		SingleTone singleTone1 = SingleTone.getInstance();
		SingleTone singleTone2 = SingleTone.getInstance();
		
		if(singleTone1 == singleTone2) {
			System.out.println("��ü�� �޸���ġ�� ����");
		}
	}

}
