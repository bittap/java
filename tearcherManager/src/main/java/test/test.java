package test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import answerDTO.AnswerSDTO;
import common.Seting;

/** @see http://stackoverflow.com/questions/5750068 */
public class test extends JFrame {
	Container containerPane;
	JPanel boardPanel,menuPanel,bodyPanel,footPanel,subBoardPanel,subTopPanel,bodySubPanel1;
	JLabel jLabel,totalJLabel;
	JScrollPane jScrollPane;
	String topName = "주관식답안설정";
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
	ArrayList<AnswerSDTO> mdto;
	JTextField answerField,scoreField;
	int totalNum;
	String[] calpitalYN = {"Y","N"};
	int i = 0;

    private void display() {
    	setLayout(new BorderLayout(100, 30));
    	gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
		gb = new GridBagLayout();
		
		subTopPanel = new JPanel();
		subTopPanel.setLayout(gb);
		int size = 5+1;
		String[] mArr = new String[size];
		mArr[0] = "문제수";
		for (int i = 1; i < mArr.length; i++) {
			mArr[i] = String.valueOf(i);
		}
		mCount = new JComboBox<String>(mArr);

		gbAdd(mCount,0,0,1,1,new Insets(0, 0, 0, 10),align,BorderFactory.createEtchedBorder(),subTopPanel);
		
		
		

		
		bodyPanel = new JPanel(new BorderLayout(0, 2));
		bodySubPanel1 = new JPanel();
		bodySubPanel1.setLayout(gb);
		
		gbAdd(new JLabel("답안설정"),0,0,1,1,new Insets(0, 0, 20, 0),align,border,bodySubPanel1);
		
		gbAdd(new JLabel("번호"),0,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("답안"),1,1,2,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("d"),3,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("대소문자구별"),4,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("배점"),5,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);

		bodyPanel.add(bodySubPanel1,"North");
		bodyPanel.setSize(800,500);
		add(subTopPanel,"North");
		add(bodyPanel,"Center");
		setSize(800,800);
		Seting.getInstance(this);
    }
    
    void gbAdd(JComponent object, int x, int y, int w, int h,Insets insets,int align, Border border,JPanel jPanel) {
    	if(i == 0) {
    		object.setPreferredSize(new Dimension(300, 100));
    	}
    	i++;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.insets = insets;

		if (object instanceof JButton) {
			((AbstractButton) object).setHorizontalAlignment(align);
			object.setFont(font);
			object.setPreferredSize(dimension);
		} else if ((object instanceof JLabel)) {
			((JLabel) object).setHorizontalAlignment(align);
			object.setFont(font);
			
		} else if ((object instanceof JTextField)) {
			((JTextField) object).setHorizontalAlignment(align);
			object.setFont(new Font("Serif", Font.BOLD, 16));
			object.setPreferredSize(dimension);
		}
		
		object.setBorder(border);
		
		jPanel.add(object, gbc);
	}

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new test().display();
            }
        });
    }
}

