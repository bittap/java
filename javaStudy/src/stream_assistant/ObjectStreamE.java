package stream_assistant;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * ObjectInputStream�� ��ü�� ������ȭ
 * ObjectOutputStream�� ��ü�� ����ȭ�ϴ� ��Ȱ
 * ����ȭ�� ��ü�� ����Ʈ
 * ������ȭ�� ����Ʈ�� ��ü��
 * 
 * Serializable �������̽��� �޼ҵ� ������ ���� �������̽�
 * JVM���� ����ȭ�ص� ���ٰ� �����ϴ� ��Ȱ
 * 
 */
public class ObjectStreamE {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeList(); // List�� ���Ͽ� ����
		List<Board> list = readList(); // ���Ͽ� ����� List �б�
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		for (Board board : list) {
			System.out.println(board.getBno()+"\t"+board.getTitle()+"\t"+board.getContent()+"\t"+board.getWriter()+"\t"+sdf.format(board.getDate()));
		}
	}
	
	public static void writeList() throws IOException {
		List<Board> list = new ArrayList<Board>();
		
		list.add(new Board(1, "����1", "����1", "�۾���1",new Date()));
		list.add(new Board(2, "����2", "����2", "�۾���2",new Date()));
		list.add(new Board(3, "����3", "����3", "�۾���3",new Date()));
		
		FileOutputStream fos = new FileOutputStream("C:/Temp/board.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}
	
	public static List<Board> readList() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("C:/Temp/board.db");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Board> list = (List<Board>)ois.readObject();
		return list;
	}

}
