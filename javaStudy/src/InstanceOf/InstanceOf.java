package InstanceOf;


class Mom{
	private int mom = 10;
	
	void method1() {
		System.out.println("method1 ȣ��");
	}
	void method2() {
		System.out.println("method2 ȣ��");
	}
}

class Sun extends Mom{
	
	void method3(){
		System.out.println("method3 ȣ��");
	}
	
	void method4(){
		System.out.println("method4 ȣ��");
	}
}
public class InstanceOf {

	public static void main(String[] args) {
		// A(��ü) instancof B(Ÿ��)
		// A�� B�� Ÿ������ ��ü�� ���������� True ���� �ƴϸ� false ����
		// ��������ȯ�� �ش簴ü�� �ڵ�����ȯ �ƴ��� �ȵƴ����� �˻��ϱ� ���� ���
		
		
		Mom mom = new Sun();
		mom.method1();
		mom.method2();
		
		Sun sun = (Sun)mom;
		sun.method3();
		sun.method4();
		
		Mom mom2 = new Mom();
		if(mom2 instanceof Sun) {
			Sun sun2 = (Sun)mom2;
			sun2.method1();
		}else {
			System.out.println("���� ����ȯ Ȯ��");
		}
		
		
	}

}
