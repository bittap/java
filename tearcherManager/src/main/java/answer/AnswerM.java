package answer;

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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import answerDAO.AnswerCommonDAO;
import answerDAO.AnswerMDAO;
import answerDTO.AnswerMDTO;
import common.Common;
import common.Seting;
import database.DataBase;
import screen.ScreenManager;

public class AnswerM extends JFrame implements ActionListener,KeyListener,ItemListener {
	Container containerPane;
	JPanel boardPanel,menuPanel,bodyPanel,footPanel,subBoardPanel,subTopPanel,bodySubPanel1;
	JLabel jLabel,totalJLabel;
	JScrollPane jScrollPane;
	String topName = "객관식답안설정";
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
	JComboBox<String> mCount,answerSizeArrCount;
	ArrayList<AnswerMDTO> mdto;
	JTextField jTextField;
	int totalNum;
	String examNumber;
	AnswerMDAO dao = new AnswerMDAO();
	AnswerCommonDAO commDao = new AnswerCommonDAO();
	
	
	public AnswerM(int objectWidth, int objectHeight,boolean modifyFlag, String examNumber) {
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
		
		totalNum = dao.totalNumber(this.examNumber);
	}
	
	public void setUi() {
		panelCombine();
	}
	
	private void panelCombine() {
		boardPanel.add(setMenu(),"North");
		if(modifyFlag)
		{
			subBoardPanel.add(setTop2(50,5),"North");
			subBoardPanel.add(setBody2(),"Center");
		}
		else
		{
			subBoardPanel.add(setTop(50,5),"North");
			subBoardPanel.add(setBody(),"Center");
		}
		boardPanel.add(subBoardPanel,"Center");
		boardPanel.add(setFoot(),"South");
		boardPanel.setAlignmentX(100);
		containerPane.add(boardPanel);
		setSize(1200,1200);
		Seting.getInstance(this);
	}
	
	private JPanel setTop(int size,int answerSize) {
		subTopPanel = new JPanel();
		subTopPanel.setLayout(gb);
		size = size+1;
		answerSize = answerSize+1;
		String[] mArr = new String[size];
		mArr[0] = "문제수";
		for (int i = 1; i < mArr.length; i++) {
			mArr[i] = String.valueOf(i);
		}
		mCount = new JComboBox<String>(mArr);
		mCount.addItemListener(this);
		String[] answerSizeArr = new String[answerSize];
		answerSizeArr[0] = "답안항목";
		for (int i = 1; i < answerSizeArr.length; i++) {
			answerSizeArr[i] = String.valueOf(i);
		}
		answerSizeArrCount = new JComboBox<String>(answerSizeArr);
		answerSizeArrCount.addItemListener(this);
		gbAdd(mCount,0,0,1,1,new Insets(0, 0, 0, 10),align,BorderFactory.createEtchedBorder(),subTopPanel);
		gbAdd(answerSizeArrCount,1,0,1,1,new Insets(0, 0, 0, 0),align,BorderFactory.createEtchedBorder(),subTopPanel);
		
		return subTopPanel;
	}
	
	private JPanel setTop2(int size,int answerSize) {
		Map<String, String> map = commDao.selExamData(examNumber);
		subTopPanel = new JPanel();
		subTopPanel.setLayout(gb);
		size = size+1;
		answerSize = answerSize+1;
		String[] mArr = new String[size];
		mArr[0] = "문제수";
		for (int i = 1; i < mArr.length; i++) {
			mArr[i] = String.valueOf(i);
		}
		mCount = new JComboBox<String>(mArr);
		mCount.setSelectedIndex(Integer.valueOf(map.get("num_m")));
		mCount.addItemListener(this);
		String[] answerSizeArr = new String[answerSize];
		answerSizeArr[0] = "답안항목";
		for (int i = 1; i < answerSizeArr.length; i++) {
			answerSizeArr[i] = String.valueOf(i);
		}
		answerSizeArrCount = new JComboBox<String>(answerSizeArr);
		answerSizeArrCount.setSelectedIndex(Integer.valueOf(map.get("item_m")));
		answerSizeArrCount.addItemListener(this);
		gbAdd(mCount,0,0,1,1,new Insets(0, 0, 0, 10),align,BorderFactory.createEtchedBorder(),subTopPanel);
		gbAdd(answerSizeArrCount,1,0,1,1,new Insets(0, 0, 0, 0),align,BorderFactory.createEtchedBorder(),subTopPanel);
		
		return subTopPanel;
	}
	
