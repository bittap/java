package wrapper;

public class Wrapper {

	public static void main(String[] args) {
		// �⺻Ÿ���� ���� ��ü�� �����ϴ� ���� Wrapper��� ��
		
		// �ڽ�
		// �⺻Ÿ�� -> ��ü
		Byte byteVal = new Byte((byte)1);
		Character characterVal = new Character('��');
		Short shortVal = new Short((short) 100);
		Integer integerVal = new Integer(100);
		Long longVal = new Long(100);
		Float floatVal = new Float(10f);
		Double doubleVal = new Double(100.10);
		Boolean booleanVal = new Boolean(true);
		// ��ڽ�
		// ��ü -> �⺻Ÿ��
		byte byte1 = byteVal.byteValue();
		char charValue = characterVal.charValue();
		short shortValue = shortVal.shortValue();
		int intValue = integerVal.intValue();
		long longValue = longVal.longValue();
		float floatValue = floatVal.floatValue();
		double doubleValue = doubleVal.doubleValue();
		boolean booleanValue = booleanVal.booleanValue();
		
		// �ڵ��ڽ�
		Integer inttt = 100;
		System.out.println(inttt);
		
		// �ڵ���ڽ�
		int intttt = inttt;
		System.out.println(intttt);
		
		// ���� �� �ڵ� ��ڽ�
		int ina = intttt + inttt;
		System.out.println(ina);
		
		
	}

}
