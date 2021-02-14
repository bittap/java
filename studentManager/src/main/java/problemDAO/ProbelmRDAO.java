package problemDAO;

import java.sql.Connection;
import java.util.Iterator;
import java.util.Map;

import database.DataBase;
import problemDTO.ProbelmRDTO;
import session.SessionDTO;

public class ProbelmRDAO {
	DataBase dataBase;
	Connection conn;
	SessionDTO sessionDTO;
	ProbelmRDTO probelmRDTO;

	
	public ProbelmRDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();
		probelmRDTO = new ProbelmRDTO();
		sessionDTO = SessionDTO.getInstance();

	}
	
	public ProbelmRDTO bodyData(){
		String sql = "select \r\n" + 
				"total_m as mPerfectScore,\r\n" + 
				"total_s as sPerfectScore,\r\n" + 
				"(select sum(case when m.submission = e.solution then e.score else 0 end) as m_score from problem_m m, exam_m e where e.exam_number ="+sessionDTO.getExamNumber()+" and m.exam_number ="+sessionDTO.getExamNumber()+" and m.num =e.num and m.id ='"+sessionDTO.getId()+"' group by id) as mScore,\r\n" + 
				"(select sum(case when e.capital_yn = 'Y' then (case when m.submission = e.solution then e.score else 0 end) else (case when upper(m.submission) = upper(e.solution) then e.score else 0 end) end) as s_score from problem_s m, exam_s e where e.exam_number ="+sessionDTO.getExamNumber()+" and m.exam_number ="+sessionDTO.getExamNumber()+" and m.num =e.num and m.id ='"+sessionDTO.getId()+"' group by id) as sScore\r\n" + 
				"from exam\r\n" + 
				"where exam_number = '"+sessionDTO.getExamNumber()+"'";
		//System.out.println(sql);
		Map<String,String> map = dataBase.oneSelect(sql,conn);
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = map.get(key);
			
			if(key.equals("mPerfectScore".toLowerCase())) probelmRDTO.setmPerfectScore(value);
			if(key.equals("sPerfectScore".toLowerCase())) probelmRDTO.setsPerfectScore(value);
			if(key.equals("mScore".toLowerCase())) probelmRDTO.setmScore(value);
			if(key.equals("sScore".toLowerCase())) probelmRDTO.setsScore(value);
		}
		
		return probelmRDTO;
	}
	
	
	public void disConn() {
		dataBase.disConn(conn);
	}
	
}
