package nested;

public class LocalClassThis {
	String innerFiled = "필드";
	
	void innerMethod() {
		System.out.println("메소드");
	}

	public class inner{
		String innerFiled = "이너 맴버클래스 필드";
		
		void innerMethod() {
			System.out.println("이너 맴버클래스 메소드");
		}
		
		void print() {
			// 그냥 this를 사용시는 자기 클래스
			System.out.println(this.innerFiled);
			this.innerMethod();
			
			// 엄마 클래스.this.
			System.out.println(LocalClassThis.this.innerFiled);
			LocalClassThis.this.innerMethod();
		}
	}
	
	public static void main(String[] args) {
		LocalClassThis localClassThis = new LocalClassThis();
		LocalClassThis.inner inner = localClassThis.new inner();
		
		inner.print();
	}

}
