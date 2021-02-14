package addressbook.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import addressbook.dto.AddressDTO;


public class RegisterLogic {
	
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
	
	public boolean addressBookInsert(AddressDTO dto) {
		Connection conn = connSetting();
		int row = 0;
		PreparedStatement stmt = null;

		String sql = "insert into AddressBook (name, mail_address, phone_number, address, reg_date) VALUES (?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getMail_address());
			stmt.setString(3, dto.getPhone_number());
			stmt.setString(4, dto.getAddress());
			stmt.setDate(5, dto.getReg_date());
			row = stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			allQuit(conn,stmt);
		}
		
		if(row > 0) return true;
		else  return false;
	}
	
	
	private void allQuit(Connection conn, PreparedStatement stmt) {
		try {
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
