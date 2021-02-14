package stream_assistant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class BufferReaderE {

	public static void main(String[] args) throws FileNotFoundException {
		
		Reader reader = new FileReader("c:/Temp/test6.txt");
		BufferedReader bfr = new BufferedReader(reader);
		
		String data = "";
		
		try {
			while((data = bfr.readLine()) != null) {
				System.out.println(data);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
