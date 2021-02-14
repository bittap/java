package problemDTO;

import java.util.List;
import java.util.Map;


public class ProbelmSDTO {
	private List<Map<String,String>> list;
	private static ProbelmSDTO probelmSDTO = new ProbelmSDTO();
	
	private ProbelmSDTO() {
		
	}
	
	public static ProbelmSDTO getInstance() {
		return probelmSDTO;
	}

	public List<Map<String,String>> getList() {
		return list;
	}

	public void setList(List<Map<String,String>> list) {
		this.list = list;
	}

	
	

}
