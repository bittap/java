package inheritance;

public class NoteBook extends Computer{
	public int bettery;

	protected NoteBook(int width, int height, String[] part) {
		super(width, height, part);
	}
	

	
	
	public int betteryChk() {
		String dou = String.format("%.2f", Math.random());
		System.out.println(dou);
		bettery = (int)(Double.parseDouble(dou)*100);
		System.out.println(bettery);
		return bettery;
	}

}
