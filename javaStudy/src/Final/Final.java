package Final;


// final  Ŭ����
// �������� Ŭ������� �ǹ̷� ��ӺҰ�
public class Final {
	
	// final �ʵ�
	// �ѹ� �����ϸ� ������ �Ұ���
	// �ʵ� ����� ���� ���� ������ �����ڿ��� ���� �־����� ������ ������ �߻��Ѵ�.
	final String nation = "korea";
	final String ssn;
	String name;
	
	public Final() {
		ssn = "930816";
	}
	
	// final �޼ҵ�
	public static void main(String[] args) {
		Final finalClass = new Final();
		System.out.println(finalClass.ssn);
	}

}
