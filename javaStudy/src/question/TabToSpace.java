package question;

import java.io.FileInputStream;
import java.io.IOException;

public class TabToSpace {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\jmp17\\eclipse-workspace\\javaStudy\\src\\question\\TabToSpace.java");
			int data;
			
			while((data = fis.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
