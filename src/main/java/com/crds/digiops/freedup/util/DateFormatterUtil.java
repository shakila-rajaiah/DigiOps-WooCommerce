package com.crds.digiops.freedup.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Calendar;
import java.net.InetAddress;
import java.net.UnknownHostException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.crds.digiops.freedup.service.*;
import com.crds.digiops.freedup.model.*;

/**
 * @author S RAJAIAH
 * @Date : April 1, 2021
 * @Description : This is a common utility file that calculates and formats
 *              Dates.
 *
 */
public class DateFormatterUtil {

	public DateFormatterUtil() {
		// TODO Auto-generated constructor stub
	}

	static Logger logger = LoggerFactory.getLogger(DateFormatterUtil.class);
	
	
	/**
	 * @author Shakila Rajaiah
	 * @Date  October 12, 2023
	 * @Description: gets the host name and address for the server
	 *               
	 */	
    public String[] getHostAddress() throws UnknownHostException {
    	
    	String[] arr = new String[2];
//    	arr[0] = ans1;
//    	arr[1] = ans2;
//    	return arr;

        arr[0] = InetAddress.getLocalHost().getHostAddress();
		System.out.println(" HostAddress: " + arr[0]);
		logger.info(" HostAddress: " + arr[0]);
		arr[1] =InetAddress.getLocalHost().getHostName();
		System.out.println("HostName : " + arr[1]);
		logger.info(" HostName: " + arr[1]);
		
		return arr;		
    }
    
	/*
	 * @Author: Shakila Rajaiah
	 * @Date July 22, 2024
	 * @Desc: Convert a string date to ISO8601Date
	 * for after and before parameters 
	 */
	public String convertToIso8601Date(String startDate) throws ParseException {
		

	    // Date string in YYYY-MM-DD format
        //String dateString = "2024-05-30";
        
        // Parse the date string to LocalDate
        LocalDate localDate = LocalDate.parse(startDate);
        
        // Convert LocalDate to OffsetDateTime with the current time and UTC offset
        OffsetDateTime offsetDateTime = localDate.atStartOfDay().atOffset(ZoneOffset.UTC);
        
        // Format it as ISO8601
        String iso8601Date = offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        
        // Print the result
        System.out.println("ISO8601 Date and Time: " + iso8601Date);	
        
        return iso8601Date;
	}
	
	

	public static String calculateLongDate(String startdate) throws ParseException {

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		Date startDate = df.parse(startdate);

		// convert to unix time.
		long startTime = (long) startDate.getTime() / 1000;

		startdate = String.valueOf(startTime);

		System.out.println("**** startdate long converted to string ***" + startdate);
		logger.info("**** startdate long converted to string ***" + startdate);

		return startdate;

	}

