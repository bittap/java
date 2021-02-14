package member;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.Listener;
import common.Security;
import common.Seting;
import common.ui.HintPasswordField;
import common.ui.HintTextFieldBackup;
import list.List;
import screen.ScreenManager;

public class Login extends JFrame implements ActionListener {

	JPanel jPanel,jPanel2;
	JLabel jLabel;
	public static JTextField idText;
	public static JPasswordField passText;
	JButton jButton1,jButton2;
	GridLayout gridLayout;
	public static boolean idTextFlag,passTextFlag,examNumberTextFlag;
	
	public void create() {
		gridLayout = new GridLayout(4, 1);
		// �������� ����
		gridLayout.setVgap(10);
		jPanel = new JPanel(gridLayout);
		// �����¿� ���� �ֱ�
		jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		jPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jLabel = new JLabel("������ ����");
		jPanel2.add(jLabel);
		
		idText = new HintTextFieldBackup("���̵� �Է����ּ���");
		
		passText = new HintPasswordField("��й�ȣ�� �Է����ּ���");
			
		jButton1 = new JButton();
		jButton1.setText("�α���");
		jButton1.addActionListener(this);
	
		
		jPanel.add(jPanel2);jPanel.add(idText);
		jPanel.add(passText);
		jPanel.add(jButton1);
		
		add(jPanel);
		
		setSize(300,400);
		Seting.getInstance(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jButton1)
		{
			Security security = new Security();
			
			if(idText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "���̵� �Է����ּ���.","Message",JOptionPane.ERROR_MESSAGE);
				idText.requestFocus();
				return;
			}
			if(passText.getPassword().length == 0)
			{
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է����ּ���.","Message",JOptionPane.ERROR_MESSAGE);
				passText.requestFocus();
				return;
			}
			
			String sePass =security.encryptSHA256(String.valueOf(passText.getPassword()));

			if(idText.getText().equals("root") && sePass.equals("4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2"))
			{
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "���̵� �Ǵ� ��й�ȣ�� ����ġ�մϴ�.","Message",JOptionPane.ERROR_MESSAGE);
				idText.requestFocus();
				return;
			}
			dispose();
			ScreenManager.list();
		}
	}
	
}
