package test;

public class test7 
{
	public static void main(String[] args) 
	{
		int number_1 = 10;
		int number_2 = 10;
		
		if(number_1 == number_2) 
		{
			number_1 *= 3;
			number_1 = number_1<<2;
		}
		System.out.println("number_1 = "+ number_1);
	}
}
