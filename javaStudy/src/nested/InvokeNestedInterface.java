package nested;

public class InvokeNestedInterface {

	public static void main(String[] args) {
		NestedInterface nestedInterface = new NestedInterface();
		
		nestedInterface.setOnClickListener(new CallListener());
		nestedInterface.touch();
		
		nestedInterface.setOnClickListener(new MessageListener());
		nestedInterface.touch();
		
	}

}
