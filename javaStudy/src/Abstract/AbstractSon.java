package Abstract;

public class AbstractSon extends Abstract {

	public AbstractSon(String owner) {
		super(owner);
	}
	
	public void internetSearch() {
		System.out.println("���ͳ� �˻��� �մϴ�.");
	}
	
	@Override
	protected void turnOff() {
		System.out.println("������ ����");
	}
	
	

}
