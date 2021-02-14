package stream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

class InputStreamExample {

	public static void main(String[] args) throws IOException {
		
		InputStream inputStream = new FileInputStream("C:/Temp/test1.txt");
		
		int data;
		
		try {
			while((data = inputStream.read())!= -1) {
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			inputStream.close();
		}
		
		System.out.println("------------------------");
		
		InputStream inputStream2 = new FileInputStream("C:/Temp/test2.txt");
		
		byte[] data2 = new byte[10];
		
		if(inputStream2.read(data2) != -1) {
			for (int i = 0; i < data2.length; i++) {
				System.out.println(data2[i]);
			}
		}
		System.out.println("------------------------");
		
		InputStream inputStream3 = new FileInputStream("C:/Temp/test3.txt");
		
		byte[] data3 = new byte[10];
		
		if(inputStream3.read(data3, 2, 3) != -1) {
			for (int i = 0; i < data3.length; i++) {
				System.out.println(data3[i]);
			}
		}
		
		System.out.println("------------------------");
		
		Reader reader = new FileReader("c:/Temp/test4.txt");
		
		int data4;
		
		while ((data4 = reader.read()) != -1) {
			System.out.println((char)data4);
		}
		
		System.out.println("------------------------");
		
		Reader reader2 = new FileReader("c:/Temp/test5.txt");
		
		char[] data5 = new char[10];
		
		if(reader2.read(data5) != -1) {
			for (char c : data5) {
				System.out.println(c);
			}
		}
	}

}
