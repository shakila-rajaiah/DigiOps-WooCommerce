package com.crds.digiops.freedup.service;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;
import java.io.FileWriter;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crds.digiops.freedup.model.OrderPOJO;
import com.crds.digiops.freedup.model.OrderPOJOCSV;
import com.crds.digiops.freedup.model.Payouts;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

/**
 * @author S RAJAIAH
 * @Date - July 25, 2021
 * @Modified: November 11, 2021.
 * @Description - This class takes a list of WooCommerce Order Objects (Payouts + Charges) 
 * 				  and writes the main one to a CSV File.
 * @return 
 * @Params
 * @Called from :  WriteExcelSheetsFile(List<OrderPOJOCSV> payouts, List<OrderPOJOCSV> couples, List<OrderPOJOCSV> individuals, List<OrderPOJOCSV> failed, String fileName) {
 **/
public class ExcelFileService{
	
	List<OrderPOJO> orders = new ArrayList<OrderPOJO>();
    public ExcelFileService() {
    	//List<OrderPOJO> orderList = orders;
    }
    
	/**
	 * @author S RAJAIAH
	 * @Date - October 14 , 2021
	 * @Description: This method creates creates a call to put a .payouts.xlsx
	 * 	             in Woocommerce/Payouts/Payout_12072021_18-7-12-718.csv 
	 *               creates a call to put the 4 lists (payouts, couples, individuals, failed) 
	 *               in separate tabs in Woocommerce/FreedUp-MultiTabs_12072021_15-45-23-227.xlsx file
	 * @return  
	 * @Called from : String  ConvertJsonORDERSToCSVFile ; convertJSONString(String json)
	 * ExcelFileService.WriteExcelSheetsFile(payoutList, couplesList, indiList, failedList, "MultiTabs");
	 *
	 * 
	 */
	public static void WriteExcelSheetsFile(List<OrderPOJOCSV> payouts, List<OrderPOJOCSV> couples, List<OrderPOJOCSV> individuals, List<OrderPOJOCSV> failed, String fileName) {
        	
        try {
  
        	ExcelWriterService writer = new ExcelWriterService();
        	//C:\Users\S RAJAIAH\Documents\WooCommerce/FreedUp-woocommerce_10192021_19-17-55-659.csv
        	       	
    	    // get the hour of the day, minute, seconds,	
    	    Calendar c = Calendar.getInstance();
    	    String timeStamp =  c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE) + "-" + c.get(Calendar.SECOND)
    	            + "-" + c.get(Calendar.MILLISECOND);           
	
    	    // get current date
    	    String date = new SimpleDateFormat("MMddyyyy").format(new Date());
    	    String formattedDate = date +  "_"+ timeStamp;
    	       
    		//First, use System.getProperty("user.home") to get the "user" directory...
    		String path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "WooCommerce";
    		//C:\Users\S RAJAIAH\Documents\WooCommerce\FreedUp-MultiTabs_12072021_15-45-23-227.xlsx
    		
     		
    		System.out.println("********path **   " + path );
        	 
    		String newFile =  path + ("/") + "FreedUp-"+  (fileName + "_"+ formattedDate + ".xlsx");
    		//C:\Users\S RAJAIAH\Documents\WooCommerce/FreedUp-MultiTabs_12072021_19-52-23-583.xlsx
    		
    		File payoutFile = writeCsVForPayoutList(payouts);
    		
    		System.out.println("newFile    " + newFile);
       		System.out.println("payoutFile    " + payoutFile);
    		
    		writer.writeToExcelInMultiSheets(newFile, "Payouts", payouts);
    		writer.writeToExcelInMultiSheets(newFile, "Couples", couples);
    		writer.writeToExcelInMultiSheets(newFile, "Individuals", individuals);
    		writer.writeToExcelInMultiSheets(newFile, "Failed Transactions", failed);
        	 
        	System.out.println("***The WooCommerec Orders file has bee created and placed in the User's directory : " + newFile);
        	System.out.println("***The WooCommerec Ppayouts file has bee created and placed in the User's directory : " + newFile);
	    	File multiTabFile = new File(System.getProperty(path), newFile);  
	    	  EmailServiceImpl eserv = new EmailServiceImpl();
	    	  eserv.sendEmailWithAttachments(multiTabFile);
	    	  
           
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		
    }//write method
	
    
    /**
     * @author S RAJAIAH
     * @Created Date: October 20, 2021.
     * @param List<OrderPOJOCSV>, payoutList
     * @Desc creates an excel file from the list of orders retrieved from the Woocommerce interface.
     * @return File Woocommerce/Payouts/Payout_12072021_18-7-12-718.csv
     * @Called from : WriteExcelSheetsFile(List<OrderPOJOCSV> payouts, List<OrderPOJOCSV> couples, List<OrderPOJOCSV> individuals, List<OrderPOJOCSV> failed, String fileName) 
     */
    public static File writeCsVForPayoutList(List<OrderPOJOCSV> payouts) {
    	
  	  File file = getPayoutsFileName();
  	  
  	  System.out.println("Payouts file : ***" + file);
     
      try {
    	  
          // Creating writer class to generate
          // csv file
          FileWriter writer = new 
                     FileWriter(file);
          
          //writer.append("Payout_ID,Cash_Deposit_date,Charge_ID,Description,Created,Currency,Amount,Fee,Net,Reporting_category,Card_Brand,Customer_email,Contact_name,Address_line1,Address_line2,Address_city,Address_state,Address_zip,Address_country,Fund,Fund_trunc,Document_number,Address_ID,Email_Trunc,Contact_name_Trunc\n");        
          writer.append("Order_Number,First_Name_Shipping,Last_Name_Shipping,Order_Status,Order_Date,Cart_Discount_Amount,Order_Subtotal_Amount,Shipping_Method_Title,Order_Shipping_Amount,Order_Refund_Amount,Order_Total_Amount,Order_Total_Tax_Amount,SKU#1,Variation_Id#1,ItemNo#1,Item_Name#1,Quantity#1,Item_Cost#1,SKU#2,Variation_Id#2,ItemNo#2,Item_Name#2,Quantity#2,Item_Cost#2,Cost_of_Goods_Sold,Coupon_Code#1,Discount_Amount#1,Discount_Amount_Tax#1,Coupon_Code#2,Discount_Amount#2,Discount_Amount_Tax#2,PaymentMethod,PaymentMethodTitle,TransactionId \n");         

          // Create Mapping Strategy to arrange the 
          // column name in order
          ColumnPositionMappingStrategy<OrderPOJOCSV> mappingStrategy=
                      new ColumnPositionMappingStrategy<OrderPOJOCSV>();
          mappingStrategy.setType(OrderPOJOCSV.class);
         

          // Creating StatefulBeanToCsv object
          StatefulBeanToCsvBuilder<OrderPOJOCSV> builder=
                      new StatefulBeanToCsvBuilder<OrderPOJOCSV>(writer);

			StatefulBeanToCsv<OrderPOJOCSV> beanWriter = 
				builder.withMappingStrategy(mappingStrategy).build();

          // Write list to StatefulBeanToCsv object
          beanWriter.write(payouts);
                   
          // closing the writer object
          writer.close();
          
          
          System.out.println("The payout output file : " + file + " has been written to the User's directory");
          
      }catch (Exception e) {
          System.out.println("Failed to create  CSV file")  ;
          e.printStackTrace();
      }
      return file;
  }

