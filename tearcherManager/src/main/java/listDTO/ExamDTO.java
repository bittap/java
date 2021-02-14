package listDTO;

import javax.swing.JButton;

public class ExamDTO {
	private String examNumber;
	private JButton modifyButton;
	private JButton detailButton;
	
	
	public ExamDTO(String examNumber, JButton modifyButton, JButton detailButton) {
		super();
		this.examNumber = examNumber;
		this.modifyButton = modifyButton;
		this.detailButton = detailButton;
	}
	
	public String getExamNumber() {
		return examNumber;
	}
	public JButton getModifyButton() {
		return modifyButton;
	}
	public JButton getDetailButton() {
		return detailButton;
	}
	
	
	
	
	
	
}
