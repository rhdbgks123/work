package hgjava.chap06_1;

public class Book {

	private int bookNum;
	private String bookName;
	private int price;
	
	
	public Book(int bookNum, String bookName, int price)
	{
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.price = price;
	}


	public int getBookNum() {
		return bookNum;
	}


	public String getBookName() {
		return bookName;
	}


	public int getPrice() {
		return price;
	}
	
	
	
}
