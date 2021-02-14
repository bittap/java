package common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	
	public String encryptSHA256(String str) {
		String sha = "";
		
		try {
			MessageDigest meDigest = MessageDigest.getInstance("SHA-256");
			meDigest.update(str.getBytes());
			byte byteData[] = meDigest.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i]&0xff)+0x100,16).substring(1));
			}
			sha = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		return sha;
	}
}
