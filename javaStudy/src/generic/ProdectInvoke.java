package generic;

public class ProdectInvoke {

	public static void main(String[] args) {
		Prodect<String, Integer> prodect = new Prodect<String, Integer>();
		prodect.setBrand("��");
		prodect.setModelNumber(123);
		System.out.printf("�귣�� = %s, �𵨳ѹ� = %d",prodect.getBrand(),prodect.getModelNumber());
	}

}
