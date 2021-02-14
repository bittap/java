package javaAwt.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutTest {

	public static void main(String[] args) {
		// 5개의 영역으로 구분하여 보여줌
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setBounds(300, 100, 300, 300);
		
		BorderLayout borderLayout = new BorderLayout();
		frame.setLayout(borderLayout);
		
		frame.add("North",new Button("북쪽"));
		frame.add("West",new Button("서쪽"));
		frame.add("East",new Button("동쪽"));
		frame.add("Center",new Button("중앙"));
		frame.add("South",new Button("남쪽"));
		
	}

}
