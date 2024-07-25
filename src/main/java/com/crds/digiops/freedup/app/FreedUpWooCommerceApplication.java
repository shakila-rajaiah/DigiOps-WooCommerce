package com.crds.digiops.freedup.app;

//import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java. util. Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import com.crds.digiops.freedup.woocommerce.WooCommerceClientStart;
import com.crds.digiops.freedup.util.DateFormatterUtil;
import com.crds.digiops.freedup.service.EmailServiceImpl;
import com.crds.digiops.freedup.controller.FreedUpController;


/**
 * @author S RAJAIAH
 * @Date : August 2, 2022
 * @Desc : This is The main class re-written for the Freed-Up App.
 *
 */
//lets you scan every component that you want to scan.

@ComponentScan(basePackageClasses=FreedUpController.class)
@SpringBootApplication
public class FreedUpWooCommerceApplication {
	
	static Logger logger = LoggerFactory.getLogger(FreedUpWooCommerceApplication.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(FreedUpWooCommerceApplication.class, args);
		
//		FreedUpController fc = new FreedUpController();
//			
//		try {
//			fc.getWooCommerceOrdersReport(null, null);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			logger.error(e.getMessage());
//		}
//		
//		logger.info("Scheduler run at {}", dateFormat.format(new Date()));

	}



	/**
	 * @author S RAJAIAH
	 * @Date May 9, 2024
	 * @Modified date : February 3rd, 2022. - made changes to first and last day of monthly reports.
	 * @Description : run Woocommerce Freed Up every monday. 
	 * 				  It was run twice a month on the 3rd and the 17th of each Month. 
	 * 				  Bethany has requested that it be run in a weekly manner.
	 *  			  Scheduled(cron = "0 45 13 ? * MON")              
	 *	 <second> <minute> <hour> <day-of-month> <month> <day-of-week> <command>
	 */
	// Schedule a cron job to run the WooCommerce Freed-Upreport testing 
	@Scheduled(cron = "0 15 14 ? * MON-FRI")//schedule a task to run at 2.15 PM DAILY for testing.  
	//in test to test for server activity.
	public void scheduleTaskUsingCronExpressionFreedUpWeeklyTest() throws ParseException {
	    String message ="";
		long now = System.currentTimeMillis() / 1000;
	    System.out.println("********** schedule tasks using cron jobs a task to run at 2.15 PM DAILY for testing in ITDev1- " + now);
	    
	    try {
	    
	    DateFormatterUtil df = new DateFormatterUtil();
	        
	    String startDate= df.calculateWeeklyReportStartDate();   		
	    String endDate= df.calculateWeeklyReportEndDate();
	    
	    System.out.println(" the cron start date For FREED-UP WEEKLY REPORT in ITDev1" + startDate);
	    logger.info(" the cron start date For FREED-UP WEEKLY REPORT in ITDev1 " + startDate);
	    System.out.println(" the cron end date  For FREED-UP WEEKLY REPORT testing in ITDev1 " + endDate);
	    logger.info(" the cron end date  For FREED-UP WEEKLY REPORT in ITDev1 " + endDate);
	    
	    // run the CRON job only if it is from the production server 
		EmailServiceImpl esr = new EmailServiceImpl();
		String[]arr = esr.getHostAddress();
		// if it is ITDev1
		if (arr[0].equals("10.2.48.15")) {		        
		    WooCommerceClientStart wcs = new WooCommerceClientStart();		    
		    message = wcs.getWooCommerceOrders("weekly"); 		    
		    System.out.println("**** message from scheduler daily test for Freed-UP Orders report" + message);	
		}
    
	    System.out.println("**** message from scheduler for Daily testing of WEEKLY FREED-UP ORDERS REPORT ****" + message);
	    logger.info("**** message from scheduler for Daily testing for  WEEKLY FREED-UP ORDERS REPORT **** " + message);
	    
	    }catch(Exception e) {
	    	
	    }
	}
	
	
	/**
	 * @author S RAJAIAH
	 * @Date May 16, 2024
	 * @Modified date : .
	 * @Description :send a message if ITProd1 is up and running         
	 *	 <second> <minute> <hour> <day-of-month> <month> <day-of-week> <command>
	 */
	// testing for shakila
	//@Scheduled(cron = "0 40 15 ? * MON-FRI")//schedule a task to run at 8.10 AM every Weekday in IRPROD1.
	// Schedule a cron job to run the Freed-Up WooCommerce Freed-Up report TESTING BY SHAKILA
	@Scheduled(cron = "0 30 07 ? * MON-FRI")//schedule a task to run at 7.30 AM every Weekday in ITPROD1.
	public void scheduleTaskUsingCronExpressionFreedUpWeeklySystemStatusProd() throws ParseException {
	    String message ="";
	    LocalDateTime now = LocalDateTime.now();
	    System.out.println("Date Today " + now);
	    
	    try {
	    
	    System.out.println(" the cron start date For FREED-UP STATUS IN ITProd1" + now);
	    
	    // run the CRON job only if it is from the production server 
		EmailServiceImpl esr = new EmailServiceImpl();
		String[]arr = esr.getHostAddress();
		// if it is ITProd1
		if (arr[0].equals("10.2.48.17")) {		        
			message = esr.sendEmailWithSystemStatus()	;   	    
		    System.out.println("**** message from scheduler for ITProd1 " + message);	
		}
		else {
			// do nothing 			
		}
	    
	    System.out.println("**** message from scheduler for FREED-UP SERVER DAILY STATUS REPORT ****" + message);
	    logger.info("**** message from scheduler for FREED-UP DAILY STATUS REPORT **** " + message);
	    
	    }catch(Exception e) {
	    	
	    }
	}

	
	/**
	 * @author S RAJAIAH
	 * @Date May 16, 2024
	 * @Modified date : .
	 * @Description :send a message if ITProd1 is up and running         
	 *	 <second> <minute> <hour> <day-of-month> <month> <day-of-week> <command>
	 */
	// testing for shakila
	//@Scheduled(cron = "0 12 14 ? * MON-FRI")//schedule a task to run at 8.10 AM every Weekday in IRPROD1.
	// Schedule a cron job to run the Freed-Up WooCommerce report TESTING BY SHAKILA
	@Scheduled(cron = "0 15 07 ? * MON-FRI")//schedule a task to run at 7.15 AM for server test each weekday in ITDEV1
	public void scheduleTaskUsingCronExpressionFreedUpWeeklySystemStatusDev() throws ParseException {
	    String message ="";
	    
	    try {
	    
		LocalDateTime now = LocalDateTime.now();
	    System.out.println(" the cron start date For FREED-UP STATUS " + now);

	    
	    // run the CRON job only if it is from the production server 
		EmailServiceImpl esr = new EmailServiceImpl();
		String[]arr = esr.getHostAddress();
		// if it is ITProd1
		if (arr[0].equals("10.2.48.17")) {		        
				// do nothing
		}
		else {
			// send the status
			esr.sendEmailWithSystemStatus()	;    
		    System.out.println("**** message from scheduler WOOCOMMERCE TEST SERVER " + message);
			//message = "This cron job was triggered from ITDev1 server and therefore job was not run";				
		}
	    
	    System.out.println("**** message from scheduler for DAILY STATUS REPORT ****" + message);
	    logger.info("**** message from scheduler for WEEKLY FREED-UP STATUS REPORT **** " + message);
	    
	    }catch(Exception e) {
	    	
	    }
	}
	
	
	/**
	 * @author S RAJAIAH
	 * @Date May 13, 2024
	 * @Modified date : February 3rd, 2022. - made changes to first and last day of monthly reports.
	 * @Description : 	run WooCommerce Orders report for Freed Up biMonthly. Changed by Beth per her email on 5/13/2024.
	 * 					15th of each month - Run from 28th of prior month through 15th of current month 
	 *                  (Ex. April 15th - March 28th-April 15th)
	 *                  3rd of each month - Run from the 12th current month through the 3rd following month 
	 *                  (Ex. May 3rd - April 12th-May 3rd)
	 * 				  It was previously run twice a month on the 3rd and the 17th of each Month. 
	 * 				  Bethany has requested that it be run in a weekly manner.
	 *  			  Scheduled(cron = "0 45 13 ? * MON")              
	 *	 <second> <minute> <hour> <day-of-month> <month> <day-of-week> <command>
	 */
	// schedule to run the first half of the previous month reports on the 17th of the month 1st to 15t 
	@Scheduled(cron = "0 45 10 17 * ?")// schedule 17th day of the month, at 10.45 AM 
	public void scheduleTaskUsingCronExpressionFirstHalf() throws ParseException {
	 
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "schedule tasks using cron jobs on - " + now);
	    
