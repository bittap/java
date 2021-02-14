package listDTO;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StudentDetailDTO2 {
	private JComponent jComponent;
	private int x;
	private int y;
	private int w;
	private int h;
	
	
	
	public StudentDetailDTO2(JComponent jComponent, int x, int y, int w, int h) {
		super();
		this.jComponent = jComponent;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	
	public JComponent getjComponent() {
		return jComponent;
	}
	public void setjComponent(JComponent jComponent) {
		this.jComponent = jComponent;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	
	
	
	
}
