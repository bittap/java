package system;

import java.io.IOException;

public class SystemInput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// �Է��� �ް� �� ���ڸ����� ���� �޴´� 
		// enterŰ�� ���� �� ����Ǹ� �������� enter�� 13,10�� ������ �Է¹޴´�
		int keyCode = System.in.read();
		System.out.println("keycode:"+keyCode);
		
		int keyCode2 = System.in.read();
		System.out.println("keycode2:"+keyCode2);
		
		int keyCode3 = System.in.read();
		System.out.println("keycode3:"+keyCode3);
		
		int keyCode4 = System.in.read();
		System.out.println("keycode4:"+keyCode4);
		
		int keyCode5 = System.in.read();
		System.out.println("keycode5:"+keyCode5);
	}

}
