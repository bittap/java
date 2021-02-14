package accessmodifier;

import accessmodifierexample.AccessModifierExample2;

public class Kind {

	public static void main(String[] args) {
		// 접근제한자
		// public -> protected -> default -> private
		// public : 모두 사용가능
		// protected : 같은 패키지 또는 자식패키지에서 사용가능
		// default : 같은 패키지에 소속된 클래스만 사용가능 
		// private : 자기밖에사용 못함 get,set형식으로 가져옴 투명성을 위해
		
		AccessModifierExample ex = new AccessModifierExample();
		String str = ex.publicString;
		String str1 = ex.protectedString;
		String str2 = ex.defaultString;
		
		
		AccessModifierExample2 ex2 = new AccessModifierExample2();
		String str3 = ex2.publicString;
		
		
	}

}
