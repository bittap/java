package javaAwt.awt;

import java.awt.Frame;

public class FrameTest extends Frame {

	public static void main(String[] args) {
		/*
		// 첫번째 방법
		Frame frame = new Frame("test");
		frame.setVisible(true);
		frame.setBounds(100, 100, 300, 300);
		frame.setLocation(500, 100);
		*/
		
		// 두번째 방법
		FrameTest ft = new FrameTest();
	}
	
	public FrameTest() {
		// 첫번째 방법
		Frame frame = new Frame("test");
		frame.setVisible(true);
		frame.setBounds(100, 100, 300, 300);
		frame.setLocation(500, 100);
	}
	
	
	
	

}
