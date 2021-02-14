package anonymous;

class Button {
	OnclickListener onclickListener;
	
	void setOnclickListener(OnclickListener onclickListener) {
		this.onclickListener = onclickListener;
		onclickListener.setOnclike();
	}
	
	void touch() {
		onclickListener.setOnclike();
	}
	
	static interface OnclickListener{
		void setOnclike();
	}
}


