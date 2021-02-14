package collectionFrameWork;

class Member {
	int age;
	String name;
	
	public Member(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		System.out.println("hascode호출");
		return name.hashCode()+age;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals호출");
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return this.age == member.age && this.name.equals(member.name);
		}else {
			return false;
		}
	}
	
	
	
	
}
