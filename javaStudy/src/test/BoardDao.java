package test;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	public List<Board> getBoardList(){
		
		ArrayList<Board> arryList = new ArrayList<Board>();
		
		arryList.add(new Board("力格1","郴侩1"));
		arryList.add(new Board("力格2","郴侩2"));
		arryList.add(new Board("力格3","郴侩3"));
		
		return arryList;
	}
	

}
