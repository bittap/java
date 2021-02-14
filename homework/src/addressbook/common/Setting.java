package addressbook.common;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Setting {
	
	public static int width;
	public static int height;
	
	public static void Setting(JFrame jFrame) {
		width = 1000;
		height = 800;
		jFrame.setSize(width,height);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.setTitle("林家废");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void Setting(JDialog jFrame) {
		width = 800;
		height = 600;
		jFrame.setSize(width,height);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.setTitle("林家废");
		jFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}
