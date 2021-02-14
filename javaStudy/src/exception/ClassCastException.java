package exception;

public class ClassCastException {

	public static void main(String[] args) {
		Animal animal = new Dog();
		
		//if(animal instanceof Dog) {
			//Dog dog = (Dog)animal;
		//}else if(animal instanceof Cat) {
			Cat cat = (Cat)animal;
		//}
	}

}

class Animal{
	
}

class Dog extends Animal{
	
}

class Cat extends Animal{
	
}


