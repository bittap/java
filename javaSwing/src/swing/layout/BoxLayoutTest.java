package swing.layout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class BoxLayoutTest {

	public static void main(String[] args) {
		JRadioButton r1,r2,r3,r4,r5,r6;
		JFrame jFrame = new JFrame();
		jFrame.setSize(300,500);
		jFrame.setLayout(new BorderLayout());
		Box left = Box.createVerticalBox();
		left.add(Box.createVerticalStrut(30));
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(r1 = new JRadioButton("치킨"));
		left.add(r1);
		left.add(Box.createVerticalStrut(30));
		buttonGroup.add(r2 = new JRadioButton("피자"));
		left.add(r2);
		
		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.setBorder(new TitledBorder(new EtchedBorder(),"음식"));
		leftPanel.add(left,BorderLayout.CENTER);
		//jFrame.add(leftPanel);
		
		// 수평배치 박스레아웃 생성
		Box right = Box.createHorizontalBox();
		right.add(Box.createVerticalStrut(30));
		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(r3 = new JRadioButton("너구리"));
		right.add(r3);
		buttonGroup2.add(r4 = new JRadioButton("돼지"));
		right.add(r4);
		buttonGroup2.add(r5 = new JRadioButton("족제비"));
		right.add(r5);
		buttonGroup2.add(r6 = new JRadioButton("붕어"));
		right.add(r6);
		
		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.setBorder(new TitledBorder(new EtchedBorder(),"동물"));
		rightPanel.add(right,BorderLayout.CENTER);
		//jFrame.add(rightPanel);
		
		Box box = Box.createHorizontalBox();
		box.add(leftPanel);
		box.add(rightPanel);
		jFrame.add(box,BorderLayout.CENTER);

		
		
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		jFrame.setLayout(new FlowLayout());
	}

}
