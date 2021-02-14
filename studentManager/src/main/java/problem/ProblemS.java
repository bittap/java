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
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import common.Common;
import common.Seting;
import common.ui.AssistUi;
import database.DataBase;
import problemDAO.ProbelmSDAO;
import screen.ScreenManager;
import session.SessionDTO;

// �ְ���
public class ProblemS extends JFrame implements ActionListener {
	
	JPanel mainPanel,menuPanel,borderPanel,bodyPanel,footPanel,bodySubPanel;
	JPanel topGridPanel,bodyGridPanel; // Grid�г�
	JLabel jLabel;
	JRadioButton radioButton;
	JButton registerButton;
	ButtonGroup buttonGroup;
	Container containerPane;
	String topName = "�ְ��Ĵ��";
	int numY; // numY = ���� ����
	int align = (int) JFrame.CENTER_ALIGNMENT;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Font font = new Font("Serif",Font.BOLD,16);
	Dimension dimension;
	DataBase dao;
	ProbelmSDAO sDAO = new ProbelmSDAO();
	List<Map<String,String>> list;
	ArrayList<JTextField> textArray = new ArrayList<JTextField>();
	boolean textFlag; // �ؽ�Ʈ�� ���õǾ� �ִ��� �ȵǾ��ִ��� Ȯ��
	ArrayList<String> inputNoSelectNum; // ���� �� �� ������ȣ Ȯ��
	GridBagLayout gb;
	GridBagConstraints gbc;
	String[] top = {"��ȣ","���","����"};
	AssistUi assistUi;
	
	public ProblemS(int objectWidth, int objectHeight) {
		containerPane = getContentPane();
		this.numY = sDAO.numY(); // 
		dimension = new Dimension(objectWidth, objectHeight);
		assistUi = new AssistUi(dimension);
		mainPanel = new JPanel(new BorderLayout(100, 0));
		mainPanel.setSize(600, 800);

		
	}

	public void setUi() {
		panelCombine();
	}
	
	public List<Map<String,String>> setData() {
		return sDAO.bodyData();
	}
	
	void panelCombine() {
		mainPanel.add(setMenu(),"North");
		mainPanel.add(setBody(),"Center");
		setFoot();
		containerPane.add(mainPanel,"North");
		containerPane.add(footPanel,"South");
		setSize(600,1000);
		Seting.getInstance(this);
	}
	
	JPanel setMenu() {
		menuPanel = new JPanel(new FlowLayout(1,0,30));
		jLabel = new JLabel(topName);
		
		jLabel.setFont(font);
		menuPanel.add(jLabel);
		return menuPanel;
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

		gbAdd(new JLabel("��ȣ"),0,0,1,1);
		gbAdd(new JLabel("���"),1,0,6,1);
		gbAdd(new JLabel("����"),7,0,1,1);
		
		
		list = setData();
		for (int y = 1; y <= numY; y++) {
			gbAdd(new JLabel(String.valueOf(y)),0,y,1,1);
			JTextField jTextField = new JTextField("");
			textArray.add(jTextField);
			gbAdd(jTextField,1,y,6,1);
			gbAdd(new JLabel(list.get(y-1).get("score")),7,y,1,1);
		}
		
		bodyPanel.add(bodySubPanel);
		
		return bodyPanel;
		
	}
	
	void gbAdd(JComponent object, int x, int y, int w, int h) {
		assistUi.decorateGridBagObject(gbc, object, x, y, w, h);
		bodySubPanel.add(object, gbc);
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
	
	public static void main(String[] args) {
		SessionDTO sessionDTO = SessionDTO.getInstance();
		sessionDTO.setExamNumber("13579");
		ScreenManager.problemS();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		inputNoSelectNum = new ArrayList<String>();
		textFlag = true;
		for (int i = 1; i <= textArray.size(); i++) 
		{
			if(textArray.get(i-1).getText().equals("")) textFlag = false;
			
			if(!textFlag) 
			{
				inputNoSelectNum.add(String.valueOf(i));
			}
		}
		
		if(inputNoSelectNum.size() == 0) 
		{
			int ans = JOptionPane.showConfirmDialog(this, "������ "+ topName +"�� �����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION);
			// Yes�� ���
			if(ans == 0)
			{
				for (int i = 1; i <= textArray.size(); i++) 
				{
					sDAO.solveAdd(i, textArray.get(i-1).getText());
				}
				sDAO.disConn();
				dispose();
				/********* ������ ��� ȣ�� �ۼ� *******/
				ScreenManager.problemN();
			}
			
		}
		else
		{
			String[] strData = inputNoSelectNum.toArray(new String[inputNoSelectNum.size()]);
			JOptionPane.showMessageDialog(this, Common.arrayJoin(",", strData)+"�� ������ Ǯ���ּ���.","Message",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
