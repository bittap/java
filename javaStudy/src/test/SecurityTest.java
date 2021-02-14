package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityTest {
	

	public static void main(String[] args) {
		String sha = "";
		String str = "";
		
		try {
			MessageDigest meDigest = MessageDigest.getInstance("SHA-256");
			meDigest.update(str.getBytes());
			byte byteData[] = meDigest.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i]&0xff)+0x100,16).substring(1));
			}
			sha = sb.toString();
			System.out.println(sha);
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
	}
}
