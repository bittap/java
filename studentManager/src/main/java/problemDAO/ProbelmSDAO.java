package problemDAO;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import database.DataBase;
import problemDTO.ProbelmSDTO;
import session.SessionDTO;

public class ProbelmSDAO {
	DataBase dataBase;
	Connection conn;
	SessionDTO sessionDTO;
	ProbelmSDTO probelmSDTO;

	
	public ProbelmSDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();
		probelmSDTO = ProbelmSDTO.getInstance();
		sessionDTO = SessionDTO.getInstance();

	}
	
	public int numY() {
		Map<String,String> map = dataBase.oneSelect("select num_s from exam where exam_number = '"+sessionDTO.getExamNumber()+"' limit 1",conn);
		
		return Integer.parseInt(map.get("num_s"));
	}
	
	public List<Map<String,String>> bodyData(){
		List<Map<String,String>> list = dataBase.allSelect("select num,score from exam_s where exam_number = '"+sessionDTO.getExamNumber()+"'",conn);
		probelmSDTO.setList(list);

		return probelmSDTO.getList();
	}
	
	public void solveAdd(int num, String solve) {
		HashMap<String, String> insertMap = new HashMap<String, String>();
		
		insertMap.put("id", sessionDTO.getId());
		insertMap.put("exam_number", sessionDTO.getExamNumber());
		insertMap.put("num", String.valueOf(num));
		insertMap.put("submission", solve);
		dataBase.insert("problem_s", insertMap);
	}
	
	public void disConn() {
		dataBase.disConn(conn);
	}
}
