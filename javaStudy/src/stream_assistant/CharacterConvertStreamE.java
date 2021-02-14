package stream_assistant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

class CharacterConvertStreamE {

	public static void main(String[] args) {
		write("문자 변환 스트림을 사용합니다.");
		String data = read();
		System.out.println(data);
	}
	
	public static void write(String str) {
		try {
			FileOutputStream fos = new FileOutputStream("c:/Temp/test7.txt");
			Writer writer = new OutputStreamWriter(fos);
			writer.write(str);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static String read() {
		try {
			FileInputStream fis = new FileInputStream("c:/Temp/test7.txt");
			Reader reader = new InputStreamReader(fis);
			int data;
			String strData = "";
			while ((data = reader.read()) != -1) {
				strData += String.valueOf((char)data);
			}
			return strData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
