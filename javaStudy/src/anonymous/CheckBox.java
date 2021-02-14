package anonymous;

public class CheckBox {
	CheckInterface checkInterface;
	
	void setOnSelectListener(CheckInterface checkInterface) {
		this.checkInterface = checkInterface;
		
	}
	
	void select() {
		checkInterface.selectCall();
	}
	
	static interface CheckInterface{
		void selectCall();
	}
}
