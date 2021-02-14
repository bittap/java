package stream_assistant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 기본 타입 입출력 보조 스트림
 * 
 */
public class DataStreamE {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("c:/Temp/primitive.db");
		DataOutputStream dos = new DataOutputStream(fos);
		
		
		dos.writeUTF("홍길동");
		dos.writeDouble(95.5);
		dos.writeInt(10);
		
		dos.writeUTF("김자바");
		dos.writeDouble(90.3);
		dos.writeInt(2);
		
		dos.flush();
		dos.close();
		
		FileInputStream fis = new FileInputStream("c:/Temp/primitive.db");
		DataInputStream dis = new DataInputStream(fis);
		
		int data;
		while ((data = dis.read()) != -1) {	
			System.out.println(dis.readUTF()+" "+dis.readDouble()+" "+dis.readInt());
		}
	}

}
