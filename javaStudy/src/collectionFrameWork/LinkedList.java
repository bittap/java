package collectionFrameWork;

import java.util.ArrayList;
import java.util.List;

class LinkedList {

	public static void main(String[] args) {
		// ��ũ�� �����Ͽ� �ϹǷ� �߰��� �߰��� �� ������
		// �������
		List<String> link = new java.util.LinkedList<String>();
		List<String> link2 = new java.util.LinkedList<>();
		
		ArrayList<String> arrayList = new ArrayList<String>();
		List<String> link3 = new java.util.LinkedList<String>();
		
		long firstTime = System.nanoTime();
		
		for (int i = 0; i < 10000; i++) {
			arrayList.add(0, "��");
		}
		
		long lastTime = System.nanoTime();
		
		System.out.println("List�����ð� : " + (lastTime-firstTime));
	}

}
