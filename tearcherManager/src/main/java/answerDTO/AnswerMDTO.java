package answerDTO;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AnswerMDTO {
	private JComboBox<Integer> jComboBox;
	private int num;
	private JTextField jTextField;
	
	
	public AnswerMDTO(JComboBox<Integer> jComboBox, int num, JTextField jTextField) {
		super();
		this.jComboBox = jComboBox;
		this.num = num;
		this.jTextField = jTextField;
	}
	
	public JComboBox<Integer> getjComboBox() {
		return jComboBox;
	}
	public int getNum() {
		return num;
	}
	public JTextField getjTextField() {
		return jTextField;
	}
	
	
	
	
	
	
	
	
	
	
}
