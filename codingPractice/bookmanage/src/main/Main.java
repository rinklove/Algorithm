package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.Book;
import data.MyBook;
import manager.BookManager;

public class Main {

	public static List<Book> bookLists = new ArrayList<Book>();
	public static List<MyBook> myBookLists = new ArrayList<MyBook>();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] arg1s) {
		
		BookManager manager = new BookManager();
		manager.setBooks();

		Book b = new Book();

		while(true) {
			manager.printFirstInfo();
			int num = sc.nextInt();
			
			switch(num) {
			case 1: manager.borrowBook(); break;
			case 2: manager.returnBook(); break;
			case 3: manager.extendPeriod(); break;
			case 4: manager.addBook(); break;
			case 5: return;
			}
		}
		
	}
}
