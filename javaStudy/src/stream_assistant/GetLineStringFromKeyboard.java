package stream_assistant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class GetLineStringFromKeyboard {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		
		while (true) {
			System.out.print("�Է��ϼ��� : ");
			String str = br.readLine();
			if(str.equals("q") || str.equals("quit"))break;
			System.out.println("�Էµ� ���� : "+str);
		}
	}

}
