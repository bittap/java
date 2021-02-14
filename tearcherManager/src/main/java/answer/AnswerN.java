package answer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import answerDAO.AnswerCommonDAO;
import answerDAO.AnswerNDAO;
import answerDTO.AnswerNDTO;
import common.Common;
import common.Seting;
import database.DataBase;
import screen.ScreenManager;

public class AnswerN extends JFrame implements ActionListener,KeyListener,ItemListener {
	Container containerPane;
	JPanel boardPanel,menuPanel,bodyPanel,footPanel,subBoardPanel,subTopPanel,bodySubPanel1;
	JLabel jLabel,totalJLabel;
	JScrollPane jScrollPane;
	String topName = "서술형답안설정";
	Font font = new Font("Serif",Font.BOLD,16);
	int align = (int) JFrame.CENTER_ALIGNMENT;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Dimension dimension;
	GridBagLayout gb;
	GridBagConstraints gbc;
	public static JTextField jLabelTitle,jLableExam,jLableDate;
	JTextField answerM,answerS,answerN;
	JButton checkButton;
	int objectWidth;
	int objectHeight;
	boolean modifyFlag;
	Calendar c = Calendar.getInstance();
	JComboBox<String> mCount;
	ArrayList<AnswerNDTO> mdto;
	JTextField answerField,scoreField;
	int totalNum;
	String[] ext = {"zip","txt","jar","jpg","jpeg","gif","png"};
	String examNumber;
	AnswerCommonDAO commDao = new AnswerCommonDAO();
	
	public AnswerN(int objectWidth, int objectHeight,boolean modifyFlag, String examNumber) {
		this.objectWidth = objectWidth;
		this.objectHeight = objectHeight;
		this.modifyFlag = modifyFlag;
		this.examNumber = examNumber;
		
		containerPane = getContentPane();
		setLayout(new FlowLayout(1,0,30));
		dimension = new Dimension(objectWidth, objectHeight);
		boardPanel = new JPanel(new BorderLayout(100, 30));
		subBoardPanel = new JPanel(new BorderLayout(100, 30));
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
		gb = new GridBagLayout();

		jScrollPane = new JScrollPane();
		
		AnswerNDAO ndao = new AnswerNDAO();
		totalNum = ndao.totalNumber(this.examNumber);
	}
	
	public void setUi() {
		panelCombine();
	}
	
	private void panelCombine() {
		boardPanel.add(setMenu(),"North");
		if(modifyFlag) 
		{
			subBoardPanel.add(setTop2(50),"North");
			subBoardPanel.add(setBody2(),"Center");
		}else 
		{
			subBoardPanel.add(setTop(50),"North");
			subBoardPanel.add(setBody(),"Center");
		}
		boardPanel.add(subBoardPanel,"Center");
		boardPanel.add(setFoot(),"South");
		boardPanel.setAlignmentX(100);
		containerPane.add(boardPanel);
		setSize(1200,1200);
		Seting.getInstance(this);
	}
	
	private JPanel setTop(int size) {
		subTopPanel = new JPanel();
		subTopPanel.setLayout(gb);
		size = size+1;
		String[] mArr = new String[size];
		mArr[0] = "문제수";
		for (int i = 1; i < mArr.length; i++) {
			mArr[i] = String.valueOf(i);
		}
		mCount = new JComboBox<String>(mArr);
		mCount.addItemListener(this);

		gbAdd(mCount,0,0,5,1,new Insets(0, 0, 0, 10),align,BorderFactory.createEtchedBorder(),subTopPanel);
		
		return subTopPanel;
	}
	
	private JPanel setTop2(int size) {
		Map<String, String> map = commDao.selExamData(examNumber);
		subTopPanel = new JPanel();
		subTopPanel.setLayout(gb);
		size = size+1;
		String[] mArr = new String[size];
		mArr[0] = "문제수";
		for (int i = 1; i < mArr.length; i++) {
			mArr[i] = String.valueOf(i);
		}
		mCount = new JComboBox<String>(mArr);
		mCount.setSelectedIndex(Integer.valueOf(map.get("num_n")));
		mCount.addItemListener(this);

		gbAdd(mCount,0,0,5,1,new Insets(0, 0, 0, 10),align,BorderFactory.createEtchedBorder(),subTopPanel);
		
		return subTopPanel;
	}
	
