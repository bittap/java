package excelDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class excelDTO {
	private String sheetName;
	private ArrayList<String[]> data;
	
	
	public excelDTO(String sheetName, ArrayList<String[]> data) {
		super();
		this.sheetName = sheetName;
		this.data = data;
	}
	
	
	public String getSheetName() {
		return sheetName;
	}
	
	public ArrayList<String[]> getData() {
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
}
