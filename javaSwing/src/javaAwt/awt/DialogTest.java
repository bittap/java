package javaAwt.awt;

import java.awt.Dialog;
import java.awt.Frame;

public class DialogTest {

	public static void main(String[] args) {
		Frame frame = new Frame("다이얼로그 프레임");
		Dialog dialog = new Dialog(frame, "다이알로그",true);
		frame.setBounds(0, 0, 400, 400);
		frame.setVisible(true);
		dialog.setSize(200,200);
		dialog.setVisible(true);
		
	}

}
