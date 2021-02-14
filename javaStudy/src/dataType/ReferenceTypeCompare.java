package dataType;

public class ReferenceTypeCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 참조 변수끼리의 ==, != 연산은   
		// 힙영역에 같은 주소를 참고있느냐를 비교하는거다 
		int[] intArr1 = {10,20,30};
		int[] intArr2 = {10,20,30};
		
		if(intArr1 != intArr2) {
			System.out.println("객체변수는 메모리 번지수를 비교한다.");
		}
		
		// 자바는 문자열 리터럴이 같을 경우 동일 힙영역을 공유한다.
		String str1 = "김태영";
		String str2 = "김태영";
		
		if(str1 == str2) {
			System.out.println("문자열은 리터럴이 같을 경우 같은 힙영역을 공유한다. 즉 스택에 저장되는 메모리번지수가 같음");
		}
	}

}
