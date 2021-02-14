package InstanceOf;


class Mom{
	private int mom = 10;
	
	void method1() {
		System.out.println("method1 호출");
	}
	void method2() {
		System.out.println("method2 호출");
	}
}

class Sun extends Mom{
	
	void method3(){
		System.out.println("method3 호출");
	}
	
	void method4(){
		System.out.println("method4 호출");
	}
}
public class InstanceOf {

	public static void main(String[] args) {
		// A(객체) instancof B(타입)
		// A가 B의 타입으로 객체가 생성됐으면 True 리턴 아니면 false 리턴
		// 강제형변환시 해당객체가 자동형변환 됐는지 안됐는지를 검사하기 위해 사용
		
		
		Mom mom = new Sun();
		mom.method1();
		mom.method2();
		
		Sun sun = (Sun)mom;
		sun.method3();
		sun.method4();
		
		Mom mom2 = new Mom();
		if(mom2 instanceof Sun) {
			Sun sun2 = (Sun)mom2;
			sun2.method1();
		}else {
			System.out.println("강제 형변환 확인");
		}
		
		
	}

}
