package com.crds.digiops.freedup.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.text.ParseException;

import com.crds.digiops.freedup.woocommerce.WooCommerceClientStart;
import com.crsrds.digiops.freedup.util.DateFormatterUtil;

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


	//temporarily disables as Beth requested to run weekly citi link reports 
	////* * 15 * * - every miniute on day 15
	//@Scheduled(cron = "0 45 10 20 * ?")// for testing schedule a task to run at 10.45 PM 0n the 20th day of the month..
	// at 3.00 pm daily
	//@Scheduled(cron = "0 20 18 22 * ?")// testing on the 22  day at 6.20
	@Scheduled(cron = "0 15 13 08 * ?")// testing on the 22  day at 6.20
	public void scheduleTaskUsingCronExpression() throws ParseException {
	 
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "schedule tasks using cron jobs on - " + now);
	    
	    try {
	    
//		    DateFormatterUtil df = new DateFormatterUtil();
//		    //PoliceController pc = new PoliceController();
//		    
//		    String startDate= df.calculateStartDateForCronJob("");    		
//		    String endDate= df.calculateEndDateForCronJob("");
//		    
//		    System.out.println(" the cron start date" + startDate);
//		    //System.out.println(" the cron end date" + endDate);
		    WooCommerceClientStart wcs = new WooCommerceClientStart();		    
		    String message = wcs.getWooCommerceOrders(); 		    
		    System.out.println("**** message from scheduler" + message);		    
	    
	    }catch(Exception e) {
	    	
	    }
	 }// scheduler

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
