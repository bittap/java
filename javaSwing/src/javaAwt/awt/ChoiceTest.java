package javaAwt.awt;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Panel;

public class ChoiceTest extends Frame {
	Panel panel;
	
	public ChoiceTest() {
		setVisible(true);
		setBounds(300, 300, 300, 200);
		panel = new Panel();
		add(panel);
	}
	
	public void ChoiceCreate() {
		Choice choice = new Choice();
		choice.addItem("ġŲ");
		choice.addItem("����");
		choice.addItem("�ܹ���");
		panel.add(choice);
	}
	
	
}
