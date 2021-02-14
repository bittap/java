package typeChange;

import Interface.RemoteControl;
import Interface.Television;

public class InterfaceTypeChange {

	public static void main(String[] args) {
		// 인터페이스 형 변환
		
		// 자동 형변환
		// 인터페이스 = 자식
		RemoteControl remoteControl = new Television("ㅇㅇ");
		remoteControl.turnOn();
		remoteControl.turnOff();
		// 강제 형변환
		// 자식 = (자식)인터페이스
		// 강제 형변환은 인터페이스에 있는 함수밖에 사용할 수 없는 한계로 인해 사용한다.
		Television television = (Television) remoteControl;
		television.turnOn();
		television.turnOff();
		television.tv();
		
	}

}
