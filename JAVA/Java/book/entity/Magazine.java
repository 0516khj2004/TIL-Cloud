package workshop.book.entity;

public class Magazine extends Publication {
	private String publishPeriod;
	
	public Magazine() {
		
	}

	public Magazine(String title, String publishingDate, int page, int price, String publishPeriod) {
		super(title, publishingDate, page, price);
		this.publishPeriod = publishPeriod;
	}

	public String getPublishPeriod() {
		return publishPeriod;
	}

	public void setPublishPeriod(String publishPeriod) {
		this.publishPeriod = publishPeriod;
	}

	
	
	
}
