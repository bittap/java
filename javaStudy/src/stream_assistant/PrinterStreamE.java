package stream_assistant;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
 * PrintStream : ����Ʈ ��� ��½�Ʈ��
 * PrintWriter : ���� ��� ��½�Ʈ��
 * print, println�� ������ �ִ� ���� ��Ʈ��
 */
public class PrinterStreamE {

	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:/Temp/test8.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.println("[������ ���� ��Ʈ��]");
		ps.print("��ġ");
		ps.println("�����Ͱ� ����ϴ� ��ó��");
		ps.println("�����͸� ����մϴ�.");
		
		ps.flush();
		ps.close();
	}

}
