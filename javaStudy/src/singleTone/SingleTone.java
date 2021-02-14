package singleTone;

public class SingleTone {
	// �̱���
	// ��ü ���α׷����� �� �ϳ��� ��ü�� ���鵵�� �����ϴ°� => new �����ڷ� ȣ�� ���ϰ� ���ƾ� �Ѵ�.
	// ������� : �޸� ����
	
	// ���� �ʵ�
	private static SingleTone singleTone = new SingleTone();
	
	// ������ ����
	private SingleTone() {
		System.out.println("�̱��� ��ü�� �����Ǿ����ϴ�.");
	}
	
	static SingleTone getInstance() {
		//singleTone = new SingleTone();
		return singleTone;
	}
}
