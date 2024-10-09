package com.crds.digiops.freedup.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.OffsetDateTime;
//import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.crds.digiops.freedup.woocommerce.WooCommerceClientStart;

import org.json.JSONArray;


/**
 * 
 * @author S RAJAIAH
 * @Date May 20th 2024
 * saved in: C:\Users\S RAJAIAH\gitrepos\FreedUpWooCommerce
 * 
 * 
 * http://localhost:8088/dropdown
 * 
 */
/**
//How to list all available methods of a class in Eclipse? content assist; autocomplete
To make Eclipse faster:
1) Clean up history and indexes
2) Remove structured text validation
To turn off these text validations, open Windows > Preferences and in search bar type “validation”. 
It will list down all files type
s and applied validations on them. Disable whichever you feel un-necessary. And click OK.
3) Do not use subclipse plugin
4) Configure appropriate start-up arguments
//For cleaning up indexes
//{workspace path}\.metadata\.plugins\org.eclipse.jdt.core
//For cleaning up history
//{workspace path}\.metadata\.plugins\org.eclipse.core.resources\.history
//Here {workspace path} is the path of eclipse workspace where you create all projects.
-- to kill a process that runs port 8099
netstat -ao | find "8088"
find the process id and kill the process: Taskkill /PID  20712 /F
//http://localhost:8091/check

if the tests are failing use : 
mvn clean install -DskipTests
This happens when Maven tries to run your test cases while building the jar. You can simply skip running the test cases by adding -DskipTests at the end of your maven command.

Ex: mvn clean install -DskipTests or mvn clean package -DskipTests
*/
//@RestController - DO NOT USE will send the response to the @Responsebody and in JSON. Will not return a JSP page.
@Controller
public class FreedUpController {

	Logger logger = LoggerFactory.getLogger(FreedUpController.class);
	
	public FreedUpController() {
		// TODO Auto-generated constructor stub
	}
	
	//http://localhost:8088/home
	// itdev1

	// for testing
	@GetMapping("/home")
	public String home() {
		
		 return "index"; // This refers to index.jsp in /WEB-INF/views/
	}
	

	
	
	//http://localhost:8088/freedup
	// in ITDev1
	//http://10.2.48.15:8080/freedup/freedup
	//IN ITProd1
	//http://10.2.48.17:8080/freedup/freedup
	//sr added for FreedUp
	//Modified date: June 20, 2024
	@GetMapping("/freedup")
	public String freedup() {
		
		return "freedup";
	}
	
	//http://localhost:8088/viewfreedup
	//Modified date: June 20, 2024
	// viewdropdown.jsp page
	@PostMapping("viewfreedup")
	public String viewfreedup(@RequestParam("startdate") String startdate,
							@RequestParam("enddate") String enddate,							
							 ModelMap modelMap) throws Exception {
		
	    
		System.out.println("start date " + startdate);
		System.out.println("end date " + enddate);
		logger.info("start date " + startdate);
	    //startdate= convertDate(startdate);	    		
	    //enddate= convertDate(enddate);
//	    System.out.println("**** end time  long ***" + enddate);
//	    logger.info("**** end time  long ***" + enddate);
//	    System.out.println("**** company ***" + flag);
//	    logger.info("**** company***" + flag);
	    
	    String message = getFreedUpReport(startdate, enddate);

	    System.out.println("**** MESSAGE ***" + message);
	    logger.info("**** MESSAGE ***" + message);
		
		modelMap.put("startdate", startdate);
		modelMap.put("enddate", enddate);
		//modelMap.put("flag", flag);
		modelMap.put("message", message);
					
		return "viewfreedup";
	}
	
	
	
	
	/*
	 * @Author: Shakila Rajaiah
	 * @Date April 2, 2021
	 * @Desc: Convert a string date to long..
	 */
	public String convertDate(String startdate) throws ParseException {
		

		startdate = startdate.replaceAll(",","");

		Date startDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(startdate);

		// convert to unix time.
	    long startTime = (long) startDate.getTime()/1000;
	  
	    
	    startdate= String.valueOf(startTime);

	    return startdate;			
	}
	

	
	/*
	 * @Author: Shakila Rajaiah
	 * @Date April 2, 2021
	 * @Desc: Convert a string date to long..
	 * startDate =2024-10-03
	 * endDate = 2024-08-30
	 */
	public String getFreedUpReport(String startDate, String endDate) throws Exception {
		
	    System.out.println("**** Report Results value in controller ***" + startDate);
	    System.out.println("**** Report Results value in controller ***" + endDate);
		
		//String start = convertToIso8601Date(startDate);
	    //System.out.println("**** Report Results value in controller ***" + start);
		
		
		WooCommerceClientStart wcs = new WooCommerceClientStart();
		
		String results = wcs.getWooCommerceOrders(startDate, endDate);

	    System.out.println("**** Report Results value in controller ***" + results);
	    logger.info("**** Report Results value in controller ***" + results);
	    
	    return results;
			
		}
	
	
//	/*
//	 * @Author: Shakila Rajaiah
//	 * @Date July 22nd 2024.
//	 * @Desc: Convert a string date to long..
//	 */
//	public void getWooCommerceOrdersReport(String startdate, String endDate) throws Exception {
//		
//		WooCommerceOrdersService wcs = new WooCommerceOrdersService();
//		
//		JSONArray results = wcs.fetchAllOrders();
//		
//		//String results = wcs.getWooCommerceOrders(startdate, endDate);
//
//	    System.out.println("**** Report Results value in controller ***" + results);
//	    logger.info("**** Report Results value in controller ***" + results);
//	    
//	    //return results;
//			
//		}
	
	
}
