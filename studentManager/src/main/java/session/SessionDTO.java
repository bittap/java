package session;

/**
 * @author jmp17
 *
 */
public class SessionDTO {
	private String id;
	private String examNumber;
	private String name;
	
	private static SessionDTO SessionDTO = new SessionDTO();
	
	private SessionDTO() {
		
	}
	
	public static SessionDTO getInstance() {
		return SessionDTO;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExamNumber() {
		return examNumber;
	}
	public void setExamNumber(String examNumber) {
		this.examNumber = examNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
