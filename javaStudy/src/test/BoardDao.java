package test;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	public List<Board> getBoardList(){
		
		ArrayList<Board> arryList = new ArrayList<Board>();
		
		arryList.add(new Board("����1","����1"));
		arryList.add(new Board("����2","����2"));
		arryList.add(new Board("����3","����3"));
		
		return arryList;
	}
	

}
