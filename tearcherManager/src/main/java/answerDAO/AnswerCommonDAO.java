package answerDAO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import common.Common;
import database.DataBase;

public class AnswerCommonDAO {
	
	public Map<String, String> selExamData(String exam_number) {
		DataBase DataBase = new DataBase();
		Map<String,String> map = DataBase.oneSelect("select * from exam where exam_number = '"+exam_number+"' limit 1",DataBase.conn()); // 
		DataBase.disConn();
		
		return map;
	}
	
	public List<Map<String, String>> selExamMData(String exam_number, String table) {
		DataBase DataBase = new DataBase();
		List<Map<String, String>> map = DataBase.allSelect("select * from "+ table +" where exam_number = '"+exam_number+"'",DataBase.conn());
		DataBase.disConn();
		
		return map;
	}
	
	

	public static boolean insertOrUpdate(JFrame jFrame, boolean modifyFlag, HashMap<String, String> data, String examNumber, String table, String num) {
		DataBase DataBase = new DataBase();
		boolean resultFlag = false;
		// ¼öÁ¤
		if(modifyFlag == true) 
		{
			if(!Common.isEmpty(num)) 
			{
				resultFlag = DataBase.update(table, data, "exam_number = '"+examNumber+"' and num = '"+num+"'");
			}
			else
			{
				resultFlag = DataBase.update(table, data, "exam_number = '"+examNumber+"'");
			}
			
		}
		// »ðÀÔ
		else
		{
			resultFlag = DataBase.insert(table, data);
		}
		
		DataBase.disConn();
		return resultFlag;
	}
	
	public static void mndUpdate(JFrame jFrame, HashMap<String, String> data, String examNumber) {
		DataBase DataBase = new DataBase();
		
		DataBase.update("exam", data, "exam_number = "+"'"+examNumber+"'");
		
		DataBase.disConn();
	}
	
}
