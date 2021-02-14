package anonymous;

public class AnonymousExample2 {

	public static void main(String[] args) {
		AnonymousExampleExcute2 annoymousExampleExcute2 = new AnonymousExampleExcute2();
		annoymousExampleExcute2.field.run();
		annoymousExampleExcute2.method1();
		annoymousExampleExcute2.method2(
			new Vehicle() {
				
				@Override
				public void run() {
					System.out.println("트럭이 달립니다.");
				}
			}
		);
	}

}
