package Abstract;

public abstract class Abstract {
	// �߻�޼ҵ�� ���߽� �����ڰ� ����� ���赵�� ����.
	// ������ ����� �޾Ƽ� ����Ѵ�. new �����ڷ� ���� �Ұ�
	public String owner;
	
	public Abstract(String owner) {
		this.owner=owner;
	}
	
	public void turnOn() {
		System.out.println("�� ������ �մϴ�.");
	}
	// �� ��⸶�� turnoff����� �ٸ��� ���� ������ �ڽ�Ŭ�������� �������ϰ� ��������� ���������� �����Ѵ�.
	// [public / protected] abstarct ����Ÿ�� �޼ҵ��̸�(�Ű�����);
	protected abstract void turnOff();
}
