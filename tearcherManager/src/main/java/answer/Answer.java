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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePicker;

import answerDAO.AnswerCommonDAO;
import answerDAO.AnswerDAO;
import answerDTO.AnswerDTO;
import common.Common;
import common.Listener;
import common.Seting;
import common.ui.HintConditionTextField;
import common.ui.HintTextField;
import common.ui.HintTextFieldBackup;
import database.DataBase;
import list.Exam;
import list.List;
import screen.ScreenManager;

public class Answer extends JFrame implements ActionListener {
	private static final String HintTextField = null;
	Container containerPane;
	JPanel boardPanel,menuPanel,bodyPanel,footPanel;
	JLabel jLabel;
	DatePicker picker;
	String topName = "답안설정";
	Font font = new Font("Serif",Font.BOLD,16);
	int align = (int) JFrame.CENTER_ALIGNMENT;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Dimension dimension;
	GridBagLayout gb;
	GridBagConstraints gbc;
	public static JTextField jLabelTitle,jLableExam;
	JTextField answerM,answerS,answerN;
	JButton checkButton,backButton;
	int objectWidth;
	int objectHeight;
	boolean modifyFlag;
	Calendar c = Calendar.getInstance();
	String examNumber;
	AnswerDAO dao = new AnswerDAO();
	
	public Answer(int objectWidth, int objectHeight,boolean modifyFlag, String examNumber) {
		this.objectWidth = objectWidth;
		this.objectHeight = objectHeight;
		this.modifyFlag = modifyFlag;
		this.examNumber = examNumber;
		
		containerPane = getContentPane();
		setLayout(new FlowLayout(1,0,30));
		dimension = new Dimension(objectWidth, objectHeight);
		boardPanel = new JPanel(new BorderLayout(100, 30));
		
	}
	
	public void setUi() {
		panelCombine();
	}
	
	private void panelCombine() {
		boardPanel.add(setMenu(),"North");
		boardPanel.add(setBody(),"Center");
		boardPanel.add(setFoot(),"South");
		boardPanel.setAlignmentX(100);
		containerPane.add(boardPanel);
		setSize(700,700);
		Seting.getInstance(this);
	}
	
	// 입력
	private JPanel setBody() {
		
		bodyPanel = new JPanel();
		gb = new GridBagLayout();
		bodyPanel.setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        ArrayList<AnswerDTO> jBody = new ArrayList<AnswerDTO>();
        
        String jLabelTitleVal = "시험제목";
        String jLableExamVal = "시험고유번호";
        String answerMVal = "0";
        String answerSVal = "0";
        String answerNVal = "0";
        jLabelTitle = new HintTextField();
        if(modifyFlag)
        {
        	Map<String, String> dataMap = dao.selExam(examNumber);
        	
        	jLabelTitleVal = dataMap.get("title");
        	jLableExamVal = dataMap.get("exam_number");
        	answerMVal = dataMap.get("total_m");
        	answerSVal = dataMap.get("total_s");
        	answerNVal = dataMap.get("total_n");
        	
        	int[] dateArr = Common.StringArrToIntArr(dataMap.get("enforce_date").split("-"));
        	c.set(dateArr[0], (dateArr[1]-1), dateArr[2]);
        }
        jLabelTitle.setText(jLabelTitleVal);
        jLableExam = new HintConditionTextField(jLableExamVal,0,1);
        	
        picker = new JDatePicker(c);
        picker.setTextEditable(false);
        picker.setShowYearButtons(true);
        
        answerM = new HintConditionTextField(answerMVal,3,1);
        answerS = new HintConditionTextField(answerSVal,3,1);
        answerN = new HintConditionTextField(answerNVal,3,1);

		jBody.add(new AnswerDTO(jLabelTitle, 0, 0, 3, 1, new Insets(0, 0, 20, 0),2,BorderFactory.createEtchedBorder()));
		
		jBody.add(new AnswerDTO(jLableExam, 0, 1, 3, 1, new Insets(0, 0, 20, 0),2,BorderFactory.createEtchedBorder()));

		jBody.add(new AnswerDTO(new JLabel("시험실시날짜"), 0, 2, 1, 1, new Insets(0, 0, 20, 0),2,BorderFactory.createEtchedBorder()));
		jBody.add(new AnswerDTO((JComponent)picker, 1, 2, 2, 1, new Insets(0, 0, 20, 0),2,BorderFactory.createEtchedBorder()));
		
		jBody.add(new AnswerDTO(new JLabel("배점설정"), 0, 3, 3, 1, new Insets(0, 0, 0, 0),align,border));
		
		jBody.add(new AnswerDTO(new JLabel("객관식"), 0, 4, 1, 1, new Insets(0, 0, 0, 0),align,border));
		jBody.add(new AnswerDTO(new JLabel("주관식"), 1, 4, 1, 1, new Insets(0, 0, 0, 0),align,border));
		jBody.add(new AnswerDTO(new JLabel("서술형"), 2, 4, 1, 1, new Insets(0, 0, 0, 0),align,border));
		
		jBody.add(new AnswerDTO(answerM, 0, 5, 1, 1, new Insets(0, 0, 0, 0),align,border));
		jBody.add(new AnswerDTO(answerS, 1, 5, 1, 1, new Insets(0, 0, 0, 0),align,border));
		jBody.add(new AnswerDTO(answerN, 2, 5, 1, 1, new Insets(0, 0, 0, 0),align,border));
		
		
		for (int i = 0; i < jBody.size(); i++) {
			gbAdd(jBody.get(i).getjComponent(),jBody.get(i).getX(),jBody.get(i).getY(),jBody.get(i).getW(),
					jBody.get(i).getH(),jBody.get(i).getInsets(),jBody.get(i).getAlign(),jBody.get(i).getBorder());
		}
		
		return bodyPanel;
	}
	
