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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import answer.Answer;
import common.Seting;
import screen.ScreenManager;

public class List extends JFrame implements ActionListener {
	Container containerPane;
	JPanel boardPanel,menuPanel,bodyPanel;
	JButton answerRegisterButton,listButton;
	JLabel jLabel;
	String topName = "답안설정/현황";
	Font font = new Font("Serif",Font.BOLD,16);
	int align = (int) JFrame.CENTER_ALIGNMENT;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Dimension dimension;
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	public List(int objectWidth, int objectHeight) {
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
		boardPanel.setAlignmentX(100);
		containerPane.add(boardPanel);
		setSize(350,400);
		Seting.getInstance(this);
	}
	
	private JPanel setBody() {
		bodyPanel = new JPanel();
		gb = new GridBagLayout();
		bodyPanel.setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        ArrayList<JButton> jBody = new ArrayList<JButton>();
        answerRegisterButton = new JButton("답안설정");
        listButton = new JButton("리스트");
        
        answerRegisterButton.addActionListener(this);
        listButton.addActionListener(this);
        
		jBody.add(answerRegisterButton);
		jBody.add(listButton);
		
		for (int i = 0; i < jBody.size(); i++) {
			gbAdd(jBody.get(i),0,i,1,1,bodyPanel);
		}
		
		return bodyPanel;
	}
	
	void gbAdd(JComponent object, int x, int y, int w, int h,JPanel panel) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.insets = new Insets(0, 0, 20, 0);
		object.setFont(font);
		object.setPreferredSize(dimension);
		panel.add(object, gbc);
	}

	private JLabel setMenu() {
		jLabel = new JLabel(topName);
		jLabel.setFont(font);
		jLabel.setHorizontalAlignment(align);
		
		return jLabel;
	}
	
	public static void main(String[] args) {
		List list = new List(250, 50);
		list.setUi();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		
		if(e.getSource() == answerRegisterButton)
		{
			ScreenManager.answer(false, "");
		}
		else if(e.getSource() == listButton)
		{
			ScreenManager.exam();
		}
	}
	
	
}
