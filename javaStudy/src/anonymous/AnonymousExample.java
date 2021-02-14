package anonymous;

public class AnonymousExample {

	public static void main(String[] args) {
		AnonymousExampleExcute annoymousExampleExcute = new AnonymousExampleExcute();
		annoymousExampleExcute.worker.start();
		annoymousExampleExcute.method1();
		annoymousExampleExcute.method2(
			new Worker() {
				@Override
				void start() {
					System.out.println("테스트를 합니다.");
				}
			}
		);
	}

}
