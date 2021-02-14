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
		
		buttonGroup.add(r1 = new JRadioButton("ġŲ"));
		left.add(r1);
		left.add(Box.createVerticalStrut(30));
		buttonGroup.add(r2 = new JRadioButton("����"));
		left.add(r2);
		
		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.setBorder(new TitledBorder(new EtchedBorder(),"����"));
		leftPanel.add(left,BorderLayout.CENTER);
		//jFrame.add(leftPanel);
		
		// �����ġ �ڽ����ƿ� ����
		Box right = Box.createHorizontalBox();
		right.add(Box.createVerticalStrut(30));
		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(r3 = new JRadioButton("�ʱ���"));
		right.add(r3);
		buttonGroup2.add(r4 = new JRadioButton("����"));
		right.add(r4);
		buttonGroup2.add(r5 = new JRadioButton("������"));
		right.add(r5);
		buttonGroup2.add(r6 = new JRadioButton("�ؾ�"));
		right.add(r6);
		
		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.setBorder(new TitledBorder(new EtchedBorder(),"����"));
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
