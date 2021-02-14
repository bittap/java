package member;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import common.Security;
import common.Seting;
import common.ui.HintConditionTextField;
import database.DataBase;
import screen.ScreenManager;

public class SignUp extends JFrame implements ActionListener,KeyListener {
	
	JPanel mainJpanel,menuPanel,subJpanel,sexPanel;
	JLabel menuLabel,idLable,passLabel,nameLabel,passCheckLabel,birthdayLabel,passConLabel,spaceLabel1;
	JPasswordField passTextField,passCheckField;
	FlowLayout flowLayout;
	JButton backButton,registerButton,checkButton;
	JTextField idTextField,nameTextField,birthTextField;
	ButtonGroup buttonGroup;
	JRadioButton man,woman;
	boolean idChk,passChk,registerChk;
	
	public SignUp() {
		setLayout(null);
		
		menuLabel = new JLabel("회원가입");
		menuLabel.setFont(new Font("Serif",Font.BOLD,16));
		menuLabel.setBounds(250, 30, 100, 20);
		add(menuLabel);
	
		// 1열
		idLable = new JLabel("아이디");
		idLable.setBounds(100, 70, 200, 30);
		add(idLable);
		
		nameLabel = new JLabel("이름");
		nameLabel.setBounds(100, 110, 200, 30);
		add(nameLabel);
		
		passLabel = new JLabel("비밀번호");
		passLabel.setBounds(100, 150, 200, 30);
		add(passLabel);
		
		passCheckLabel = new JLabel("비밀번호 확인");
		passCheckLabel.setBounds(100, 190, 200, 30);
		add(passCheckLabel);
		
		birthdayLabel = new JLabel("<html>생년월일 <br/>ex)780819</html>");
		birthdayLabel.setBounds(100, 230, 200, 30);
		add(birthdayLabel);
		
		// 2열
		idTextField = new JTextField();
		idTextField.setBounds(200, 70, 200, 30);
		add(idTextField);
		idTextField.requestFocus();
		
		nameTextField = new HintConditionTextField("",3,0);
		nameTextField.setBounds(200, 110, 200, 30);
		add(nameTextField);
		nameTextField.addKeyListener(this);
		
		passTextField = new JPasswordField(10);
		passTextField.setBounds(200, 150, 200, 30);
		add(passTextField);
		
		passCheckField = new JPasswordField(10);
		passCheckField.setBounds(200, 190, 200, 30);
		add(passCheckField);
		
		birthTextField = new HintConditionTextField("",6,1);
		birthTextField.setBounds(200, 230, 200, 30);
		add(birthTextField);
		
		//3열
		checkButton = new JButton("중복검사");
		checkButton.setBounds(410, 70, 100, 30);
		add(checkButton);
		checkButton.addActionListener(this);
		
		passConLabel = new JLabel("<html>영(대,소문)자, 숫자만 <br>7자 이상 10자 이하</html>");
		passConLabel.setBounds(410, 150, 300, 40);
		add(passConLabel);
		
		buttonGroup = new ButtonGroup();
		
		man = new JRadioButton("남",true);
		woman = new JRadioButton("여");
		
		buttonGroup.add(man);
		buttonGroup.add(woman);
		
		sexPanel = new JPanel(new FlowLayout());
		sexPanel.setBounds(410, 230, 100, 30);
		sexPanel.add(man);
		sexPanel.add(woman);
		
		add(sexPanel);
		
		backButton = new JButton("닫기");
		backButton.setBounds(100, 300, 200, 40);
		backButton.addActionListener(this);
		add(backButton);
		
		registerButton = new JButton("등록");
		registerButton.setBounds(310, 300, 200, 40);
		registerButton.addActionListener(this);
		add(registerButton);


		setSize(600,500);
		Seting.getInstance(this);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// 만약 키 입력됐을 시는 무조건 아이디 중복체크 값 false로 변경
		if(e.getSource() == idTextField) 
		{
			idChk = false;
			
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) 
		{
			dispose();
		}
		else if(e.getSource() == checkButton) 
		{
			DataBase DataBase = new DataBase();
			String sql = "SELECT count(*) from member where id = '"+idTextField.getText()+"'";
			boolean checkValue = DataBase.boolSelect(sql);

			if(checkValue) {
				JOptionPane.showMessageDialog(this, "중복된 아이디가 있습니다.","Message",JOptionPane.ERROR_MESSAGE);
				idChk = false;
			}else {
				JOptionPane.showMessageDialog(this, "중복된 아이디가 없습니다.","Message",JOptionPane.PLAIN_MESSAGE);
				idChk = true;
			}
			DataBase.disConn();
		}
		else if(e.getSource() == registerButton) 
		{

			DataBase DataBase = new DataBase();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			String date = format1.format(new Date());
			String sex = "";
			Security security = new Security();
			
			if(idTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				idTextField.requestFocus();
				return;
			}
			if(!idChk)
			{
				JOptionPane.showMessageDialog(this, "중복된 아이디가 있거나 중복 체크를 해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				idTextField.requestFocus();
				return;
			}
			if(nameTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "이름을 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				nameTextField.requestFocus();
				return;
			}
			if(passTextField.getPassword().length == 0)
			{
				JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				passTextField.requestFocus();
				return;
			}
			else if(passCheckField.getPassword().length == 0)
			{
				JOptionPane.showMessageDialog(this, "비밀번호확인를 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				passCheckField.requestFocus();
				return;
			}
			else
			{
				String password1 = String.valueOf(passTextField.getPassword());
				String password2 = String.valueOf(passCheckField.getPassword());
				
				if(!password1.equals(password2)) 
				{
					JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.","Message",JOptionPane.ERROR_MESSAGE);
					passTextField.requestFocus();
					return;
				}
				
				Pattern pattern = Pattern.compile("(^[a-zA-Z0-9]{7,10}$)");
				Matcher matcher = pattern.matcher(password1);
				
				if(!matcher.find())
				{
					JOptionPane.showMessageDialog(this, "비밀번호 형식이 일치하지 않습니다.","Message",JOptionPane.ERROR_MESSAGE);
					passTextField.requestFocus();
					return;
				}
			}
			if(birthTextField.getText().equals("") || birthTextField.getText().length() > 6)
			{
				JOptionPane.showMessageDialog(this, "생년월일을 제대로 입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);
				birthTextField.requestFocus();
				return;
			}

			if(man.isSelected())
			{
				sex = "1";
			}
			else
			{
				sex = "2";
			}
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("id", idTextField.getText());
			map.put("name", nameTextField.getText());
			map.put("password", security.encryptSHA256(String.valueOf(passTextField.getPassword())));
			map.put("birthday", birthTextField.getText());
			map.put("sex", sex);
			map.put("register_date", date);
			
			if(DataBase.insert("member", map)) 
			{
				JOptionPane.showMessageDialog(this, "회원가입을 축하합니다.","Message",JOptionPane.PLAIN_MESSAGE);
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "오류가 발생했습니다. 관리자에게 문의해주세요","Message",JOptionPane.ERROR_MESSAGE);
			}
			DataBase.disConn();

		} // end register
			
	}
	
	public static void main(String[] args) {
		SignUp signUp = new SignUp();
	}
	
	
}
