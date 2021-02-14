package common.ui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HintTextFieldBackup extends JTextField implements FocusListener,DocumentListener,MouseListener {
	private final String hint;
	private boolean showingHint;
	private Color hintColor = Color.red;
	private Color basicColor = Color.black;
	
	public HintTextFieldBackup(final String hint) {
		super(hint);
		this.hint = hint;
		this.showingHint = true;
		super.addFocusListener(this);
		super.getDocument().addDocumentListener(this);
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
	public void changedUpdate(DocumentEvent e) {
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		if(this.getText().isEmpty()) {
			this.setForeground(basicColor);
			showingHint = false;
		}
		
	}
	
	@Override
	public void removeUpdate(DocumentEvent e) {
		this.setForeground(basicColor);
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		if(this.getText().isEmpty()) {
			super.setText("");
			showingHint = false;
		}
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		if(this.getText().isEmpty()) {
			this.setForeground(hintColor);
			super.setText(hint);
			showingHint = true;
		}
	}
	
	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}

}
