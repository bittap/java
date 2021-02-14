package javaAwt.awt;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Panel;

public class CheckBoxTest extends Frame {
	Panel panel;
	public CheckBoxTest() {
		panel = new Panel();
		setVisible(true);
		setBounds(300, 300, 300, 300);
		add(panel);
	}
	
	public void CheckBoxCreate() {
		Checkbox checkbox = new Checkbox("치킨",true);
		Checkbox checkbox1 = new Checkbox("피자");
		Checkbox checkbox2 = new Checkbox("햄버거");
		
		panel.add(checkbox);
		panel.add(checkbox1);
		panel.add(checkbox2);
	}
	
	public void RadioBoxCreate() {
		CheckboxGroup group = new CheckboxGroup();
		
		Checkbox checkbox = new Checkbox("치킨",group,true);
		Checkbox checkbox1 = new Checkbox("피자",group,false);
		Checkbox checkbox2 = new Checkbox("햄버거",group,false);
		
		panel.add(checkbox);
		panel.add(checkbox1);
		panel.add(checkbox2);
	}
}
