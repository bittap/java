package screen;

import answer.Answer;
import answer.AnswerM;
import answer.AnswerN;
import answer.AnswerS;
import list.Exam;
import list.ExamDetail;
import list.List;
import list.StudentDetail;
import list.StudentDetail2;
import member.Login;

public class ScreenManager {
	
	public static void answer(boolean modifyFlag, String examNumber) {
		Answer list = new Answer(150, 50,modifyFlag,examNumber);
		list.setUi();
	}

	public static void answerM(boolean modifyFlag, String examNumber) {
		AnswerM answerM = new AnswerM(150, 40, modifyFlag,examNumber);
		answerM.setUi();
	}
	
	public static void answerS(boolean modifyFlag, String examNumber) {
		AnswerS answerS = new AnswerS(150, 50, modifyFlag,examNumber);
		answerS.setUi();
	}
	
	public static void answerN(boolean modifyFlag, String examNumber) {
		AnswerN answerN = new AnswerN(150, 50, modifyFlag, examNumber);
		answerN.setUi();
	}
	
	public static void login() {
		Login login = new Login();
		login.create();
	}
	
	public static void list() {
		List list = new List(250, 50);
		list.setUi();
	}
	
	public static void exam() {
		Exam list = new Exam(150, 40);
		list.setUi();
	}
	
	public static void examDetail(String examNumber) {
		ExamDetail list = new ExamDetail(150, 40,examNumber);
		list.setUi();
	}
	
	public static void studentDetail(String examNumber, String id) {
		StudentDetail list = new StudentDetail(50, 40,examNumber,id);
		list.setUi();
	}
	
	public static void studentDetail2(String examNumber, String id) {
		StudentDetail2 list = new StudentDetail2(50, 40,examNumber,id);
		list.setUi();
	}
	
	
	
}
