package swing.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SubFrame extends JFrame implements ActionListener {
	
	public SubFrame() {
		super("나는 자식");
		setSize(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton bt = new JButton("닫기");
		add(bt);
		bt.addActionListener(this);
		setLocation(200,0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
