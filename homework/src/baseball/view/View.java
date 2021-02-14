package baseball.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import baseball.common.Setting;
import baseball.event.ViewEvent;
import baseball.logic.Logic;

public class View extends JFrame {
	
	public JTextField numFiled = new JTextField(10);
	
	
	public View() {
		setUi();
		Setting.Setting(this);
	}
	
	
	private void setUi() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton inputButton = new JButton("ют╥б");
		inputButton.setName("button");
		ViewEvent viewEvent = new ViewEvent(this);
		inputButton.addActionListener(viewEvent);
		inputButton.setSize(100, 100);
		
		this.add(numFiled);
		this.add(inputButton);
	}
}
