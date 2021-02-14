package screen;

import java.awt.Dimension;
import java.awt.Toolkit;

import member.Login;
import member.SignUp;
import problem.ProblemM;
import problem.ProblemN;
import problem.ProblemResult;
import problem.ProblemS;

public class ScreenManager {
	
	public static void login() {
		Login login = new Login();
		login.create();
	}
	
	public static void problemM() {
		ProblemM problem = new ProblemM(50,30);
		problem.setUi();
	}
	
	public static void problemS() {
		ProblemS problemS = new ProblemS(50, 40);
		problemS.setUi();
	}
	
	public static void problemN() {
		ProblemN problemN = new ProblemN(50, 40);
		problemN.setUi();
	}
	
	public static void problemResult() {
		ProblemResult problemR = new ProblemResult(150, 100);
		problemR.setUi();
	}
	

	
}
