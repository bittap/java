package answerDAO;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import database.DataBase;

public class AnswerMDAO {
	DataBase dataBase;
	Connection conn;

	
	public AnswerMDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();
	}
	
	public int totalNumber(String exam_number) {
		Map<String,String> map = dataBase.oneSelect("select total_m from exam where exam_number = '"+exam_number+"' limit 1",conn); // 
		
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
