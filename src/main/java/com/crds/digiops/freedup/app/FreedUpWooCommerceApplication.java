package com.crds.digiops.freedup.app;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.crds.digiops.freedup.woocommerce.WooCommerceClientStart;

/**
 * @author S RAJAIAH
 * @Date : August 2, 2022
 * @Desc : This is The main class re-written for the Freed-Up App.
 *
 */

@SpringBootApplication
public class FreedUpWooCommerceApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(FreedUpWooCommerceApplication.class, args);
	    WooCommerceClientStart wcs = new WooCommerceClientStart();		    
	    String message = wcs.getWooCommerceOrders(); 	
	}


	//temporarily disabled as Beth requested to run bi-monthly freedup reports 
	//@Scheduled(cron = "0 45 10 03 * ?")// testing on the 3  day at 10.45 AM
	// schedule to run the first half of the previous month reports on the 17th of the month 1st to 15t 
	@Scheduled(cron = "0 15 10 17 * ?")// schedule 17th day of the month, at 10.15 AM 
	public void scheduleTaskUsingCronExpressionFirstHalf() throws ParseException {
	 
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "schedule tasks using cron jobs on - " + now);
	    
	    try {	    
		    WooCommerceClientStart wcs = new WooCommerceClientStart();		    
		    String message = wcs.getWooCommerceOrders(); 		    
		    System.out.println("**** message from scheduler" + message);		    
	    
	    }catch(Exception e) {
	    	
	    }
	 }// scheduler first half of month
	
	
	//temporarily disables as Beth requested to run weekly citi link reports 
	//@Scheduled(cron = "0 45 10 20 * ?")// for testing schedule a task to run at 10.45 PM 0n the 20th day of the month..
	// schedule to run on the second half of the previous month reports from 16th to the last day of teh month
	@Scheduled(cron = "0 15 10 03 * ?")// schedule 3rd dat of Month at 10.15
	public void scheduleTaskUsingCronExpressionSecondHalf() throws ParseException {
	 
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "schedule tasks using cron jobs on - " + now);
	    
	    try {
	    
		    WooCommerceClientStart wcs = new WooCommerceClientStart();		    
		    String message = wcs.getWooCommerceOrders(); 		    
		    System.out.println("**** message from scheduler" + message);		    
	    
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
