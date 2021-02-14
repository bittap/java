package test;

import java.util.ArrayList;

import javax.swing.JPanel;

public class ProbelmM{

	JPanel jPanel;
	String title = "객관식 답안";
	ArrayList<String> menu;
	int numX; // numX = 번호 갯수
	int numY; // numY = 문제 갯수
	
	public ProbelmM(int numX,int numY) {
		menu = new ArrayList<String>();
		menu.add("번호");
		for (int i = 1; i <= numX; i++) {
			menu.add(String.valueOf(i));
		}
		menu.add("배점");
	}
	
	void mainLayout() {
		
	}
	
	public static void main(String[] args) {
		ProbelmM probelmM = new ProbelmM(5,20);
	}

}
