package data;

import java.time.LocalDate;

public class MyBook extends Book{
	

	private LocalDate borrowDate;
	private LocalDate returnDate;
	
	public MyBook(Book book) {
		super(book.getIsbn(), book.getName(), book.getWriter(), book.getPublisher(), book.getPublishedYear());
		this.borrowDate = LocalDate.now();
		this.returnDate = LocalDate.now().plusDays(7);
		this.setBorrowed(false);
	}
	
	public void extendDate() {
		System.out.println("7일 연장되었습니다");
		System.out.println("변경 전 반납일: "+ returnDate);
		System.out.println("-----------------------------------");
		returnDate = returnDate.plusDays(7);
		System.out.println("변경 후 반납일: "+ returnDate);
	}
	
	@Override
	public String toString() {
		return super.toString() + " // [대여일=" + borrowDate + ", 반납일=" + returnDate + "]";
	}
	
}
