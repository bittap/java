package answerDAO;

import java.sql.Connection;
import java.util.Map;

import database.DataBase;

public class AnswerNDAO {
	DataBase dataBase;
	Connection conn;

	
	public AnswerNDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();

	}
	
	public int totalNumber(String examNumber) {
		Map<String,String> map = dataBase.oneSelect("select total_n from exam where exam_number = '"+examNumber+"' limit 1",conn); // 
		
		try {
			return Integer.parseInt(map.get("total_n"));
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
