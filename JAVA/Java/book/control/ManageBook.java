package workshop.book.control;

import java.util.ArrayList;
import java.util.List;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.RefetenceBook;

public class ManageBook {
	
	public static void main(String[] args) {
		ManageBook manager = new ManageBook();
		
		List<Publication> books = new ArrayList<>();
		books.add(new Magazine("마이크로소프트","2007-10-01",328,9900,"매월")); 
		books.add(new Magazine("경영과컴퓨터","2007-10-03",316,9000,"매월"));
		books.add(new Novel("빠삐용","2007-07-01",396,9800,"베르나르베르베르","현대소설"));
		books.add(new Novel("남한산성","2007-04-14",383,11000,"김훈","대하소설"));
		books.add(new RefetenceBook("실용주의프로그래머","2007-01-14",496,25000,"소프트웨어공학")); 
		
		System.out.println("===Book 정보 출력===");
		for (Publication publication : books) {
			System.out.println(publication);
		}
		System.out.println("===가격정보 변경 전===");
		System.out.println(books.get(2) + " : " + books.get(2).getPrice());
		
		System.out.println("===가격정보 변경 후===");
		manager.modifyPrice(books.get(2));
		System.out.println(books.get(2) + " : " + books.get(2).getPrice());
	
	}
//다형적 아큐먼트 
	public void modifyPrice(Publication books) {
		int price = books.getPrice();
		double rate = 0.0;
		if(books instanceof Magazine) {
			rate = 0.4;
		}else if(books instanceof Novel) {
			rate = 0.2;
		}else if(books instanceof RefetenceBook) {
			rate = 0.1;
		}
		
		books.setPrice(price - (int)(price * rate));
		
	}            

}
