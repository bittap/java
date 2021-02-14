package collectionFrameWork;

import java.util.HashSet;
import java.util.Iterator;

public class Set {

	public static void main(String[] args) {
		// 인덱스가 아니라 이름으로 가져온다.
		
		// 생성방법
		java.util.Set<String> set = new HashSet<String>();
		java.util.Set<String> set2 = new HashSet<>();
		
		set.add("java");
		set.add("C");
		set.add("c++");
		
		// 호출방법 1
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key);
		}
		
		// 호출방법 2
		for (String element : set) {
			System.out.println(element);
		}
	}

}
