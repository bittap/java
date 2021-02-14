package listDAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.DataBase;
import listDTO.StudentDetailDTO2;

public class studentDetailDAO {
	DataBase dataBase;
	Connection conn;

	
	public studentDetailDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();

	}
	
	public Map<String,String> examData(String examNumber, String id){
		String sql = "select title, exam_number, reg_date, (select name from member where id = '"+id+"') as name from exam where exam_number =  '"+examNumber+"'";
		//Syste.out.println(sql);
		return dataBase.oneSelect(sql, conn);
	}
	
	
	public ArrayList<StudentDetailDTO2> mDetail(String examNumber, String id){
		int y = 0;
		int sum = 0;
		
		String sql = "select p.num as col1, p.submission as col2," + 
				" e.solution as col3, (case when p.submission = e.solution then e.score else '0' end) as col4" + 
				" from problem_m p, exam_m e " + 
				" where p.id = '"+id+"'" + 
				" and p.exam_number = "+examNumber+ 
				" and e.exam_number = "+examNumber+ 
				" and p.num = e.num"+ 
				" order by col1 asc";
		ArrayList<StudentDetailDTO2> listTemp = new ArrayList<StudentDetailDTO2>();
		//System.out.println(sql);
		listTemp.add(new StudentDetailDTO2(new JLabel("객관식"), 0, y, 4, 1));
		
		listTemp.add(new StudentDetailDTO2(new JLabel("번호"), 0, ++y, 1, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel("입력한값"), 1, y, 1, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel("정답"), 2, y, 1, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel("점수"), 3, y, 1, 1));
		
		
		List<Map<String,String>> list = dataBase.allSelect(sql,conn); // 
		for (int z = 0; z < list.size(); z++) {
			int x = 0;
			TreeMap<String, String> map = new TreeMap<String, String>(list.get(z));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col1")), x++, ++y, 1, 1));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col2")), x++, y, 1, 1));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col3")), x++, y, 1, 1));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col4")), x++, y, 1, 1));
			
			sum += Integer.parseInt(map.get("col4"));
		}
		
		listTemp.add(new StudentDetailDTO2(new JLabel("총점"), 0, ++y, 3, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel(String.valueOf(sum)), 3, y, 1, 1));
		
		return listTemp;
	}
	
	public ArrayList<StudentDetailDTO2> sDetail(String examNumber, String id){
		int y = 0;
		int sum = 0;
		
		String sql = "select p.num as col1, p.submission as col2," + 
				" e.solution as col3, (case when e.capital_yn = 'Y' then (case when p.submission = e.solution then e.score else 0 end) else (case when upper(p.submission) = upper(e.solution) then e.score else '0' end) end) as col4" + 
				" from problem_s p, exam_s e " + 
				" where p.id = '"+id+"'" + 
				" and p.exam_number = "+examNumber+ 
				" and e.exam_number = "+examNumber+ 
				" and p.num = e.num"+ 
				" order by col1 asc";
		ArrayList<StudentDetailDTO2> listTemp = new ArrayList<StudentDetailDTO2>();
		//System.out.println(sql);
		listTemp.add(new StudentDetailDTO2(new JLabel("주관식"), 0, y, 4, 1));
		
		listTemp.add(new StudentDetailDTO2(new JLabel("번호"), 0, ++y, 1, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel("입력한값"), 1, y, 1, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel("정답"), 2, y, 1, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel("점수"), 3, y, 1, 1));
		
		
		List<Map<String,String>> list = dataBase.allSelect(sql,conn); // 
		for (int z = 0; z < list.size(); z++) {
			int x = 0;
			TreeMap<String, String> map = new TreeMap<String, String>(list.get(z));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col1")), x++, ++y, 1, 1));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col2")), x++, y, 1, 1));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col3")), x++, y, 1, 1));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col4")), x++, y, 1, 1));
			
			sum += Integer.parseInt(map.get("col4"));
		}
		
		listTemp.add(new StudentDetailDTO2(new JLabel("총점"), 0, ++y, 3, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel(String.valueOf(sum)), 3, y, 1, 1));
		
		return listTemp;
	}
	
	public ArrayList<StudentDetailDTO2> nDetail(String examNumber, String id){
		int y = 0;
		int sum = 0;
		
		String sql = "select p.num as col1,    \r\n" + 
				"coalesce(p.score,0) as col3, e.score as col2\r\n" + 
				"from problem_n p, exam_n e   \r\n" + 
				"where p.id = '"+id+"'  \r\n" + 
				"and p.exam_number = "+examNumber+"  \r\n" + 
				"and e.exam_number = "+examNumber+"   \r\n" + 
				"and p.num = e.num   \r\n" + 
				"order by col1 asc";
		ArrayList<StudentDetailDTO2> listTemp = new ArrayList<StudentDetailDTO2>();
		System.out.println(sql);
		listTemp.add(new StudentDetailDTO2(new JLabel("서술형"), 0, y, 3, 1));
		
		listTemp.add(new StudentDetailDTO2(new JLabel("번호"), 0, ++y, 1, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel("배점"), 1, y, 1, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel("점수"), 2, y, 1, 1));
		
		
		List<Map<String,String>> list = dataBase.allSelect(sql,conn); // 
		for (int z = 0; z < list.size(); z++) {
			int x = 0;
			TreeMap<String, String> map = new TreeMap<String, String>(list.get(z));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col1")), x++, ++y, 1, 1));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col2")), x++, y, 1, 1));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col3")), x++, y, 1, 1));
			
			sum += Integer.parseInt(map.get("col3"));
		}
		
		listTemp.add(new StudentDetailDTO2(new JLabel("총점"), 0, ++y, 2, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel(String.valueOf(sum)), 2, y, 1, 1));
		
		return listTemp;
	}
	
	public ArrayList<StudentDetailDTO2> nDetail2(String examNumber, String id){
		int y = 0;
		int sum = 0;
		
		String sql = "select p.num as col1,    \r\n" + 
				"p.score as col3, e.score as col2\r\n" + 
				"from problem_n p, exam_n e   \r\n" + 
				"where p.id = '"+id+"'  \r\n" + 
				"and p.exam_number = "+examNumber+"  \r\n" + 
				"and e.exam_number = "+examNumber+"   \r\n" + 
				"and p.num = e.num   \r\n" + 
				"order by col1 asc";
		ArrayList<StudentDetailDTO2> listTemp = new ArrayList<StudentDetailDTO2>();
		//System.out.println(sql);
		listTemp.add(new StudentDetailDTO2(new JLabel("서술형"), 0, y, 3, 1));
		
		listTemp.add(new StudentDetailDTO2(new JLabel("번호"), 0, ++y, 1, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel("배점"), 1, y, 1, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel("점수"), 2, y, 1, 1));
		
		
		List<Map<String,String>> list = dataBase.allSelect(sql,conn); // 
		for (int z = 0; z < list.size(); z++) {
			int x = 0;
			TreeMap<String, String> map = new TreeMap<String, String>(list.get(z));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col1")), x++, ++y, 1, 1));
			listTemp.add(new StudentDetailDTO2(new JLabel(map.get("col2")), x++, y, 1, 1));
			JTextField jTextField = new JTextField(map.get("col3"));
			jTextField.setName(map.get("col1"));
			listTemp.add(new StudentDetailDTO2(jTextField, x++, y, 1, 1));
			
			sum += Integer.parseInt(map.get("col3"));
		}
		
		listTemp.add(new StudentDetailDTO2(new JLabel("총점"), 0, ++y, 2, 1));
		listTemp.add(new StudentDetailDTO2(new JLabel(String.valueOf(sum)), 2, y, 1, 1));
		
		return listTemp;
	}
	

	public void disConn() {
		dataBase.disConn(conn);
	}
}
