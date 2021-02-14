package stream_assistant;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * ���۽�Ʈ���� �ӵ� ����� ���� ����Ѵ�.
 * �ϵ��ũ �ӵ��� ���簡�Ƿ� �װ��� ���� ���ۿ� ��� ó���ؼ� �ӵ� ����� ������
 * 
 */

class BufferStreamE {

	public static void main(String[] args) throws FileNotFoundException {
		// �������
		/*
		 * BufferedOutputStream bop = new BufferedOutputStream(null); // ����Ʈ ��� ��� ��Ʈ��
		 * BufferedWriter bw = new BufferedWriter(null); // ���� ��� ��� ��Ʈ��
		 * 
		 * BufferedInputStream bis = new BufferedInputStream(null); // ����Ʈ ��� �Է� ��Ʈ��
		 * BufferedReader br = new BufferedReader(null); // ���� ��� �Է� ��Ʈ��
		 */	    
	    
	    System.out.println("------------------��������-----------------");
	    
	    String originalFilePath = BufferStreamE.class.getResource("tenshi.jpg").getPath();
	    String targetFilePath = "c:/Temp/tenshi.jpg";
	    InputStream is = new FileInputStream(originalFilePath);
	    OutputStream os = new FileOutputStream(targetFilePath);
	    
	    String originalFilePath2 = BufferStreamE.class.getResource("tenshi.jpg").getPath();
	    String targetFilePath2 = "c:/Temp/tenshi2.jpg";
	    InputStream is2 = new FileInputStream(originalFilePath2);
	    OutputStream os2 = new FileOutputStream(targetFilePath2);
	    BufferedInputStream bis = new BufferedInputStream(is2);
	    BufferedOutputStream bos = new BufferedOutputStream(os2);
	    
	    long noBuffer = copy(is,os);
	    System.out.println("���� ������ : "+noBuffer);
	    
	    long buffer = copy(bis,bos);
	    System.out.println("���� ������ : "+buffer);
	    
	}
	
	public static long copy(InputStream is, OutputStream os) {
		long start = System.nanoTime();
		int data;
		try {
			while ((data = is.read()) != -1) {
				os.write(data);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		long end = System.nanoTime();
		
		return (end-start);
		
	}

}
