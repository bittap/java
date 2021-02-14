package swing;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class JListTest {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setLayout(new FlowLayout());
		
		
		String count[] = {"1","2","3","4","5","6"};
		JList<String> jList = new JList<String>(count);
		JScrollPane jScrollPane = new JScrollPane(jList);
		jList.setVisibleRowCount(2);
		jFrame.add(jScrollPane);
		
		jFrame.setVisible(true);
		jFrame.setSize(300, 300);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
	}

}