    /**
     * @author S RAJAIAH
     * @Created Date: October 20, 2021.
     * @param payouts
     * @param List<OrderPOJOCSV>, fileName
     * @Desc creates an excel file from the list of orders retrieved from the Woocommerce interface.
     * @return
     * @called from : convertJSONString(String)
     */
    public static File writeCsVFromOrders( List<OrderPOJOCSV> orderPOJOs, String fileName) {
    	
  	  File file = getWooCommerceFileName(fileName);
  	 //C:\Users\S RAJAIAH\Documents\WooCommerce\FreedUp-woocommerce_12072021_19-49-57-618.csv
  	  
  	  System.out.println("file : ***" + file);
     
      try {
    	  
          // Creating writer class to generate
          // csv file
          FileWriter writer = new 
                     FileWriter(file);
          
          //writer.append("Payout_ID,Cash_Deposit_date,Charge_ID,Description,Created,Currency,Amount,Fee,Net,Reporting_category,Card_Brand,Customer_email,Contact_name,Address_line1,Address_line2,Address_city,Address_state,Address_zip,Address_country,Fund,Fund_trunc,Document_number,Address_ID,Email_Trunc,Contact_name_Trunc\n");        
          writer.append("Order_Number,First_Name_Shipping,Last_Name_Shipping,Order_Status,Order_Date,Cart_Discount_Amount,Order_Subtotal_Amount,Shipping_Method_Title,Order_Shipping_Amount,Order_Refund_Amount,Order_Total_Amount,Order_Total_Tax_Amount,SKU#1,Variation_Id#1,ItemNo#1,Item_Name#1,Quantity#1,Item_Cost#1,SKU#2,Variation_Id#2,ItemNo#2,Item_Name#2,Quantity#2,Item_Cost#2,Cost_of_Goods_Sold,Coupon_Code#1,Discount_Amount#1,Discount_Amount_Tax#1,Coupon_Code#2,Discount_Amount#2,Discount_Amount_Tax#2,PaymentMethod,PaymentMethodTitle,TransactionId \n");         

          // Create Mapping Strategy to arrange the 
          // column name in order
          ColumnPositionMappingStrategy<OrderPOJOCSV> mappingStrategy=
                      new ColumnPositionMappingStrategy<OrderPOJOCSV>();
          mappingStrategy.setType(OrderPOJOCSV.class);
         

          // Creating StatefulBeanToCsv object
          StatefulBeanToCsvBuilder<OrderPOJOCSV> builder=
                      new StatefulBeanToCsvBuilder<OrderPOJOCSV>(writer);

			StatefulBeanToCsv<OrderPOJOCSV> beanWriter = 
				builder.withMappingStrategy(mappingStrategy).build();

          // Write list to StatefulBeanToCsv object
          beanWriter.write(orderPOJOs);
                   
          // closing the writer object
          writer.close();
          
          
          System.out.println("The output file : " + file + " has been written to the User's directory");
          
      }catch (Exception e) {
          System.out.println("Failed to create  CSV file")  ;
          e.printStackTrace();
      }
      return file;
  }

    
    /**
     * @author S RAJAIAH
     * @Date - October 28, 2021
     * @Description - Creates a WooCommerce directory in users/documents directory if one does not exist 
     *                & creates a FileName (wooCommerce/FreedUp-woocommerce_12072021_15-45-22-781.csv 
     *                which contains all the orders for the previous month
     * @param fileName
     * @return - file FreedUp-woocommerce_12072021_15-45-22-781.csv
     * 
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
		//C:\Users\S RAJAIAH\Documents\WooCommerce\FreedUp-woocommerce_12072021_19-49-57-618.csv
	    return file;    
    }
    
    
//    /**
//     * @author S RAJAIAH
//     * @Date - October 10, 2021
//     * @Description - Creates a CitiLink directory in users/documents directory if one does not exist & creates a FileName.
//     * @param fileName
//     * @return
//     */
//    public static String getPathForFile(String dirName) {
//   
////	    // get the hour of the day, minute, seconds,	
////	    Calendar c = Calendar.getInstance();
////	    String timeStamp =  c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE) + "-" + c.get(Calendar.SECOND)
////	            + "-" + c.get(Calendar.MILLISECOND);           
////	
////	    // get current date
////	    String date = new SimpleDateFormat("MMddyyyy").format(new Date());
////	    String formattedDate = date +  "_"+ timeStamp;
//	       
//		//First, use System.getProperty("user.home") to get the "user" directory...
//		String path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + dirName;
//		//File customDir = new File(path);
//	    
//		// If customer dircetory does not exist, create one, otherwise ignore..
////		if (customDir.exists()) {
////		    System.out.println(customDir + " already exists");
////		} else if (customDir.mkdirs()) {
////		    System.out.println(customDir + " was created");
////		} else {
////		    System.out.println(customDir + " was not created");
////		}
//		
//		//File file = new File(customDir + "/FreedUp-" + fileName + "_"+ formattedDate + ".xls");
//
//	    return path;    
//    }
    
    
    /**
     * @author S RAJAIAH
     * @Date - October 5, 2021
     * @Description - Creates a Woocommerce/Payouts directory in users/documents directory if one does not exist & creates a FileName.
     * @param 
     * @return : Woocommerce/Payouts/Payout_12072021_18-7-12-718.csv
     * @Called From :  writeCsVForPayoutList(List<OrderPOJOCSV> payouts) 
     */
    public static File getPayoutsFileName() {
   
	    // get the hour of the day, minute, seconds,	
	    Calendar c = Calendar.getInstance();
	    String timeStamp =  c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE) + "-" + c.get(Calendar.SECOND)
	            + "-" + c.get(Calendar.MILLISECOND);           
	
