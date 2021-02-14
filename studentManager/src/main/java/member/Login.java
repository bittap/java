package member;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.Security;
import common.Seting;
import common.ui.HintPasswordField;
import common.ui.HintTextFieldBackup;
import common.ui.HintTextField;
import memberDAO.MemberDAO;
import problem.ProblemM;
import screen.ScreenManager;

public class Login extends JFrame implements ActionListener {

	JPanel jPanel,jPanel2;
	JLabel jLabel;
	public static JTextField idText,examNumberText;
	public static JPasswordField passText;
	JButton jButton1,jButton2;
	GridLayout gridLayout;
	public static boolean idTextFlag,passTextFlag,examNumberTextFlag;
	SignUp signUp;
	
	public void create() {
		gridLayout = new GridLayout(6, 1);
		// 열마다의 간격
		gridLayout.setVgap(10);
		jPanel = new JPanel(gridLayout);
		// 상하좌우 간격 주기
		jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		jPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jLabel = new JLabel("수험생 전용");
		jPanel2.add(jLabel);
		
		idText = new HintTextField("아이디를 입력해주세요");
		
		passText = new HintPasswordField("암호를 입력해주세요");
			
		examNumberText = new HintTextField("시험고유번호를 입력해주세요");
		
		jButton1 = new JButton();
		jButton1.setText("로그인");
		jButton1.addActionListener(this);
		
		jButton2 = new JButton();
		jButton2.setText("회원가입");
		jButton2.addActionListener(this);
		
		
		jPanel.add(jPanel2);jPanel.add(idText);
		jPanel.add(passText);jPanel.add(examNumberText);
		jPanel.add(jButton1);jPanel.add(jButton2);
		
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
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				idText.requestFocus();
				return;
			}
			if(passText.getPassword().length == 0)
			{
				JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				passText.requestFocus();
				return;
			}
			if(examNumberText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "수험번호를 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				examNumberText.requestFocus();
				return;
			}
			Pattern pattern = Pattern.compile("(^[0-9]*$)");
			Matcher matcher = pattern.matcher(examNumberText.getText());
			if(!matcher.find()) 
			{
				JOptionPane.showMessageDialog(this, "수험번호는 숫자만 가능합니다.","Message",JOptionPane.ERROR_MESSAGE);
				examNumberText.requestFocus();
				return;
			}
			
			MemberDAO memberDAO = new MemberDAO();
			int chk = memberDAO.login(idText.getText(), security.encryptSHA256(String.valueOf(passText.getPassword())), examNumberText.getText());
			
			switch (chk) {
				case 1:
					JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 불일치합니다.","Message",JOptionPane.ERROR_MESSAGE);
					idText.requestFocus();
					return;
				case 2:
					JOptionPane.showMessageDialog(this, "수험번호가 불일치합니다.","Message",JOptionPane.ERROR_MESSAGE);
					examNumberText.requestFocus();
					return;
				case 3:
					JOptionPane.showMessageDialog(this, "수험번호가 기간만료 되었습니다.","Message",JOptionPane.ERROR_MESSAGE);
					examNumberText.requestFocus();
					return;
				case 4:
					dispose();
					ScreenManager.problemM();
					return;
				default:
					break;
			}
			
			
			
		}
		else if(e.getSource() == jButton2)
		{
			if(signUp == null) {
				signUp = new SignUp();	
			}else {
				signUp.dispose();
				signUp = new SignUp();
			}
		}
	}
	
	public static void main(String[] args) {
		ScreenManager.login();
	}
	
}
