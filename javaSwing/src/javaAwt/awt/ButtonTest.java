package javaAwt.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class ButtonTest {

	public static void main(String[] args) {
		Frame frame = new Frame("버튼 테스트");
		
		Panel panel = new Panel();
		
		Button button = new Button("가위");
		Button button1 = new Button("바위");
		Button button2 = new Button("보");
		
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		frame.setBounds(100, 100, 300, 200);
		frame.setVisible(true);
		
		frame.add(panel);
	}

}
