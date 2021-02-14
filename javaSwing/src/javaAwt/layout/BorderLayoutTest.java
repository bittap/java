package javaAwt.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutTest {

	public static void main(String[] args) {
		// 5���� �������� �����Ͽ� ������
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setBounds(300, 100, 300, 300);
		
		BorderLayout borderLayout = new BorderLayout();
		frame.setLayout(borderLayout);
		
		frame.add("North",new Button("����"));
		frame.add("West",new Button("����"));
		frame.add("East",new Button("����"));
		frame.add("Center",new Button("�߾�"));
		frame.add("South",new Button("����"));
		
	}

}
