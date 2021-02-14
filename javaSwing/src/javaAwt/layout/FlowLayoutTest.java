package javaAwt.layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowLayoutTest {

	public static void main(String[] args) {
		// panel�� �⺻���� ������Ʈ ���� �������� ������� �����ϴ� ���̾ƿ�
		// �������� ��ġ�ϴٰ� �� �̻� ������ ������ ���� �ٷ� �̵��ؼ� ��ġ
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setBounds(300, 100, 500, 500);
		
		FlowLayout flowLayout = new FlowLayout();
		Button btn[] = new Button[10];
		
		frame.setLayout(flowLayout);
		
		for (int i = 0; i < 10; i++) {
			btn[i] = new Button((i+1)+"�� ��ư");
			frame.add(btn[i]);
		}
		
		
	}

}
