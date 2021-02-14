package listDAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import database.DataBase;

public class ExamDetailDAO {
	DataBase dataBase;
	Connection conn;

	
	public ExamDetailDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();

	}
	
	public List<Map<String,String>> totalExam(String examNumber) {
		String sql = "select coalesce(m_score,0) as m_score,coalesce(s_score,0) as s_score,coalesce(n_score,0) as n_score,m.id,(select name from member where m.id = id) as name, (coalesce(m_score,0)+coalesce(s_score,0)+coalesce(n_score,0)) total_score\r\n" + 
				"from (select sum(case when m.submission = e.solution then e.score else 0 end) as m_score,id from problem_m m, exam_m e where e.exam_number ="+examNumber +" and m.exam_number ="+examNumber +" and m.num =e.num group by id) as m,\r\n" + 
				"(select sum(case when e.capital_yn = 'Y' then (case when m.submission = e.solution then e.score else 0 end) else (case when upper(m.submission) = upper(e.solution) then e.score else 0 end) end) as s_score,id from problem_s m, exam_s e where e.exam_number ="+examNumber +" and m.exam_number ="+examNumber +" and m.num =e.num group by id) as s,\r\n" + 
				"(select sum(score) as n_score,id from problem_n where exam_number ="+examNumber +" group by id) as n\r\n" + 
				"where m.id = s.id and s.id = n.id\r\n" + 
				"order by name asc";
		System.out.println(sql);
		List<Map<String,String>> list = dataBase.allSelect(sql,conn); // 
		
		return list;
		
	}
	
	public Map<String,String> examData(String examNumber){
		String sql = "select title, exam_number, reg_date from exam where exam_number =  '"+examNumber+"'";
		//Syste.out.println(sql);
		return dataBase.oneSelect(sql, conn);
	}
	
	public ArrayList<String[]> excelTotalExam(String examNumber){
		String sql = "select m_score as col2,s_score as col3 ,n_score as  col4,(select name from member where m.id = id) as col1, (m_score+s_score+n_score) as col5,rank() over ( order by (m_score+s_score+n_score) desc) as col6\r\n" + 
				"from (select sum(case when m.submission = e.solution then e.score else 0 end) as m_score,id from problem_m m, exam_m e where e.exam_number ="+examNumber +" and m.exam_number ="+examNumber +" and m.num =e.num group by id) as m,\r\n" + 
				"(select sum(case when e.capital_yn = 'Y' then (case when m.submission = e.solution then e.score else 0 end) else (case when upper(m.submission) = upper(e.solution) then e.score else 0 end) end) as s_score,id from problem_s m, exam_s e where e.exam_number ="+examNumber +" and m.exam_number ="+examNumber +" and m.num =e.num group by id) as s,\r\n" + 
				"(select sum(score) as n_score,id from problem_n where exam_number ="+examNumber +" group by id) as n\r\n" + 
				"where m.id = s.id and s.id = n.id\r\n" + 
				"order by col1 asc";
		//Syste.out.println(sql);
		List<Map<String,String>> list = dataBase.allSelect(sql,conn); // 
		
		ArrayList<String[]> listTep = new ArrayList<String[]>();
		
		String[] s = new String[]{"이름","객관식점수","주관식점수","서술형점수","총점","순위"};
		listTep.add(s);

		for (int i = 0; i < list.size(); i++) {
			TreeMap<String, String> map = new TreeMap<String, String>(list.get(i));
			String[] tep = new String[map.size()];
			int j = 0;
			for (String string : map.values()) {
				tep[j] = string;
				j++;
			}
			listTep.add(tep);

		}
		return listTep;
	}
	
	public ArrayList<String[]> excelDetail(String examNumber, String id){
		String[][] top = new String[][] 
			{
				{"객관식번호","입력한값","정답","배점","정답여부"},
				{"주관식번호","입력한값","정답","배점","정답여부"},
				{"서술형번호","파일이름","얻은점수","배점"}
			};
		String[] sql = new String[]
			{
				"select p.num as col1, p.submission as col2,   \r\n" + 
				"e.solution as col3, e.score as col4,   \r\n" + 
				"(case when p.submission = e.solution then '정답' else '오답' end) as col5  \r\n" + 
				"from problem_m p, exam_m e   \r\n" + 
				"where p.id = '"+id+"'  \r\n" + 
				"and p.exam_number = "+examNumber+"  \r\n" + 
				"and e.exam_number = "+examNumber+"   \r\n" + 
				"and p.num = e.num   \r\n" + 
				"order by col1 asc",
				
				"select p.num as col1, p.submission as col2,   \r\n" + 
				"e.solution as col3, e.score as col4,   \r\n" + 
				"(case when e.capital_yn = 'Y' then (case when p.submission = e.solution then '정답' else '오답' end) else (case when upper(p.submission) = upper(e.solution) then '정답' else '오답' end) end) as col5  \r\n" + 
				"from problem_s p, exam_s e   \r\n" + 
				"where p.id = '"+id+"'  \r\n" + 
				"and p.exam_number = "+examNumber+"  \r\n" + 
				"and e.exam_number = "+examNumber+"   \r\n" + 
				"and p.num = e.num   \r\n" + 
				"order by col1 asc",
				
				"select p.num as col1, p.file_name as col2,   \r\n" + 
				"p.score as col3, e.score as col4\r\n" + 
				"from problem_n p, exam_n e   \r\n" + 
				"where p.id = '"+id+"'  \r\n" + 
				"and p.exam_number = "+examNumber+"  \r\n" + 
				"and e.exam_number = "+examNumber+"   \r\n" + 
				"and p.num = e.num   \r\n" + 
				"order by col1 asc"
						
			};
		ArrayList<String[]> listTemp = new ArrayList<String[]>();
		
		for (int i = 0; i < top.length; i++) {
			
			listTemp.add(top[i]);
			
			List<Map<String,String>> list = dataBase.allSelect(sql[i],conn); // 
			for (int y = 0; y < list.size(); y++) {
				TreeMap<String, String> map = new TreeMap<String, String>(list.get(y));
				String[] temp = new String[map.size()];
				int j = 0;
				for (String string : map.values()) {
					temp[j] = string;
					j++;
				}
				listTemp.add(temp);

			}
			
			// 공백주기 위해서
			String[] blenk = {"",""}; 
			listTemp.add(blenk);
		}

		return listTemp;
	}

	public void disConn() {
		dataBase.disConn(conn);
	}
}
