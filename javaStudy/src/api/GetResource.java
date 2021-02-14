package api;

public class GetResource {

	public static void main(String[] args) {
		Class clazz = GetResource.class;
		
		String photo1path = clazz.getResource("photo1.png").getPath();
		System.out.println(photo1path);
		
	}

}

