package addressbook.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import addressbook.common.PageKind;
import addressbook.dto.AddressDTO;
import addressbook.logic.DeleteLogic;
import addressbook.logic.ModifyLogic;
import addressbook.logic.RegisterLogic;
import addressbook.logic.RetrieveLogic;
import addressbook.view.AddressBook;
import addressbook.view.InUpDeDialog;

public class Ctrl{
	
	public class AddressBookCtrl implements ActionListener{
		private final AddressBook ADDRESSBOOK;
		private RetrieveLogic reLogic = new RetrieveLogic();
		
		public AddressBookCtrl(AddressBook view) {
			ADDRESSBOOK = view;
		}
		
		public List<AddressDTO> addressBookSInvoke (){
			return reLogic.addressBookS(ADDRESSBOOK.ITEMNUM, ADDRESSBOOK.NOWPAGENUM);
		}
		
		public List<Integer> addressPages() {
			return reLogic.addressPages(ADDRESSBOOK.PAGENUM, ADDRESSBOOK.ITEMNUM, ADDRESSBOOK.NOWPAGENUM);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Map<String, List<JButton>> map = ADDRESSBOOK.btns;
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				List<JButton> value = map.get(key);

				for (JButton jButton : value) {
					if(jButton == e.getSource())
					{
						AddressBook adBook = null;
						InUpDeDialog inUpDeDialog = null;
						switch (key) {
						case "detail":
							inUpDeDialog = new InUpDeDialog(reLogic.addressBook(Integer.parseInt(jButton.getName())), PageKind.DETAIL,ADDRESSBOOK);
							inUpDeDialog.setUi();
							break;
						case "modify":
							inUpDeDialog = new InUpDeDialog(reLogic.addressBook(Integer.parseInt(jButton.getName())), PageKind.MODIFY,ADDRESSBOOK);
							inUpDeDialog.setUi();
							break;
						case "write":
							inUpDeDialog = new InUpDeDialog(PageKind.INSERT,ADDRESSBOOK);
							inUpDeDialog.setUi();
							break;
						case "delete":
							DeleteLogic deleteLogic = new DeleteLogic();
							if(deleteLogic.addressBookDel(Integer.parseInt(jButton.getName()))) 
							{
								JOptionPane.showMessageDialog(ADDRESSBOOK, "삭제 했습니다.","Message",JOptionPane.PLAIN_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(ADDRESSBOOK, "오류가 발생했습니다. 관리자에게 문의해주세요","Message",JOptionPane.ERROR_MESSAGE);
							}
							ADDRESSBOOK.dispose();
							adBook = new AddressBook(1);
							adBook.setUi();
							break;
						case "prev":
							ADDRESSBOOK.dispose();
							adBook = new AddressBook(reLogic.getPrevNumber(ADDRESSBOOK.PAGENUM, ADDRESSBOOK.NOWPAGENUM));
							adBook.setUi();
							break;
						case "pages":
							ADDRESSBOOK.dispose();
							adBook = new AddressBook(Integer.parseInt(jButton.getText()));
							adBook.setUi();
							break;
						case "next":
							ADDRESSBOOK.dispose();
							adBook = new AddressBook(reLogic.getNextNumber(ADDRESSBOOK.PAGENUM, ADDRESSBOOK.ITEMNUM, ADDRESSBOOK.NOWPAGENUM));
							adBook.setUi();
							break;
						default:
							break;
						}
						
						break;
					}
				}
			}
		}
	}
	
	public class inUpDeDialogCtrl implements ActionListener{
		private final InUpDeDialog INUPDEDIALOG;
		
		public inUpDeDialogCtrl(InUpDeDialog inUpDeDialog) {
			this.INUPDEDIALOG = inUpDeDialog;
		}
		
		public AddressDTO inUpDeDialogData(int dataNum){
			return new AddressDTO();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == INUPDEDIALOG.closeBtn)
			{
				INUPDEDIALOG.dispose();
			}
			else
			{
				INUPDEDIALOG.dispose();
				INUPDEDIALOG.MOTHERFRAME.dispose();
				
				AddressBook adBook = null;
				AddressDTO dto = new AddressDTO();
				dto.setName(INUPDEDIALOG.jTextFields.get(0).getText());
				dto.setMail_address(INUPDEDIALOG.jTextFields.get(1).getText());
				dto.setPhone_number(INUPDEDIALOG.jTextFields.get(2).getText());
				dto.setAddress(INUPDEDIALOG.jTextFields.get(3).getText());
				java.util.Date date = new java.util.Date();
				java.sql.Date date2 = new java.sql.Date(date.getTime());
				dto.setReg_date(date2);
				if(INUPDEDIALOG.KIND.toString().equals("INSERT"))
				{
					RegisterLogic registerLogic = new RegisterLogic();

					if(registerLogic.addressBookInsert(dto)) 
					{
						JOptionPane.showMessageDialog(adBook, "입력 했습니다.","Message",JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(adBook, "오류가 발생했습니다. 관리자에게 문의해주세요","Message",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else if(INUPDEDIALOG.KIND.toString().equals("MODIFY"))
				{
					dto.setNum(INUPDEDIALOG.nowNumber);
					ModifyLogic modifyLogic = new ModifyLogic();

					if(modifyLogic.addressBookUpdate(dto)) 
					{
						JOptionPane.showMessageDialog(adBook, "수정 했습니다.","Message",JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(adBook, "오류가 발생했습니다. 관리자에게 문의해주세요","Message",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				adBook = new AddressBook(1);
				adBook.setUi();

			}
		}
	}
	
}
