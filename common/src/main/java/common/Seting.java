package common;

import javax.swing.JFrame;

public class Seting {

	public static void getInstance(JFrame jFrame) {
		jFrame.getRootPane().setFocusable(true);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.setTitle("ä�� ���α׷�");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
