package lambda;

public class UsingLambda {
	public static void main(String[] args) {
		//Thread 생성 방법 두가지
		//1.
		Thread t1 = new Thread(new MyRunnable());
		t1.setName("현진");
		t1.start();
		//2. Anonymous Inner Class 익명 클래스 형태로 
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t2.setName("길동");
		t2.start();
		//3. Lambda 식 형태
		Thread t3 = new Thread(() -> System.out.println(Thread.currentThread().getName())); // 위 run() = ()  -> run() 구현부 
 		t3.setName("자바");
		t3.start();
		
	}
}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}


