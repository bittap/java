package javaAwt.awt;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

public class LableTest extends Frame {
	Panel panel;
	
	public LableTest() {
		setVisible(true);
		setBounds(300, 100, 300, 500);
		panel = new Panel();
		add(panel);
	}
	
	public void LableCreate() {
		Label label = new Label("����");
		Label label1 = new Label("ġŲ", Label.CENTER);
		Label label2 = new Label("����", Label.LEFT);
		
		panel.add(label);
		panel.add(label1);
		panel.add(label2);
		
	}
}
