package swing;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class JTextFieldTest {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setSize(300,500);

		
		EtchedBorder etchedBorder = new EtchedBorder();
		JLabel jLabel = new JLabel("���̵�� �н����带 �Է��� �ּ���.");
		jLabel.setBorder(etchedBorder);
		jFrame.add(jLabel);
		
		JPanel idjP = new JPanel();
		JLabel idjL = new JLabel("���̵�");
		JTextField idjT = new JTextField(10);
		idjP.add(idjL);
		idjP.add(idjT);
		jFrame.add(idjP);

		
		JPanel psJP = new JPanel();
		JLabel psJL = new JLabel("�н�����");
		JTextField psJT = new JTextField(10);
		psJP.add(psJL);
		psJP.add(psJT);
		jFrame.add(psJP);
		
		JPanel loginJP = new JPanel();
		JButton idButton = new JButton("�α���");
		JButton passButton = new JButton("ȸ������");
		loginJP.add(idButton);
		loginJP.add(passButton);
		jFrame.add(loginJP);
		
		JTextArea jTextArea = new JTextArea(3,20);
		JScrollPane jScrollPane = new JScrollPane(jTextArea);
		jFrame.add(jScrollPane);
		
		
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		jFrame.setLayout(new FlowLayout());
	}

}
