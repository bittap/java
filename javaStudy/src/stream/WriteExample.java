package stream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

class WriteExample {

	public static void main(String[] args) throws IOException {
		
		OutputStream outputStream = new FileOutputStream("C:/Temp/test1.txt");
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		outputStream.write(a);
		outputStream.write(b);
		outputStream.write(c);
		
		outputStream.flush();
		outputStream.close();
		
		System.out.println("----------------------------------------------");
		
		OutputStream outputStream2 = new FileOutputStream("C:/Temp/test2.txt");
		
		byte[] d = new byte[] {10,20,30};
		
		outputStream2.write(d);
		
		outputStream2.flush();
		outputStream2.close();
		
		System.out.println("----------------------------------------------");
		
		OutputStream outputStream3 = new FileOutputStream("C:/Temp/test3.txt");
		
		byte[] e = new byte[] {10,20,30,40,50};
		
		outputStream3.write(e,1,3);
		
		outputStream3.flush();
		outputStream3.close();
		
		System.out.println("----------------------------------------------");
		
		Writer writer = new FileWriter("c:/Temp/test4.txt");
		
		writer.write('A');
		writer.write('B');
		writer.write('C');
		
		writer.flush();
		writer.close();
		
		System.out.println("----------------------------------------------");
		
		Writer writer2 = new FileWriter("c:/Temp/test5.txt");
		
		char[] charArr = new char[] {'A','B','C'};
		
		writer2.write(charArr);
		
		writer2.flush();
		writer2.close();
		
		System.out.println("----------------------------------------------");
		
		Writer writer3 = new FileWriter("c:/Temp/test6.txt");
		
		char[] charArr2 = new char[] {'A','B','C','D','E'};
		
		writer3.write(charArr2,1,3);
		
		writer3.flush();
		writer3.close();
		
	}

}
