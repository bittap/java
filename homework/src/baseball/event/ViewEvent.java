package baseball.event;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import baseball.logic.Logic;
import baseball.view.View;

public class ViewEvent implements ActionListener {
	
	private View view = null;
	private String[] computerNumbers;
	private Logic logic = new Logic();
	
	public ViewEvent(View view) {
		this.view = view;
		computerNumbers = logic.numberCreate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jbutton = (JButton)e.getSource();
		System.out.println(jbutton.getName());
		String textValue = view.numFiled.getText();
		String[] userInput = new String[textValue.length()];
		for (int i = 0; i < userInput.length; i++) {
			userInput[i] = textValue.substring(i, i+1);
		}
		/*
		for (String string : userInput) {
			System.out.println(string);
		}
		*/
		logic.result(userInput, computerNumbers);

	}
	
	
}
