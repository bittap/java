package swing.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SubFrameTest extends JFrame implements ActionListener {
	SubFrame subFrame;
	
	public SubFrameTest() {
		super("프레임 생성");
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton bt = new JButton("단추");
		add(bt);
		bt.addActionListener(this);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new SubFrameTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(subFrame == null) {
			subFrame = new SubFrame();
		}else {
			subFrame.dispose();
			subFrame = new SubFrame();
		}
	}

}
