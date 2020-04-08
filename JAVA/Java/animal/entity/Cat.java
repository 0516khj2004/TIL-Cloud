package workshop.animal.entity;

public class Cat extends Animal implements Pet {
	private String catName;
	
	public Cat(String name) {
		super(4); //다리 개수를 말하는 거임
		catName = name;
	}

	public Cat() {
		this("");
	}
	
	@Override
	public void setName(String name) {
		catName = name;
	}
	@Override
	public String getName() {
		return catName;
	}
	@Override
	public void play() {
		System.out.println("고양아는 논다");
		
	}
	@Override
	public void eat() {
		System.out.println("고양이는 먹는다");
		
	}
}
