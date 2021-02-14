package problemDAO;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import database.DataBase;
import problemDTO.ProbelmSDTO;
import session.SessionDTO;

public class ProbelmNDAO {
	DataBase dataBase;
	Connection conn;
	SessionDTO sessionDTO;
	ProbelmSDTO probelmSDTO;

	
	public ProbelmNDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();
		probelmSDTO = ProbelmSDTO.getInstance();
		sessionDTO = SessionDTO.getInstance();

	}
	
	public int numY() {
		Map<String,String> map = dataBase.oneSelect("select num_n from exam where exam_number = '"+sessionDTO.getExamNumber()+"' limit 1",conn);
		
		return Integer.parseInt(map.get("num_n"));
	}
	
	public List<Map<String,String>> bodyData(){
		List<Map<String,String>> list = dataBase.allSelect("select num,file_form,score from exam_n where exam_number = '"+sessionDTO.getExamNumber()+"'",conn);
		probelmSDTO.setList(list);

		return probelmSDTO.getList();
	}
	
	public void solveAdd(int num, String fileId,String fileName) {
		// 2019-11-01 score 수험생페이지에서 넣을 필요없어서 주석
		//Map<String,String> map = dataBase.oneSelect("select score  from exam_n where exam_number = '"+sessionDTO.getExamNumber()+"' and num = '"+ num +"' limit 1",conn);
		HashMap<String, String> insertMap = new HashMap<String, String>();
		/*
		String score = "";
		
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = map.get(key);

			if(key.equals("score")) score = value;
		}
		*/
		
		insertMap.put("id", sessionDTO.getId());
		insertMap.put("file_id", fileId);
		insertMap.put("file_name", fileName);
		insertMap.put("num", String.valueOf(num));
		insertMap.put("score_yn", "N");
		insertMap.put("exam_number", sessionDTO.getExamNumber());
		dataBase.insert("problem_n", insertMap);
	}
	
	public void disConn() {
		dataBase.disConn(conn);
	}
}
