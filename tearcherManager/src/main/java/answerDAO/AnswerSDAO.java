package answerDAO;

import java.sql.Connection;
import java.util.Map;

import database.DataBase;

public class AnswerSDAO {
	DataBase dataBase;
	Connection conn;

	
	public AnswerSDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();

	}
	
	public int totalNumber(String examNumber) {
		Map<String,String> map = dataBase.oneSelect("select total_s from exam where exam_number = '"+examNumber+"' limit 1",conn); // 
		
		try {
			return Integer.parseInt(map.get("total_s"));
		} catch (NumberFormatException e) {
			return 0;
		}finally {
			disConn();
		}
		
	}
	
	
	public void disConn() {
		dataBase.disConn(conn);
	}
}
