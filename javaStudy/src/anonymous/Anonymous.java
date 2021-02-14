package anonymous;

public class Anonymous {
	// �͸� Ŭ������ �ش���ġ���� �� �����ϹǷ� �̸��� ���̱� ������ �� ����Ѵ�.
	// �θ�Ŭ���� [�ʵ�|����] = new �θ�Ŭ����(�Ű�����){}
	Parent parent = new Parent() {
		int childField;
		void childMethod() {
			
		}
		@Override
		void parentMethod() {
			super.parentMethod();
		}
	};
	
	// �޼ҵ� ���ο��� �͸�Ŭ���� ����
	void method() {
		Parent parent = new Parent() {
			int childField;
			void childMethod() {
				
			}
			@Override
			void parentMethod() {
				super.parentMethod();
			}
		};
	}
	
	Person filed = new Person() {
		void work() {
			System.out.println("����մϴ�.");
		}
		@Override
		void wake() {
			System.out.println("6�ÿ� �Ͼ�ϴ�.");
			work();
		}
	};
	
	void method1() {
		Person localVar = new Person() {
			void work() {
				System.out.println("��å�մϴ�.");
			}
			@Override
			void wake() {
				System.out.println("7�ÿ� �Ͼ�ϴ�.");
				work();
			}
		};
		localVar.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}

	
}
