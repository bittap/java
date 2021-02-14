package javaAwt.layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardLayoutTest {
	
	static Frame frame = new Frame();
	static Color color[] = {Color.red,Color.blue,Color.yellow,Color.green,Color.cyan};
	static CardLayout cardLayout = new CardLayout();
	
	public static void main(String[] args) {
		// 여러 개의 카드를 쌓은 것처럼 레이아웃으로 한번에 하나만 보여줌
		// next 메소드를 이용해 다음 화면을 출력
		// Layout에 null을 설정하면 좌표와 크기를 직접 설정해서 배치
		frame.setVisible(true);
		frame.setBounds(300, 100, 300, 300);
		
		Panel panel[] = new Panel[5];
		frame.setLayout(cardLayout);
		MouseHandle mouseHandle = new MouseHandle();
		
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new Panel();
			panel[i].setBackground(color[i]);
			panel[i].addMouseListener(mouseHandle);
			frame.add(""+(i+1),panel[i]);
		}
		
	}
	
	public static class MouseHandle extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			cardLayout.next(frame);
		}
	}

}
