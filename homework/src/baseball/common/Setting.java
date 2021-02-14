package baseball.common;

import javax.swing.JFrame;

public class Setting {
	
	public static void Setting(JFrame jFrame) {
		jFrame.setSize(400,400);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.setTitle("야구 게임");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
