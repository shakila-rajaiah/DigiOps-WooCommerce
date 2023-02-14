package com.crds.digiops.freedup.woocommerce;


import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class JavaDateExample {

    public static String DATE_FORMAT_INPUT = "ddMMyyyy";
    public static String DATE_FORMAT_OUTPUT = "yyyy-MM-dd";
    
    public static void main(String[] args) {

        String date1 = "2016-08-16";

        //default, ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date1);

        System.out.println(localDate);
        localDate.isBefore(localDate);
        String str = "2023-01-12";  
        
	  
	  	String date = str.replace("-", "");  //20230112
	  	
	  	String createdDate = date.substring(4, 6) + "/" + date.substring(6,8) + "/" + date.substring(0, 4);
	  	System.out.println( "********createdDate " + createdDate);
	  	//calculate the date range check based on the create date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		//convert String to LocalDate
		LocalDate localCreateDate = LocalDate.parse(createdDate, formatter);
		
		
		LocalDate monthBefore6 =  localCreateDate.minusMonths(2);
		
		
		
		int day = localCreateDate.getDayOfMonth();	
		int month = localCreateDate.getMonthValue();
		int year = localCreateDate.getYear();
		LocalDate now = LocalDate.now();
		int dayToday = now.getDayOfMonth();
		int monthToday = now.getMonthValue();
		int prevMonth = now.getMonthValue() -1;	
		int yearToday = now.getYear();	 
		int prevYear = now.getYear()-1;
//		LocalDate startDate = null;
//		LocalDate endDate = null;
		
		LocalDate startDate = YearMonth.of(yearToday, prevMonth).atDay(16);
		System.out.println( "********startDate " + startDate);
		  //last day of previous month
		LocalDate endDate = YearMonth.of(yearToday, prevMonth).atEndOfMonth();	
		System.out.println( "********endDate " + endDate);
	  	
	  	


    }
    



//        public static void main(String[] args) {
//            System.out.println(formatted(convert("21022019")));
//        }

        public static String formatted(LocalDate date) {
            return date.format(DateTimeFormatter.ofPattern(DATE_FORMAT_OUTPUT));
        }

        public static LocalDate convert(String dateStr) {
            return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DATE_FORMAT_INPUT));
        }
    
    
}

