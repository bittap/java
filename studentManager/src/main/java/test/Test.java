package test;

import javax.swing.JFrame;
import javax.swing.JLabel;

import google.drive.DriveManager;

public class Test extends JFrame {
	
	public Test() {
		
		String path = Test.class.getResource("/tokens").getPath();
		System.out.println(path);
		

		
		final String CREDENTIALS_FILE_PATH = "/credentials.json";
		String path2 = DriveManager.class.getResource("../").getPath();
		JLabel jLabel2 = new JLabel(path2);
		System.out.println(path2);
		
		
	}
}
