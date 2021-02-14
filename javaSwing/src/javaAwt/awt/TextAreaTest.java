package javaAwt.awt;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;

public class TextAreaTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setBounds(300, 300, 300, 300);
		
		Panel panel = new Panel();
		frame.add(panel);
		
		TextArea textArea = new TextArea(10,30);
		textArea.setText("java world");
		panel.add(textArea);
		
	}

}
