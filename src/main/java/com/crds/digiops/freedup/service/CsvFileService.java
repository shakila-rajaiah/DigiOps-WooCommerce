/**
 * 
 */
package com.crds.digiops.freedup.service;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.crds.digiops.freedup.model.Payouts;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
  
/**
 * @author S RAJAIAH
 * @Date - March 25, 2021
 * @Description - This class takes a list of Java Payout Objects (Payouts + Charges) and writes them to a CSV File.
 *
 */

public class CsvFileService{
	
	List<Payouts> payoutList = new ArrayList<Payouts>();
	
	/**
	 * @author S RAJAIAH
	 * @Date: March 21, 2021
	 * @Description: constuctor for CsvFileService
	 */
	
    public CsvFileService(List<Payouts> payouts) {
    	payoutList = payouts;
    }
    
    
    
	/**
	 * @author S RAJAIAH
	 * @Date: March 22, 2021
	 * @Description: This method creates a .csv file in the format specified to upload into great plains.
	 * @return the customer file and the donation file path..
	 */
//	public String WriteCSVFile(List<Payouts> payoutList) {
//        
//		File custFile  = null; 
//		File donFile = null;
//		String message = null;
//		
//        try {
//  
//        	// create customers file 
//        	 custFile  =	writeCsVFromPayouts(payoutList, "Customer");
//        		
//        	//create donations file	
//        	 donFile =	writeCsVFromPayouts(payoutList, "Donations");   
// 
//System.out.println("Before calling email service" + custFile +";   " + donFile);
//        	 
//        	 EmailServiceImpl email = new EmailServiceImpl();
//        	 String emailMessage = email.sendEmailWithAttachments(custFile, donFile); 
//        	 
//System.out.println("after calling email service" + emailMessage);        	      	 
//           
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//		return " ** Customer File  :  " + custFile + "<br/>" +"** Donation File : " + donFile;
//    }//write method
	
	
	
	/**
	 * @author S RAJAIAH
	 * @Date: March 22, 2021 
	 * @Modified Date November 4, 2021
	 * @Description: This method creates a .csv file in the format specified to upload into great plains.
	 * @return the customer file and the donation file path..
	 * 
	 */
	public String WriteCSVFile(List<Payouts> payoutList, String flag) {
        
		File custFile  = null; 
		File donFile = null;
		String message = null;
		
        try {
  
        	// create customers file 
        	 custFile  =	writeCsVFromPayouts(payoutList, "Customer", flag);
        		
        	//create donations file	
        	 donFile =	writeCsVFromPayouts(payoutList, "Donations", flag);   
 
System.out.println("Before calling email service" + custFile +";   " + donFile);

			 if (flag.equalsIgnoreCase("freedUp"))
			{
				//file = getWooCommerceFileName(fileName);
				 //call something here
			}
        	 
        	 EmailServiceImpl email = new EmailServiceImpl();
        	 String emailMessage = email.sendEmailWithAttachments(custFile); 
        	 
System.out.println("after calling email service" + emailMessage);        	      	 
           
        }
        catch (Exception e) {
            e.printStackTrace();
        }

		return " ** Customer File  :  " + custFile + "<br/>" +"** Donation File : " + donFile;
    }//write method
	
  
    /**
     * @author S RAJAIAH
     * @Date  March 22, 2021
     * @param payouts
     * @param fileName
     * @return
     * @Desc writes the payout list into customer and donor file to the directory based on the flag
     */
    public static File writeCsVFromPayouts( List<Payouts> payouts, String fileName) {
    	
  	  File file = getStripeFileName(fileName);
  	  
  	  //System.out.println("file : ***" + file);
     
      try {
    	  
          // Creating writer class to generate
          // csv file
          FileWriter writer = new 
                     FileWriter(file);
          
          //writer.append("Payout_ID,Cash_Deposit_date,Charge_ID,Description,Created,Currency,Amount,Fee,Net,Reporting_category,Card_Brand,Customer_email,Customer_name,Address_line1,Address_line2,Address_city,Address_state,Address_zip,Address_country,Fund,Fund_trunc\n");
          writer.append("Payout_ID,Cash_Deposit_date,Charge_ID,Description,Created,Currency,Amount,Fee,Net,Reporting_category,Card_Brand,Customer_email,Contact_name,Address_line1,Address_line2,Address_city,Address_state,Address_zip,Address_country,Fund,Fund_trunc,Document_number,Address_ID,Email_Trunc,Contact_name_Trunc\n");
         

          // Create Mapping Strategy to arrange the 
          // column name in order
          ColumnPositionMappingStrategy<Payouts> mappingStrategy=
                      new ColumnPositionMappingStrategy<Payouts>();
          mappingStrategy.setType(Payouts.class);
         

          // Creating StatefulBeanToCsv object
          StatefulBeanToCsvBuilder<Payouts> builder=
                      new StatefulBeanToCsvBuilder<Payouts>(writer);

			StatefulBeanToCsv<Payouts> beanWriter = 
				builder.withMappingStrategy(mappingStrategy).build();

          // Write list to StatefulBeanToCsv object
          beanWriter.write(payouts);

          // closing the writer object
          writer.close();
          
          System.out.println("The output file : " + fileName + " has been written to the User's directory");
          
      }catch (Exception e) {
          System.out.println("Failed to create Payout CSV file")  ;
          e.printStackTrace();
      }
      return file;
  }

    
    /**
     * @author S RAJAIAH
     * @Date  November 8 , 2021
     * @param payouts
     * @param fileName
     * @return
     * @Desc writes the payout list into customer and donor file to the directory based on the flag
     */
    public static File writeCsVFromPayouts( List<Payouts> payouts, String fileName, String flag) {
    	
    	File file = null;
    	if (flag.equalsIgnoreCase("citiLink"))
    	{
    		file = getStripeFileName(fileName);
    	}
    	else if (flag.equalsIgnoreCase("freedUp"))
    	{
    		file = getWooCommerceFileName(fileName);
    	}

     
      try {
    	  
          // Creating writer class to generate
          // csv file
          FileWriter writer = new 
                     FileWriter(file);
          
          //writer.append("Payout_ID,Cash_Deposit_date,Charge_ID,Description,Created,Currency,Amount,Fee,Net,Reporting_category,Card_Brand,Customer_email,Customer_name,Address_line1,Address_line2,Address_city,Address_state,Address_zip,Address_country,Fund,Fund_trunc\n");
          writer.append("Payout_ID,Cash_Deposit_date,Charge_ID,Description,Created,Currency,Amount,Fee,Net,Reporting_category,Card_Brand,Customer_email,Contact_name,Address_line1,Address_line2,Address_city,Address_state,Address_zip,Address_country,Fund,Fund_trunc,Document_number,Address_ID,Email_Trunc,Contact_name_Trunc\n");
         

          // Create Mapping Strategy to arrange the 
          // column name in order
          ColumnPositionMappingStrategy<Payouts> mappingStrategy=
                      new ColumnPositionMappingStrategy<Payouts>();
          mappingStrategy.setType(Payouts.class);
         

          // Creating StatefulBeanToCsv object
          StatefulBeanToCsvBuilder<Payouts> builder=
                      new StatefulBeanToCsvBuilder<Payouts>(writer);

			StatefulBeanToCsv<Payouts> beanWriter = 
				builder.withMappingStrategy(mappingStrategy).build();

          // Write list to StatefulBeanToCsv object
          beanWriter.write(payouts);

          // closing the writer object
          writer.close();
          
          System.out.println("The output file : " + fileName + " has been written to the User's directory");
          
      }catch (Exception e) {
          System.out.println("Failed to create Payout CSV file")  ;
          e.printStackTrace();
      }
      return file;
  }
    
