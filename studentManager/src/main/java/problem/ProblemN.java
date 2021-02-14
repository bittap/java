package problem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import common.Seting;
import common.ui.HintTextEnableFiled;
import common.ui.HintTextFieldBackup;
import database.DataBase;
import google.drive.DriveManager;
import problemDAO.ProbelmNDAO;
import screen.ScreenManager;
import session.SessionDTO;

// ������
public class ProblemN extends JFrame implements ActionListener {

	JPanel mainPanel, menuPanel, borderPanel, bodyPanel, footPanel, bodySubPanel;
	JPanel topGridPanel, bodyGridPanel; // Grid�г�
	JLabel jLabel;
	JButton registerButton, chooeserButton;
	Container containerPane;
	String topName = "���������";
	int numY; // numY = ���� ����
	int align = (int) JFrame.CENTER_ALIGNMENT;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Font font = new Font("Serif", Font.BOLD, 16);
	Dimension dimension;
	DataBase dao;
	ProbelmNDAO nDAO = new ProbelmNDAO();
	List<Map<String, String>> list;
	ArrayList<JTextField> textArray = new ArrayList<JTextField>();
	boolean textFlag; // �ؽ�Ʈ�� ���õǾ� �ִ��� �ȵǾ��ִ��� Ȯ��
	ArrayList<String> inputNoSelectNum; // ���� �� �� ������ȣ Ȯ��
	GridBagLayout gb;
	GridBagConstraints gbc;
	String[] bodyMenu = { "��ȣ", "���", "����", "����" };
	List<Map<JButton, JTextField>> buttonList;
	Map<Integer,File> fileMap; // ���� ���� ��
	SessionDTO sessionDTO = SessionDTO.getInstance();
	String rootDir = System.getProperty("user.dir")+"\\"+"file"+"\\"+sessionDTO.getExamNumber(); // ���� ���
	String nameDir = rootDir+"\\"+sessionDTO.getName();
	String idDir = nameDir+"\\"+sessionDTO.getId();

	public ProblemN(int objectWidth, int objectHeight) {
		containerPane = getContentPane();
		this.numY = nDAO.numY(); //
		dimension = new Dimension(objectWidth, objectHeight);
		mainPanel = new JPanel(new BorderLayout(100, 0));
		mainPanel.setSize(600, 800);

		// �ϴ� �κ�
		footPanel = new JPanel(new FlowLayout(1, 50, 30));
		
		//fileMap �ʱ�ȭ
		fileMap = new HashMap<Integer, File>(); // ���� ���� ��
		for (int i = 1; i <= this.numY; i++) {
			fileMap.put(i, null);
		}
	}

	public void setUi() {
		panelCombine();
	}

	public List<Map<String, String>> setData() {
		return nDAO.bodyData();
	}

	void panelCombine() {
		mainPanel.add(setMenu(), "North");
		mainPanel.add(setBody(), "Center");
		setFoot();
		containerPane.add(mainPanel, "North");
		containerPane.add(footPanel, "South");
		setSize(600, 1000);
		Seting.getInstance(this);
	}

	JPanel setMenu() {
		menuPanel = new JPanel(new FlowLayout(1, 0, 30));
		jLabel = new JLabel(topName);

		jLabel.setFont(font);
		menuPanel.add(jLabel);
		return menuPanel;
	}

	JPanel setBody() {
		buttonList = new ArrayList<Map<JButton, JTextField>>();
		bodyPanel = new JPanel();
		bodySubPanel = new JPanel();
		gb = new GridBagLayout();
		bodySubPanel.setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		for (int i = 0; i < bodyMenu.length; i++) {
			gbAdd(new JLabel(bodyMenu[i]), i, 0, 1, 1);
		}

		list = setData();
		for (int y = 1; y <= numY; y++) {
			int x = 0;
			Map<JButton, JTextField> tempMap = new HashMap<JButton, JTextField>();

			JTextField jTextField = new HintTextEnableFiled(list.get(y - 1).get("file_form").toString());
			jTextField.setEnabled(false);
			// ������ Ȯ���� list�� �������� Ű
			jTextField.setName(String.valueOf(y));
			chooeserButton = new JButton("����");
			chooeserButton.addActionListener(this);

			tempMap.put(chooeserButton, jTextField);
			buttonList.add(tempMap);

			gbAdd(new JLabel(list.get(y - 1).get("num").toString()), x++, y, 1, 1);
			gbAdd(jTextField, x++, y, 1, 1);
			gbAdd(chooeserButton, x++, y, 1, 1);
			gbAdd(new JLabel(list.get(y - 1).get("score").toString()), x++, y, 1, 1);
		}

		bodyPanel.add(bodySubPanel);

		return bodyPanel;

	}

