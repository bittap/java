package test;

import java.util.ArrayList;

import javax.swing.JPanel;

public class ProbelmM{

	JPanel jPanel;
	String title = "������ ���";
	ArrayList<String> menu;
	int numX; // numX = ��ȣ ����
	int numY; // numY = ���� ����
	
	public ProbelmM(int numX,int numY) {
		menu = new ArrayList<String>();
		menu.add("��ȣ");
		for (int i = 1; i <= numX; i++) {
			menu.add(String.valueOf(i));
		}
		menu.add("����");
	}
	
	void mainLayout() {
		
	}
	
	public static void main(String[] args) {
		ProbelmM probelmM = new ProbelmM(5,20);
	}

}
