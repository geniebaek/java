package exam.examc4;

import java.util.ArrayList;

interface MediaBook {
	String getMediaType();
}

class Book implements MediaBook, Comparable<MediaBook> {
	private String title; 
	private String author; 
	private int publicationYear; 
	private String isbn;
	
	
	
	public Book(String title, String author, int publicationYear, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}



	@Override 
	public int compareTo(MediaBook mbook) {
		return 0;
	}



	@Override
	public String getMediaType() {
		
		return "Title : "+title+"Author : "+author+"PublicationYear : "+publicationYear+"Isbn : "+isbn;
	}



	
}
class CDBook implements MediaBook, Comparable<MediaBook> {
	private String title;
	private String artist;
	private String catalogNumber;
	
	

	public CDBook(String title, String artist, String catalogNumber) {
		super();
		this.title = title;
		this.artist = artist;
		this.catalogNumber = catalogNumber;
	}

	@Override 
	public int compareTo(MediaBook mbook) {
		return 0;
	}

	@Override
	public String getMediaType() {
		
		return "Title : "+title+"Artist"+artist+"CatalogNumber"+catalogNumber;
	}
}

class USBBook implements MediaBook, Comparable<MediaBook> {
	private String title; 
	private int capacity; 
	private String serialNumber;
	
	public USBBook(String title, int capacity, String serialNumber) {
		super();
		this.title = title;
		this.capacity = capacity;
		this.serialNumber = serialNumber;
	}

	@Override
	public int compareTo(MediaBook o) {
		
		return 0;
	}

	@Override
	public String getMediaType() {
		
		return "Title : "+title+"Capacity : "+capacity+"SerialNumber : "+serialNumber;
	} 
	
}


class Library<T extends MediaBook> {
	private ArrayList<T> items; 
	private int capacity;
	
	
	
	public Library() {
		items=new ArrayList<>();
		
	}

//	Library(T[] items, int capacity){
//		items=new ArrayList[capacity];
//		this.capacity=capacity;
//		
//		
//	}

	

	// 항목 추가 
	public void addItem(T item) {
		items.add(item);
		return;
	}

	// 항목 삭제 
	public void removeItem(T item) {
		for(int i = 0; i<capacity;i++) {
			
		}
	}

	public void printItems() {
		for(int i = 0;i<capacity;i++) {
			System.out.println(());
		}
		 
		 return ;
		
	}
}




public class ExamC4 {
	public static void main(String[] args) {

		Library<MediaBook> library = new Library<MediaBook>(); 

		// 5개의 item 객체 초기화 및 추가
		library.addItem(new Book("자바", "강감찬", 1995, "1234567890"));
		library.addItem(new Book("파이썬", "이순신", 2008, "1234567891")); 
		library.addItem(new Book("자바스크립트", "을지문덕", 2008, "1234567892"));
		library.addItem(new Book("자료구조", "연개소문", 1994, "1234567893")); 
		library.addItem(new Book("리액트", "김춘추", 1999, "1234567894"));		
		
		library.addItem(new CDBook("노래1", "나훈아", "3333"));
		library.addItem(new CDBook("노래2", "남진", "2222"));
		library.addItem(new CDBook("노래3", "홍길동", "1111"));
		
		library.addItem(new USBBook("데이터1", 2000, "ABCD1234"));
		library.addItem(new USBBook("데이터2", 1000, "ABCD1235"));
		library.addItem(new USBBook("데이터3", 3000, "ABCD1235"));
		
		library.printItems();

		library.removeBook();
		
		library.printItems();
		library.removeBook();
		library.printItems();
		library.removeBook();
		library.printItems();
	}
}
