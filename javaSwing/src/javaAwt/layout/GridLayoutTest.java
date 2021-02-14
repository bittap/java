package javaAwt.layout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutTest {

	public static void main(String[] args) {
		// ���� ������� ��ġ
		// ��� ���� ���� �����ؼ� ��ġ
		// ��� �� ������ ������Ʈ�� ���� ������ �ڵ������� �þ
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setBounds(300, 100, 500, 500);
		
		GridLayout gridLayout = new GridLayout(3, 2);
		frame.setLayout(gridLayout);
		Button button[] = new Button[6];
		
		for (int i = 0; i < button.length; i++) {
			button[i] = new Button((i+1)+"��°�� ��ư");
			frame.add(button[i]);
		}
		
	}

}
