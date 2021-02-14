package excel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import excelDTO.excelDTO;


public class Excel {
	private static final String filePath = "C:/Temp/";
	private List<String> nameOverLapList;
	
	public void wirte(ArrayList<excelDTO> list,String fileName) {
		HSSFWorkbook write = new HSSFWorkbook();
		
		nameOverLapList = new ArrayList<String>();
		// 시트별 구분
		for (int i = 0; i < list.size(); i++) 
		{
			HSSFSheet sheet = write.createSheet(nameOverLapCheck(list.get(i).getSheetName()));
			int rowIndex = 0;

			// 행별구분
			ArrayList<String[]> data = list.get(i).getData();
			
			for (int j = 0; j < data.size(); j++) 
			{
				HSSFRow row = sheet.createRow(rowIndex++);
				HSSFCell cell = row.createCell(0);
				for (int k = 0; k < data.get(j).length; k++) {
					cell = row.createCell(k);
					cell.setCellValue(data.get(j)[k]);
				}
			}
		}
		
		fileMake(fileName,write);
		fileRead(fileName);
		
	}
	
	// 중복 방지
	// The workbook already contains a sheet named 방지
	public String nameOverLapCheck(String str) {
		String reString = str;
		
		for (int i = 0; i < nameOverLapList.size(); i++) {
			if(nameOverLapList.get(i).equals(reString)) {
				char[] tempChar = nameOverLapList.get(i).toCharArray();
				String tempString = "";
				for (int j = 0; j < tempChar.length; j++) {
					if(j+1 == tempChar.length) 
					{
						if(Character.isDigit(tempChar[j])) tempString += String.valueOf(((tempChar[j]-'0')+1));
						else tempString += tempChar[j] + "1";
					}else {
						tempString += tempChar[j];
					}
				}
				reString = tempString;
			}
		}
		nameOverLapList.add(reString);
		
		return reString;
	}
	
	public void fileRead(String fileName) {
		try {
			Desktop.getDesktop().open(new File(filePath+fileName+".xls"));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	}
	
	public void fileMake(String fileName,HSSFWorkbook write) {
		FileOutputStream output;
		try {
			output = new FileOutputStream(filePath+fileName+".xls");
			write.write(output);
			output.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void wirte() {
		HSSFWorkbook write = new HSSFWorkbook();
		HSSFSheet sheet = write.createSheet();
		int rowIndex = 0;
		
		HSSFRow row;
		
		for (int i = 0; i < 3; i++) 
		{
			row = sheet.createRow(++rowIndex);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("안녕");
			cell = row.createCell(1);
			cell.setCellValue("하이");
		}
		FileOutputStream output;
		try {
			output = new FileOutputStream("C:/Temp"+"/result.xls");
			write.write(output);
			output.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Excel excel = new Excel();
		excel.wirte();
	}
}
