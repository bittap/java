package stack;

import java.util.Stack;

class StackExample {
	
	public static void main(String[] args) {
		// 积己规过
		Stack<Coin> stak = new Stack<Coin>();
		
		stak.push(new Coin(50));
		stak.push(new Coin(100));
		stak.push(new Coin(200));
		stak.push(new Coin(300));
		
		while (!stak.isEmpty()) {
			Coin c = stak.pop();
			System.out.println(c.getValue());
		}
	}
}
