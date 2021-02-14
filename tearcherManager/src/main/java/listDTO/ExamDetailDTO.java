package listDTO;

import javax.swing.JButton;

public class ExamDetailDTO {
	private String id;
	private JButton detailButton;
	
	
	public ExamDetailDTO(String id, JButton detailButton) {
		super();
		this.id = id;
		this.detailButton = detailButton;
	}
	
	public String getId() {
		return id;
	}
	public JButton getDetailButton() {
		return detailButton;
	}
	
	
	
	
	
	
	
	
	
}
