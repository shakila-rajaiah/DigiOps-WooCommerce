package com.crds.digiops.freedup.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.crds.digiops.freedup.service.*;
import com.crds.digiops.freedup.model.*;



/**
 * @author S RAJAIAH
 * @Date : April 1, 2021
 * @Description : This is a common utility file that calculates and formats Dates.
 *
 */
public class DateFormatterUtil {


	public DateFormatterUtil() {
		// TODO Auto-generated constructor stub
	}
	
	static Logger logger = LoggerFactory.getLogger(DateFormatterUtil.class);
	
	public static String calculateLongDate(String startdate) throws ParseException {
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 

		Date startDate = df.parse(startdate);

		// convert to unix time.
	    long startTime = (long) startDate.getTime()/1000;
	    
	    startdate= String.valueOf(startTime);

	    System.out.println("**** startdate long converted to string ***" + startdate);
	    logger.info("**** startdate long converted to string ***" + startdate);
	    
	    return startdate;
			
		}
	
	
	/*
	 * Takes in a date (string) and converts it to a long date.
	 * used from the jsp as it strips off the ""
	 */
	public String convertDate(String startdate) throws ParseException {
			
		startdate = startdate.replaceAll(",","");
		Date startDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(startdate);
		
		// convert to unix time.
	    long startTime = (long) startDate.getTime()/1000;
	    
	    startdate= String.valueOf(startTime);
	    System.out.println("**** startdate long converted to string ***" + startdate);
	    logger.info("**** startdate long converted to string ***" + startdate);
	        
	    return startdate;
			
		}
	
//	/**
//	 * @Author : Shakila Rajaiah
//	 * @Date : 9-7-2022
//	 * @param args
//	 * @throws ParseException 
//	 * @Description: Calculates the start date based on when the report is run.  
//	 * 				If the report is run for the first half of the month, the start date 
//	 * 				will be the 1st of the month.
//	 * 				If the report is run for the second half of the month, the start date 
//	 * 				will be the 15th of the month.
//	 */
//	public String calculateStartDateForCronJob(String startDate) throws ParseException {
//						
//			//LocalDateTime now = LocalDateTime.now().minusDays(1);
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//			//reduce a day as the payout reports are not available for the current day...
//			LocalDateTime dateTime = LocalDateTime.parse(startDate, formatter);			
//			String formatedDateTime = dateTime.format(formatter);
//			System.out.println("Current DateTime after Formatting:: " + formatedDateTime );
//			logger.info("Current DateTime after Formatting:: " + formatedDateTime );
//			
////			//local date object can only be printed only as as yyyy-mm-dd
//	       LocalDate localDate =  LocalDate.parse(formatedDateTime, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//			//System.out.println("LocalDate :  " + localDate );			
//			int year  = localDate.getYear();
//			int month = localDate.getMonthValue();
//			int prevMonth = month-1;
//			int day   = localDate.getDayOfMonth();
//
//			//Make the start date the first of the month if the start date is after the 15th and endDate = 15th of the month
//			if (day >15) {
//				formatedDateTime = month +"/"+ "01" + "/" + year ;
//				System.out.println("************** formated START DateTime for the 15th day of the month: " + formatedDateTime);
//				logger.info("************** formated START DateTime for the 19th day of the month: " + formatedDateTime);
//			}
//			//if its in January make the start day = 15, month = December and year = prev year
//			else if (day <15 && month == 1) {	
//				prevMonth = 12;
//				int prevYear = year-1;
//				formatedDateTime = prevMonth +"/"+ "15" + "/" + prevYear ;
//				System.out.println("************** formated START DateTime for the 5th day of the month for JANUARY: " + formatedDateTime);
//				logger.info("************** formated START DateTime for the 5th day of the month for JANUARY: " + formatedDateTime);
//			}
//			//Make the start date the fifteenth of the previous month from Feb to Dec..
//			else if (day <15 && (month>1 && month <=12 )) {
//				//int prevMonth = month-1;
//				formatedDateTime = prevMonth +"/"+ "15" + "/" + year ;
//				System.out.println("************** formated START DateTime for the 5th day of the months FEB TO DECEMBER:  " + formatedDateTime);	
//				logger.info("************** formated START DateTime for the 5th day of the months FEB TO DECEMBER:  " + formatedDateTime);			
//			}
//			
//			 startDate = calculateLongDate(formatedDateTime);
//			System.out.println("***Start Long Date : " + startDate);
//			
//			return startDate;
//			
//		}
//			
	
