package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class solution8 {

	public static void main(String[] args) {
		Map<Integer, Box> map = new HashMap<Integer, Box>();
	
		map.put(1, new Box("00001", "りんご", 100));
		map.put(2, new Box("00010", "メロン", 1000));
		map.put(3, new Box("00100", "なし", 500));
		
        List<Map.Entry<Integer, Box>> list = new LinkedList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Box>>() {
            @Override
            public int compare(Map.Entry<Integer, Box> o1, Map.Entry<Integer, Box> o2) {
                int comparision = (o1.getValue().getPrice() - o2.getValue().getPrice()) * 1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        

        Map<Integer, Box> sortedMap = new LinkedHashMap<>(); 
        for(Iterator<Map.Entry<Integer, Box>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<Integer, Box> entry = iter.next();
            System.out.printf("number = %s, name = %s ,price = %d\n",entry.getValue().getNumber(),entry.getValue().getName(),entry.getValue().getPrice());
        }
       
		
	}

}

class Box{
	private String number;
	private String name;
	private int price;
	
	public Box(String number, String name, int price) {
		if(number.getBytes().length > 5) {
			System.out.println("number byte over");
		}
		if(name.getBytes().length > 100) {
			System.out.println("name byte over");
		}
		this.number = number;
		this.name = name;
		this.price = price;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
