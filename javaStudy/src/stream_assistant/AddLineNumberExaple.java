package stream_assistant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AddLineNumberExaple {

	public static void main(String[] args) throws IOException {
		String filePath = "src/stream_assistant/AddLineNumberExaple.java";
		
		FileReader fr = new FileReader(filePath);
		BufferedReader bfr = new BufferedReader(fr);
		
		int rowNumber = 0;
		String data;

		String outputData = "";
		
		while ((data =bfr.readLine()) != null) {
			++rowNumber;
			if(rowNumber == 1) {
				outputData = data+"\n";
			}else {
				outputData = outputData+data+"\n";
			}
		}
		
		String[] outArr = outputData.split("\n");
		int preLenStr = String.valueOf(outArr.length).length();
		String space = "";
		
		for (int i = 0; i < preLenStr; i++) {
			space = space+ " ";
		}
		int startLenStr = 1;
		
		for (int i = 1; i <= outArr.length; i++) {
			int nowLenStr = String.valueOf(i).length();
			// ÀÚ¸´¼ö º¯µ¿
			if(startLenStr != nowLenStr) {
				space = space.substring(0, space.length()-1);
				startLenStr++;
			}
			System.out.println(i+space+outArr[i-1]);
		}
	}

}






















































