	private JPanel setBody() {
		
		bodyPanel = new JPanel(new BorderLayout(0, 2));
		bodySubPanel1 = new JPanel();
		bodySubPanel1.setLayout(gb);
		
		gbAdd(new JLabel("답안설정"),0,0,5,1,new Insets(0, 0, 20, 0),align,border,bodySubPanel1);
		
		gbAdd(new JLabel("번호"),0,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("파일형식"),1,1,3,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("배점"),4,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);

		bodyPanel.add(bodySubPanel1,"North");
		bodyPanel.setSize(300,500);

		
		return bodyPanel;
	}
	
	private JPanel setBody2() {
		
		setBody();
		
		List<Map<String, String>> mapList = commDao.selExamMData(examNumber,"exam_n");
		
		
		JPanel bodySubPanel2 = new JPanel();
		bodySubPanel2.setLayout(gb);
		bodySeting(bodySubPanel2);
		totalJLabel = new JLabel();
			
		mdto = new ArrayList<AnswerNDTO>();
		
		int ySize = Integer.parseInt(String.valueOf(mCount.getSelectedItem()));
		int sum = 0;
		for (int i = 1; i <= ySize; i++) {
			int x = 0 ;
			gbAdd(new JLabel(String.valueOf(i)),x++,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
				
			JPanel tempJPanel = new JPanel();
			tempJPanel.setLayout(new GridLayout(3,4));
			ArrayList<JCheckBox> checkBoxs = new ArrayList<JCheckBox>();
			String[] fileForm = mapList.get(i-1).get("file_form").split(",");
			for (String string : ext) {
				JCheckBox jCheckBox = new JCheckBox(string);
				mapList.get(i-1).get("file_form");
				if(Arrays.asList(fileForm).contains(string))jCheckBox.setSelected(true);
				jCheckBox.addItemListener(this);
				checkBoxs.add(jCheckBox);
				tempJPanel.add(jCheckBox);
			}
			gbAdd(tempJPanel,x++,i-1,3,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			
			
			scoreField = new JTextField(mapList.get(i-1).get("score"));
			scoreField.addKeyListener(this);
			gbAdd(scoreField,x+3,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			mdto.add(new AnswerNDTO(checkBoxs, i,scoreField));
			sum += Integer.parseInt(mapList.get(i-1).get("score"));
			if(i == ySize) 
			{
				totalJLabel = new JLabel(String.valueOf(sum));
				gbAdd(new JLabel("총점("+totalNum+")"),0,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
				gbAdd(totalJLabel,2,i,4,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			}
			
		}

		bodyPanel.add(jScrollPane,"Center");
		
		return bodyPanel;
	}
	
	private JPanel setFoot() {
		footPanel = new JPanel(new FlowLayout(1,0,30));
		
		checkButton = new JButton("확인");
		checkButton.addActionListener(this);
		checkButton.setPreferredSize(dimension);
	
		footPanel.add(checkButton);
		
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
			
		} else if ((object instanceof JLabel)) {
			((JLabel) object).setHorizontalAlignment(align);
		} else if ((object instanceof JTextField)) {
			((JTextField) object).setHorizontalAlignment(align);
		}
		
		object.setFont(font);
		object.setBorder(border);
		object.setPreferredSize(new Dimension(objectWidth*w, objectHeight*h));
		jPanel.add(object, gbc);
	}
	
	

	private JLabel setMenu() {
		jLabel = new JLabel(topName);
		jLabel.setFont(font);
		jLabel.setHorizontalAlignment(align);
		
		return jLabel;
	}
	
	public static void main(String[] args) {
		AnswerN list = new AnswerN(150, 40,true,"13579");
		list.setUi();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == checkButton) 
		{
			if(!Common.isStringInt(String.valueOf(mCount.getSelectedItem()))) 
			{
				JOptionPane.showMessageDialog(this, "문제수를 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				mCount.requestFocus();
				return;
			}
			int sum = 0;
			for (AnswerNDTO answerNDTO : mdto) {
				if(answerNDTO.getScore().getText().equals("")) {
					JOptionPane.showMessageDialog(this, "배점을 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
					answerNDTO.getScore().requestFocus();
					return;
				}else {
					sum = sum+Integer.parseInt(answerNDTO.getScore().getText());
				}
			}
			
			if(sum != totalNum) 
			{
				JOptionPane.showMessageDialog(this, "점수가 일치하지 않습니다.","Message",JOptionPane.ERROR_MESSAGE);
				totalJLabel.requestFocus();
				return;
			}
			
			for (int i = 0; i < mdto.size(); i++) {
				
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("exam_number", examNumber);
				map.put("num", String.valueOf(mdto.get(i).getNum()));
				String tmpJcheckBox = "";
				for (JCheckBox jCheckBox : mdto.get(i).getjComboBox()) {
					Object[] str = jCheckBox.getSelectedObjects();
					try {
						tmpJcheckBox = tmpJcheckBox + str[0] + ",";
					} catch (NullPointerException e2) {
						// TODO: handle exception
					}

				}
				tmpJcheckBox = tmpJcheckBox.substring(0, tmpJcheckBox.length()-1);
				map.put("file_form", tmpJcheckBox);
				map.put("score", mdto.get(i).getScore().getText());
				if(!AnswerCommonDAO.insertOrUpdate(this, modifyFlag, map,examNumber,"exam_n",String.valueOf(mdto.get(i).getNum()))) 
				{
					JOptionPane.showMessageDialog(this, "오류가 발생했습니다. 관리자에게 문의해주세요","Message",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
			HashMap<String, String> updateMap = new HashMap<String, String>();
			updateMap.put("num_n", String.valueOf(mCount.getSelectedItem()));
			AnswerCommonDAO.mndUpdate(this,updateMap,examNumber);

			JOptionPane.showMessageDialog(this, "시험이 등록됐습니다.","Message",JOptionPane.PLAIN_MESSAGE);
			dispose();
			ScreenManager.list();
		}
	}
	
	public void bodySeting(JPanel jpanel) {
		jScrollPane.setViewportView(jpanel);
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		jScrollPane.setPreferredSize(new Dimension(500, 500));
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getStateChange() == ItemEvent.SELECTED) 
		{
			if(e.getSource() == mCount) {
				if(Common.isStringInt(String.valueOf(mCount.getSelectedItem())))
				{
					JPanel bodySubPanel2 = new JPanel();
					bodySubPanel2.setLayout(gb);
					bodySeting(bodySubPanel2);
					totalJLabel = new JLabel();
						
					mdto = new ArrayList<AnswerNDTO>();
					
					int ySize = Integer.parseInt(String.valueOf(mCount.getSelectedItem()));
					for (int i = 1; i <= ySize; i++) {
						int x = 0 ;
						gbAdd(new JLabel(String.valueOf(i)),x++,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
							
						JPanel tempJPanel = new JPanel();
						tempJPanel.setLayout(new GridLayout(3,4));
						ArrayList<JCheckBox> checkBoxs = new ArrayList<JCheckBox>();
						for (String string : ext) {
							JCheckBox jCheckBox = new JCheckBox(string);
							jCheckBox.addItemListener(this);
							checkBoxs.add(jCheckBox);
							tempJPanel.add(jCheckBox);
						}
						gbAdd(tempJPanel,x++,i-1,3,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
						
						
						scoreField = new JTextField();
						scoreField.addKeyListener(this);
						gbAdd(scoreField,x+3,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
						mdto.add(new AnswerNDTO(checkBoxs, i,scoreField));
						
						if(i == ySize) 
						{
							gbAdd(new JLabel("총점("+totalNum+")"),0,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
							gbAdd(totalJLabel,2,i,4,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
						}
						
					}
	
					bodyPanel.remove(jScrollPane);
					bodyPanel.add(jScrollPane,"Center");
					bodyPanel.revalidate();
					bodyPanel.repaint();
					
				}
			}
		}else{
			
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int sum = 0;
		
		for (AnswerNDTO answerNDTO : mdto) {
			if(answerNDTO.getScore() == e.getSource()) 
			{
				// 숫자만 받기
				if(e.getKeyChar() < 0x30 || e.getKeyChar() > 0x39) 
				{
					answerNDTO.getScore().setText("");
				}
				
			}
			if(!answerNDTO.getScore().getText().equals("")) sum = sum+Integer.parseInt(answerNDTO.getScore().getText());
			
		}
		totalJLabel.setText(String.valueOf(sum));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	
}
