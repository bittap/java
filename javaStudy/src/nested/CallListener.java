package nested;

public class CallListener implements NestedInterface.OnClickListener {
	@Override
	public void onClick() {
		System.out.println("전화를 겁니다.");
	}

}
