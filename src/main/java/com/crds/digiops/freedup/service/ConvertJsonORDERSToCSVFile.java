package com.crds.digiops.freedup.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.*;

import com.crds.digiops.freedup.model.CouponLinesPOJO;
import com.crds.digiops.freedup.model.LineItemPOJO;
import com.crds.digiops.freedup.model.LineItemsMetaDataPOJO;
import com.crds.digiops.freedup.model.MetaDataPOJO;
import com.crds.digiops.freedup.model.OrderPOJO;
import com.crds.digiops.freedup.model.OrderPOJOCSV;
import com.crds.digiops.freedup.model.RefundPOJO;
import com.crds.digiops.freedup.model.ShippingLinesPOJO;
import com.crds.digiops.freedup.service.ExcelFileService;
import com.crds.digiops.freedup.util.DateFormatterUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * @author S RAJAIAH
 * @Date : August 14, 2021
 * @Desc : This is The main class that reads a Orders JSON and converts it into meaningful Java Objects
 * @listening at port 8080: netstat -a -n -o | find "8080"
 *
 */
public class ConvertJsonORDERSToCSVFile {
	
	
//Parsing Json in Java Tutorial - Part 3: More complex Mappings
	
	// return an object mapper
	private static ObjectMapper getDefaultObjectMapper() {
		
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		// if you have a JSON with many fields, and you do not have a POJO for each field, then set this extra configuration
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return defaultObjectMapper;
	}
	
    public static String readFileAsString(String json)throws Exception
    
    {
    	String message = convertJSONString(json) ;
        //return new String(Files.readAllBytes(Paths.get(file)));
    	return message;
    }
	
//	/**
//	 * @author srajaiah
//	 * @Date November 15th, 2021
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
//
//
//		//localCreateDate.isAfter(localCreateDate);
//
//		// after the last date of the prev + 2 months , i.e. 1st day of the previous month
//		LocalDate startDate = YearMonth.now().minusMonths( 2 ).atEndOfMonth();
//		// before the first day of the current month i.e. the last day of the prev month.
//		LocalDate endDate = YearMonth.now().atDay(1);
//		    
//	    return  localCreateDate.isAfter(startDate) && localCreateDate.isBefore(endDate);			
//		
//	}
	
	
    