	    // get current date
	    String date = new SimpleDateFormat("MMddyyyy").format(new Date());
	    String formattedDate = date +  "_"+ timeStamp;
	       
		//First, use System.getProperty("user.home") to get the "user" directory...
		String path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "WooCommerce" + File.separator + "Payouts";
		File customDir = new File(path);
	    
		// If customer dircetory does not exist, create one, otherwise ignore..
		if (customDir.exists()) {
		    System.out.println(customDir + " already exists");
		} else if (customDir.mkdirs()) {
		    System.out.println(customDir + " was created");
		} else {
		    System.out.println(customDir + " was not created");
		}
		
		File file = new File(customDir + "/Payout_"+ formattedDate + ".csv");
		//Payouts file : ***C:\Users\S RAJAIAH\Documents\WooCommerce\Payouts\Payout_12072021_19-52-52-8.csv
	    return file;    
    }
    
    
    
    /**
     * @author S RAJAIAH
     * @Date - October 11, 2021
     * @Description - Creates an an excel SS with different tabs for payouts, couples, individuals and failed transactions.
     * @param fileName, sheetName, data
     * @return
     */
	public <T> void writeToExcelInMultiSheets(final String fileName, final String sheetName, final List<T> data) {
		File file = null;
		OutputStream fos = null;
		XSSFWorkbook workbook = null;
		try {
			
			file = new File(fileName);
			// File file = getPurchaseFileName(fileName);
			 System.out.println("  File file = getPurchaseFileName(fileName) " + file);
			//file = new File(fileName);
			Sheet sheet = null;
			if (file.exists()) {
				workbook = (XSSFWorkbook) WorkbookFactory.create(new FileInputStream(file));
			} else {
				workbook = new XSSFWorkbook();
			}
			sheet = workbook.createSheet(sheetName);
			List<String> fieldNames = getFieldNamesForClass(data.get(0).getClass());
			int rowCount = 0;
			int columnCount = 0;
			Row row = sheet.createRow(rowCount++);
			for (String fieldName : fieldNames) {
				Cell cell = row.createCell(columnCount++);
				cell.setCellValue(fieldName);
			}
			Class<? extends Object> classz = data.get(0).getClass();
			for (T t : data) {
				row = sheet.createRow(rowCount++);
				columnCount = 0;
				for (String fieldName : fieldNames) {
					Cell cell = row.createCell(columnCount);
					Method method = null;
					try {
						method = classz.getMethod("get" + capitalize(fieldName));
					} catch (NoSuchMethodException nme) {
						method = classz.getMethod("get" + fieldName);
					}
					Object value = method.invoke(t, (Object[]) null);
					if (value != null) {
						if (value instanceof String) {
							cell.setCellValue((String) value);
						} else if (value instanceof Long) {
							cell.setCellValue((Long) value);
						} else if (value instanceof Integer) {
							cell.setCellValue((Integer) value);
						} else if (value instanceof Double) {
							cell.setCellValue((Double) value);
						}
					}
					columnCount++;
				}
			}
			fos = new FileOutputStream(file);
			workbook.write(fos);
			 System.out.println("  The purchase file " + file + "has been written to the users directory");
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
			}
			try {
				if (workbook != null) {
					workbook.close();
				}
			} catch (IOException e) {
			}
		}
	}
	
