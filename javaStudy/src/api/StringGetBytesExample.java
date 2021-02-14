package api;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {

	public static void main(String[] args) {
		String str = "æ»≥Á«œººø‰";
		
		byte[] bytes = str.getBytes();
		System.out.println("byes.length : "+bytes.length);
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes2.length : "+bytes2.length);

			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length : "+bytes3.length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}
