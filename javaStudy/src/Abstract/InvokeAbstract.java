package Abstract;

public class InvokeAbstract {

	public static void main(String[] args) {
		
		// �߻�޼ҵ� ȣ�� ù��° ���
		AbstractSon abstractSon = new AbstractSon("���¿�");
		
		abstractSon.turnOn();
		abstractSon.internetSearch();
		abstractSon.turnOff();
		
		// �߻�޼ҵ� ȣ�� �ι�° ���
		Abstract abstract1 = null;
		abstract1 = new AbstractSon("���¿�");
		abstract1.turnOn();
		abstract1.turnOff();
		
		// �߻�޼ҵ� ȣ�� ����° ���
		turnOff(new AbstractSon("���¿�"));
	}
	
	public static void turnOff(Abstract abstract1) {
		abstract1.turnOff();
	}

}
