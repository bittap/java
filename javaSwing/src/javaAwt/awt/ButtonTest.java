package javaAwt.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class ButtonTest {

	public static void main(String[] args) {
		Frame frame = new Frame("��ư �׽�Ʈ");
		
		Panel panel = new Panel();
		
		Button button = new Button("����");
		Button button1 = new Button("����");
		Button button2 = new Button("��");
		
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		frame.setBounds(100, 100, 300, 200);
		frame.setVisible(true);
		
		frame.add(panel);
	}

}
