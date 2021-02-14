package stream_assistant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * �⺻ Ÿ�� ����� ���� ��Ʈ��
 * 
 */
public class DataStreamE {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("c:/Temp/primitive.db");
		DataOutputStream dos = new DataOutputStream(fos);
		
		
		dos.writeUTF("ȫ�浿");
		dos.writeDouble(95.5);
		dos.writeInt(10);
		
		dos.writeUTF("���ڹ�");
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
