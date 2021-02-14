package answerDTO;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class AnswerNDTO {
	private ArrayList<JCheckBox> jCheckBoxs;
	private int num;
	private JTextField score;
	
	public AnswerNDTO(ArrayList<JCheckBox> jCheckBoxs, int num, JTextField score) {
		super();
		this.jCheckBoxs = jCheckBoxs;
		this.num = num;
		this.score = score;
	}

	public ArrayList<JCheckBox> getjComboBox() {
		return jCheckBoxs;
	}

	public int getNum() {
		return num;
	}

	public JTextField getScore() {
		return score;
	}
	
	
	
	

}
