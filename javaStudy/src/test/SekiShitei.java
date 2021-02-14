package test;

import java.util.HashMap;
import java.util.Iterator;

public class SekiShitei {

	public static void main(String[] args) {
		String[] name = new String[] {"홍성현","김태영","신동진","윤병갑","하영종","한기옥","김보람","이민호"};
		String outStr = "";
		
		HashMap<Integer, Integer> hashLen = new HashMap<Integer, Integer>();
		
		HashMap<Integer, String> sysoutName = new HashMap<Integer, String>();


		for (int i = 1; i <= name.length; i++) {
			hashLen.put(i, i);
		}

		// 첫 번째 실행시
		int i = 0;
		int tempSu = (int)(Math.random()*name.length)+1;
		hashLen.remove(tempSu);
		sysoutName.put(tempSu, name[i++]);
		
		// 두 번째 실행시 부터
		while(true) {
			while(true) {
				tempSu = (int)(Math.random()*name.length)+1;

				try {
					if(hashLen.get(tempSu) != null) {
						hashLen.remove(tempSu);
						sysoutName.put(tempSu, name[i++]);
						break;
					}
				} catch (IndexOutOfBoundsException e) {
					
				}
			}
			
			if(hashLen.size() == 0) {
				break;
			}
		}
		
		Iterator<Integer> iterator = sysoutName.keySet().iterator();
		
		while (iterator.hasNext()) {
			int key = iterator.next();
			String value = sysoutName.get(key);
			outStr += value+"은"+key+"번째 자리입니다.\\r\\n"+"\\r\\n";
			System.out.printf("%s는 %d번째 자리입니다.\n",value,key);
		}
		
		Main main1 = new Main();
		main1.testSend(outStr);
		
		
	}
	


}
