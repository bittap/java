package common.ui;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HintTextEnableFiled extends JTextField implements DocumentListener{
	
	private Color enableColor = Color.red;
	private Color basicColor = Color.black;
	
	public HintTextEnableFiled(final String hint) {
		super(hint);
		super.getDocument().addDocumentListener(this);
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		this.setDisabledTextColor(basicColor);
	}
	
	@Override
	public void removeUpdate(DocumentEvent e) {
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		super.setDisabledTextColor(enableColor);
	}
	
	
	
	
}
