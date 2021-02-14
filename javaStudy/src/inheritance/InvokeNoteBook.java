package inheritance;

public class InvokeNoteBook {

	public static void main(String[] args) {
		String part[] = new String[] {"메모리","바테리"};
		
		NoteBook noteBook = new NoteBook(50, 80, part);
		
		noteBook.betteryChk();
		noteBook.move();
	}

}
