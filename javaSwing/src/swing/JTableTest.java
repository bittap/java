package swing;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setLayout(new FlowLayout());
		jFrame.setSize(300,500);
		
		String title[] = {"��ȣ", "�̸�", "����"};
		String data[][] = {{"1","�ʱ���","26"},{"2","����","25"},{"3","������","24"}};
		DefaultTableModel model = new DefaultTableModel(data, title);
		JTable jTable = new JTable(model);
		jTable.getTableHeader().setReorderingAllowed(false);
		jTable.getTableHeader().setResizingAllowed(false);
		JScrollPane jScrollPane = new JScrollPane(jTable);
		jFrame.getContentPane().add(jScrollPane);

		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		jFrame.setLayout(new FlowLayout());
	}

}
