package accessmodifier;

import accessmodifierexample.AccessModifierExample2;

public class Kind {

	public static void main(String[] args) {
		// ����������
		// public -> protected -> default -> private
		// public : ��� ��밡��
		// protected : ���� ��Ű�� �Ǵ� �ڽ���Ű������ ��밡��
		// default : ���� ��Ű���� �Ҽӵ� Ŭ������ ��밡�� 
		// private : �ڱ�ۿ���� ���� get,set�������� ������ ������ ����
		
		AccessModifierExample ex = new AccessModifierExample();
		String str = ex.publicString;
		String str1 = ex.protectedString;
		String str2 = ex.defaultString;
		
		
		AccessModifierExample2 ex2 = new AccessModifierExample2();
		String str3 = ex2.publicString;
		
		
	}

}
