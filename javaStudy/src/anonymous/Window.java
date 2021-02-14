package anonymous;

class Window {
	Button button1 = new Button();
	Button button2 = new Button();
	
	Button.OnclickListener listener = new Button.OnclickListener() {
		
		@Override
		public void setOnclike() {
			System.out.println("전화를 겁니다.");
		}
	};
	
	Window(){
		button1.setOnclickListener(listener);
		button2.setOnclickListener(new Button.OnclickListener() {
			
			@Override
			public void setOnclike() {
				System.out.println("메세지를 보냅니다.");
			}
		});
	}
}
