package javaAwt.awt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class PanelTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		// �г��� �ϼ��Ѵ����� �����ӿ� ���� ����
		Panel panel = new Panel();
		panel.setBackground(Color.red);
		frame.add(panel);
		
		frame.setSize(300, 500);
		frame.setVisible(true);
		
	}

}
