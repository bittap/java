package problem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import common.Common;
import common.Seting;
import common.ui.AssistUi;
import database.DataBase;
import problemDAO.ProbelmMDAO;
import screen.ScreenManager;
import session.SessionDTO;

public class ProblemM extends JFrame implements ActionListener {
	
	JPanel mainPanel,menuPanel,topPanel,borderPanel,bodyPanel,footPanel;
	JPanel topGridPanel,bodyGridPanel; // Grid�г�
	JLabel jLabel;
	JRadioButton radioButton;
	JButton registerButton;
	ButtonGroup buttonGroup;
	Container containerPane;
	ArrayList<String> top;
	String topName = "�����Ĵ��";
	int numX; // numX = ��ȣ ����
	int numY; // numY = ���� ����
	int align = (int) JFrame.CENTER_ALIGNMENT;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Font font = new Font("Serif",Font.BOLD,16);
	Dimension dimension;
	DataBase dao;
	ProbelmMDAO mDAO = new ProbelmMDAO();
	List<Map<String,String>> list;
	ArrayList<ButtonGroup> buttonArray = new ArrayList<ButtonGroup>();
	boolean buttonSelectFlag; // ��ư�� ���õǾ� �ִ��� �ȵǾ��ִ��� Ȯ��
	ArrayList<String> buttonNoSelectNum; // ���� �� �� ������ȣ Ȯ��
	AssistUi assitUi;
	
	public ProblemM(int objectWidth, int objectHeight) {
		containerPane = getContentPane();
		this.numX = mDAO.numX();
		this.numY = mDAO.numY(); // 
		dimension = new Dimension(objectWidth, objectHeight);
		assitUi = new AssistUi(dimension);
		mainPanel = new JPanel(new BorderLayout(100, 0));
		mainPanel.setSize(600, 800);
		
	}

	public void setUi() {
		mainPanel.add(setMenu(),"North");
		mainPanel.add(setTop(),"Center");
		mainPanel.add(setBody(),"South");
		setFoot();
		containerPane.add(mainPanel,"North");
		containerPane.add(footPanel,"South");
		setSize(600,1000);
		Seting.getInstance(this);
	}
	
	public List<Map<String,String>> setData() {
		return mDAO.bodyData();
	}
	
	JPanel setMenu() {
		menuPanel = new JPanel(new FlowLayout(1,0,30));
		jLabel = new JLabel(topName);
		jLabel.setFont(font);
		menuPanel.add(jLabel);
		return menuPanel;
	}
	
	JPanel setTop() {
		top = new ArrayList<String>();
		topPanel = new JPanel(new FlowLayout(1,0,0)); 
		topGridPanel = new JPanel(new GridLayout(1,top.size()));
		
		top.add("��ȣ");
		for (int i = 1; i <= numX; i++) {
			top.add(String.valueOf(i));
		}
		top.add("����");
		
		for (int i = 0; i < top.size(); i++) {
			setGridField(topGridPanel,new JLabel(String.valueOf(top.get(i))));
		}
		topPanel.add(topGridPanel);
		return topPanel;
	}
	
	JPanel setBody() {
		list = setData();
		
		bodyPanel = new JPanel(new FlowLayout(1,0,0)); 
		bodyGridPanel = new JPanel(new GridLayout(numY,top.size()));
		
		JScrollPane scrollPane = AssistUi.scrollSetting(false, true, 350, 600, bodyGridPanel);
		
		// ��ü
		for (int i = 1; i <= numY; i++) {
			// ��ȣ
			setGridField(bodyGridPanel,new JLabel(list.get(i-1).get("num").toString()));
			buttonGroup = new ButtonGroup();
			buttonArray.add(buttonGroup);
			for (int j = 1; j <= numX; j++) {
				radioButton = new JRadioButton();
				radioButton.setName(String.valueOf(j));
				setGridField(buttonGroup,radioButton,bodyGridPanel);
			}
			// ����
			setGridField(bodyGridPanel,new JLabel(list.get(i-1).get("score").toString()));
		}
		bodyPanel.add(scrollPane);
		return bodyPanel;
	}
	
	void setScroll() {

	}
	
	void setFoot() {
		// �ϴ� �κ�
		footPanel= new JPanel(new FlowLayout(1,50,30));
		registerButton = new JButton("����");
		registerButton.setSize(500,100);
		registerButton.setPreferredSize(new Dimension(150, 70));
		registerButton.addActionListener(this);
		footPanel.add(registerButton);
	}
	
	void setGridField(JPanel jPanel,JLabel object) {
		assitUi.decorateObject(object);
		jPanel.add(object);
	}
	
	void setGridField(ButtonGroup buttonGroup,JRadioButton object,JPanel jPanel) {
		assitUi.decorateObject(object);
		buttonGroup.add(object);
		jPanel.add(object);
	}
	
	public static void main(String[] args) {
		SessionDTO sessionDTO = SessionDTO.getInstance();
		sessionDTO.setExamNumber("13579");
		ScreenManager.problemM();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		buttonNoSelectNum = new ArrayList<String>();
		for (int i = 1; i <= buttonArray.size(); i++) 
		{
			Enumeration<AbstractButton> enumeration = buttonArray.get(i-1).getElements();
			buttonSelectFlag = false;
			while (enumeration.hasMoreElements()) 
			{
				AbstractButton ab = enumeration.nextElement();
				JRadioButton jb = (JRadioButton) ab;
				
				if(jb.isSelected()) buttonSelectFlag = true;
			}
			if(!buttonSelectFlag) 
			{
				buttonNoSelectNum.add(String.valueOf(i));
			}
		}
		
		if(buttonNoSelectNum.size() == 0) 
		{
			int ans = JOptionPane.showConfirmDialog(this, "������ "+ topName +"�� �����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION);
			// Yes�� ���
			if(ans == 0)
			{
				for (int i = 1; i <= buttonArray.size(); i++) 
				{
					Enumeration<AbstractButton> enumeration = buttonArray.get(i-1).getElements();
					while (enumeration.hasMoreElements()) 
					{
						AbstractButton ab = enumeration.nextElement();
						JRadioButton jb = (JRadioButton) ab;
						
						if(jb.isSelected()) mDAO.solveAdd(i,Integer.parseInt(jb.getName()));
					}
				}
				mDAO.disConn();
				dispose();
				/********* �ְ��� ��� ȣ�� �ۼ� *******/
				ScreenManager.problemS();
			}
			
		}
		else
		{
			String[] strData = buttonNoSelectNum.toArray(new String[buttonNoSelectNum.size()]);
			JOptionPane.showMessageDialog(this, Common.arrayJoin(",", strData)+"�� ������ Ǯ���ּ���.","Message",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
