package listDTO;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class StudentDetailDTO {
	private JPanel jPanel;
	private JScrollPane jScrollPane;
	private GridBagLayout gb;
	private String place;
	private ArrayList<StudentDetailDTO2> dto;
	
	
	public StudentDetailDTO(JPanel jPanel, JScrollPane jScrollPane,GridBagLayout gb, String place,int width, int heigth) {
		super();
		this.jPanel = jPanel;
		this.jScrollPane = jScrollPane;
		this.gb = gb;
		this.place = place;
		
		jPanel.setLayout(gb);
		
		jScrollPane.setViewportView(jPanel);
		jScrollPane.setPreferredSize(new Dimension(width, heigth));
	}
	
	
	public JPanel getjPanel() {
		return jPanel;
	}

	public JScrollPane getjScrollPane() {
		return jScrollPane;
	}


	public GridBagLayout getGb() {
		return gb;
	}


	public String getPlace() {
		return place;
	}
	
	
	
	

	
	

	
	
	
}
