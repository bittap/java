package swing;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JComboTest {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setLayout(new FlowLayout());
		
		JPanel jPanel = new JPanel();
		JComboBox<String> jComboBox = new JComboBox<String>();
		jComboBox.addItem("너구리");
		jComboBox.addItem("신라면");
		jComboBox.addItem("진라면");
		jPanel.add(jComboBox);
		jFrame.add(jPanel);
		
		jFrame.setVisible(true);
		jFrame.setSize(300, 300);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
	}

}
