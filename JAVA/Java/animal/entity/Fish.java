package workshop.animal.entity;

public class Fish extends Animal implements Pet{
	private String fishName;
	
	public Fish() {
		super(0);
	}
	
	@Override
	public void setName(String name) {
		fishName = name;
	}

	@Override
	public String getName() {
		return fishName;
	}

	@Override
	public void play() {
		System.out.println("물고기는 헤어침다");
		
	}

	@Override
	public void eat() {
		System.out.println("물고기는 모이를 먹는다");
		
	}

	@Override
	public void walk() {
		System.out.println("물고기는 다리가 없다");
	}
	

}
