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
		
		menuLabel = new JLabel("ȸ������");
		menuLabel.setFont(new Font("Serif",Font.BOLD,16));
		menuLabel.setBounds(250, 30, 100, 20);
		add(menuLabel);
	
		// 1��
		idLable = new JLabel("���̵�");
		idLable.setBounds(100, 70, 200, 30);
		add(idLable);
		
		nameLabel = new JLabel("�̸�");
		nameLabel.setBounds(100, 110, 200, 30);
		add(nameLabel);
		
		passLabel = new JLabel("��й�ȣ");
		passLabel.setBounds(100, 150, 200, 30);
		add(passLabel);
		
		passCheckLabel = new JLabel("��й�ȣ Ȯ��");
		passCheckLabel.setBounds(100, 190, 200, 30);
		add(passCheckLabel);
		
		birthdayLabel = new JLabel("<html>������� <br/>ex)780819</html>");
		birthdayLabel.setBounds(100, 230, 200, 30);
		add(birthdayLabel);
		
		// 2��
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
		
		//3��
		checkButton = new JButton("�ߺ��˻�");
		checkButton.setBounds(410, 70, 100, 30);
		add(checkButton);
		checkButton.addActionListener(this);
		
		passConLabel = new JLabel("<html>��(��,�ҹ�)��, ���ڸ� <br>7�� �̻� 10�� ����</html>");
		passConLabel.setBounds(410, 150, 300, 40);
		add(passConLabel);
		
		buttonGroup = new ButtonGroup();
		
		man = new JRadioButton("��",true);
		woman = new JRadioButton("��");
		
		buttonGroup.add(man);
		buttonGroup.add(woman);
		
		sexPanel = new JPanel(new FlowLayout());
		sexPanel.setBounds(410, 230, 100, 30);
		sexPanel.add(man);
		sexPanel.add(woman);
		
		add(sexPanel);
		
		backButton = new JButton("�ݱ�");
		backButton.setBounds(100, 300, 200, 40);
		backButton.addActionListener(this);
		add(backButton);
		
		registerButton = new JButton("���");
		registerButton.setBounds(310, 300, 200, 40);
		registerButton.addActionListener(this);
		add(registerButton);


		setSize(600,500);
		Seting.getInstance(this);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// ���� Ű �Էµ��� �ô� ������ ���̵� �ߺ�üũ �� false�� ����
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
				JOptionPane.showMessageDialog(this, "�ߺ��� ���̵� �ֽ��ϴ�.","Message",JOptionPane.ERROR_MESSAGE);
				idChk = false;
			}else {
				JOptionPane.showMessageDialog(this, "�ߺ��� ���̵� �����ϴ�.","Message",JOptionPane.PLAIN_MESSAGE);
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
				JOptionPane.showMessageDialog(this, "���̵� �Է����ּ���.","Message",JOptionPane.ERROR_MESSAGE);
				idTextField.requestFocus();
				return;
			}
			if(!idChk)
			{
				JOptionPane.showMessageDialog(this, "�ߺ��� ���̵� �ְų� �ߺ� üũ�� ���ּ���.","Message",JOptionPane.ERROR_MESSAGE);
				idTextField.requestFocus();
				return;
			}
			if(nameTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "�̸��� �Է����ּ���.","Message",JOptionPane.ERROR_MESSAGE);
				nameTextField.requestFocus();
				return;
			}
			if(passTextField.getPassword().length == 0)
			{
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է����ּ���.","Message",JOptionPane.ERROR_MESSAGE);
				passTextField.requestFocus();
				return;
			}
			else if(passCheckField.getPassword().length == 0)
			{
				JOptionPane.showMessageDialog(this, "��й�ȣȮ�θ� �Է����ּ���.","Message",JOptionPane.ERROR_MESSAGE);
				passCheckField.requestFocus();
				return;
			}
			else
			{
				String password1 = String.valueOf(passTextField.getPassword());
				String password2 = String.valueOf(passCheckField.getPassword());
				
				if(!password1.equals(password2)) 
				{
					JOptionPane.showMessageDialog(this, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.","Message",JOptionPane.ERROR_MESSAGE);
					passTextField.requestFocus();
					return;
				}
				
				Pattern pattern = Pattern.compile("(^[a-zA-Z0-9]{7,10}$)");
				Matcher matcher = pattern.matcher(password1);
				
				if(!matcher.find())
				{
					JOptionPane.showMessageDialog(this, "��й�ȣ ������ ��ġ���� �ʽ��ϴ�.","Message",JOptionPane.ERROR_MESSAGE);
					passTextField.requestFocus();
					return;
				}
			}
			if(birthTextField.getText().equals("") || birthTextField.getText().length() > 6)
			{
				JOptionPane.showMessageDialog(this, "��������� ����� �Է����ּ���.","Message",JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(this, "ȸ�������� �����մϴ�.","Message",JOptionPane.PLAIN_MESSAGE);
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "������ �߻��߽��ϴ�. �����ڿ��� �������ּ���","Message",JOptionPane.ERROR_MESSAGE);
			}
			DataBase.disConn();

		} // end register
			
	}
	
	public static void main(String[] args) {
		SignUp signUp = new SignUp();
	}
	
	
}