	/*
	 * Takes in a date (string) and converts it to a long date. used from the jsp as
	 * it strips off the ""
	 */
	public String convertDate(String startdate) throws ParseException {

		startdate = startdate.replaceAll(",", "");
		Date startDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(startdate);

		// convert to unix time.
		long startTime = (long) startDate.getTime() / 1000;

		startdate = String.valueOf(startTime);
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
	 * @Description: Calculates the end date based on when the report is run. If the
	 *               report is run for the first half of the month, the end date
	 *               will be the 15th of the month. If the report is run for the
	 *               second half of the month, the end date will be the 3th of the
	 *               next month. This is to give them a cushion for the payouts to
	 *               be deposited on the 15th and 30/31st of the month.
	 * 
	 */
	public String calculateEndDateForCronJob(String startdate) throws ParseException {

		// reduce a day as the payout reports are not available for the current day...
		LocalDateTime now = LocalDateTime.now().minusDays(1);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String endDate = now.format(formatter);
		System.out.println("***** Current END DATE TIME after Formatting:: " + endDate);

		endDate = calculateLongDate(endDate);

		System.out.println("**** endDate (long) converted to string ***" + endDate);
		return endDate;

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
	public static String  calculateWeeklyReportStartDate() throws ParseException {
				
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime sDate = now.minusDays(9);
		System.out.println("Today date: "+ sDate);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String startDate = sDate.format(formatter);
		System.out.println("Current DateTime after Formatting:: " + startDate );
		
				
		//String startDate = calculateLongDate(formatedDateTime);
		//System.out.println("***after calculate start date2 : " + startDate);
		
		return startDate;		
			
		}
	
	/**
	 * @Author : Shakila Rajaiah
	 * @Date : October 16, 2023
	 * @param date
	 * @throws ParseException 
	 * @Modified: As Bethany Stutz send a email mentioning that Season would like these to be weekly reports.
	 * @Description: Calculates the end date of the weekly report for WooCommerce/Freedup..  
	 * 				The report needs to be run every Monday. 
	 * 				For example for Monday January 24th 
	 * 				Start Date = previous Saturday = January 15th otherwise, it skips the previous Monday.
	 * 				End date = previous day - Sunday.
	 * 				 
	 **/
	public static String  calculateWeeklyReportEndDate() throws ParseException {
				
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime eDate = now.minusDays(1);
		System.out.println("end date: "+ eDate);		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String endDate = eDate.format(formatter);
		System.out.println("Current DateTime after Formatting:: " + endDate );		
				
//		String endDate = calculateLongDate(formatedDateTime);
//		System.out.println("***after calculate start date2 : " + endDate);
		
		return endDate;		
			
		}
	
	/**
	 * @author srajaiah
	 * @Date April 8, 2024
	 * @ModifiedDate 
	 * @Description : Checks if the createDate falls within the previous week
	 * 	 * VPN Issues and email issues with woo commerce reports 
	 * @ReportDate = typically run on Mondays
	 * @StartDate = 9 days prev to today
	 * @End Date = 1 day previous to today
	 */
	public static boolean isWithinDateRangeForWeek(OrderPOJO oP) throws ParseException {

		boolean order = false;

//	  	//'2021-11-15T09:49:04'
		String str = oP.getDate_created().substring(0, 10);
		String date = str.replace("-", "");
		String createdDate = date.substring(4, 6) + "/" + date.substring(6, 8) + "/" + date.substring(0, 4);
		System.out.println("********createdDate " + createdDate);
		// calculate the date range check based on the create date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//		//convert String to LocalDate
		LocalDate localCreateDate = LocalDate.parse(createdDate, formatter);
		String strStartDate = calculateWeeklyReportStartDate();
		String strEndDate = calculateWeeklyReportEndDate();
		LocalDate startDate = LocalDate.parse(strStartDate, formatter);
		LocalDate endDate = LocalDate.parse(strEndDate, formatter);

		System.out.println("********localCreateDate" + localCreateDate);
		
		order = (localCreateDate.isAfter(startDate) || localCreateDate.isEqual(startDate))
				&& (localCreateDate.isBefore(endDate) || localCreateDate.isEqual(endDate));
		System.out.println("result weekly report dates): " + order + "- start" + startDate + " - end " + endDate);

		return order;
	}


	/**
	 * @author srajaiah
	 * @Date November 15th, 2021
	 * @Report Date = 3rd of the month
	 * @Description : Checks if the createDate is in the last Month.
	 */
	public static  boolean isWithinDateRangeForPrevMonth(OrderPOJO oP) throws ParseException {
		
		boolean order = false;

//	  	//'2021-11-15T09:49:04'
		String str = oP.getDate_created().substring(0, 10);
		String date = str.replace("-", "");
		
		System.out.println("ConvertJsonFile inside isWithinDateRangeForPrevMonth: " + date);
		
		String createDate = date.substring(4, 6) + "/" + date.substring(6,8) + "/" + date.substring(0, 4);
		System.out.println("********createdDate " + createDate);
					
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		//convert String to LocalDate
		LocalDate localCreateDate = LocalDate.parse(createDate, formatter);

		LocalDate startDate = YearMonth.now().minusMonths( 2 ).atEndOfMonth();
		// before the first day of the current month i.e. the last day of the prev month.
		LocalDate endDate = YearMonth.now().atDay(1);
		    
	    return  localCreateDate.isAfter(startDate) && localCreateDate.isBefore(endDate);			
		
	}
	
	

	/**
	 * @author srajaiah
	 * @Date September 7, 2022
	 * @ModifiedDate: May 13th 2024
	 * @Description : Changed by Beth via email on 5/13/2024
	 * 					Checks if the createDate between 28th of the Previous month and 15th day of 
	 *                  the current month.
	 *              
	 * @ReportDate = 15th of every month
	 * @StartDate = 28th of the Previous Month
	 * @End Date = 15th day of current month.
	 * 
	 */
	public static boolean isWithinDateRangeForCurrentMonthFirstHalfNew(OrderPOJO oP) throws ParseException {

//	  	//'2021-11-15T09:49:04'
		String dateString = oP.getDate_created().substring(0, 10);	
//		String date = dateString.replace("-", "");
//		String createdDate = date.substring(4, 6) + "/" + date.substring(6, 8) + "/" + date.substring(0, 4);
		System.out.println("********createdDate " + dateString);
		
        LocalDate dateLocal = LocalDate.parse(dateString);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Get the 28th of the previous month
        LocalDate previousMonth28th = currentDate.minusMonths(1).withDayOfMonth(28);

        // Get the 15th of the current month
        LocalDate currentMonth15th = currentDate.withDayOfMonth(15);

        // Check if the date is after the 28th of the previous month and before the 15th of the current month
        return dateLocal.isAfter(previousMonth28th) && dateLocal.isBefore(currentMonth15th);
	}
	
	
	/**
	 * @author srajaiah
	 * @Date   May 20, 2024
	 * @ModifiedDate: May 13th 2024
	 * @DESC    		Checks if the createDate Start and Stop Date.
	 *              
	 * @ReportDate = Run from User front Interface
	 * @StartDate = 
	 * @End Date = 
	 * 
	 */
	public static boolean isWithinStartDateAndStopdate(OrderPOJO oP, String startDate, String endDate) throws ParseException {

//	  	//'2021-11-15T09:49:04'
		String dateString = oP.getDate_created().substring(0, 10);	
//		String date = dateString.replace("-", "");
//		String createdDate = date.substring(4, 6) + "/" + date.substring(6, 8) + "/" + date.substring(0, 4);
		System.out.println("********createdDate " + dateString);
		
        LocalDate dateLocal = LocalDate.parse(dateString);
        
        
        //Get StartDate
        LocalDate start = LocalDate.parse(startDate);
        
        //Get EndDate
        LocalDate end = LocalDate.parse(endDate);       

        // Check if the date is after the 28th of the previous month and before the 15th of the current month
        return (dateLocal.isAfter(start) || dateLocal.isEqual(start)) && (dateLocal.isBefore(end) || dateLocal.isEqual(end)) ;

	}
	
	
	
	
	/**
	 * @author srajaiah
	 * @Date September 7, 2022
	 * @ModifiedDate: May 13th 2024
	 * @Description : Changed by Beth via email on 5/13/2024
	 * 					Checks if the createDate between 12th of the current month to the 3rd of the following month. 
	 *                  the current month.
	 *                  3rd of each month - Run from the 12th current month through 
	 *                  the 3rd following month (Ex. May 3rd - April 12th-May 3rd)
	 *              
	 * @ReportDate = 3rd of every month
	 * @StartDate = 12th of the Previous Month
	 * @End Date = 3rd day of current month.
	 * 
	 */
	public static boolean isWithinDateRangeForPrevMonthSecondHalfNew(OrderPOJO oP) throws ParseException {
		boolean order = false;

		// '2021-11-15T09:49:04'
		String dateString = oP.getDate_created().substring(0, 10);
//		String dateStr = dateString.replace("-", "");
//		// 11/01/2022 : month/day/year
//		String createdDate = dateStr.substring(4, 6) + "/" + dateStr.substring(6, 8) + "/" + dateStr.substring(0, 4);
		System.out.println("********createdDate in order  " + dateString);

        LocalDate date = LocalDate.parse(dateString);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Get the 12th of the previous month
        LocalDate previousMonth12th = currentDate.minusMonths(1).withDayOfMonth(12);

        // Get the 3rd of the current month
        LocalDate currentMonth3rd = currentDate.withDayOfMonth(3);

        // Check if the date is after the 12th of the previous month and before the 3rd of the current month
        return date.isAfter(previousMonth12th) && date.isBefore(currentMonth3rd);

	}
	
	
	/**
	 * @author srajaiah
	 * @Date September 7, 2022
	 * @ModifiedDate February 21, 2023.
	 * @Description : Checks if the createDate between 1st and the 16th of the
	 *              current month.
	 * @ReportDate = 17th of every month
	 * @StartDate = 1st day of current month
	 * @End Date = 17th day of current month.
	 * 
	 */
	public static boolean isWithinDateRangeForCurrentMonthFirstHalf(OrderPOJO oP) throws ParseException {

		boolean order = false;

//	  	//'2021-11-15T09:49:04'
		String str = oP.getDate_created().substring(0, 10);
		String date = str.replace("-", "");
		String createdDate = date.substring(4, 6) + "/" + date.substring(6, 8) + "/" + date.substring(0, 4);
		System.out.println("********createdDate " + createdDate);
		// calculate the date range check based on the create date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//		//convert String to LocalDate
		LocalDate localCreateDate = LocalDate.parse(createdDate, formatter);

		System.out.println("********localCreateDate" + localCreateDate);

		int day = localCreateDate.getDayOfMonth();
		int month = localCreateDate.getMonthValue();
		int year = localCreateDate.getYear();
		LocalDate now = LocalDate.now();
		int dayToday = now.getDayOfMonth();
		int monthToday = now.getMonthValue();
		int prevMonth = now.getMonthValue() - 1;
		int yearToday = now.getYear();

		 if (day >=16 && day<=31) {
			 return false;
		 }
		// before the first day of the current month i.e. the last day of the prev
		// month.
		LocalDate startDate = YearMonth.now().atDay(1);
		// System.out.println( "********startDate " + startDate);

		// 16th day of the current month i.e. the last day of the prev month.
		LocalDate endDate = YearMonth.now().atDay(16);
		// System.out.println( "********endDate " + endDate);

		if (dayToday >= 16 && day <= 16) {
			if (year == yearToday && month == monthToday) {
				order = localCreateDate.isAfter(startDate) && localCreateDate.isBefore(endDate);
				// System.out.println( "result firstHalfTest of month date): " + order);
			}
		} else {
			order = false;
		}

		return order;
	}
	
	
	/**
	 * @author srajaiah
	 * @Date September 7, 2022
	 * @ModifiedDate January 12, 2023 (to correct prev month 12th problem)
	 * @ModifiedDate February 21, 2023. 
	 * @Report Run date = 3rd of every month
	 * @Description : Checks if the createDate between 16th and the last day of the
	 *              previous month
	 */
	public static boolean isWithinDateRangeForPrevMonthSecondHalf(OrderPOJO oP) throws ParseException {
		boolean order = false;

		// '2021-11-15T09:49:04'
		String str = oP.getDate_created().substring(0, 10);
		String date = str.replace("-", "");
		// 11/01/2022 : month/day/year
		String createdDate = date.substring(4, 6) + "/" + date.substring(6, 8) + "/" + date.substring(0, 4);
		System.out.println("********createdDate in order  " + createdDate);
		// calculate the date range check based on the create date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		// convert String to LocalDate
		LocalDate localCreateDate = LocalDate.parse(createdDate, formatter);

		int day = localCreateDate.getDayOfMonth();
		int month = localCreateDate.getMonthValue();
		int year = localCreateDate.getYear();

		LocalDate now = LocalDate.now();
		int dayToday = now.getDayOfMonth();
		int monthToday = now.getMonthValue();
		int prevMonth = now.getMonthValue() - 1;
		int yearToday = now.getYear();
		int prevYear = now.getYear() - 1;
		LocalDate startDate = null;
		LocalDate endDate = null;

		 if (year == prevYear && month != 12) {
			return false;
		 }
		
		  if(day>=1 && day<=15) 
		  { 
			  return false; 
		  }
		 

		// note that the cron job will run on the 3rd of each month for the previous 2nd
		// half..
		// 16th day of the previous month 2022-10-16
		if (month == 1 && year == yearToday) {
			startDate = YearMonth.of(year, month).atDay(16);
			System.out.println("********startDate prev month second half start date" + startDate);
		}
		// get only for previous month ii current month is January
		else if (month == 12 && year == prevYear && monthToday == 1) {
			startDate = YearMonth.of(year, month).atDay(16);
			System.out.println("********startDate prev month second half prev december" + startDate);
		}
		// for all other months Feb to Dec in current year
		else {
			startDate = YearMonth.of(yearToday, prevMonth).atDay(16);
			System.out.println("********startDate prev month 2nd half current year" + startDate);
		}

		if (month == 1 && year == yearToday) {
			// add it for Jan 15 to Jan 31
			endDate = YearMonth.of(year, month).atEndOfMonth();
			System.out.println("********endDate for 2nd half January: " + endDate);
		} else if (month == 12 && year == prevYear && monthToday == 1) {
			endDate = YearMonth.of(year, month).atEndOfMonth();
			System.out.println("********endDate prev month second half prev december : " + endDate);
		} else {
			endDate = YearMonth.of(yearToday, prevMonth).atEndOfMonth();
			System.out.println("********endDate Prev Month 2nd half current year : " + endDate);
		}

		// for the 12th month of December - calculate little differently - see if dates
		// fall within start and end dates
		// if it is the first half of January of Current year - order == false..
		if (month == 1 && year == yearToday && day < 15) {
			order = false;
//			order = (localCreateDate.isAfter(startDate)|| localCreateDate.isEqual(startDate)) && (localCreateDate.isBefore(endDate) || localCreateDate.isEqual(endDate));
//			System.out.println( "result   firstHalfTest of month date): " + order);
		} else if (month == 1 && year == yearToday && day > 15 && dayToday <15) {
			// order=false;
			order = (localCreateDate.isAfter(startDate) || localCreateDate.isEqual(startDate))
					&& (localCreateDate.isBefore(endDate) || localCreateDate.isEqual(endDate));
			System.out.println("result   secondHalfTest of month date): " + order + "-" + localCreateDate);
		}
		// if it is the 12th month of last year and day =>15 then true;
		else if (month == 12 && year == prevYear && day > 15 && monthToday==1 && dayToday <15) {
			order = (localCreateDate.isAfter(startDate) || localCreateDate.isEqual(startDate))
					&& (localCreateDate.isBefore(endDate) || localCreateDate.isEqual(endDate));
			System.out.println("result   firstHalfTest of month date): " + order + "-" + localCreateDate);
		} else if (month == prevMonth && year == yearToday && day > 15 && dayToday <15) {
			order = (localCreateDate.isAfter(startDate) || localCreateDate.isEqual(startDate))
					&& (localCreateDate.isBefore(endDate) || localCreateDate.isEqual(endDate));
			System.out.println("result   firstHalfTest of month date): " + order + "-" + localCreateDate);
		} else {
			order = false;
		}
		return order;
	}


	
	
	/**
	 * @author srajaiah
	 * @Date April 8, 2024
	 * @ModifiedDate 
	 * @Description : Checks if the createDate falls in the previous month. Written for Beth as there were 
	 * VPN Issues and email issues with woo commerce reports for the month of march..
	 * @ReportDate = run as needed for testing
	 * @StartDate = 1st day of current month
	 * @End Date = 31 st day of previous month.
	 */
	public static boolean isWithinDateRangeForPreviousMonthTest(OrderPOJO oP) throws ParseException {

		boolean order = false;

//	  	//'2021-11-15T09:49:04'
		String str = oP.getDate_created().substring(0, 10);
		String date = str.replace("-", "");
		String createdDate = date.substring(4, 6) + "/" + date.substring(6, 8) + "/" + date.substring(0, 4);
		System.out.println("********createdDate " + createdDate);
		// calculate the date range check based on the create date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//		//convert String to LocalDate
		LocalDate localCreateDate = LocalDate.parse(createdDate, formatter);

		System.out.println("********localCreateDate" + localCreateDate);

		int day = localCreateDate.getDayOfMonth();
		int month = localCreateDate.getMonthValue();
		int year = localCreateDate.getYear();
		LocalDate now = LocalDate.now();
		int dayToday = now.getDayOfMonth();
		int monthToday = now.getMonthValue();
		int prevMonth = now.getMonthValue() - 1;
		int yearToday = now.getYear();

		 if (month ==3 &yearToday==2024) {
			 order = true;
		 }

		return order;
	}
	
	


	/**
	 * @author srajaiah
	 * @Date October 17th 2022,
	 * @Description : Checks if the createDate between 1st and the 16th of the
	 *              current month & Current year
	 * @ReportDate = 17th of every month
	 * @StartDate = 1st day of current month
	 * @End Date = 17th day of current month.
	 */
	public static boolean isCreateDateWithinRange(LocalDate localDate) throws ParseException {

		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		boolean todayTest = false;

		// before the first day of the current month i.e. the last day of the prev
		// month.
		LocalDate startDate = YearMonth.now().atDay(1);

		// 16th day of the current month i.e. the last day of the prev month.
		LocalDate endDate = YearMonth.now().atDay(16);

		if (day >= 16 && day <= 31) {
			todayTest = true;
		}

		boolean firstHalfTest = localDate.isAfter(startDate) && localDate.isBefore(endDate);

//		System.out.println("todayTest: " + todayTest); 
//		System.out.println("firstHalfTest: " + firstHalfTest); 
		System.out.println("result   firstHalfTest && todayTest): " + (firstHalfTest && todayTest));

		// return localDate.isAfter(startDate) && localDate.isBefore(endDate);
		return firstHalfTest && todayTest;

	}

//	/**
//	 * @Author : Shakila Rajaiah
//	 * @Date : January 24th 2022.
//	 * @param date
//	 * @throws ParseException
//	 * @Modified: As Bethany Stutz send a email on January 20th 2022 saying that
//	 *            Season would like these to be weekly reports.
//	 * @Description: Calculates the end date of the weekly report for Citilink.. The
//	 *               report needs to be run every Monday. For example for Monday
//	 *               January 24th Start Date = previous Saturday = January 15th
//	 *               otherwise, it skips the previous Monday. End date = previous
//	 *               day - Sunday.
//	 * 
//	 */
//	public static void calculateStartDateForWeeklyReport() throws ParseException {
//
//		LocalDate localDate = LocalDate.now();
//		LocalDate endDate = localDate.minusDays(1);
//		LocalDate startDate = localDate.minusDays(9);
//		System.out.println("Today endDate: " + endDate);
//		System.out.println("Today startDate: " + startDate);
//
//		// local date object can only be printed only as as yyyy-mm-dd
//		// LocalDate localDate = LocalDate.parse(startDate,
//		// DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//		System.out.println("LocalDate :  " + localDate);
//
//		// return startDate;
//
//	}

	/**
	 * @Author : Shakila Rajaiah
	 * @Date : November 12 2021.
	 * @param date
	 * @throws ParseException
	 * @Description: Calculates the end date of the Month for WooCommerce. For Jan,
	 *               March, May, July, August, October, December it will be the
	 *               31st. For April, June, September, November it will be the 30
	 *               For February it will be the 28th or the 29th depending on the
	 *               leap year.
	 * 
	 * 
	 */
	public String calculateEndDateForWoo(String startdate) throws ParseException {

		// it should be the first day of the previous month
		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String startDate = now.format(formatter);
		System.out.println("Current DateTime after Formatting:: " + startDate);

		// local date object can only be printed only as as yyyy-mm-dd
		LocalDate localDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		System.out.println("LocalDate :  " + localDate);

		int year = localDate.getYear();
		int month = localDate.getMonthValue();

		java.util.Date day = calculateMonthEndDate1(month, year);

		return startDate;

	}

	public void StringToDate() {

		// public static void main(String[] args)throws Exception {
		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			System.out.println("Formatted date date1: " + date1);
		} catch (Exception e) {
			e.getStackTrace();
		}
		// }
	}

	public static String getMonth() {
		String prevMonthName = null;
		try {

			LocalDate startDate = YearMonth.now().minusMonths(1).atDay(1);
			prevMonthName = startDate.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);
			System.out.println(prevMonthName);

		} catch (Exception e) {
			e.getStackTrace();
		}
		return prevMonthName;
	}
	
	
	/**
	 * @author srajaiah
	 * @Date September 7, 2022
	 * @ModifiedDate February 21, 2023.
	 * @Description : Gives the Month and Date Range for the Woo Commerce report 
	 * 				  based on the report date,	
	 * @ReportDate =  3rd of every month (15th to 31st of the previous month
	 * @ReportDate =  17th of every month 1 to 15th of current month)
	 */
	public static String getMonthAndDateRangeForEmailReport() {
		String monthName = null;
		String currentMonth = null;
		try {

			LocalDate today = LocalDate.now();
			int month = today.getMonthValue();
			int day = today.getDayOfMonth();
			
			if (day > 1 && day <=15) {
				LocalDate startDatePrevMonth = YearMonth.now().minusMonths(1).atDay(1);
				monthName = startDatePrevMonth.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH) + " (Previous Month) Second Half reports";	
				System.out.println(monthName);
			}
			
			if (day >= 16 && day <31) {			
				LocalDate startDateCurrentMonth = YearMonth.now().minusMonths(0).atDay(1);
				monthName = startDateCurrentMonth.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH)  + " (Current Month) First Half Reports";
				System.out.println(monthName);
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return monthName;
	}

	public static java.util.Date calculateMonthEndDate1(int month, int year) {
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
