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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import addressbook.common.GbSupport;
import addressbook.common.Setting;
import addressbook.controller.Ctrl;
import addressbook.dto.AddressDTO;

/*
 * 아쉬운점 1 setBody() 부분이 너무 하드코딩느낌
 * 아쉬운점 2 페이징처리 부분 로직이 완성하긴 했지만 다른사람이 봤을 떄 과연 이해할 수 있는가..
 * 아쉬운점 3 설계할 때 처리가 복잡한 부분은 안 쪽까지 설계는 불가능했음
 */
public class AddressBook extends JFrame {
	private JPanel topPanel,bodyPanel,footPanel;
	public final int PAGENUM = 5; //pageNum = 왼쪽 오른쪽 안에 있는 page갯수
	public final int ITEMNUM = 10; //itemNum = 1페이지당 글 갯수
	private Ctrl.AddressBookCtrl abCtrl = null;
	public  Map<String, List<JButton>> btns;
	public final int NOWPAGENUM;
	
	//nowPageNum = 현재페이지
	public AddressBook(int nowPageNum) {
		this.NOWPAGENUM = nowPageNum;
		Ctrl ctrl = new Ctrl();
		abCtrl = ctrl.new AddressBookCtrl(this);
		
		btns = new HashMap<String, List<JButton>>();
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
		JLabel title = new JLabel("주소록");
		
		topPanel.add(title);
		
		return topPanel;
	}
	
	private JPanel setBody() {
		int x = 0;
		int y = 0;
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
		GridBagLayout gb = new GridBagLayout();
		bodyPanel = new JPanel(gb);
		GbSupport gbSupport = new GbSupport(gbc, bodyPanel, BorderFactory.createEtchedBorder(EtchedBorder.RAISED), (int) JFrame.CENTER_ALIGNMENT, new Font("Serif",Font.BOLD,12), new Dimension(30, 10));
		
		
		gbSupport.gbAdd(new JLabel("번호"), x++, y, 1, 1, new Insets(0, 0, 0, 0));
		gbSupport.gbAdd(new JLabel("이름"), x++, y, 1, 1, new Insets(0, 0, 0, 0));
		gbSupport.gbAdd(new JLabel("메일주소"), x++, y, 2, 1, new Insets(0, 0, 0, 0));
		x++;
		gbSupport.gbAdd(new JLabel("핸드폰번호"), x++, y, 2, 1, new Insets(0, 0, 0, 0));
		x++;
		gbSupport.gbAdd(new JLabel("집주소"), x++, y, 6, 1, new Insets(0, 0, 0, 0));
		x = x+5;
		gbSupport.gbAdd(new JLabel("상세보기"), x++, y, 1, 1, new Insets(0, 0, 0, 0));
		gbSupport.gbAdd(new JLabel("수정"), x++, y, 1, 1, new Insets(0, 0, 0, 0));
		gbSupport.gbAdd(new JLabel("삭제"), x++, y, 1, 1, new Insets(0, 0, 0, 0));
		
		x = 0;
		y++;
		
        List<AddressDTO> list = abCtrl.addressBookSInvoke();
        List<JButton> detailBtns = new ArrayList<>();
        List<JButton> modBtns = new ArrayList<>();
        List<JButton> delBtns = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++) {
        	gbSupport.gbAdd(new JLabel(String.valueOf(list.get(i).getNum())), x++, y, 1, 1, new Insets(0, 0, 0, 0));
        	gbSupport.gbAdd(new JLabel(list.get(i).getName()), x++, y, 1, 1, new Insets(0, 0, 0, 0));
        	gbSupport.gbAdd(new JLabel(list.get(i).getMail_address()), x++, y, 2, 1, new Insets(0, 0, 0, 0));
        	x++;
        	
        	String phone_number = list.get(i).getPhone_number();
        	
        	if(phone_number.length() == 11)
        	{
        		phone_number = phone_number.substring(0, 3)+"-"+phone_number.substring(3, 7)+"-"+phone_number.substring(7, 11);
        	}
        	 
        	gbSupport.gbAdd(new JLabel(phone_number), x++, y, 2, 1, new Insets(0, 0, 0, 0));
        	x++;
        	gbSupport.gbAdd(new JLabel(list.get(i).getAddress()), x++, y, 6, 1, new Insets(0, 0, 0, 0));
        	x = x+5;
        	
        	/****** 버튼부분 ****/
        	JButton detailBtn = new JButton("상세");
        	JButton modBtn = new JButton("수정");
        	JButton delBtn = new JButton("삭제");
        	
        	detailBtn.setName(String.valueOf(list.get(i).getNum()));
        	modBtn.setName(String.valueOf(list.get(i).getNum()));
        	delBtn.setName(String.valueOf(list.get(i).getNum()));
        	
        	detailBtn.addActionListener(abCtrl);
        	modBtn.addActionListener(abCtrl);
        	delBtn.addActionListener(abCtrl);
        	
        	detailBtns.add(detailBtn);
        	modBtns.add(modBtn);
        	delBtns.add(delBtn);
        	
        	gbSupport.gbAdd(detailBtn, x++, y, 1, 1, new Insets(0, 0, 0, 0));
        	gbSupport.gbAdd(modBtn, x++, y, 1, 1, new Insets(0, 0, 0, 0));
        	gbSupport.gbAdd(delBtn, x++, y, 1, 1, new Insets(0, 0, 0, 0));
        	
    		x = 0;
    		y++;
		}
        
        btns.put("detail", detailBtns);
        btns.put("modify", modBtns);
        btns.put("delete", delBtns);
        
       
		
		return bodyPanel;
	}
	
	private JPanel setFoot() {
		footPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton preBtn,nextBtn,writeBtn;
		
		preBtn = new JButton("이전");
		footPanel.add(preBtn);
		List<Integer> pages = abCtrl.addressPages();
		
		List<JButton> pageBtns = new ArrayList<>();
		for (Integer integer : pages) {
			JButton pageBtn = new JButton(String.valueOf(integer));
			
			if(integer == NOWPAGENUM) pageBtn.setBackground(Color.black);
			else pageBtn.addActionListener(abCtrl);
			
			pageBtns.add(pageBtn);
			footPanel.add(pageBtn);
		}
		
		nextBtn = new JButton("다음");
		footPanel.add(nextBtn);
		
		writeBtn = new JButton("입력");
		footPanel.add(writeBtn);
		
		btns.put("prev", new ArrayList<JButton>(Arrays.asList(preBtn)));
		btns.put("pages", pageBtns);
		btns.put("next", new ArrayList<JButton>(Arrays.asList(nextBtn)));
		btns.put("write", new ArrayList<JButton>(Arrays.asList(writeBtn)));
		
		preBtn.addActionListener(abCtrl);
		nextBtn.addActionListener(abCtrl);
		writeBtn.addActionListener(abCtrl);
		
		return footPanel;
	}
	
	
	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook(1);
		addressBook.setUi();
	}
}
