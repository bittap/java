package javaAwt.layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowLayoutTest {

	public static void main(String[] args) {
		// panel의 기본으로 컴포넌트 들을 수평으로 순서대로 나열하는 레이아웃
		// 수평으로 배치하다가 더 이상 공간이 없으면 다음 줄로 이동해서 배치
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setBounds(300, 100, 500, 500);
		
		FlowLayout flowLayout = new FlowLayout();
		Button btn[] = new Button[10];
		
		frame.setLayout(flowLayout);
		
		for (int i = 0; i < 10; i++) {
			btn[i] = new Button((i+1)+"번 버튼");
			frame.add(btn[i]);
		}
		
		
	}

}
