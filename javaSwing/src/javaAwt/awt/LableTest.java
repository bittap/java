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
		Label label = new Label("피자");
		Label label1 = new Label("치킨", Label.CENTER);
		Label label2 = new Label("맘마", Label.LEFT);
		
		panel.add(label);
		panel.add(label1);
		panel.add(label2);
		
	}
}