	private JPanel setBody() {
		
		bodyPanel = new JPanel(new BorderLayout(0, 2));
		bodySubPanel1 = new JPanel();
		bodySubPanel1.setLayout(gb);
		
		gbAdd(new JLabel("답안설정"),0,0,3,1,new Insets(0, 0, 20, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("번호"),0,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("답안"),1,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("배점"),2,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);

		bodyPanel.add(bodySubPanel1,"North");
		bodyPanel.setSize(300,500);

		
		return bodyPanel;
	}
	
	private JPanel setBody2() {
		
		setBody();

		List<Map<String, String>> mapList = commDao.selExamMData(examNumber,"exam_m");
		JPanel bodySubPanel2 = new JPanel();
		bodySubPanel2.setLayout(gb);
		bodySeting(bodySubPanel2);
		
		int answerSize = Integer.parseInt(String.valueOf(answerSizeArrCount.getSelectedItem()));
		Integer[] temp = new Integer[answerSize];
		for (int i = 1; i <= temp.length; i++) {
			temp[i-1] = i;
		}
		mdto = new ArrayList<AnswerMDTO>(); 
		int ySize = Integer.parseInt(String.valueOf(mCount.getSelectedItem()));
		int sum = 0;
		for (int i = 1; i <= ySize; i++) {
			JComboBox<Integer> jComboBox = new JComboBox<Integer>(temp);
			System.out.println(Integer.parseInt(mapList.get(i-1).get("solution")));
			jComboBox.setSelectedIndex(Integer.parseInt(mapList.get(i-1).get("solution"))-1);
			jTextField = new JTextField(mapList.get(i-1).get("score"));
			jTextField.addKeyListener(this);
			mdto.add(new AnswerMDTO(jComboBox, i, jTextField));
			gbAdd(new JLabel(String.valueOf(i)),0,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			gbAdd(jComboBox,1,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			gbAdd(jTextField,2,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			sum += Integer.parseInt(mapList.get(i-1).get("score"));
			if(i == ySize) 
			{
				totalJLabel = new JLabel(String.valueOf(sum));
				gbAdd(new JLabel("총점("+totalNum+")"),0,i,2,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
				gbAdd(totalJLabel,2,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			}
			
		}

		bodyPanel.remove(jScrollPane);
		bodyPanel.add(jScrollPane,"Center");
		bodyPanel.revalidate();
		bodyPanel.repaint();

		
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
			object.setFont(font);
		} else if ((object instanceof JLabel)) {
			((JLabel) object).setHorizontalAlignment(align);
			object.setFont(font);
		} else if ((object instanceof JTextField)) {
			((JTextField) object).setHorizontalAlignment(align);
			object.setFont(new Font("Serif", Font.BOLD, 16));
		}
		
		object.setBorder(border);
		object.setPreferredSize(dimension);
		jPanel.add(object, gbc);
	}

	private JLabel setMenu() {
		jLabel = new JLabel(topName);
		jLabel.setFont(font);
		jLabel.setHorizontalAlignment(align);
		
		return jLabel;
	}
	
	public static void main(String[] args) {
		AnswerM list = new AnswerM(150, 40,true,"13579");
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
			if(!Common.isStringInt(String.valueOf(answerSizeArrCount.getSelectedItem()))) 
			{
				JOptionPane.showMessageDialog(this, "답안항목을 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				answerSizeArrCount.requestFocus();
				return;
			}
			int sum = 0;
			for (AnswerMDTO answerMDTO : mdto) {
				if(answerMDTO.getjTextField().getText().equals("")) {
					JOptionPane.showMessageDialog(this, "배점을 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
					answerMDTO.getjTextField().requestFocus();
					return;
				}else {
					sum = sum+Integer.parseInt(answerMDTO.getjTextField().getText());
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
				map.put("solution", String.valueOf(mdto.get(i).getjComboBox().getSelectedItem()));
				map.put("score", mdto.get(i).getjTextField().getText());
				if(!AnswerCommonDAO.insertOrUpdate(this, modifyFlag, map,examNumber,"exam_m",String.valueOf(mdto.get(i).getNum()))) 
				{
					JOptionPane.showMessageDialog(this, "오류가 발생했습니다. 관리자에게 문의해주세요","Message",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
			
			HashMap<String, String> updateMap = new HashMap<String, String>();
			updateMap.put("num_m", String.valueOf(mCount.getSelectedItem()));
			updateMap.put("item_m", String.valueOf(answerSizeArrCount.getSelectedItem()));
			AnswerCommonDAO.mndUpdate(this,updateMap,examNumber);
			
			JOptionPane.showMessageDialog(this, "객관식시험이 완료됐습니다.","Message",JOptionPane.PLAIN_MESSAGE);
			dispose();
			ScreenManager.answerS(modifyFlag, examNumber);
		}
	}
	
	public void bodySeting(JPanel jpanel) {
		jScrollPane.setViewportView(jpanel);
		jScrollPane.setPreferredSize(new Dimension(500, 500));
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getStateChange() == ItemEvent.SELECTED) 
		{
			if(e.getSource() == mCount) 
			{
				if(!Common.isStringInt(String.valueOf(answerSizeArrCount.getSelectedItem()))) 
				{
					JOptionPane.showMessageDialog(this, "답안항목을 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
					answerSizeArrCount.requestFocus();
					return;
				}

			}
			if(e.getSource() == answerSizeArrCount) 
			{
				if(!Common.isStringInt(String.valueOf(mCount.getSelectedItem()))) 
				{
					JOptionPane.showMessageDialog(this, "문제수를 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
					mCount.requestFocus();
					return;
				}
			}
			if(Common.isStringInt(String.valueOf(answerSizeArrCount.getSelectedItem())) && Common.isStringInt(String.valueOf(mCount.getSelectedItem())))
			{
				JPanel bodySubPanel2 = new JPanel();
				bodySubPanel2.setLayout(gb);
				bodySeting(bodySubPanel2);
				totalJLabel = new JLabel();
					
				int answerSize = Integer.parseInt(String.valueOf(answerSizeArrCount.getSelectedItem()));
				Integer[] temp = new Integer[answerSize];
				for (int i = 1; i <= temp.length; i++) {
					temp[i-1] = i;
				}
				mdto = new ArrayList<AnswerMDTO>(); 
				int ySize = Integer.parseInt(String.valueOf(mCount.getSelectedItem()));
				for (int i = 1; i <= ySize; i++) {
					JComboBox<Integer> jComboBox = new JComboBox<Integer>(temp);
					jTextField = new JTextField();
					jTextField.addKeyListener(this);
					mdto.add(new AnswerMDTO(jComboBox, i, jTextField));
					gbAdd(new JLabel(String.valueOf(i)),0,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
					gbAdd(jComboBox,1,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
					gbAdd(jTextField,2,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
					
					if(i == ySize) 
					{
						gbAdd(new JLabel("총점("+totalNum+")"),0,i,2,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
						gbAdd(totalJLabel,2,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
					}
					
				}

				bodyPanel.remove(jScrollPane);
				bodyPanel.add(jScrollPane,"Center");
				bodyPanel.revalidate();
				bodyPanel.repaint();
				
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int sum = 0;
		
		for (AnswerMDTO answerMDTO : mdto) {
			if(answerMDTO.getjTextField() == e.getSource()) 
			{
				// 숫자만 받기
				if(e.getKeyChar() < 0x30 || e.getKeyChar() > 0x39) 
				{
					answerMDTO.getjTextField().setText("");
				}
				
			}
			if(!answerMDTO.getjTextField().getText().equals("")) sum = sum+Integer.parseInt(answerMDTO.getjTextField().getText());
			
		}
		totalJLabel.setText(String.valueOf(sum));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	
}
