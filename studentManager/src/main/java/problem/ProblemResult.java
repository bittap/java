package problem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import common.Seting;
import database.DataBase;
import problemDAO.ProbelmRDAO;
import problemDTO.ProbelmRDTO;
import session.SessionDTO;

// 서술형
public class ProblemResult extends JFrame implements ActionListener {

	JPanel mainPanel, menuPanel, bodyPanel, footPanel, bodySubPanel;
	JLabel jLabel;
	JButton cancelButton;
	Container containerPane;
	String topName = "객관식/주관식 점수확인";
	int align = (int) JFrame.CENTER_ALIGNMENT;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Font font = new Font("Serif", Font.BOLD, 16);
	Dimension dimension;
	DataBase dao;
	ProbelmRDAO rDAO = new ProbelmRDAO();
	GridBagLayout gb;
	GridBagConstraints gbc;
	ArrayList<String[]> bodyMenu = new ArrayList<String[]>();
	

	public ProblemResult(int objectWidth, int objectHeight) {
		containerPane = getContentPane();
		dimension = new Dimension(objectWidth, objectHeight);
		mainPanel = new JPanel(new BorderLayout(100, 0));
		mainPanel.setSize(600, 500);

		// 하단 부분
		footPanel = new JPanel(new FlowLayout(1, 50, 30));
		
		
	}

	public void setUi() {
		panelCombine();
	}

	void panelCombine() {
		mainPanel.add(setMenu(), "North");
		mainPanel.add(setBody(), "Center");
		setFoot();
		containerPane.add(mainPanel, "North");
		containerPane.add(footPanel, "South");
		setSize(600, 600);
		Seting.getInstance(this);
	}

	JPanel setMenu() {
		menuPanel = new JPanel(new FlowLayout(1, 0, 30));
		jLabel = new JLabel(topName);

		jLabel.setFont(font);
		menuPanel.add(jLabel);
		return menuPanel;
	}
	
	void setBodyMenu(){
		ProbelmRDTO rDTO = rDAO.bodyData(); // dto에 데이터 셋팅
		
		bodyMenu.add(new String[] {"유형", "점수", "만점"});
		bodyMenu.add(new String[] {"객관식", rDTO.getmScore(), rDTO.getmPerfectScore()});
		bodyMenu.add(new String[] {"주관식", rDTO.getsScore(), rDTO.getsPerfectScore()});
	}

	JPanel setBody() {
		bodyPanel = new JPanel();
		bodySubPanel = new JPanel();
		gb = new GridBagLayout();
		bodySubPanel.setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		setBodyMenu();

		for (int i = 0; i < bodyMenu.size(); i++) {
			for (int j = 0; j < bodyMenu.get(i).length; j++) {
				gbAdd(new JLabel(bodyMenu.get(i)[j]), j, i, 1, 1);
			}	
		}

		bodyPanel.add(bodySubPanel);
		rDAO.disConn();
		return bodyPanel;

	}

	void gbAdd(JComponent object, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;

		if ((object instanceof JLabel)) {
			((JLabel) object).setHorizontalAlignment(align);
			object.setPreferredSize(dimension);
			object.setFont(font);
		}
		object.setBorder(border);

		bodySubPanel.add(object, gbc);
	}
	
	public static void main(String[] args) {
		SessionDTO session = SessionDTO.getInstance();
		session.setExamNumber("20191110");
		session.setId("20191108");
		session.setName("김태영");
		ProblemResult problemR = new ProblemResult(150, 100);
		problemR.setUi();
	}

	void setFoot() {
		cancelButton = new JButton("닫기");
		cancelButton.setSize(500, 100);
		cancelButton.setPreferredSize(new Dimension(150, 70));
		cancelButton.addActionListener(this);
		footPanel.add(cancelButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
