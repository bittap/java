package javaAwt.awt;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class TextFiledTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setBounds(300, 300, 300, 300);
		
		Panel panel = new Panel();
		frame.add(panel);
		
		Label label = new Label("아이디:");
		Label label1 = new Label("비밀번호:");
		
		TextField textField = new TextField("ID",20);
		TextField textField2 = new TextField(20);
		
		textField2.setEchoChar('*');
		panel.add(label);
		panel.add(textField);
		panel.add(label1);
		panel.add(textField2);
		
		
	}

}