	private JPanel setFoot() {
		footPanel = new JPanel(null);
		footPanel.setPreferredSize(new Dimension(0, 100));
		
		checkButton = new JButton("확인");
		checkButton.addActionListener(this);
		checkButton.setBounds(50, 25, objectWidth, objectHeight);
		
		backButton = new JButton("뒤로");
		backButton.addActionListener(this);
		backButton.setBounds(250, 25, objectWidth, objectHeight);
		
		footPanel.add(checkButton);
		footPanel.add(backButton);
		
		return footPanel;
	}
	
	void gbAdd(JComponent object, int x, int y, int w, int h,Insets insets,int align, Border border) {
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
		bodyPanel.add(object, gbc);
	}

	private JLabel setMenu() {
		jLabel = new JLabel(topName);
		jLabel.setFont(font);
		jLabel.setHorizontalAlignment(align);
		
		return jLabel;
	}
	
	public static void main(String[] args) {
		Answer list = new Answer(150, 50,true,"13579");
		list.setUi();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == checkButton) 
		{
			
			if(jLabelTitle.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "시험제목을 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				jLabelTitle.requestFocus();
				return;
			}
			if(jLableExam.getText().equals("") )
			{
				JOptionPane.showMessageDialog(this, "시험고유번호를 제대로 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				jLableExam.requestFocus();
				return;
			}
			
			Pattern pattern = Pattern.compile("(^[0-9]*$)");
			Matcher matcher = pattern.matcher(jLableExam.getText());
			if(!matcher.find())
			{
				JOptionPane.showMessageDialog(this, "시험고유번호를 제대로 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				jLableExam.requestFocus();
				return;
			}
			
			if(!modifyFlag) 
			{
				if(dao.dupliExamNumber(jLableExam.getText()) != 0)
				{
					JOptionPane.showMessageDialog(this, "시험번호가 중복됐습니다.","Message",JOptionPane.ERROR_MESSAGE);
					jLableExam.requestFocus();
					return;
				}
			}

			if(answerM.getText().equals("")) 
			{
				JOptionPane.showMessageDialog(this, "객관식점수을 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				answerM.requestFocus();
				return;
			}
			if(answerS.getText().equals("")) 
			{
				JOptionPane.showMessageDialog(this, "주관식점수을 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				answerS.requestFocus();
				return;
			}
			if(answerN.getText().equals("")) 
			{
				JOptionPane.showMessageDialog(this, "서술형점수을 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				answerN.requestFocus();
				return;
			
			}
			
			int sum = Integer.parseInt(answerM.getText())+Integer.parseInt(answerS.getText())+Integer.parseInt(answerN.getText());
			
			if(sum != 100) 
			{
				JOptionPane.showMessageDialog(this, "점수를 합해서 100점이야 합니다.","Message",JOptionPane.ERROR_MESSAGE);

				return;
			}
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("exam_number", jLableExam.getText());
			map.put("title", jLabelTitle.getText());
			
			String today = c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE);
			map.put("reg_date", today);
			
			Calendar data = (Calendar) picker.getModel().getValue();
			String enforce_date = data.get(Calendar.YEAR)+"-"+(data.get(Calendar.MONTH)+1)+"-"+data.get(Calendar.DATE);
			map.put("enforce_date", enforce_date);
			map.put("total_m", answerM.getText());
			map.put("total_s", answerS.getText());
			map.put("total_n", answerN.getText());

			if(!AnswerCommonDAO.insertOrUpdate(this, modifyFlag, map,jLableExam.getText(),"exam","")) 
			{
				JOptionPane.showMessageDialog(this, "오류가 발생했습니다. 관리자에게 문의해주세요","Message",JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(this, "완료 되었습니다.","Message",JOptionPane.PLAIN_MESSAGE);
			dispose();
			ScreenManager.answerM(modifyFlag, jLableExam.getText());
		}else if(e.getSource() == backButton) {
			dispose();
			
			if(modifyFlag) 
			{
				ScreenManager.exam();
			}
			else
			{
				ScreenManager.list();
			}
			
		}
	}
	
	
	
}
