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
		Checkbox checkbox = new Checkbox("ġŲ",true);
		Checkbox checkbox1 = new Checkbox("����");
		Checkbox checkbox2 = new Checkbox("�ܹ���");
		
		panel.add(checkbox);
		panel.add(checkbox1);
		panel.add(checkbox2);
	}
	
	public void RadioBoxCreate() {
		CheckboxGroup group = new CheckboxGroup();
		
		Checkbox checkbox = new Checkbox("ġŲ",group,true);
		Checkbox checkbox1 = new Checkbox("����",group,false);
		Checkbox checkbox2 = new Checkbox("�ܹ���",group,false);
		
		panel.add(checkbox);
		panel.add(checkbox1);
		panel.add(checkbox2);
	}
}
