package AbstractExample;

public class InvokeAbstractExample {

	public static void main(String[] args) {
		method(new AbstractExampleSon1());
		method(new AbstractExampleSon2());
	}
	
	public static void method(AbstractExample abstractExample) {
		abstractExample.service();
	}

}
