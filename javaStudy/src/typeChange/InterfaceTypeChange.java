package typeChange;

import Interface.RemoteControl;
import Interface.Television;

public class InterfaceTypeChange {

	public static void main(String[] args) {
		// �������̽� �� ��ȯ
		
		// �ڵ� ����ȯ
		// �������̽� = �ڽ�
		RemoteControl remoteControl = new Television("����");
		remoteControl.turnOn();
		remoteControl.turnOff();
		// ���� ����ȯ
		// �ڽ� = (�ڽ�)�������̽�
		// ���� ����ȯ�� �������̽��� �ִ� �Լ��ۿ� ����� �� ���� �Ѱ�� ���� ����Ѵ�.
		Television television = (Television) remoteControl;
		television.turnOn();
		television.turnOff();
		television.tv();
		
	}

}
