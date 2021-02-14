package wrapper;

public class Wrapper {

	public static void main(String[] args) {
		// 기본타입의 값을 객체로 생성하는 것을 Wrapper라고 함
		
		// 박싱
		// 기본타입 -> 객체
		Byte byteVal = new Byte((byte)1);
		Character characterVal = new Character('가');
		Short shortVal = new Short((short) 100);
		Integer integerVal = new Integer(100);
		Long longVal = new Long(100);
		Float floatVal = new Float(10f);
		Double doubleVal = new Double(100.10);
		Boolean booleanVal = new Boolean(true);
		// 언박싱
		// 객체 -> 기본타입
		byte byte1 = byteVal.byteValue();
		char charValue = characterVal.charValue();
		short shortValue = shortVal.shortValue();
		int intValue = integerVal.intValue();
		long longValue = longVal.longValue();
		float floatValue = floatVal.floatValue();
		double doubleValue = doubleVal.doubleValue();
		boolean booleanValue = booleanVal.booleanValue();
		
		// 자동박싱
		Integer inttt = 100;
		System.out.println(inttt);
		
		// 자동언박싱
		int intttt = inttt;
		System.out.println(intttt);
		
		// 연산 시 자동 언박싱
		int ina = intttt + inttt;
		System.out.println(ina);
		
		
	}

}
