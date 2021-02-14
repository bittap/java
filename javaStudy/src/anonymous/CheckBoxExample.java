package anonymous;

class CheckBoxExample {

	public static void main(String[] args) {
		CheckBox checkBox = new CheckBox();
		checkBox.setOnSelectListener(
			new CheckBox.CheckInterface() {
				
				@Override
				public void selectCall() {
					System.out.println("배경을 변경합니다.");
				}
			}
		);
		checkBox.select();
	}

}