	void gbAdd(JComponent object, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;

		if (object instanceof JButton) {
			((AbstractButton) object).setHorizontalAlignment(align);
			object.setPreferredSize(dimension);
			object.setFont(font);
		} else if ((object instanceof JLabel)) {
			((JLabel) object).setHorizontalAlignment(align);
			object.setPreferredSize(dimension);
			object.setFont(font);
		} else if ((object instanceof JTextField)) {
			((JTextField) object).setHorizontalAlignment(align);
			object.setPreferredSize(new Dimension(300, (int) dimension.getHeight()));
			object.setFont(new Font("Serif", Font.BOLD, 16));
			object.setForeground(Color.RED);

		}
		object.setBorder(border);

		bodySubPanel.add(object, gbc);
	}

	void setFoot() {
		registerButton = new JButton("����");
		registerButton.setSize(500, 100);
		registerButton.setPreferredSize(new Dimension(150, 70));
		registerButton.addActionListener(this);
		footPanel.add(registerButton);
	}
	
	public static void main(String[] args) {
		SessionDTO sessionDTO = SessionDTO.getInstance();
		sessionDTO.setExamNumber("13579");
		ScreenManager.problemN();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registerButton) 
		{
			int ans = JOptionPane.showConfirmDialog(this, "������ "+ topName +"�� �����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION);
			// Yes�� ���
			if(ans == 0)
			{
				String[] folName = {"file",sessionDTO.getExamNumber(),sessionDTO.getName()};
				DriveManager driveManager = new DriveManager(folName);
				Iterator<Integer> iterator = fileMap.keySet().iterator();
				while (iterator.hasNext()) {
					int key = iterator.next();
					File value = fileMap.get(key);
					
					// ������ ���� ��쿡��
					if(value != null) 
					{
						// ���� ����
						String fileId = driveManager.fileUplod(value.getName(), value);
						nDAO.solveAdd(key, fileId,value.getName());
					}
				}
				nDAO.disConn();
				dispose();

				ScreenManager.problemResult();
			}
		}
		else
		{
			for (int i = 0; i < buttonList.size(); i++) {
				Set<JButton> keySet = buttonList.get(i).keySet();
				Iterator<JButton> iterator = keySet.iterator();
				while (iterator.hasNext()) {
					JButton key = iterator.next();
					JTextField value = buttonList.get(i).get(key);
					
					if(e.getSource() == key) {
						JFileChooser fc = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter(list.get(i).get("file_form").toString(),list.get(i).get("file_form").toString().split(","));
						fc.addChoosableFileFilter(filter);
						fc.setAcceptAllFileFilterUsed(false);
						int returnVal = fc.showOpenDialog(this);
						
						if(returnVal == JFileChooser.APPROVE_OPTION)
						{
							File file = fc.getSelectedFile();
								
							// 2019-10-22 FileNameExtensionFilter�� �̿��� ����� �ʿ�������� �ּ�ó��
							/*
							int pos = file.getName().lastIndexOf(".");
							String ext = file.getName().substring(pos+1);
									
							String file_form = list.get(i).get("file_form").toString();
							String[] file_formArr = file_form.split(",");
							boolean formFlag = false;
							for (int j = 0; j < file_formArr.length; j++) {
								if(ext.equals(file_formArr[j])) 
								{	
									formFlag = true;
									break;
								}
							}
							*/
							/*
							 * if(formFlag) {
							 */
							value.setText(file.getName());
							fileMap.put(i+1,file);
/*							}
							else 
							{
								JOptionPane.showMessageDialog(this, "Ȯ���ڰ� ��ġ���� �ʽ��ϴ�.","Message",JOptionPane.ERROR_MESSAGE);
							}*/
						}	
						
						
					}
				}
			}
		}


	}
}