//	public static  void writeToExcelSheets (List<OrderPOJOCSV> payouts, List<OrderPOJOCSV> couples, List<OrderPOJOCSV> individuals, String fileName) {
//		ExcelWriterService writer = new ExcelWriterService();
//
//        // write into 3 sheets
//        
////		writer.writeToExcelInMultiSheets(path, "Payout Details", payouts);
////		writer.writeToExcelInMultiSheets(path, "Couples details", couples);
////		writer.writeToExcelInMultiSheets(path, "Individual Details", individuals);
//		
//		//return fileName;
//
//	}
	
	
	

	// retrieve field names from a POJO class
    /**
     * @author S RAJAIAH
     * @Date - October 11, 2021
     * @Description -  retrieve field names from a POJO class
     * @param Class
     * @return List<String>
     */
	private List<String> getFieldNamesForClass(Class<?> clazz) throws Exception {
		List<String> fieldNames = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fieldNames.add(fields[i].getName());
		}
		return fieldNames;
	}	
	
	// capitalize the first letter of the field name for retriving value of the
	// field later
    /**
     * @author S RAJAIAH
     * @Date - October 12, 2021
     * @Description -  capitalize the first letter of the field name for retrieving value of the field later
     * @param string
     * @return String
     */
	private String capitalize(String s) {
		if (s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
	

    
	/**
	 * @author S RAJAIAH
     * @Date - October 15, 2021
     * @param payouts
     * @param fileName
     * @return file
     * @Desc - 
     * @Called from : 
     */
    public static File writeCsVFromPayouts( List<Payouts> payouts, String fileName) {
    	
  	  File file = getWooCommerceFileName(fileName);
  	  //
     
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
     * @Author: S RAJAIAH
     * @Date - March 28, 2021
     * @Description - Creates a CitiLink directory in users/documents directory if one does not exist & creates a FileName.
     * @param fileName
     * @return
     * @Called from: 
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
     * @Created Date: October 20, 2021.
     * @param payouts
     * @param List<OrderPOJOCSV>, fileName
     * @Desc creates an excel file from the list of orders retrieved from the Woocommerce interface.
     * @return
     * @called from : 
     */
    public void ReadExcelFileDemo() throws IOException  
    {  
	    //obtaining input bytes from a file  
	    FileInputStream fis=new FileInputStream(new File("C:\\demo\\student.xls"));  
	    //creating workbook instance that refers to .xls file  
	    HSSFWorkbook wb=new HSSFWorkbook(fis);   
	    //creating a Sheet object to retrieve the object  
	    HSSFSheet sheet=wb.getSheetAt(0);  
	    //evaluating cell type   
	    
	    FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();  
	    for(Row row: sheet)     //iteration over row using for each loop  
		    {  
			    for(Cell cell: row)    //iteration over cell using for each loop  
			    {  
				    switch(formulaEvaluator.evaluateInCell(cell).getCellType())  
				    {  			
					    //cell.getCellType().
					    case NUMERIC:   //field that represents numeric cell type  
					    //getting the value of the cell as a number  
					    System.out.print(cell.getNumericCellValue()+ "\t\t");   
					    break;  
					    case STRING:    //field that represents string cell type  
					    //getting the value of the cell as a string  
					    System.out.print(cell.getStringCellValue()+ "\t\t");  
					    break;  
				    }  
				  }  
				    System.out.println();  
		    }  
     }  

    
}
