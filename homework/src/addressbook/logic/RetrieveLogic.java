package addressbook.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import addressbook.dto.AddressDTO;

public class RetrieveLogic {
	
	private Connection connSetting() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "111111");

		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url,props);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public List<AddressDTO> addressBookS (int itemNum,int nowPageNum){
		Connection conn = connSetting();
		List<AddressDTO> list = new ArrayList<AddressDTO>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from AddressBook order by num asc limit "+itemNum+" offset "+itemNum*(nowPageNum-1);
			rs = stmt.executeQuery(sql);
			while(rs.next()) 
			{
				AddressDTO dto = new AddressDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setMail_address(rs.getString("mail_address"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setAddress(rs.getString("address"));
				dto.setReg_date(rs.getDate("reg_date"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			allQuit(conn,stmt,rs);
		}
		
		return list;
	}
	
	public int getPrevNumber(int pageNum,int nowPageNum) {
		int prevResult = 0;
		
		int mok = (int) Math.ceil((double)nowPageNum/pageNum);
		
		if(mok == 1) prevResult = 1;
		else prevResult = (mok-2)*pageNum+1;

		return prevResult;
	}
	
	public int getNextNumber(int pageNum,int itemNum,int nowPageNum) {
		int allPage = getAllPageNumber(itemNum);
		int nextResult = 0;
		
		int mok = (int) Math.ceil((double)nowPageNum/pageNum);
		
		nextResult = (mok)*pageNum+1;
		if(nextResult > allPage) nextResult = (mok-1)*pageNum+1;
		
		return nextResult;
	}
	
	private int getAllPageNumber(int itemNum) {
		int allPage = 0;
		Connection conn = connSetting();
		AddressDTO dto = new AddressDTO();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from AddressBook";
			rs = stmt.executeQuery(sql);
			if(rs.next()) 
			{
				allPage = (int) Math.ceil((double)rs.getInt(1)/itemNum);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			allQuit(conn,stmt,rs);
		}
		
		return allPage;
	}
	
	public List<Integer> addressPages(int pageNum, int itemNum, int nowPageNum) {
		int allPage = getAllPageNumber(itemNum);
		List<Integer> list = new ArrayList<Integer>();
		
		int mok = (int) Math.ceil((double)nowPageNum/pageNum);
		
		int start = ((mok-1)*pageNum)+1;
		for (int i = start; i <= start+pageNum-1; i++) {
			if(i > allPage) break;
			list.add(i);
		}
		
		
		return list;
	}
	
	public AddressDTO addressBook(int dataNum) {
		Connection conn = connSetting();
		AddressDTO dto = new AddressDTO();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from AddressBook where num = "+dataNum;
			rs = stmt.executeQuery(sql);
			if(rs.next()) 
			{
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setMail_address(rs.getString("mail_address"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setAddress(rs.getString("address"));
				dto.setReg_date(rs.getDate("reg_date"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			allQuit(conn,stmt,rs);
		}
		
		return dto;
	}
	
	
	private void allQuit(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
}
