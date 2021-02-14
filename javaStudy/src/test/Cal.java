package test;

import java.awt.*;
import javax.swing.*;


class Cal
{
	JFrame frame;
	JPanel panel, inPanel;
	
	JMenu menu;
	JMenuItem item;
	JMenuBar menuBar;
	
	JButton button;
	JLabel label;
	
	String[] mainMenu = {"����(F)","����(E)","����(T)","����(H)"};
	String[][] subMenu = {{"������(N)", "����(X)"},{"����(C)", "�ٿ��ֱ�(V)"},
	{"����(P)", "����(O)"}, {"����(L)", "����(A)"}};
	String[][] buttnName = {{"Sta", "Ave", "Sum", "s", "Dat"},
	{"F-E", "(", ")", "dms", "Exp", "In", "sin", "x^y", "log", "cos", "x^3", "n!", "tan", "x^2", "1/x"},
	{"MC", "MR", "MS", "M+", "pi"},
	{"7", "8", "9", "/", "Mod", "And", "4", "5", "6", "*",
	"Or", "Xor", "1", "2", "3", "-", "Lsh", "Not", "0", "+/-",
	".", "+", "=", "Int", "A", "B", "C", "D", "E", "F"}};

	public Cal() {
	
		frame = new JFrame("����");
		menuBar = new JMenuBar();
		System.out.println(FlowLayout.LEFT);
		System.out.println(FlowLayout.RIGHT);
		System.out.println(FlowLayout.CENTER);
		panel = new JPanel(new FlowLayout(1, 15, 20));
	}

	// ���� �޴� ����
	void createSubMenu(String strMenu, int menuCnt) {
		menu = new JMenu(strMenu);
		
		for(int cnt = 0; cnt < subMenu[menuCnt].length; cnt++) {
			item = new JMenuItem(subMenu[menuCnt][cnt]);
			menu.add(item);
		}
		menuBar.add(menu);
	}

	// ���� �޴� ����
	void setMenu() {
		for(int cnt = 0; cnt < mainMenu.length; cnt++)
			createSubMenu(mainMenu[cnt], cnt);
		
		frame.setJMenuBar(menuBar);
	}

	void mainLayout() {
		// ������ ���ʿ� �ؽ�Ʈ �ʵ� ����
		frame.add(new JTextField("0.", 20), "North");
		
		// ������ �ϴܿ� �г� ���� �� ��ư ����
		panel.add(addSouthButton(0, 5, 1, 3, 3));
		panel.add(addSouthButton(1, 5, 3, 3, 3));
		panel.add(addSouthButton(2, 5, 1, 3, 3));
		panel.add(addSouthButton(3, 5, 6, 3, 3));
		
		frame.add(panel, "South");
	}

	public JPanel addSouthButton(int count, int xSize, int ySize, int xMargin, int yMargin) {
		inPanel = new JPanel(new GridLayout(xSize, ySize, xMargin, yMargin));
		for(int cnt = 0; cnt < buttnName[count].length; cnt++) {
			button = new JButton(buttnName[count][cnt]);
			inPanel.add(button);
		}
		return inPanel;
	}

	void setGUI() {
		setMenu();
		mainLayout();
		frame.pack();
		frame.show();
	
	}

	public static void main(String[] args)
	{
		Cal cal = new Cal();
		cal.setGUI();
		//new RadioButton();
	}
}