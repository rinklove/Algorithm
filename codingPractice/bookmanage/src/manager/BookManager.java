package manager;

import data.Book;
import data.MyBook;
import main.Main;

public class BookManager {
	
	public void printFirstInfo() {
		System.out.println("=======================");
		System.out.println("     도서 대여 프로그램     ");
		System.out.println("=======================");
		System.out.println("원하는 작업을 선택하세요");
		System.out.println("1. 도서 대여");
		System.out.println("2. 대여한 도서 반납");
		System.out.println("3. 도서 반납 기한 연장");
		System.out.println("4. 신규 도서 추가");		
		System.out.println("5. 종료");
	}
	
	public void setBooks() {
		Main.bookLists.add(new Book("9791165341909", "달러구트 꿈 백화점",
			"이미예", "팩토리나인", 2020));
		Main.bookLists.add(new Book("9791188331796", "돈의 속성",
				"김승호", "스노우폭스북스", 2020));
		Main.bookLists.add(new Book("9791191056556", "미드나잇 라이브러리",
				"매트 헤이그", "인플루엔셜", 2021));
		Main.bookLists.add(new Book("9788954699372", "눈부신 안부",
				"백수린", "문학동네", 2023));
		Main.bookLists.add(new Book("9788954655972", "여행의 이유",
				"김영하", "문학동네", 2019));
	}
	
	public void printBookList() {
		for(int index = 0; index<Main.bookLists.size(); index++) {
			System.out.println("Book "+(index+1)+". "+Main.bookLists.get(index));
		}
	}
	
	public void borrowBook() {
		System.out.println("대여하실 책을 선택하세요");
		printBookList();
		int index = Main.sc.nextInt();
		if(Main.bookLists.get(index-1).getIsBorrowed() == true) {
			Main.myBookLists.add(new MyBook(Main.bookLists.get(index-1)));
			Main.bookLists.get(index-1).setBorrowed(false);
			System.out.println("대여 완료되었습니다");
		} else {
			System.out.println("이미 대여한 책입니다. 다른 책을 골라주세요");
		}
	}
	
	public void extendPeriod() {
		System.out.println("대여 기간을 연장하실 책을 선택하세요");
		printMyBookList();
		int num = Main.sc.nextInt();
		Main.myBookLists.get(num-1).extendDate();
		System.out.println("연장 되었습니다");
	}
	
	public void addBook() {
		System.out.print("도서 번호를 입력하세요");
		String isbn = Main.sc.next();
		System.out.print("책 제목을 입력하세요");
		String name = Main.sc.next();
		System.out.print("작가를 입력하세요");
		String writer = Main.sc.next();
		System.out.print("출판사를 입력하세요");
		String publisher = Main.sc.next();
		System.out.print("출판 년도를 입력하세요");
		int publishedYear = Main.sc.nextInt();
		
		Main.bookLists.add(new Book(isbn, name, writer, publisher, publishedYear));
		System.out.println("추가되었습니다.");
		System.out.println("--------------------------------------------------------------------");
		printBookList();
	}
	
	public void printMyBookList() {
		for(int index = 0; index<Main.myBookLists.size(); index++) {
			System.out.println("MyBook "+(index+1)+". "+Main.myBookLists.get(index));
		}
	}
	
	public void returnBook() {
		if(Main.myBookLists.size() == 0) {
			System.out.println("반납할 책이 없습니다.");
		} else {
			System.out.println("반납하실 책을 선택하세요");
			
			printMyBookList();
			int index = Main.sc.nextInt();
			Book findBook = Main.myBookLists.get(index-1);
			System.out.println(findBook);
			
			for(Book b : Main.bookLists) {
				if(b.getIsbn().equals(findBook.getIsbn())) {
					b.setBorrowed(true);
					Main.myBookLists.remove(findBook);
					System.out.println("반납되었습니다");
				}
			}
		}
	}
} 
