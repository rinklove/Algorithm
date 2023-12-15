package data;

public class Book {

	private String isbn;
	private String name;
	private String writer;
	private String publisher;
	private int publishedYear;
	private boolean ableBorrow;
	
	public Book() {}
	
	public Book(String isbn, String name, String writer, String publisher, int publishedYear) {
		this.isbn = isbn;
		this.name = name;
		this.writer = writer;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
		this.ableBorrow = true;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public String getName() {
		return name;
	}

	public String getWriter() {
		return writer;
	}
	
	public String getPublisher() {
		return publisher;
	}

	public int getPublishedYear() {
		return publishedYear;
	}
	
	public boolean getIsBorrowed() {
		return ableBorrow;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.ableBorrow = isBorrowed;
	}
	
	@Override
	public String toString() {
		return "[isbn=" + isbn + ", 이름=" + name + ", 작가: " + writer + ", 출판사=" + publisher
				+ ", 출판년도=" + publishedYear + ", 대여 가능여부=" + ableBorrow + "]";
	}
}
