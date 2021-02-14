package javaAwt.awt;

import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

public class ListTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setBounds(100, 100, 300, 300);
		frame.setVisible(true);
		
		Panel panel = new Panel();
		frame.add(panel);
		
		List list = new List(1);
		list.add("치킨");
		list.add("피자");
		list.add("햄버거");
		
		panel.add(list);
	}

}
