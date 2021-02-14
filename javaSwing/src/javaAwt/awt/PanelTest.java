package javaAwt.awt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class PanelTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		// 패널을 완성한다음에 프레임에 보통 붇임
		Panel panel = new Panel();
		panel.setBackground(Color.red);
		frame.add(panel);
		
		frame.setSize(300, 500);
		frame.setVisible(true);
		
	}

}
