package collectionFrameWork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Map {

	public static void main(String[] args) {
		// Ű, ����
		// �������
		java.util.Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("�ȳ�", 27);
		map.put("�ȳ�2", 30);
		
		// ù ���� ȣ�� ���
		
		java.util.Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Integer value = map.get(key);
			
			System.out.printf("key = %s , value = %d\n",key,value);
		}
		
		// �� ��° ȣ�� ���
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<java.util.Map.Entry<String, Integer>> entryIter = entrySet.iterator();
		while(entryIter.hasNext()) {
			java.util.Map.Entry<String, Integer> entry = entryIter.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.printf("key = %s , value = %d\n",key,value);
		}
		
		// �� ��° ȣ�� ���
		Set<Entry<String, Integer>> entrySet2 = map.entrySet();
		Iterator<java.util.Map.Entry<String, Integer>> entryIter2 = entrySet.iterator();
		for (Entry<String, Integer> entry : entrySet2) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.printf("key = %s , value = %d\n",key,value);
		}
	}

}
