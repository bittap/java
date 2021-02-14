package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {
		String str = "1234567";
		Pattern pattern = Pattern.compile("(^[a-zA-Z0-9]{7,10}$)");
		Matcher matcher = pattern.matcher(str);
		
		if(matcher.find()) 
		{
			System.out.println(str);
		}
		else
		{
			System.out.println("ÀÌ»óÇØ");
		}
	}

}
