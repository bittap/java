package javaAwt.awt;

import java.awt.Frame;

public class FrameTest extends Frame {

	public static void main(String[] args) {
		/*
		// ù��° ���
		Frame frame = new Frame("test");
		frame.setVisible(true);
		frame.setBounds(100, 100, 300, 300);
		frame.setLocation(500, 100);
		*/
		
		// �ι�° ���
		FrameTest ft = new FrameTest();
	}
	
	public FrameTest() {
		// ù��° ���
		Frame frame = new Frame("test");
		frame.setVisible(true);
		frame.setBounds(100, 100, 300, 300);
		frame.setLocation(500, 100);
	}
	
	
	
	

}
