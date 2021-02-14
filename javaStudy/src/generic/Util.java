package generic;

public class Util {
	
	public static <T> Box<T> boxing(T t){
		Box<T> b = new Box<T>();
		b.setT(t);
		return b;
	}
}
