package common;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import answer.Answer;
import member.Login;

public class Listener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		JComponent[] jtextField = {Answer.jLabelTitle,Answer.jLableExam,Login.idText,Login.passText};
		
		for (int i = 0; i < jtextField.length; i++) {
			if(e.getSource().equals(jtextField[i])) {
				if (jtextField[i] instanceof JTextField) {
					((JTextField)jtextField[i]).setText("");
				}else if(jtextField[i] instanceof JPasswordField){
					((JPasswordField)jtextField[i]).setText("");
				}
				
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	
}
