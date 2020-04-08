package workshop.animal.test;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Fish;
import workshop.animal.entity.Pet;
import workshop.animal.entity.Spider;

public class TestAnimals {
	public static void main(String[] args) {
		Fish d = new Fish();
		
		Cat c1 = new Cat();
		c1.setName("CAT1");
		System.out.println(c1.getName());
		c1.play();
		c1.eat();
		c1.walk();
		
		Animal c2 = new Cat("CAT2");
		c2.eat();
		c2.walk();
		
		Pet c3 = new Cat();
		c3.setName("CAT3");
		System.out.println(c1.getName());
		c3.play();
		
		Animal a = new Fish();
		Animal e = new Spider();
		
	
	}
}
