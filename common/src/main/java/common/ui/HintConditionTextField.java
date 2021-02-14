package common.ui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HintConditionTextField extends JTextField implements FocusListener,MouseListener,KeyListener {
	private String hint;
	private boolean showingHint;
	private int limitNumber;
	private int condition;
	private Color hintColor = Color.red;
	private Color basicColor = Color.black;
	
	public HintConditionTextField() {
		super();
		
		this.showingHint = true;
		super.addFocusListener(this);
		this.addKeyListener(this);
		this.setForeground(hintColor);
	}
	
	// limitNumber = 0  => 동작 x
	// kind = 1 : 숫자만
	public HintConditionTextField(String hint, int limitNumber, int condition) {
		super(hint);
		
		this.hint = hint;
		this.limitNumber = limitNumber;
		this.condition = condition;
		
		this.showingHint = true;
		super.addFocusListener(this);
		this.addKeyListener(this);
		this.setForeground(hintColor);
	}
	

	public String getHint() {
		return hint;
	}





	public void setHint(String hint) {
		this.hint = hint;
	}





	public int getLimitNumber() {
		return limitNumber;
	}





	public void setLimitNumber(int limitNumber) {
		this.limitNumber = limitNumber;
	}





	public int getCondition() {
		return condition;
	}





	public void setCondition(int condition) {
		this.condition = condition;
	}





	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		switch (condition) 
		{
			case 1:
				// 숫자만 받기
				if(e.getKeyChar() < 0x30 || e.getKeyChar() > 0x39) 
				{
					this.setText("");
				}
				break;
	
			default:
				break;
		}

		
		if(limitNumber > 0 && this.getText().length() > limitNumber) 
		{
			this.setText(this.getText().substring(0, limitNumber));
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
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
