/**
 * 
 */
package com.crsrds.digiops.freedup.model;

import java.util.List;

/**
 * @author S RAJAIAH
 * @Date : August 14, 2021
 * @Desc : This is The main class for Author POJO
 *
 */
public class AuthorPOJO {

	/**
	 * 
	 */
	public AuthorPOJO() {
		// TODO Auto-generated constructor stub
	}
	
	private String author_name;
	private List<BookPOJO> books;
	/**
	 * @return the author_name
	 */
	public String getAuthor_name() {
		return author_name;
	}
	/**
	 * @return the books
	 */
	public List<BookPOJO> getBooks() {
		return books;
	}
	/**
	 * @param author_name the author_name to set
	 */
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<BookPOJO> books) {
		this.books = books;
	}
	
	

}
