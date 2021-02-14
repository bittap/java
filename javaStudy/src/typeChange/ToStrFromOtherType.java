package typeChange;

public class ToStrFromOtherType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String -> byte
		String str = "100";
		byte str_byte = Byte.parseByte(str);
		System.out.println("String -> byte:"+str_byte);
		//String -> short
		String str1 = "200";
		short str_short = Short.parseShort(str1);
		System.out.println("String -> short:"+str_short);
		//String -> int
		String str2 = "300";
		int str_int = Integer.parseInt(str2);
		System.out.println("String -> int:"+str_int);
		//String -> Long
		String str3 = "400";
		long str_long =	Long.parseLong(str3);
		System.out.println("String -> Long:"+str3);
		//String -> float
		String str4 = "500.55";
		float str_float = Float.parseFloat(str4);
		System.out.println("String -> float:"+str4);
		//String -> double
		String str5 = "1000.35";
		double str_double = Double.parseDouble(str5);
		System.out.println("String -> double:"+str_double);
		//String -> boolean
		String str6 = "true";
		boolean str_boolean = Boolean.parseBoolean(str6);
		System.out.println("String -> boolean:"+str6);
	}

}