	/**
	 * @Author : Shakila Rajaiah
	 * @Date : September 7, 2022
	 * @param : end datedate
	 * @throws ParseException 
	 * @Description: Calculates the end date based on when the report is run.  
	 * 				 If the report is run for the first half of the month, the end date 
	 *				 will be the 15th  of the month.
	 * 				If the report is run for the second half of the month, the end date 
	 * 				will be the 3th of the next month. This is to give them a cushion for 
	 * 				the payouts to be deposited on the 15th and 30/31st of the month.
	 * 
	 */
	public String calculateEndDateForCronJob(String startdate) throws ParseException {
				
		//reduce a day as the payout reports are not available for the current day...
		LocalDateTime now = LocalDateTime.now().minusDays(1);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String endDate = now.format(formatter);
		System.out.println("***** Current END DATE TIME after Formatting:: " + endDate );
		
		endDate =  calculateLongDate(endDate);
		
	    System.out.println("**** endDate (long) converted to string ***" + endDate);
	    return endDate;
			
		}
	
//	/**
//	 * @author srajaiah
//	 * @Date November 15th, 2021
//	 * @Report Date = 3rd of the month
//	 * @Description : Checks if the createDate is in the last Month.
//	 */
//	public static  boolean isWithinDateRangeForPrevMonth(String date) throws ParseException {
//		
//		System.out.println("ConvertJsonFile inside isWithinDateRangeForPrevMonth: " + date);
//		
//		 String createDate = date.substring(4, 6) + "/" + date.substring(6,8) + "/" + date.substring(0, 4);
//		 System.out.println(createDate);
//					
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//
//		//convert String to LocalDate
//		LocalDate localCreateDate = LocalDate.parse(createDate, formatter);
//
//		LocalDate startDate = YearMonth.now().minusMonths( 2 ).atEndOfMonth();
//		// before the first day of the current month i.e. the last day of the prev month.
//		LocalDate endDate = YearMonth.now().atDay(1);
//		    
//	    return  localCreateDate.isAfter(startDate) && localCreateDate.isBefore(endDate);			
//		
//	}

	
	/**
	 * @author srajaiah
	 * @Date September 7, 2022
	 * @Description : Checks if the createDate between 1st and the 16th of the current month.
	 * @ReportDate = 17th of every month
	 * @StartDate = 1st day of current month
	 * @End Date = 17th day of current month.
	 */
	public static  boolean isWithinDateRangeForCurrentMonthFirstHalf(OrderPOJO oP) throws ParseException {
	
		boolean order = false;
		
//	  	//'2021-11-15T09:49:04'
	  	String str =oP.getDate_created().substring(0, 10);
	  	String date = str.replace("-", "");
	  	String createdDate = date.substring(4, 6) + "/" + date.substring(6,8) + "/" + date.substring(0, 4);
	  	System.out.println( "********createdDate " + createdDate);
	  	//calculate the date range check based on the create date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//		//convert String to LocalDate
		LocalDate localCreateDate = LocalDate.parse(createdDate, formatter);
		
		System.out.println( "********localCreateDate" + localCreateDate);
		
		int day = localCreateDate.getDayOfMonth();	
		int month = localCreateDate.getMonthValue();
		int year = localCreateDate.getYear();
		LocalDate now = LocalDate.now();
		int dayToday = now.getDayOfMonth();
		int monthToday = now.getMonthValue();
		int prevMonth = now.getMonthValue()-1;
		int yearToday = now.getYear();	    
		
		// before the first day of the current month i.e. the last day of the prev month.
		LocalDate startDate = YearMonth.now().atDay(1);	
		//System.out.println( "********startDate " + startDate);
		
		//  16th day of the current month i.e. the last day of the prev month.
		LocalDate endDate = YearMonth.now().atDay(16);
		//System.out.println( "********endDate " + endDate);
		
		if(dayToday >= 17 && day <=17) {
			if(year == yearToday && month == monthToday ) {
				order = localCreateDate.isAfter(startDate) && localCreateDate.isBefore(endDate);	
				//System.out.println( "result   firstHalfTest of month date): " + order);
			}
		}
		else {
			order=false;
		}

	    return  order;		
	}
	
