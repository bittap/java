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
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
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
import common.Seting;
import excel.Excel;
import excelDTO.excelDTO;
import google.drive.DriveManager;
import listDAO.ExamDetailDAO;
import listDTO.ExamDetailDTO;
import screen.ScreenManager;

public class ExamDetail extends JFrame implements ActionListener{
	Container containerPane;
	JPanel boardPanel,menuPanel,subBoardPanel,subTopPanel,bodySubPanel1;
	JLabel jLabel,totalJLabel,fileJLable;
	JScrollPane jScrollPane;
	String topName = "리스트";
	Font font = new Font("Serif",Font.BOLD,16);
	int align = (int) JFrame.CENTER_ALIGNMENT;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Dimension dimension;
	GridBagLayout gb;
	GridBagConstraints gbc;
	public static JTextField jLabelTitle,jLableExam,jLableDate;
	JTextField answerM,answerS,answerN;
	JButton backButton,excelButton,openButton,submitButton;
	int objectWidth;
	int objectHeight;
	Calendar c = Calendar.getInstance();
	JComboBox<String> mCount,answerSizeArrCount;
	ArrayList<ExamDetailDTO> dto;
	ExamDetailDAO dao = new ExamDetailDAO();
	JTextField jTextField;
	String examNumber;
	Map<String,String> examData;
	List<Map<String,String>> list;
	File file;
	
	public ExamDetail(int objectWidth, int objectHeight, String examNumber) {
		this.objectWidth = objectWidth;
		this.objectHeight = objectHeight;
		this.examNumber = examNumber;
		
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
		
		list = dao.totalExam(examNumber);
	}
	
	public void setUi() {
		panelCombine();
	}
	
	private void panelCombine() {
		boardPanel.add(setMenu(),"North");
		subBoardPanel.add(setTop(),"North");
		subBoardPanel.add(setBody(),"Center");
		boardPanel.add(subBoardPanel,"Center");
		boardPanel.add(setFoot(),"South");
		boardPanel.setAlignmentX(100);
		containerPane.add(boardPanel);
		setSize(1200,1200);
		Seting.getInstance(this);
	}
	
	private JPanel setTop() {
		subTopPanel = new JPanel();
		subTopPanel.setLayout(gb);

		gbAdd(new JLabel("이름"),0,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		gbAdd(new JLabel("객관식"),1,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		gbAdd(new JLabel("주관식"),2,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		gbAdd(new JLabel("서술형"),3,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		gbAdd(new JLabel("총점"),4,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		gbAdd(new JLabel("상세내역"),5,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		
		return subTopPanel;
	}
	
	private JScrollPane setBody() {
		
		bodySubPanel1 = new JPanel();
		bodySubPanel1.setLayout(gb);
		
		jScrollPane.setViewportView(bodySubPanel1);
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane.setPreferredSize(new Dimension(500, 500));
		
		dto = new ArrayList<ExamDetailDTO>();
		
		for (int i = 0; i < list.size(); i++) 
		{
			// 키 벨류 확인
			/*
			Set<String> keySet = list.get(i).keySet();
			Iterator<String> iterator = keySet.iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.printf("%s = %s\n",key,list.get(i).get(key));
			}
			System.out.println();
			*/
			JButton detailButton = new JButton("상세");
			detailButton.addActionListener(this);
			
			gbAdd(new JLabel(list.get(i).get("name")),0,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			gbAdd(new JLabel(list.get(i).get("m_score")),1,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			gbAdd(new JLabel(list.get(i).get("s_score")),2,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			gbAdd(new JLabel(list.get(i).get("n_score")),3,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			gbAdd(new JLabel(list.get(i).get("total_score")),4,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			gbAdd(detailButton,5,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			
			dto.add(new ExamDetailDTO(list.get(i).get("id"),detailButton));
		}

		return jScrollPane;
	}
	
	private JPanel setFoot() {
		JPanel footJPanel = new JPanel(new BorderLayout(0,20));
		
		JPanel footTopPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));
		
		fileJLable = new JLabel("엑셀파일");
		fileJLable.setPreferredSize(dimension);
		
		openButton = new JButton("열기");
		openButton.addActionListener(this);
		openButton.setPreferredSize(dimension);
		
		submitButton = new JButton("전송");
		submitButton.addActionListener(this);
		submitButton.setPreferredSize(dimension);
		
		JPanel footBottomPanel = new JPanel(new FlowLayout(1,100,30));
		
		excelButton = new JButton("엑셀출력");
		excelButton.addActionListener(this);
		excelButton.setPreferredSize(dimension);
		
		backButton = new JButton("뒤로");
		backButton.addActionListener(this);
		backButton.setPreferredSize(dimension);
		
		footTopPanel.add(fileJLable);
		footTopPanel.add(openButton);
		footTopPanel.add(submitButton);
	
		footBottomPanel.add(excelButton);
		footBottomPanel.add(backButton);
		
		footJPanel.add(footTopPanel,"North");
		footJPanel.add(footBottomPanel,"South");
		
		return footJPanel;
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
		examData = dao.examData(examNumber);
		
		jLabel = new JLabel(examData.get("title")+"/"+examData.get("exam_number")+"/"+examData.get("reg_date"));
		jLabel.setFont(font);
		jLabel.setHorizontalAlignment(align);
		
		return jLabel;
	}
	
	public static void main(String[] args) {
		ExamDetail list = new ExamDetail(150, 40,"13579");
		list.setUi();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton)
		{
			this.dispose();
			ScreenManager.exam();
		}else if(e.getSource() == excelButton){
			ArrayList<excelDTO> exDTO = new ArrayList<excelDTO>();
			// 첫번째 시트
			exDTO.add(new excelDTO("상세내역", dao.excelTotalExam(examNumber)));
			// 각 이름별 상세시트
			for (int i = 0; i < list.size(); i++) {
				exDTO.add(new excelDTO(list.get(i).get("name"), dao.excelDetail(examNumber,list.get(i).get("id"))));
			}
			Excel excel = new Excel();
			excel.wirte(exDTO, examData.get("title"));
		}else if(e.getSource() == openButton){
			JFileChooser fc = new JFileChooser();
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
			fc.addChoosableFileFilter(filter);
			fc.setAcceptAllFileFilterUsed(false);
			
			int returnVal = fc.showOpenDialog(this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION) 
			{
				file = fc.getSelectedFile();
				fileJLable.setText(file.getName());
			}
		}else if(e.getSource() == submitButton){
			try {
				String[] folName = {"file",examNumber};
				DriveManager driveManager = new DriveManager(folName);
				driveManager.fileUplod(file.getName(), file);
				JOptionPane.showMessageDialog(this, "파일 전송이 완료 되었습니다.","Message",JOptionPane.PLAIN_MESSAGE);
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(this, "파일을 넣어주세요","Message",JOptionPane.ERROR_MESSAGE);
			}
		}else {
			for (ExamDetailDTO examDTO : dto) {
				// 상세
				if(e.getSource() == examDTO.getDetailButton()) 
				{
					this.dispose();
					ScreenManager.studentDetail(examNumber, examDTO.getId());
				}
			}
		}
	}
	
}
