package answerDTO;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AnswerSDTO {
	private JComboBox<String> jComboBox;
	private int num;
	private JTextField answer;
	private JTextField score;
	
	
	public AnswerSDTO(JComboBox<String> jComboBox, int num, JTextField answer, JTextField score) {
		super();
		this.jComboBox = jComboBox;
		this.num = num;
		this.answer = answer;
		this.score = score;
	}
	
	public JComboBox<String> getjComboBox() {
		return jComboBox;
	}
	public int getNum() {
		return num;
	}
	public JTextField getanswer() {
		return answer;
	}
	
	public JTextField getScore() {
		return score;
	}
	
	
	
	
	
	
	
	
	
	
}
