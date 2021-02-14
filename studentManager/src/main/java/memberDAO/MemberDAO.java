package memberDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.DateT;
import database.DataBase;
import session.SessionDTO;

public class MemberDAO {
	
	Connection conn;
	DataBase dataBase;
	SessionDTO sessionDTO = SessionDTO.getInstance();
	Statement stmt;
	ResultSet rs;
	DateT date;
	
	public MemberDAO() {
		dataBase = new DataBase();
		conn = dataBase.conn();
	}
	
	// 1�� ��� id �Ǵ� �н����� ����ġ
	// 2�� ��� �����ȣ ����ġ
	// 3�� ��� �Ⱓ����
	// 4�� ��� ����
	public int login(String id, String password, String examNumber) {
		String tempId = "";
		String tempName = "";
		
		String memberSql = "select id,name from member "+ "where id ='"+id+"' and  password = '"+password+"'";
		String examSql = "select enforce_date from exam where exam_number = '"+examNumber+"'";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(memberSql);
			
			if(rs.next()) 
			{
				tempId = rs.getString("id");
				tempName = rs.getString("name");
			}
			else return 1;

			rs = stmt.executeQuery(examSql);
			
			if(rs.next()) 
			{	
				// ��¥��
				date = new DateT();
				int compare = date.todayCompareDate(rs.getString("enforce_date"));
				if(compare > 0) return 3;
				sessionDTO.setId(tempId);
				sessionDTO.setExamNumber(examNumber);
				sessionDTO.setName(tempName);
			}
			else 
			{
				return 2;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			dataBase.disStRs(stmt,rs);
			dataBase.disConn(conn);
		}
		
		return 4;
		
	}
}
