package system;

import java.io.IOException;

public class SystemInput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 입력을 받고 각 글자마다의 값을 받는다 
		// enter키를 누를 시 종료되며 나머지는 enter로 13,10을 무조건 입력받는다
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
