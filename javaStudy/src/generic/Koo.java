package generic;

public class Koo {
	public <N1, N2> Integer exampleOne(N1 t, N2 e) {
		return (Integer)t + (Integer)e;
	}
	
	public <String> Foo<String> exampleTwe(){
		return new Foo<>();
	}
}