	    try {	    
		    WooCommerceClientStart wcs = new WooCommerceClientStart();		    
		    String message = wcs.getWooCommerceOrders("bimonthly"); 		    
		    System.out.println("**** message from scheduler schedule 17th day of the month, at 10.45 AM :" + message);		    
	    
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	
	    }
	 }// scheduler first half of month
	
	
	//@Scheduled(cron = "0 45 10 20 * ?")// for testing schedule a task to run at 10.45 PM 0n the 20th day of the month..
	// schedule to run on the second half of the previous month reports from 16th to the last day of teh month
	@Scheduled(cron = "0 30 13 03 * ?")// schedule 3rd day of the Month at 1.30 pm
	public void scheduleTaskUsingCronExpressionSecondHalf() throws ParseException {
	 
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "schedule tasks using cron jobs on - " + now);
	    
	    try {
	    
		    WooCommerceClientStart wcs = new WooCommerceClientStart();		    
		    String message = wcs.getWooCommerceOrders("bimonthly"); 		    
		    System.out.println("**** message from scheduler for report run on on the second half of the previous month reports from 16th to the last day of the month : " + message);		    
	    
	    }catch(Exception e) {
	    	
	    } 
	 }// scheduler second half of month

} // Freed Up Application

/*
* @Date 7/13/21
* @Desc : To enable support for scheduling tasks and the @Scheduled annotation in Spring, 
* we can use the Java enable-style annotation:
* 
*/

@Configuration
@EnableScheduling
class SchedulingConfiguration {

}
