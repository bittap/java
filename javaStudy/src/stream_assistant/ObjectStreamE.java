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
 * ObjectInputStream은 객체로 역직렬화
 * ObjectOutputStream은 객체를 직렬화하는 역활
 * 직렬화란 객체를 바이트
 * 역직렬화란 바이트를 객체로
 * 
 * Serializable 인터페이스는 메소드 선언이 없는 인터페이스
 * JVM에게 직렬화해도 좋다고 승인하는 역활
 * 
 */
public class ObjectStreamE {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeList(); // List를 파일에 저장
		List<Board> list = readList(); // 파일에 저장된 List 읽기
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		for (Board board : list) {
			System.out.println(board.getBno()+"\t"+board.getTitle()+"\t"+board.getContent()+"\t"+board.getWriter()+"\t"+sdf.format(board.getDate()));
		}
	}
	
	public static void writeList() throws IOException {
		List<Board> list = new ArrayList<Board>();
		
		list.add(new Board(1, "제목1", "내용1", "글쓴이1",new Date()));
		list.add(new Board(2, "제목2", "내용2", "글쓴이2",new Date()));
		list.add(new Board(3, "제목3", "내용3", "글쓴이3",new Date()));
		
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
