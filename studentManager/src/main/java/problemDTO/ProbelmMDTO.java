package problemDTO;


import java.util.List;
import java.util.Map;


public class ProbelmMDTO {
	private List<Map<String,String>> list;
	private static ProbelmMDTO probelmMDTO = new ProbelmMDTO();
	
	private ProbelmMDTO() {
		
	}
	
	public static ProbelmMDTO getInstance() {
		return probelmMDTO;
	}

	public List<Map<String,String>> getList() {
		return list;
	}

	public void setList(List<Map<String,String>> list) {
		this.list = list;
	}

	
	

}