    /**
     * @author S RAJAIAH
     * @Date - March 28, 2021
     * @Description - Creates a CitiLink directory in users/documents directory if one does not exist & creates a FileName.
     * @param fileName
     * @return
     */
    public static File getStripeFileName(String fileName) {
   
	    // get the hour of the day, minute, seconds,	
	    Calendar c = Calendar.getInstance();
	    String timeStamp =  c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE) + "-" + c.get(Calendar.SECOND)
	            + "-" + c.get(Calendar.MILLISECOND);           
	
	    // get current date
	    String date = new SimpleDateFormat("MMddyyyy").format(new Date());
	    String formattedDate = date +  "_"+ timeStamp;
	       
		//First, use System.getProperty("user.home") to get the "user" directory...
		String path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "CitiLink";
		File customDir = new File(path);
	    
		// If customer dircetory does not exist, create one, otherwise ignore..
		if (customDir.exists()) {
		    System.out.println(customDir + " already exists");
		} else if (customDir.mkdirs()) {
		    System.out.println(customDir + " was created");
		} else {
		    System.out.println(customDir + " was not created");
		}
			
	    File file = new File(customDir + "/Stripe-CityLink-" + fileName + "_"+ formattedDate + ".csv");
	      
	    return file;
    
    }
    
    /**
     * @author S RAJAIAH
     * @Date - November 1 , 2021
     * @Description - Creates a CitiLink directory in users/documents directory if one does not exist & creates a FileName.
     * @param fileName
     * @return
     */
    public static File getWooCommerceFileName(String fileName) {
   
	    // get the hour of the day, minute, seconds,	
	    Calendar c = Calendar.getInstance();
	    String timeStamp =  c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE) + "-" + c.get(Calendar.SECOND)
	            + "-" + c.get(Calendar.MILLISECOND);           
	
	    // get current date
	    String date = new SimpleDateFormat("MMddyyyy").format(new Date());
	    String formattedDate = date +  "_"+ timeStamp;
	       
		//First, use System.getProperty("user.home") to get the "user" directory...
		String path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "WooCommerce";
		File customDir = new File(path);
	    
		// If customer dircetory does not exist, create one, otherwise ignore..
		if (customDir.exists()) {
		    System.out.println(customDir + " already exists");
		} else if (customDir.mkdirs()) {
		    System.out.println(customDir + " was created");
		} else {
		    System.out.println(customDir + " was not created");
		}
		

		File file = new File(customDir + "/FreedUp-" + fileName + "_"+ formattedDate + ".csv");

	    return file;    
    }
    
}
