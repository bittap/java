package test;

import java.util.HashMap;
import java.util.Iterator;

public class SekiShitei {

	public static void main(String[] args) {
		String[] name = new String[] {"ȫ����","���¿�","�ŵ���","������","�Ͽ���","�ѱ��","�躸��","�̹�ȣ"};
		String outStr = "";
		
		HashMap<Integer, Integer> hashLen = new HashMap<Integer, Integer>();
		
		HashMap<Integer, String> sysoutName = new HashMap<Integer, String>();


		for (int i = 1; i <= name.length; i++) {
			hashLen.put(i, i);
		}

		// ù ��° �����
		int i = 0;
		int tempSu = (int)(Math.random()*name.length)+1;
		hashLen.remove(tempSu);
		sysoutName.put(tempSu, name[i++]);
		
		// �� ��° ����� ����
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
			outStr += value+"��"+key+"��° �ڸ��Դϴ�.\\r\\n"+"\\r\\n";
			System.out.printf("%s�� %d��° �ڸ��Դϴ�.\n",value,key);
		}
		
		Main main1 = new Main();
		main1.testSend(outStr);
		
		
	}
	


}
