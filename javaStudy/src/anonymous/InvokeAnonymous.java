package anonymous;

public class InvokeAnonymous {

	public static void main(String[] args) {
		Anonymous anonymous = new Anonymous();
		// �͸�ü�� �ʵ� ���
		anonymous.filed.wake();
		// �͸�ü�� ���� ���� ���
		anonymous.method1();
		// �͸�ü�� �Ű��� ���
		anonymous.method2(
			new Person() {
				void study() {
					System.out.println("�����մϴ�.");
				}	
				@Override
				void wake() {
					System.out.println("8�ÿ� �Ͼ�ϴ�.");
					study();
				}
			}
		);
	}

}