	/**
	 * @author srajaiah
	 * @Date September 7, 2022
	 * @ModifiedDate January 12, 2023 (to correct prev month 12th problem)
	 * @Report Run date = 3rd of every month
	 * @Description : Checks if the createDate between 16th and the last day of the previous month 
	 */
	public static  boolean isWithinDateRangeForPrevMonthSecondHalf(OrderPOJO oP) throws ParseException {
		boolean order = false;
		
	  	//'2021-11-15T09:49:04'
	  	String str =oP.getDate_created().substring(0, 10);
	  	String date = str.replace("-", "");
	  	//11/01/2022  : month/day/year
	  	String createdDate = date.substring(4, 6) + "/" + date.substring(6,8) + "/" + date.substring(0, 4);
	  	System.out.println( "********createdDate in order  " + createdDate);
	  	//calculate the date range check based on the create date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		//convert String to LocalDate
		LocalDate localCreateDate = LocalDate.parse(createdDate, formatter);
		
		int day = localCreateDate.getDayOfMonth();	
		int month = localCreateDate.getMonthValue();
		int year = localCreateDate.getYear();

		LocalDate now = LocalDate.now();
		int dayToday = now.getDayOfMonth();
		int monthToday = now.getMonthValue();
		int prevMonth = now.getMonthValue()-1;		
		int yearToday = now.getYear();	 
		int prevYear = now.getYear()-1;
		LocalDate startDate = null;
		LocalDate endDate = null;
		
		if(year == prevYear && month !=12) {
			return false;
		}
			
		// note that the cron job will run on the 3rd of each month for the previous 2nd half..
		// 16th day of the previous month 2022-10-16
		if(month ==1 && year==yearToday) {
			startDate = YearMonth.of(year, month).atDay(16);
			System.out.println( "********startDate prev month second half start date" + startDate);	
		}
		// get only for previous month ii current month is January  
		else if (month ==12 && year==prevYear && monthToday==1) {
			startDate = YearMonth.of(year, month).atDay(16);
			System.out.println( "********startDate prev month second half prev december" + startDate);	
		}
		// for all other months Feb to Dec in current year
		else {
			startDate = YearMonth.of(yearToday, prevMonth).atDay(16);
			System.out.println( "********startDate prev month 2nd half current year" + startDate);	
		}

		if(month ==1 && year==yearToday) {
			//add it for Jan 15 to Jan 31
			endDate = YearMonth.of(year, month).atEndOfMonth();	
			System.out.println( "********endDate for 2nd half January: " + endDate);	
		}
		else if (month ==12 && year==prevYear && monthToday==1) {
			endDate = YearMonth.of(year, month).atEndOfMonth();
			System.out.println( "********endDate prev month second half prev december : " + endDate);	
		}
		else {
			endDate = YearMonth.of(yearToday, prevMonth).atEndOfMonth();	
			System.out.println( "********endDate Prev Month 2nd half current year : " + endDate);	
		}			
		
		//for the 12th month of December - calculate little differently - see if dates fall within start and end dates
		// if it is the first half of January of Current year - order == false..
		if (month == 1 && year == yearToday && day<15) {
			order=false;
//			order = (localCreateDate.isAfter(startDate)|| localCreateDate.isEqual(startDate)) && (localCreateDate.isBefore(endDate) || localCreateDate.isEqual(endDate));
//			System.out.println( "result   firstHalfTest of month date): " + order);
		}
		else if (month == 1 && year == yearToday && day>15) {
			//order=false;
			order = (localCreateDate.isAfter(startDate)|| localCreateDate.isEqual(startDate)) && (localCreateDate.isBefore(endDate) || localCreateDate.isEqual(endDate));
			System.out.println( "result   firstHalfTest of month date): " + order);
		}	
		// if it is the 12th month of last year and day =>15 then true;
		else if (month == 12 && year==prevYear && day > 15) {
			order = (localCreateDate.isAfter(startDate)|| localCreateDate.isEqual(startDate)) && (localCreateDate.isBefore(endDate) || localCreateDate.isEqual(endDate));	
			System.out.println( "result   firstHalfTest of month date): " + order);
		}	
		else if (month == prevMonth && year==yearToday && day > 15) {
			order = (localCreateDate.isAfter(startDate)|| localCreateDate.isEqual(startDate)) && (localCreateDate.isBefore(endDate) || localCreateDate.isEqual(endDate));	
			System.out.println( "result   firstHalfTest of month date): " + order);
		}
		else {
			order=false;
		}
	    return  order;		
	}
	
	/**
	 * @author srajaiah
	 * @Date October 17th 2022, 
	 * @Description : Checks if the createDate between 1st and the 16th of the current month & Current year
	 * @ReportDate = 17th of every month
	 * @StartDate = 1st day of current month
	 * @End Date = 17th day of current month.
	 */
	public static  boolean isCreateDateWithinRange(LocalDate localDate) throws ParseException {
		
		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();
		int day   = today.getDayOfMonth();
		boolean todayTest = false;

		
		// before the first day of the current month i.e. the last day of the prev month.
		LocalDate startDate = YearMonth.now().atDay(1);
		
		//  16th day of the current month i.e. the last day of the prev month.
		LocalDate endDate = YearMonth.now().atDay(16);
		
		if (day >=16 &&  day <=31){		
			 todayTest = true;	
		}

		boolean firstHalfTest = localDate.isAfter(startDate) && localDate.isBefore(endDate);	
		
//		System.out.println("todayTest: " + todayTest); 
//		System.out.println("firstHalfTest: " + firstHalfTest); 
		System.out.println( "result   firstHalfTest && todayTest): " + (firstHalfTest && todayTest));
		
	   // return  localDate.isAfter(startDate) && localDate.isBefore(endDate);	
	    return  firstHalfTest && todayTest;	
		
	}


    

