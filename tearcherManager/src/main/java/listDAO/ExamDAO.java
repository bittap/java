package listDAO;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import database.DataBase;

public class ExamDAO {
	DataBase dataBase;
	Connection conn;

	
	public ExamDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();

	}
	
	public List<Map<String,String>> totalExam() {
		String sql = "SELECT exam_number, title, enforce_date, total_m, \r\n" + 
				"		(select count(*) \r\n" + 
				"		from (select count(*) from problem_n where e.exam_number = exam_number and score_yn = 'Y' group by id) as a\r\n" + 
				"		where count >= 1) as n_exeStudentNum,\r\n" + 
				"		(select count(*) \r\n" + 
				"		from (select count(*) from problem_n where e.exam_number = exam_number group by id) as a\r\n" + 
				"		where count >= 1) as n_allStudentNum\r\n" + 
				"	FROM public.exam as e Order by enforce_date desc";
		System.out.println(sql);
		List<Map<String,String>> list = dataBase.allSelect(sql,conn); // 
		
		return list;
		
	}

	public void disConn() {
		dataBase.disConn(conn);
	}
}
