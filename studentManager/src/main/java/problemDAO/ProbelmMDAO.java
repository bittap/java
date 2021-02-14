package problemDAO;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import database.DataBase;
import problemDTO.ProbelmMDTO;
import session.SessionDTO;

public class ProbelmMDAO {
	DataBase dataBase;
	Connection conn;
	SessionDTO sessionDTO;
	ProbelmMDTO probelmMDTO;

	
	public ProbelmMDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();
		probelmMDTO = ProbelmMDTO.getInstance();
		sessionDTO = SessionDTO.getInstance();

	}
	
	public int numX() {
		Map<String,String> map = dataBase.oneSelect("select item_m from exam where exam_number = '"+sessionDTO.getExamNumber()+"' limit 1",conn); // 
		
		return Integer.parseInt(map.get("item_m"));
	}
	
	public int numY() {
		Map<String,String> map = dataBase.oneSelect("select num_m from exam where exam_number = '"+sessionDTO.getExamNumber()+"' limit 1",conn);
		
		return Integer.parseInt(map.get("num_m"));
	}
	
	public List<Map<String,String>> bodyData(){
		List<Map<String,String>> list = dataBase.allSelect("select * from exam_m where exam_number = '"+sessionDTO.getExamNumber()+"'",conn);
		probelmMDTO.setList(list);

		return probelmMDTO.getList();
	}
	
	public void solveAdd(int num, int solve) {
		HashMap<String, String> insertMap = new HashMap<String, String>();
		
		insertMap.put("id", sessionDTO.getId());
		insertMap.put("exam_number", sessionDTO.getExamNumber());
		insertMap.put("num", String.valueOf(num));
		insertMap.put("submission", String.valueOf(solve));
		dataBase.insert("problem_m", insertMap);
	}
	
	public void disConn() {
		dataBase.disConn(conn);
	}
}