	/**
	 * @Author : Shakila Rajaiah
	 * @Date : January 24th 2022.
	 * @param date
	 * @throws ParseException 
	 * @Modified: As Bethany Stutz send a email on January 20th 2022 saying that
	 * 				Season would like these to be weekly reports.
	 * @Description: Calculates the end date of the weekly report for Citilink..  
	 * 				The report needs to be run every Monday. 
	 * 				For example for Monday January 24th 
	 * 				Start Date = previous Saturday = January 15th otherwise, it skips the previous Monday.
	 * 				End date = previous day - Sunday.
	 * 				 
	 * 	 */
	public static void calculateStartDateForWeeklyReport() throws ParseException {
				
		LocalDate localDate = LocalDate.now();
		LocalDate endDate = localDate.minusDays(1);
		LocalDate startDate = localDate.minusDays(9);
		System.out.println("Today endDate: "+ endDate);
		System.out.println("Today startDate: "+ startDate);
		
		//local date object can only be printed only as as yyyy-mm-dd
       // LocalDate localDate =  LocalDate.parse(startDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		System.out.println("LocalDate :  " + localDate );
		

		//return startDate;	
			
		}
	
	
	/**
	 * @Author : Shakila Rajaiah
	 * @Date : November 12 2021.
	 * @param date
	 * @throws ParseException 
	 * @Description: Calculates the end date of the Month for WooCommerce.  
	 * 				 For Jan, March, May, July, August, October, December it will be the 31st.
	 * 				For April, June, September, November it will be the 30
	 * 				For February it will be the 28th or the 29th depending on the leap year.  

	 * 
	 */
	public String calculateEndDateForWoo(String startdate) throws ParseException {
				
		//it should be the first day of the previous month
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String startDate = now.format(formatter);
		System.out.println("Current DateTime after Formatting:: " + startDate );
		
		//local date object can only be printed only as as yyyy-mm-dd
        LocalDate localDate =  LocalDate.parse(startDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		System.out.println("LocalDate :  " + localDate );
		
		int year  = localDate.getYear();
		int month = localDate.getMonthValue();
	
		java.util.Date day = calculateMonthEndDate1(month, year);	

		return startDate;	
			
		}

	
	
	
	public void StringToDate() 
	{
		
		//public static void main(String[] args)throws Exception {
		try{
			String sDate1="31/12/1998";
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			System.out.println("Formatted date date1: " + date1);
		}catch (Exception e) {
			e.getStackTrace();
		}
		//}
	} 
	
	public static String getMonth() 
	{
		 String prevMonthName = null;
		try{
		
			LocalDate startDate = YearMonth.now().minusMonths( 1 ).atDay( 1 );
		    prevMonthName = startDate.getMonth()
		            .getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);
		    System.out.println(prevMonthName);
			
		}catch (Exception e) {
			e.getStackTrace();
		}
		return prevMonthName;	
	} 
	
	
	
	public static java.util.Date  calculateMonthEndDate1(int month, int year) {
	    int[] daysInAMonth = { 29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	    int day = daysInAMonth[month];
	    boolean isLeapYear = new GregorianCalendar().isLeapYear(year);

	    if (isLeapYear && month == 2) {
	        day++;
	    }
	    GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
	    java.util.Date monthEndDate = new java.util.Date(gc.getTime().getTime());

	    Calendar cal = Calendar.getInstance();
	    cal.setTime(monthEndDate);
	    int month1 = cal.get(Calendar.MONTH);
	    
	    return monthEndDate;
	}
	
	public static int calculateMonthEndDate(int month, int year) {
	    int[] daysInAMonth = { 29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	    int day = daysInAMonth[month];
	    boolean isLeapYear = new GregorianCalendar().isLeapYear(year);

	    if (isLeapYear && month == 2) {
	        day++;
	    }
	    GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
	    java.util.Date monthEndDate = new java.util.Date(gc.getTime().getTime());

	    Calendar cal = Calendar.getInstance();
	    cal.setTime(monthEndDate);
	    int month1 = cal.get(Calendar.MONTH);
	    
	    return day;
	}


}
