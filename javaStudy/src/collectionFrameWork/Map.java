package collectionFrameWork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Map {

	public static void main(String[] args) {
		// 키, 벨류
		// 생성방법
		java.util.Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("안녕", 27);
		map.put("안녕2", 30);
		
		// 첫 번쨰 호출 방법
		
		java.util.Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Integer value = map.get(key);
			
			System.out.printf("key = %s , value = %d\n",key,value);
		}
		
		// 두 번째 호출 방법
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<java.util.Map.Entry<String, Integer>> entryIter = entrySet.iterator();
		while(entryIter.hasNext()) {
			java.util.Map.Entry<String, Integer> entry = entryIter.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.printf("key = %s , value = %d\n",key,value);
		}
		
		// 세 번째 호출 방법
		Set<Entry<String, Integer>> entrySet2 = map.entrySet();
		Iterator<java.util.Map.Entry<String, Integer>> entryIter2 = entrySet.iterator();
		for (Entry<String, Integer> entry : entrySet2) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.printf("key = %s , value = %d\n",key,value);
		}
	}

}
