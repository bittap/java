package answerDAO;

import java.sql.Connection;
import java.util.Map;

import database.DataBase;

public class AnswerDAO {
	DataBase dataBase;
	Connection conn;

	
	public AnswerDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();

	}
	
	public Map<String, String> selExam(String exam_number) {
		Map<String,String> map = dataBase.oneSelect("select * from exam where exam_number = '"+exam_number+"' limit 1",conn); // 
		
		return map;
	}
	
	public int dupliExamNumber(String exam_number) {
		Map<String,String> map = dataBase.oneSelect("select exam_number from exam where exam_number = '"+exam_number+"' limit 1",conn); // 
		
		try {
			return Integer.parseInt(map.get("exam_number"));
		} catch (NumberFormatException e) {
			return 0;
		}
		
	}
	
	public int totalNumber(String exam_number) {
		Map<String,String> map = dataBase.oneSelect("select exam_number from total_m where exam_number = '"+exam_number+"' limit 1",conn); // 
		
		try {
			return Integer.parseInt(map.get("total_m"));
		} catch (NumberFormatException e) {
			return 0;
		}
		
	}
	
	
	public void disConn() {
		dataBase.disConn(conn);
	}
}
