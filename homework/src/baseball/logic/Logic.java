package baseball.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Logic {

	public String[] numberCreate() {
		String[] returns = new String[3];
		Map<Integer, Integer> allNumbers = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			allNumbers.put(i, i);
		}
		int successCount = 0;
		
		while (successCount < 3) {
			int randomNumber = (int)(Math.random()*10);
			if(allNumbers.get(randomNumber) != null)
			{
				allNumbers.remove(randomNumber);
				returns[successCount] = String.valueOf(randomNumber);
				successCount++;
			}
		}

		return returns;
	}
	
	public Map<String,Integer> result(String[] userInput, String[] computerInput) {
		for (String string : computerInput) {
			System.out.print("computer:");
			System.out.print(string);
			System.out.println();
		}
		for (String string : userInput) {
			System.out.print("user:");
			System.out.print(string);
			System.out.println();
		}
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("��", 0);
		map.put("��Ʈ����ũ", 0);
		
		for (int i = 0; i < userInput.length; i++) {
			for (int j = 0; j < computerInput.length; j++) {
				if(userInput[i].equals(computerInput[j]))
				{
					if(i == j)
					{
						map.put("��Ʈ����ũ", map.get("��Ʈ����ũ")+1);
					}
					else
					{
						map.put("��", map.get("��")+1);
					}
				}
			}
		}
		
		 Iterator<String> keys = map.keySet().iterator();
	     while( keys.hasNext() ){
            String key = keys.next();
            System.out.println( String.format("Ű : %s, �� : %s", key, map.get(key)) );
	     }

		return map;
	}
}
