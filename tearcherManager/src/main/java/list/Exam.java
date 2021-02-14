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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import answer.Answer;
import answerDAO.AnswerMDAO;
import common.Seting;
import listDAO.ExamDAO;
import listDTO.ExamDTO;
import screen.ScreenManager;

public class Exam extends JFrame implements ActionListener{
	Container containerPane;
	JPanel boardPanel,menuPanel,footPanel,subBoardPanel,subTopPanel,bodySubPanel1;
	JLabel jLabel,totalJLabel;
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
	JButton backButton;
	int objectWidth;
	int objectHeight;
	Calendar c = Calendar.getInstance();
	JComboBox<String> mCount,answerSizeArrCount;
	ArrayList<ExamDTO> dto;
	ExamDAO dao = new ExamDAO();
	JTextField jTextField;
	
	public Exam(int objectWidth, int objectHeight) {
		this.objectWidth = objectWidth;
		this.objectHeight = objectHeight;
		
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

		gbAdd(new JLabel("제목"),0,0,2,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		gbAdd(new JLabel("시험고유번호"),2,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		gbAdd(new JLabel("실시날짜"),3,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		gbAdd(new JLabel("서술형채점현황"),4,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		gbAdd(new JLabel("수정"),5,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		gbAdd(new JLabel("상세"),6,0,1,1,new Insets(0, 0, 0, 0),align,border,subTopPanel);
		
		return subTopPanel;
	}
	
	private JScrollPane setBody() {
		
		bodySubPanel1 = new JPanel();
		bodySubPanel1.setLayout(gb);
		
		jScrollPane.setViewportView(bodySubPanel1);
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane.setPreferredSize(new Dimension(500, 500));
		
		dto = new ArrayList<ExamDTO>();
		List<Map<String,String>> list = dao.totalExam();
		for (int i = 0; i < list.size(); i++) 
		{
			/* 키 벨류 확인
			Set<String> keySet = list.get(i).keySet();
			Iterator<String> iterator = keySet.iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.printf("%s = %s\n",key,list.get(i).get(key));
			}
			System.out.println();
			*/
			JButton modifyButton = new JButton("수정");
			JButton detailButton = new JButton("상세");
			modifyButton.addActionListener(this);
			detailButton.addActionListener(this);
			
			gbAdd(new JLabel(list.get(i).get("title")),0,i,2,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			gbAdd(new JLabel(list.get(i).get("exam_number")),2,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			gbAdd(new JLabel(list.get(i).get("enforce_date")),3,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			gbAdd(new JLabel(list.get(i).get("n_exestudentnum")+"/"+list.get(i).get("n_allstudentnum")),4,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			gbAdd(modifyButton,5,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			gbAdd(detailButton,6,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
			
			dto.add(new ExamDTO(list.get(i).get("exam_number"),modifyButton,detailButton));
		}

		return jScrollPane;
	}
	
	private JPanel setFoot() {
		footPanel = new JPanel(new FlowLayout(1,0,30));
		
		backButton = new JButton("뒤로");
		backButton.addActionListener(this);
		backButton.setPreferredSize(dimension);
	
		footPanel.add(backButton);
		
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
		jLabel = new JLabel(topName);
		jLabel.setFont(font);
		jLabel.setHorizontalAlignment(align);
		
		return jLabel;
	}
	
	public static void main(String[] args) {
		ScreenManager.exam();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		if(e.getSource() == backButton)
		{
			ScreenManager.list();
		}else {
			for (ExamDTO examDTO : dto) {
				// 수정 
				if(e.getSource() == examDTO.getModifyButton()) 
				{
					ScreenManager.answer(true,examDTO.getExamNumber());
				}
				// 상세
				else if(e.getSource() == examDTO.getDetailButton()) 
				{
					ScreenManager.examDetail(examDTO.getExamNumber());
				}
			}
		}
	}
	
}
