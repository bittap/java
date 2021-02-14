package collectionFrameWork;

import java.util.HashSet;
import java.util.Iterator;

public class Set {

	public static void main(String[] args) {
		// �ε����� �ƴ϶� �̸����� �����´�.
		
		// �������
		java.util.Set<String> set = new HashSet<String>();
		java.util.Set<String> set2 = new HashSet<>();
		
		set.add("java");
		set.add("C");
		set.add("c++");
		
		// ȣ���� 1
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key);
		}
		
		// ȣ���� 2
		for (String element : set) {
			System.out.println(element);
		}
	}

}
