package generic;

public class ProdectInvoke {

	public static void main(String[] args) {
		Prodect<String, Integer> prodect = new Prodect<String, Integer>();
		prodect.setBrand("»§");
		prodect.setModelNumber(123);
		System.out.printf("ºê·£µå = %s, ¸ðµ¨³Ñ¹ö = %d",prodect.getBrand(),prodect.getModelNumber());
	}

}
