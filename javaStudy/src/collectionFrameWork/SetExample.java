package collectionFrameWork;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member(27, "±èÅÂ¿µ"));
		set.add(new Member(27, "±èÅÂ¿µ"));
		
		Iterator<Member> iterator = set.iterator();
		System.out.println(set.size());
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next().age);
		}
	}

}
