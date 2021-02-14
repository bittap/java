package collectionFrameWork;

import java.util.ArrayList;
import java.util.List;

class LinkedList {

	public static void main(String[] args) {
		// 링크로 연결하여 하므로 중간에 추가할 때 빠르다
		// 생성방법
		List<String> link = new java.util.LinkedList<String>();
		List<String> link2 = new java.util.LinkedList<>();
		
		ArrayList<String> arrayList = new ArrayList<String>();
		List<String> link3 = new java.util.LinkedList<String>();
		
		long firstTime = System.nanoTime();
		
		for (int i = 0; i < 10000; i++) {
			arrayList.add(0, "응");
		}
		
		long lastTime = System.nanoTime();
		
		System.out.println("List생성시간 : " + (lastTime-firstTime));
	}

}
