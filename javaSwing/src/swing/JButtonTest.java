package swing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JButtonTest {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setLayout(new FlowLayout());
		
		JPanel jPanel = new JPanel();

		
		JButton jButton = new JButton("Button");
		JButton jButton2 = new JButton("");
		jButton2.setBackground(Color.red);
		
		jPanel.add(jButton);
		jPanel.add(jButton2);
		
		JPanel jPanel2 = new JPanel();

		
		JLabel jLabel = new JLabel("취미");
		JCheckBox jCheckBox = new JCheckBox("운동");
		JCheckBox jCheckBox2 = new JCheckBox("독서");
		
		jPanel2.add(jLabel);
		jPanel2.add(jCheckBox);
		jPanel2.add(jCheckBox2);
		
		JPanel jPanel3 = new JPanel();

		
		JCheckBox jCheckBox3 = new JCheckBox("영화감상");
		JLabel jLabel2 = new JLabel("성별");
		JRadioButton jRadioButton = new JRadioButton("남자");
		
		jPanel3.add(jCheckBox3);
		jPanel3.add(jLabel2);
		jPanel3.add(jRadioButton);
		
		jFrame.add(jPanel);
		jFrame.add(jPanel2);
		jFrame.add(jPanel3);
		
		jFrame.setVisible(true);
		jFrame.setSize(300, 300);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		
		
		
	}

}
