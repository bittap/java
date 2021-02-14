package api;

import java.util.HashMap;

public class Equals {
	private String id;
	
	Equals(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	private boolean equl(Object obj) {
		if(obj instanceof Equals) {
			Equals eq = (Equals)obj;
			if(eq.id.equals(this.id)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
			
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	public static void main(String[] args) {
		Equals eq = new Equals("±èÅÂ¿µ");
		Equals eq1 = new Equals("±èÅÂ¿µ2");
		System.out.println(eq.equl(eq1));
		
		HashMap<Object, String> hashMap = new HashMap<Object, String>();
		hashMap.put(eq, "str");
		Object obj = new Object();
		System.out.println(obj.hashCode());
		System.out.println(hashMap.get(new Equals("12")));
	}

}
