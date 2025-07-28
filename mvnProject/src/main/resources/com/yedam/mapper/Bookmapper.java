package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.Book;

public interface Bookmapper
{
	public Book selectBook(int id);
	
	public List<Book> selectBooks(int page);
	
	public int insertBook(Book book);
	
	public int deleteBook(int id);
	
	public int totalCount();
}
