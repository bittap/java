package Abstract;

public class AbstractSon extends Abstract {

	public AbstractSon(String owner) {
		super(owner);
	}
	
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
	
	@Override
	protected void turnOff() {
		System.out.println("무조건 끈다");
	}
	
	

}
