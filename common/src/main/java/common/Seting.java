package common;

import javax.swing.JFrame;

public class Seting {

	public static void getInstance(JFrame jFrame) {
		jFrame.getRootPane().setFocusable(true);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.setTitle("채점 프로그램");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
