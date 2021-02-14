package answerDTO;

import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.border.Border;

public class AnswerDTO {
	private JComponent jComponent;
	private int x;
	private int y;
	private int w;
	private int h;
	private Insets insets;
	private int align;
	private Border border;
	
	public AnswerDTO(JComponent jComponent, int x, int y, int w, int h, Insets insets, int align, Border border) {
		this.jComponent = jComponent;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.insets = insets; 
		this.align = align;
		this.border = border;
	}
	
	public JComponent getjComponent() {
		return jComponent;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public Insets getInsets() {
		return insets;
	}
	public int getAlign() {
		return align;
	}

	public Border getBorder() {
		return border;
	}
	
	
	
	
	
	
	
}
