package generic;

public class UtilInvoke {

	public static void main(String[] args) {
		Box<Integer> box = Util.<Integer>boxing(10);
		System.out.println(box.getT());
		
		Box<String> box2 = Util.boxing("�ȳ�");
		System.out.println(box2.getT());
	}

}
