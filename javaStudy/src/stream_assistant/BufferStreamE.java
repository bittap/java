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
 * 버퍼스트림은 속도 향상을 위해 사용한다.
 * 하드디스크 속도에 맞춰가므로 그것을 따로 버퍼에 모아 처리해서 속도 향상을 도모함
 * 
 */

class BufferStreamE {

	public static void main(String[] args) throws FileNotFoundException {
		// 생성방법
		/*
		 * BufferedOutputStream bop = new BufferedOutputStream(null); // 바이트 기반 출력 스트림
		 * BufferedWriter bw = new BufferedWriter(null); // 문자 기반 출력 스트림
		 * 
		 * BufferedInputStream bis = new BufferedInputStream(null); // 바이트 기반 입력 스트림
		 * BufferedReader br = new BufferedReader(null); // 문자 기반 입력 스트림
		 */	    
	    
	    System.out.println("------------------성능차이-----------------");
	    
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
	    System.out.println("버퍼 사용안함 : "+noBuffer);
	    
	    long buffer = copy(bis,bos);
	    System.out.println("버퍼 사용안함 : "+buffer);
	    
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
