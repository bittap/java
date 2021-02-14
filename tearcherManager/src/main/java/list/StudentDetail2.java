package list;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import answerDAO.AnswerMDAO;
import answerDTO.AnswerMDTO;
import common.Seting;
import database.DataBase;
import excel.Excel;
import excelDTO.excelDTO;
import google.drive.DriveManager;
import listDAO.ExamDetailDAO;
import listDAO.studentDetailDAO;
import listDTO.ExamDetailDTO;
import listDTO.StudentDetailDTO2;
import screen.ScreenManager;
import listDTO.StudentDetailDTO;

public class StudentDetail2 extends JFrame implements ActionListener,KeyListener{
	Container containerPane;
	JPanel boardPanel,menuPanel,subBoardPanel,subTopPanel,bodySubPanel1;
	JLabel jLabel,totalJLabel,fileJLable;
	JScrollPane jScrollPane;
	Font font = new Font("Serif",Font.BOLD,16);
	int align = (int) JFrame.CENTER_ALIGNMENT;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Dimension dimension;
	GridBagLayout gb;
	GridBagConstraints gbc;
	public static JTextField jLabelTitle,jLableExam,jLableDate;
	JTextField answerM,answerS,answerN;
	JButton backButton,nSave;
	int objectWidth;
	int objectHeight;
	Calendar c = Calendar.getInstance();
	JComboBox<String> mCount,answerSizeArrCount;
	ArrayList<ExamDetailDTO> dto;
	studentDetailDAO dao = new studentDetailDAO();
	JTextField jTextField;
	String examNumber;
	Map<String,String> examData;
	File file;
	String id;
	ArrayList<StudentDetailDTO> arrayData;
	JLabel totalNum;
	List<JTextField> modiText = new ArrayList<JTextField>();
	
	
	public StudentDetail2(int objectWidth, int objectHeight, String examNumber,String id) {
		this.objectWidth = objectWidth;
		this.objectHeight = objectHeight;
		this.examNumber = examNumber;
		this.id = id;
		
		containerPane = getContentPane();
		setLayout(new FlowLayout(1,0,30));
		dimension = new Dimension(objectWidth, objectHeight);
		boardPanel = new JPanel(new BorderLayout(100, 30));
		subBoardPanel = new JPanel(new BorderLayout(100, 0));
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
		gb = new GridBagLayout();

		jScrollPane = new JScrollPane();
	}
	
	public void setUi() {
		panelCombine();
	}
	
	private void dataSeting() {
		arrayData = new ArrayList<StudentDetailDTO>();
		arrayData.add(new StudentDetailDTO(new JPanel(), new JScrollPane(),new GridBagLayout(), "North",500,500));
		
		ArrayList<ArrayList<StudentDetailDTO2>> mData = new ArrayList<ArrayList<StudentDetailDTO2>>();
		mData.add(dao.nDetail2(examNumber, id));
		
		int i = 0;
		for (ArrayList<StudentDetailDTO2> arrayList : mData) {
			int j = 0;
			for (StudentDetailDTO2 studentDetailDTO : arrayList) {
				// 마지막인 경우 오브젝트에 저장
				if (studentDetailDTO.getjComponent() instanceof JLabel) {
					if(arrayList.size() == j+1) totalNum = ((JLabel)studentDetailDTO.getjComponent());
					
				}else if(studentDetailDTO.getjComponent() instanceof JTextField) {
					JTextField jTextField = (JTextField)studentDetailDTO.getjComponent();
					jTextField.addKeyListener(this);
					modiText.add(jTextField);
					
				}
				gbAdd(studentDetailDTO.getjComponent(),studentDetailDTO.getX(),studentDetailDTO.getY(),
						studentDetailDTO.getW(),studentDetailDTO.getH(),new Insets(0, 0, 0, 0),align,border,arrayData.get(i).getjPanel());
				j++;
			}
			i++;
		}

	}
	
	private void panelCombine() {
		boardPanel.add(setMenu(),"North");
		
		dataSeting();
		for (StudentDetailDTO studentDetailDTO : arrayData) {
			subBoardPanel.add(studentDetailDTO.getjScrollPane(),studentDetailDTO.getPlace());
		}
		boardPanel.add(subBoardPanel,"Center");
		
		boardPanel.add(setFoot(),"South");
		boardPanel.setAlignmentX(100);
		containerPane.add(boardPanel);
		setSize(1000,1050);
		Seting.getInstance(this);
	}
	

	

	
	private JPanel setFoot() {
		JPanel footPanel = new JPanel(new FlowLayout(1,50,30));
		
		backButton = new JButton("뒤로");
		backButton.addActionListener(this);
		backButton.setPreferredSize(new Dimension(150, 40));
		
		nSave = new JButton("서술형 점수저장");
		nSave.addActionListener(this);
		nSave.setPreferredSize(new Dimension(150, 40));
	
		footPanel.add(backButton);
		footPanel.add(nSave);
		
		return footPanel;
	}
	
	void gbAdd(JComponent object, int x, int y, int w, int h,Insets insets,int align, Border border,JPanel jPanel) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.insets = insets;

		if (object instanceof JButton) {
			((AbstractButton) object).setHorizontalAlignment(align);
			object.setFont(font);
		} else if ((object instanceof JLabel)) {
			((JLabel) object).setHorizontalAlignment(align);
			object.setFont(font);
		} else if ((object instanceof JTextField)) {
			((JTextField) object).setHorizontalAlignment(align);
			object.setFont(new Font("Serif", Font.BOLD, 16));
		}
		
		object.setBorder(border);
		object.setPreferredSize(new Dimension(objectWidth*w, objectHeight*h));
		jPanel.add(object, gbc);
	}

	private JLabel setMenu() {
		examData = dao.examData(examNumber,id);
		
		jLabel = new JLabel(examData.get("title")+"/"+examData.get("exam_number")+"/"+examData.get("reg_date")+"/"+examData.get("name"));
		jLabel.setFont(font);
		jLabel.setHorizontalAlignment(align);
		
		return jLabel;
	}
	
	public static void main(String[] args) {
		StudentDetail2 list = new StudentDetail2(50, 40,"13579","bittap");
		list.setUi();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int sum = 0;
		for (JTextField jTextField : modiText) {
			if(e.getSource() == jTextField) 
			{
				// 숫자만 받기
				if(e.getKeyChar() < 0x30 || e.getKeyChar() > 0x39) 
				{
					jTextField.setText("");
				}
				
			}
			if(!jTextField.getText().equals("")) sum = sum+Integer.parseInt(jTextField.getText());
			
		}
		totalNum.setText(String.valueOf(sum));
		
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton)
		{
			this.dispose();
			ScreenManager.studentDetail(examNumber, id);
		}else {
			DataBase dataBase = new DataBase();
			for (JTextField jTextField : modiText) {
				Map<String, String> tempMap = new HashMap<String, String>();
				tempMap.put("score", jTextField.getText());
				tempMap.put("score_yn", "Y");
				String where = "id = '"+id+"' and num = '"+jTextField.getName()+"'";
				dataBase.update("problem_n", tempMap, where);
			}
			JOptionPane.showMessageDialog(this, "점수가 변경되었습니다.","Message",JOptionPane.PLAIN_MESSAGE);
			dataBase.disConn();
		}
	}
	
}
