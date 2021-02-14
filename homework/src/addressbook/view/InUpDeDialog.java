package addressbook.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import addressbook.common.GbSupport;
import addressbook.common.PageKind;
import addressbook.common.Setting;
import addressbook.controller.Ctrl;
import addressbook.dto.AddressDTO;

public class InUpDeDialog extends JDialog {
	private JPanel topPanel,bodyPanel,footPanel;
	private AddressDTO addressDTO;
	public final PageKind KIND; 
	private final String TITLE;
	public JButton actionBtn,closeBtn;
	public List<JTextField> jTextFields; // 0=> 이름, 1 => 메일주소, 2 => 핸드폰번호, 3=> 주소
	private Ctrl ctrlParents = new Ctrl();
	private final Ctrl.inUpDeDialogCtrl CTRL;
	public final JFrame MOTHERFRAME;
	public int nowNumber;
	
	// 삽입
	public InUpDeDialog(PageKind kind, JFrame jFrame) {
		this.KIND = kind;
		this.MOTHERFRAME = jFrame;
		CTRL = ctrlParents.new inUpDeDialogCtrl(this);
		TITLE = "입력";
	}
	
	// 수정, 상세보기
	public InUpDeDialog(AddressDTO addressDTO,PageKind kind,JFrame jFrame) {
		this.KIND = kind;
		this.MOTHERFRAME = jFrame;
		this.addressDTO = addressDTO;
		this.nowNumber = addressDTO.getNum();
		
		CTRL = ctrlParents.new inUpDeDialogCtrl(this);
		if(KIND.toString().equals("MODIFY"))  {
			TITLE = "수정";
		}else {
			TITLE = "상세";
		}
	}
	
	public void setUi() {
		
		setFrame();
		add(setTop(),"North");
		add(setBody(),"Center");
		add(setFoot(),"South");
		Setting.Setting(this);
	}
	
	private void setFrame() {
		this.setLayout(new BorderLayout(0,20));
	}
	
	private JPanel setTop() {
		topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel topTitle = new JLabel(TITLE);
		
		topPanel.add(topTitle);
		
		return topPanel;
	}
	
	private JPanel setBody() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
		GridBagLayout gb = new GridBagLayout();
		bodyPanel = new JPanel(gb);
		bodyPanel.setPreferredSize(new Dimension(Setting.width, 500));
		GbSupport gbSupport = new GbSupport(gbc, bodyPanel, BorderFactory.createEtchedBorder(EtchedBorder.RAISED), (int) JFrame.CENTER_ALIGNMENT, new Font("Serif",Font.BOLD,12), new Dimension(30, 10));
		
		jTextFields = dataSetting();
		
		
		gbSupport.gbAdd(new JLabel("이름"), 0, 0, 1, 1, new Insets(0, 0, 0, 0));
		gbSupport.gbAdd(jTextFields.get(0), 1, 0, 1, 1, new Insets(0, 0, 0, 0));
		
		gbSupport.gbAdd(new JLabel("메일주소"), 0, 1, 1, 1, new Insets(0, 0, 0, 0));
		gbSupport.gbAdd(jTextFields.get(1), 1, 1, 1, 1, new Insets(0, 0, 0, 0));
		
		gbSupport.gbAdd(new JLabel("핸드폰번호"), 0, 2, 1, 1, new Insets(0, 0, 0, 0));
		gbSupport.gbAdd(jTextFields.get(2), 1, 2, 1, 1, new Insets(0, 0, 0, 0));
		
		gbSupport.gbAdd(new JLabel("주소"), 0, 3, 1, 1, new Insets(0, 0, 0, 0));
		gbSupport.gbAdd(jTextFields.get(3), 1, 3, 1, 1, new Insets(0, 0, 0, 0));
		
		return bodyPanel;
	}
	
	private List<JTextField> dataSetting() {
		int fieldCount = 4;
		jTextFields = new ArrayList<JTextField>();
		
		if(KIND.toString().equals("INSERT"))
		{
			for (int i = 0; i < fieldCount; i++) {
				jTextFields.add(new JTextField());
			}
		}
		else
		{
			JTextField nameField = new JTextField(addressDTO.getName());
			JTextField mailField = new JTextField(addressDTO.getMail_address());
			JTextField phoneField = new JTextField(addressDTO.getPhone_number());
			JTextField addressField = new JTextField(addressDTO.getAddress());
			
			jTextFields.add(nameField);
			jTextFields.add(mailField);
			jTextFields.add(phoneField);
			jTextFields.add(addressField);
			
			if(KIND.toString().equals("DETAIL")) 
			{
				for (JTextField jTextField : jTextFields) 
				{
					jTextField.setEditable(false);
				}
			}

		}
		
		return jTextFields;
	}
	
	private JPanel setFoot() {
		footPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		footPanel.setPreferredSize(new Dimension(Setting.width, 100));
		
		if(!KIND.toString().equals("DETAIL"))
		{
			actionBtn = new JButton(TITLE);
			actionBtn.addActionListener(CTRL);
			footPanel.add(actionBtn);
		}
		
		closeBtn = new JButton("닫기");
		closeBtn.addActionListener(CTRL);
		footPanel.add(closeBtn);
		
		
		
		return footPanel;
	}
	
	public static void main(String[] args) {
		//InUpDeDialog inUpDeDialog = new InUpDeDialog(PageKind.DETAIL);
		//inUpDeDialog.setUi();
	}
}
