package nested;

public class LocalClassThis {
	String innerFiled = "�ʵ�";
	
	void innerMethod() {
		System.out.println("�޼ҵ�");
	}

	public class inner{
		String innerFiled = "�̳� �ɹ�Ŭ���� �ʵ�";
		
		void innerMethod() {
			System.out.println("�̳� �ɹ�Ŭ���� �޼ҵ�");
		}
		
		void print() {
			// �׳� this�� ���ô� �ڱ� Ŭ����
			System.out.println(this.innerFiled);
			this.innerMethod();
			
			// ���� Ŭ����.this.
			System.out.println(LocalClassThis.this.innerFiled);
			LocalClassThis.this.innerMethod();
		}
	}
	
	public static void main(String[] args) {
		LocalClassThis localClassThis = new LocalClassThis();
		LocalClassThis.inner inner = localClassThis.new inner();
		
		inner.print();
	}

}
