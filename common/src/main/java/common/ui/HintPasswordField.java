package common.ui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HintPasswordField extends JPasswordField implements FocusListener,MouseListener {
	private final String hint;
	private boolean showingHint;
	private Color hintColor = Color.red;
	private Color basicColor = Color.black;
	
	public HintPasswordField(final String hint) {
		super(hint);
		this.hint = hint;
		this.showingHint = true;
		super.addFocusListener(this);
		this.setEchoChar((char)0);
		this.setForeground(hintColor);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.setText("");
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	

	@Override
	public void focusGained(FocusEvent e) {
		if(this.getText().isEmpty()) {
			this.setForeground(basicColor);
			super.setText("");
			this.setEchoChar('*');
			showingHint = false;
		}
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		if(this.getText().isEmpty()) {
			this.setForeground(hintColor);
			super.setText(hint);
			this.setEchoChar((char)0);
			showingHint = true;
		}
	}
	
	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}

}
