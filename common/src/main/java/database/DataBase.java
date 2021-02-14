package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class DataBase {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData metaData;
	
	public DataBase() {
		String url = "jdbc:postgresql://database-2.cl0lyg50oy12.ap-northeast-2.rds.amazonaws.com/postgres";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "11111111");

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url,props);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection conn() {
		return conn;
	}
	
	public void disConn() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void disConn(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	

	public boolean boolSelect(String sql) {
		int count = 0;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			if(count >= 1) {
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			disStRs(stmt,rs);
		}
		
		return false;
	

	}
	
	public void disStRs(Statement stmt,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	// 모든 데이터갖고 올 때
	public List<Map<String,String>> allSelect(String sql,Connection conn) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			metaData = rs.getMetaData();
			int sizeOfColumn = metaData.getColumnCount();
			String column;
	
			while(rs.next()) 
			{
				Map<String, String> map = new HashMap<String, String>();
				
				for (int i = 0; i < sizeOfColumn; i++) 
				{
					column = metaData.getColumnName(i +1);
					map.put(column, rs.getString(column));
				}
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			disStRs(stmt,rs);
		}
		return list;
	}
	
	
	// 하나의 데이터를 가져올 때
	public Map<String,String> oneSelect(String sql,Connection conn) {
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			metaData = rs.getMetaData();
			int sizeOfColumn = metaData.getColumnCount();
			String column;
	
			while(rs.next()) 
			{
				
				for (int i = 0; i < sizeOfColumn; i++) 
				{
					column = metaData.getColumnName(i +1);
					map.put(column, rs.getString(column));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			disStRs(stmt,rs);
		}
		return map;
	}
	
	
	
	public boolean insert(String table, Map<String, String> map) {
		String start = "INSERT INTO "+table+"(";
		String field = "";
		String value = "";
		int i=1;
		
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String keyValue = map.get(key); 
			
			if(i == map.size())
			{
				field = field + key;
				value = value + "'"+keyValue+"'";
			}
			else 
			{
				field = field + key +",";
				value = value + "'"+keyValue+"'"+",";
			}
			i++;
			
		}
		
		field = field + ") VALUES(";
		value = value + ")";
		
		String fullQuery = start+field+value;
		try {
			stmt = conn.createStatement();
			if(stmt.executeUpdate(fullQuery) >= 1)
			{
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			disStRs(stmt,rs);
		}
		
		return false;
	}
	
	public boolean update(String table, Map<String, String> map,String where) {
		String sql = "UPDATE "+table+" SET ";
		
		int i=1;
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String keyValue = map.get(key); 
			
			
			if(i == map.size())
			{
				sql = sql + key +"="+ "'"+keyValue+"'";
			}
			else 
			{
				sql = sql + key +"="+ "'"+keyValue+"'"+",";
			}
			i++;
			
		}
		
		if(!where.equals("")) 
		{
			sql = sql + " where " + where;
		}
		
		System.out.println(sql);

		try {
			stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) >= 1)
			{
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			disStRs(stmt,rs);
		}
		
		
		
		return false;
	}
}
