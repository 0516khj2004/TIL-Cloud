package workshop.animal.entity;

public abstract class Animal {
	protected int legs;
	
	protected Animal(int legs) {
		this.legs = legs;
	}
	public abstract void eat();
	
	public void walk() {
		System.out.println("이 동물은 걸어다닐 수 있다");
	}
	
}
