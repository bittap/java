package javaAwt.layout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutTest {

	public static void main(String[] args) {
		// 격자 모양으로 배치
		// 행과 열의 수를 지정해서 배치
		// 행과 열 수보다 컴포넌트의 수가 많으면 자동적으로 늘어남
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setBounds(300, 100, 500, 500);
		
		GridLayout gridLayout = new GridLayout(3, 2);
		frame.setLayout(gridLayout);
		Button button[] = new Button[6];
		
		for (int i = 0; i < button.length; i++) {
			button[i] = new Button((i+1)+"번째의 버튼");
			frame.add(button[i]);
		}
		
	}

}
