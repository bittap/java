package test;

public class JHexahedron {
	public int volume(int width, int height, int depth) {
		return width*height*depth;
	}
	
	public int area(int width, int height, int depth) {
		return (width*height)*2+(width+height+width+height)*depth;
	}
}