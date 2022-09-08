/**
 * 
 */
package com.crsrds.digiops.freedup.model;

import java.time.LocalDate;

/**
 * @author S RAJAIAH
 * @Date : August 2, 2021
 * @Desc : This is s POJO for testing BooksObject Java object..
 *
 */
public class BookPOJO {

	/**
	 * 
	 */
	public BookPOJO() {
		// TODO Auto-generated constructor stub
	}
	
    private String title; //": "Title1",
    private boolean inPrint; //": true,
    private String publishDate; //": "2019-12-25"
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the inPrint
	 */
	public boolean isInPrint() {
		return inPrint;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param inPrint the inPrint to set
	 */
	public void setInPrint(boolean inPrint) {
		this.inPrint = inPrint;
	}
	/**
	 * @return the publishDate
	 */
	public String getPublishDate() {
		return publishDate;
	}
	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

    

}
