package api;

import java.io.IOException;

public class ByteToStringExample {
	public static void main(String[] args) throws IOException {
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		
		byte[] bytes2 = new byte[100];
		
		int readByteNo = System.in.read(bytes2);
		
		String str = new String(bytes2, 0, readByteNo-2);
		
		System.out.println(str);

	}
}