    /**
     * Author: S RAJAIAH
     * @Date - August 28, 2021
     * @Modified Date - August 21, 2022
     * @Description - Converts JSON to String.
     * @param json
     * @return
     * @called from: public static void apiGetAllOrders() throws IOException {
     */
   public static String convertJSONString(String json) throws JSONException {

	      try {
	    	  
	    	  // static as I need only 1 object mapper
	    	  ObjectMapper mapper = getDefaultObjectMapper();
	    	  TypeReference<List<OrderPOJO>> typeReference = new TypeReference<List<OrderPOJO>>() {};
	    	  List<OrderPOJO> orders = mapper.readValue(json, typeReference);
	    	  System.out.println("orders all : " + orders.toString()); 
	    	  System.out.println("orders all size : " + orders.size()); 
	    	  
	  	      List<OrderPOJO> currOrders = new ArrayList<OrderPOJO>();
	    	  // choose only the current orders for this period
	    	  for (OrderPOJO oP: orders ) {
	    		  String str =oP.getDate_created().substring(0, 10);
	    		  //System.out.println ("OP Date : " + oP.getDate_created());	    			
	    			if (DateFormatterUtil.isWithinDateRangeForCurrentMonthFirstHalf(oP)) {
	    				currOrders.add(oP);
	    			}
	    			if (DateFormatterUtil.isWithinDateRangeForPrevMonthSecondHalf(oP)) {
	    				currOrders.add(oP);
	    			}
	    	  }
	    	  System.out.println("currOrders.size() : " + currOrders.size());
	    	  System.out.println("currOrders.toString()  : " + currOrders.toString());
	    	  // create a new Current orders list
	  	      List<OrderPOJOCSV> orderPOJOs = new ArrayList<OrderPOJOCSV>();
	  	      List<OrderPOJOCSV> payoutList = new ArrayList<OrderPOJOCSV>();
	  	      List<OrderPOJOCSV> failedList = new ArrayList<OrderPOJOCSV>();
	  	      List<OrderPOJOCSV> couplesList = new ArrayList<OrderPOJOCSV>();
	  	      List<OrderPOJOCSV> indiList = new ArrayList<OrderPOJOCSV>();
	    	  
	    	  //changed on 10/17/2022 to add only the orders for the first or second half...
	    	  //for (OrderPOJO oP: orders ) {
		      for (OrderPOJO oP: currOrders ) {
	    		  	OrderPOJOCSV opc = new OrderPOJOCSV();  		  	
					opc.setOrderId(oP.getId());
					opc.setFirstName(oP.getShipping().getFirst_name());
					opc.setLastName(oP.getShipping().getLast_name());
					opc.setStatus(oP.getStatus());					
					opc.setDateCreated(oP.getDate_created());
					opc.setDiscountTotal(oP.getDiscount_total());	
					opc.setSubtotalAmount(0.0); // done later after sub total of items 1 & 2 are read...
					opc.setShippingMethod("");  //-- done later vis array
					opc.setShippingTotal(oP.getShipping_total());
					//opc.setRefundAmount((oP.getTotalRefundAmount() >0) ? oP.getTotalRefundAmount():0.0);
					opc.setRefundAmount(0.0);// check for refund in the array
					opc.setOrderTotal(oP.getTotal());
					opc.setOrderTotalTax(0);
					opc.setPaymentMethod(oP.getPayment_method());
					opc.setPaymentMethodTitle(oP.getPayment_method_title());
					opc.setTransactionId(oP.getTransaction_id());
			  		List<LineItemPOJO>  line_items = oP.getLine_items();
			  		// parse through line items
			  	    for (LineItemPOJO lP : line_items) {
						opc.setSku1(line_items.get(0).getSku());
						opc.setVariationId1(line_items.get(0).getVariation_id());
						opc.setItemNo1(line_items.get(0).getId());
						opc.setItemName1(line_items.get(0).getName());
						opc.setItemQuantity1(line_items.get(0).getQuantity());
						opc.setItemCost1(line_items.get(0).getTotal());
						opc.setTotalCostofGoods(line_items.get(0).getCog_item_total_cost());
						opc.setSubtotalAmount(line_items.get(0).getSubtotal());
						List<LineItemsMetaDataPOJO> line_meta_data = line_items.get(0).getLineItemsMetaData();
						// if there is a second line item
						if (line_items.size() >1) {
							opc.setSku2(line_items.get(1).getSku());
							opc.setVariationId2(line_items.get(1).getVariation_id());
							opc.setItemNo2(line_items.get(1).getId());
							opc.setItemName2(line_items.get(1).getName());
							opc.setItemQuantity2(line_items.get(1).getQuantity());
							opc.setItemCost2(line_items.get(1).getTotal());
							//double costofGoods2 = line_items.get(1).getCog_item_total_cost();
							//double totalCostOfGoods = line_items.get(0).getCog_item_total_cost() + line_items.get(1).getCog_item_total_cost();
							opc.setTotalCostofGoods(line_items.get(0).getCog_item_total_cost() + line_items.get(1).getCog_item_total_cost());
							opc.setSubtotalAmount(line_items.get(0).getSubtotal()+line_items.get(1).getSubtotal());
					     }
						else {
							opc.setSku2("");
							opc.setVariationId2(0);
							opc.setItemNo2(0);
							opc.setItemName2("");
							opc.setItemQuantity2(0);
							opc.setItemCost2(0);
							//double totalCostOfGoods = line_items.get(0).getCog_item_total_cost() + line_items.get(1).getCog_item_total_cost();
							opc.setTotalCostofGoods(line_items.get(0).getCog_item_total_cost());
							opc.setSubtotalAmount(line_items.get(0).getSubtotal());
						}
						//this.subtotalAmount = subtotalAmount;
			  	     }
				   List<ShippingLinesPOJO>  shipping_lines = oP.getShipping_lines();
//				   System.out.println(shipping_lines.get(0).toString());
				   //System.out.println("shipping_lines.size() : " + shipping_lines.size());
				   for (ShippingLinesPOJO sP : shipping_lines) {
//					  System.out.println(sP.getId());
//					  System.out.println(sP.getMethod_title());
//					  System.out.println(sP.getTotal());
//					  System.out.println(sP.toString());			  
					  opc.setShippingMethod(sP.getMethod_title());
						//this.shippingTotal = shippingTotal;
				  }
				  // get coupon data 
		  		  List<CouponLinesPOJO> coupon_lines = oP.getCoupon_lines();
				  for (CouponLinesPOJO cP : coupon_lines) {
					  opc.setCouponCode1(coupon_lines.get(0).getCode());
					  opc.setCouponDiscount1(coupon_lines.get(0).getDiscount());
					  opc.setCouponDiscountTax1(coupon_lines.get(0).getDiscount_tax());
					  if (coupon_lines.size() > 1) {
						  opc.setCouponCode2(coupon_lines.get(1).getCode());
						  opc.setCouponDiscount2(coupon_lines.get(1).getDiscount());
						  opc.setCouponDiscountTax2(coupon_lines.get(1).getDiscount_tax());
					  }
					  else {
							  opc.setCouponCode2("");
							  opc.setCouponDiscount2(0);
							  opc.setCouponDiscountTax2(0);
					  }
				  }
				  
				  // get meta_data 
		  		  List<MetaDataPOJO> metaDataPOJOS = oP.getMetaDatas();
		  		  if (metaDataPOJOS !=null) {
					  for (MetaDataPOJO mP : metaDataPOJOS) {			  
						  if (mP.getKey()=="_stripe_fee") {
							  opc.setStripeFee(metaDataPOJOS.get(1).getValue());
						  }
						  else if (mP.getKey()=="_stripe_net") {
							  opc.setStripeNet(metaDataPOJOS.get(1).getValue());
						  }
						  else if (mP.getKey()=="_stripe_currency") {
							  opc.setStripeCurrency(metaDataPOJOS.get(1).getValue());
						  }
					  }
		  		  }
				  
				  List<RefundPOJO> refunds = oP.getRefunds();
				  if (refunds.size() > 0) {
					  opc.setRefundAmount(refunds.get(0).getTotal());
				  }
				  
		   		  // add all the individual orders to the list	
				  //System.out.println(" OPC Object : " + opc.toString());
				  orderPOJOs.add(opc);
//				  i = i+1;
//				  orderPOJOs.add(i, opc);
				  // if it is a stripes file add it to the payoutList
				  System.out.println ("transaction id" + opc.getTransactionId());
				  
				  System.out.println ("!opc.getTransactionId().equals(null)" + !opc.getTransactionId().equals(null));
				  System.out.println ("opc.getTransactionId().equals(null)" + opc.getTransactionId().equals(null));
				  
				  System.out.println ("not blank" +!opc.getTransactionId().equals(""));
				  System.out.println ("equals blank" + opc.getTransactionId().equals(""));
				  
				  System.out.println ("not empty " + !opc.getTransactionId().isEmpty());
				  System.out.println ("empty: " + opc.getTransactionId().isEmpty());
				  System.out.println("OR Comparison: " );
				  System.out.println(opc.getPaymentMethod().equalsIgnoreCase("stripe") && ( !opc.getTransactionId().equals(null)  || !opc.getTransactionId().isEmpty() || !opc.getTransactionId().equals("")) );
				  System.out.println("And Comparison: " );
				  System.out.println( opc.getPaymentMethod().equalsIgnoreCase("stripe") && ( !opc.getTransactionId().equals(null)  && !opc.getTransactionId().isEmpty() && !opc.getTransactionId().equals("")) );
				  
				  // if it is a stripes file add it to the payoutList
				  // changed on 1/12/2023 as the getPaymentMethod changed sometime in October from stripe to "stripe_cc"
				  if ( (opc.getPaymentMethod().equalsIgnoreCase("stripe_cc")) && (!opc.getTransactionId().isEmpty()))
				  {
					  payoutList.add(opc);
				  }
				  else if(opc.getPaymentMethod().equalsIgnoreCase("stripe_cc") && opc.getTransactionId().isEmpty()){
					  failedList.add(opc);
				  }
				  
				  //FreedUp App & Workbook - Full App Access & 1 Workbook
				  // Individual charges
				  if (opc.getItemName1().equalsIgnoreCase("FreedUp App & Workbook - Full App Access & 1 Workbook") && !opc.getPaymentMethod().equalsIgnoreCase("stripe_cc"))
				  {
					  indiList.add(opc);
				  }
				  
				  //FreedUp App & Workbook - Full App Access & 2 Workbooks (for couples)
				  // couples charges
				  if (opc.getItemName1().equalsIgnoreCase("FreedUp App & Workbook - Full App Access & 2 Workbooks (for couples)") && !opc.getPaymentMethod().equalsIgnoreCase("stripe_cc") )
				  {
					  couplesList.add(opc);
				  }
	    	 }// orders iteration for current orders
	    	  
	    	  System.out.println(" OrderPOJOS Object : " + orderPOJOs);
	    	  System.out.println(" ****PAYOUTS  CSV Object : " + payoutList);
	    	  System.out.println(" $$$$ COUPLES ***** CSV Object : " + couplesList);
	    	  System.out.println(" &&&& INDEPENDENT CSV Object : " + indiList);
	    	  System.out.println(" &&&& FAILED Transactions : " + failedList);
	    	  String fileName = "woocommerce";
	    	  
	    	  File file = ExcelFileService.writeCsVFromOrders(orderPOJOs, fileName); 

	    	  // write the three Lists to three different tabs in excel
	    	  ExcelFileService.WriteExcelSheetsFile(payoutList, couplesList, indiList, failedList, "MultiTabs");
	    	  
	    	  System.out.println("Woocommerece File ....FILE : " + file); 	 
	    	  
	    	  String message = "Woocommerece File ....FILE : " + file;

	    	  return message;
	    	  
	      } //try
	      catch(Exception e) {
	         e.printStackTrace();
	         String message = e.getMessage(); 
	         EmailServiceImpl eser = new EmailServiceImpl();
	         eser.sendEmailWithError(message); 
	      }
	      return "message";
	      
	      
	   }
}