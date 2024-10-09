package com.crds.digiops.freedup.woocommerce;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Arrays;
import org.apache.commons.collections.ListUtils;

import com.crds.digiops.freedup.oauth.OAuthConfig;
import com.crds.digiops.freedup.oauth.SpecialSymbol;
import com.crds.digiops.freedup.service.ConvertJsonORDERSToCSVFile;
import com.crds.digiops.freedup.util.DateFormatterUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * @author S RAJAIAH
 * @Date - September 14 , 2021
 * @Description: This method starts the woocommerce service...
 * @return  
 * @Called from : String  ConvertJsonORDERSToCSVFile ; convertJSONString(String json)
 * ExcelFileService.WriteExcelSheetsFile(payoutList, couplesList, indiList, failedList, "MultiTabs");
 * If you cannot see a breakpoint you have probably pressed skip all breakpoints
 * press CTRL + ALT + B to undo that
 * //How to list all available methods of a class in Eclipse? content assist; autocomplete
To make Eclipse faster:
1) Clean up history and indexes
2) Remove structured text validation
To turn off these text validations, open Windows > Preferences and in search bar type “validation”. 
It will list down all files types and applied validations on them. Disable whichever you feel un-necessary. And click OK.
3) Do not use subclipse plugin
4) Configure appropriate start-up arguments
//For cleaning up indexes
//{workspace path}\.metadata\.plugins\org.eclipse.jdt.core
//For cleaning up history
//{workspace path}\.metadata\.plugins\org.eclipse.core.resources\.history
//Here {workspace path} is the path of eclipse workspace where you create all projects.
 * -- port 8095 - paycor; port 8087 - citylink stripes; port8093 - freedup
-- to kill a process that runs port 8093
netstat -ao | find "8093"
find the process id and kill the process: Taskkill /PID  20712 /F
host file - C:\Windows\System32\drivers\etc folder
Click Start, click All Programs, click Accessories, right-click Notepad, and then click Run as administrator. ...
Open the Hosts file or the Lmhosts file, make the necessary changes, and then click Save on the File menu.
add hosts entry in server.xml
Directory:  C:\Users\S RAJAIAH\gitrepos\FreedUpWooCommerce

*/

public class WooCommerceClientStart {

    private static final String CONSUMER_KEY = "ck_740f928a8c6a553ce748b4ce3b47add81b14e61c";
    private static final String CONSUMER_SECRET = "cs_fd2d72fc1ae5dcbd48ece9ab0c78a43ee0622b7b";
    private static final String WC_URL = "https://getfreedup.com";
    //https://getfreedup.com/wp-json/wc/v3/orders

    private static WooCommerce wooCommerce;
	// return an object mapper
	private static ObjectMapper getDefaultObjectMapper() {
		
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		// if you have a JSON with many fields, and you do not have a POJO for each field, then set this extra confic=guration
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
		return defaultObjectMapper;
	}

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    
    public static String percentEncode(String s) {
        final String UTF_8 = "UTF-8";

        try {
            return URLEncoder.encode(s, UTF_8)
                    // OAuth encodes some characters differently:
                    .replace(SpecialSymbol.PLUS.getPlain(), SpecialSymbol.PLUS.getEncoded())
                    .replace(SpecialSymbol.STAR.getPlain(), SpecialSymbol.STAR.getEncoded())
                    .replace(SpecialSymbol.TILDE.getEncoded(), SpecialSymbol.TILDE.getPlain());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    } 
    
    
    /**
     * @author S RAJAIAH
     * @Date : August 14, 2021
     * @Desc : Gets all Freed-Up Orders
     * @ModifiedDate : April 8, 2024.
     * @Desc : send a flag for weekly or bi-monthly reports
     */
    public static void apiGetAllOrders(String flag) throws IOException {
    	   	
  	  // static as I need only 1 object mapper
  	   ObjectMapper mapper = getDefaultObjectMapper();
  	   mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
  	   //mapper.con.configure(null, false);
    	
        Map<String, String> params = new HashMap<>();
        params.put("per_page","100");
        //params.put("per_page","100");
        params.put("offset","0");      

        List<Object> orders = wooCommerce.getAll(EndpointBaseType.ORDERS.getValue(), params);       
        
        //ObjectMapper mapper = new ObjectMapper();
        try {
          String json = mapper.writeValueAsString(orders);

        } catch (JsonProcessingException e) {
           e.printStackTrace();
        }
                    
        String jsonString3 = new Gson().toJson(orders, ArrayList.class);
        
        try {
			String message = ConvertJsonORDERSToCSVFile.convertJSONString(jsonString3, flag);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
        
	  System.out.println("orders all : " + orders.toString()); 
        
   }
    
    /**
     * @author S RAJAIAH
     * @Date : May 20th 2024
     * @Modified date: 7/24/2024
     * @Desc : Added Start and End Dates to Woocommerce reports
     * @ModifiedDate : 
     * @Desc : 
     */
    public static void apiGetAllOrders(String startDate, String endDate ) throws IOException {
    	
    	//List<Object> allOrders = new ArrayList<Object>();
    	   	
  	  // static as I need only 1 object mapper
  	   ObjectMapper mapper = getDefaultObjectMapper();
  	   mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
  	   //mapper.con.configure(null, false);
    	
        Map<String, String> params = new HashMap<>();
        
        //gets the first  1-100 orders
        params.put("page","1");
        params.put("per_page","100");
        params.put("offset","0");      

        List<Object> orders = wooCommerce.getAll(EndpointBaseType.ORDERS.getValue(), params);         
        System.out.println(" Fisrst 100 Orders " + orders.toString());
        System.out.println(" Orders " + orders.size());
        
        
//        //gets the next 100-200 orders
//        params.put("page","2");
//        params.put("per_page","100");
//        params.put("offset","0");      
//
//        List<Object> orders1 = wooCommerce.getAll(EndpointBaseType.ORDERS.getValue(), params);  
//        System.out.println(" Second 100-200 orders Orders1 " + orders1.toString());
//        System.out.println(" Orders1 " + orders1.size());
//        
//        allOrders.add(orders);
//        allOrders.add(orders1);
//        
//        System.out.println(" Orders1 " + allOrders.toString());
//        System.out.println(" Orders1 " + allOrders.size());
        
        
        //ObjectMapper mapper = new ObjectMapper();
        try {
          String json = mapper.writeValueAsString(orders);

        } catch (JsonProcessingException e) {
           e.printStackTrace();
        }
                    
        String jsonString3 = new Gson().toJson(orders, ArrayList.class);
        System.out.println("jason3String " + jsonString3.toString());
        
        try {
			//String message = ConvertJsonORDERSToCSVFile.convertJSONString(jsonString3, flag);
			String message = ConvertJsonORDERSToCSVFile.convertJSONString(jsonString3, startDate, endDate);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
        
	  System.out.println("orders all : " + orders.toString()); 
        
   }

    
    
    /**
     * @author S RAJAIAH
     * @throws ParseException 
     * @Date : May 20th 2024
     * @Modified date: 7/24/2024
     * @Desc : Added Start and End Dates to Woocommerce reports
     * @ModifiedDate : 
     * @Desc : 
     */
    public static void apiGetAllOrdersMultiPage(String startDate, String endDate ) throws IOException, ParseException {
    	
    	List<Object> allOrders = new ArrayList<Object>();
    	   	
  	  // static as I need only 1 object mapper
  	   ObjectMapper mapper = getDefaultObjectMapper();
  	   mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
  	   //mapper.con.configure(null, false);
    	
        Map<String, String> params = new HashMap<>();
        
        DateFormatterUtil dfu = new DateFormatterUtil();
        
        String start = dfu.convertToIso8601Date(startDate);
        String end = dfu.convertToIso8601Date(endDate);
        System.out.println(" ISO 860 start & end Date " + start + " end " + end);
        
        //gets the first  1-100 orders
        params.put("page","1");
        params.put("per_page","100");
        // TESTing SRajaiah on 7/23/2024
//        params.put("after", "2024-05-30T18:00:00.000");
//        params.put("before", "2024-07-01T18:00:00.000");
     
//        params.put("after", "2024-05-30T00:00:00Z");
//        params.put("before", "2024-07-01T00:00:00Z");
        
        //params.put("offset","0");      

        List<Object> orders = wooCommerce.getAll(EndpointBaseType.ORDERS.getValue(), params);         
        System.out.println(" Fisrst 100 Orders " + orders.toString());
        
        System.out.println(" First Orders " + orders.get(0).toString());      
        System.out.println(" last 100th Orders " + orders.get(99).toString());
        
        System.out.println(" Orders " + orders.size());
                
        //gets the next 100-200 orders
        params.put("page","2");
        params.put("per_page","100");
        //params.put("offset","0");      

        List<Object> orders1 = wooCommerce.getAll(EndpointBaseType.ORDERS.getValue(), params);  
        System.out.println(" Second 100-200 orders Orders1 " + orders1.toString());
        System.out.println(" Orders1 " + orders1.size());
        System.out.println(" First Orders " + orders1.get(0).toString());      
        System.out.println(" last 100th Orders " + orders1.get(99).toString());
        
        //gets the next 100-200 orders
        params.put("page","3");
        params.put("per_page","100");
        //params.put("offset","0"); 
        
        List<Object> orders2 = wooCommerce.getAll(EndpointBaseType.ORDERS.getValue(), params);  
        System.out.println(" Second 200-300 orders Orders2 " + orders2.toString());
        System.out.println(" Orders2 " + orders2.size());
        System.out.println(" First Orders " + orders2.get(0).toString());   
        System.out.println(" First Orders " + orders2.get(10).toString());   
        System.out.println(" First Orders " + orders2.get(15).toString());   

        //System.out.println(" last  Orders " + orders2.get(100).toString());
        
        
//        allOrders.add(orders);
//        allOrders.add(orders1);
        
        allOrders = ListUtils.union(orders, orders1);
        
        allOrders = ListUtils.union(allOrders, orders2);
               
        System.out.println(" All Orders " + allOrders.toString());
        System.out.println(" All Orders " + allOrders.size());
            
        //ObjectMapper mapper = new ObjectMapper();
        try {
          String json = mapper.writeValueAsString(allOrders);
          
//          String json = mapper.writeValueAsString(orders);
//          String json1 = mapper.writeValueAsString(orders1);
          

        } catch (JsonProcessingException e) {
           e.printStackTrace();
        }
                    
        //String jsonString3 = new Gson().toJson(orders, ArrayList.class);
        String jsonString3 = new Gson().toJson(allOrders, ArrayList.class);
        System.out.println("jason3String " + jsonString3.toString());
        
//        String jsonString2 = new Gson().toJson(orders1, ArrayList.class);
//        System.out.println("jason3String " + jsonString2.toString());
        
        try {
			//String message = ConvertJsonORDERSToCSVFile.convertJSONString(jsonString3, flag);
			String message = ConvertJsonORDERSToCSVFile.convertJSONString(jsonString3, startDate, endDate);
			//String message1 = ConvertJsonORDERSToCSVFile.convertJSONString(jsonString2, startDate, endDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
        
	  System.out.println("orders all : " + orders.toString()); 
        
   }

    public static List<Object> addLists(List<Object> list1, List<Object> list2) {
        List<Object> result = new ArrayList<>();

        int size = Math.min(list1.size(), list2.size());
        for (int i = 0; i < size; i++) {
            //result.add(list1.get(i) + list2.get(i));
        }

        return result;
    }

    public static void apiGetAllCoupons(String flag) throws IOException {
	   	
    	  // static as I need only 1 object mapper
    	   ObjectMapper mapper = getDefaultObjectMapper();
    	   mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    	   //mapper.con.configure(null, false);
      	
          Map<String, String> params = new HashMap<>();
          params.put("per_page","100");
          params.put("page","1");
          params.put("offset","0");      

          List<Object> coupons = wooCommerce.getAll(EndpointBaseType.COUPONS.getValue(), params);     
          System.out.println("coupons : " + coupons);
          
          //ObjectMapper mapper = new ObjectMapper();
          try {
            String json = mapper.writeValueAsString(coupons);
            System.out.println("json : " + json);

          } catch (JsonProcessingException e) {
             e.printStackTrace();
          }
                      
          String jsonString3 = new Gson().toJson(coupons, ArrayList.class);
          System.out.println("jsonstring3 : " + jsonString3);
          
          
          try {
  			String message = ConvertJsonORDERSToCSVFile.convertJSONString(jsonString3, flag);
  			
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			e.getMessage();
  		}
          
  	  System.out.println("orders all : " + coupons.toString()); 
          
     }
    
    
    
    public static void apiGetOrder(String flag) {
    	
    	  System.out.println("inside apiGetOrder" );
    	  System.out.println("***EndpointBaseType.ORDERS.getValue() ***: " + EndpointBaseType.ORDERS.getValue());
    	  int id = 18644;
    	  //setUp();
    	
        Map order = wooCommerce.get(EndpointBaseType.ORDERS.getValue(), id);
        
        System.out.println("****order**** : " + order);
        JasonObjectToFileCSV  joc = new JasonObjectToFileCSV();
        
        String json = joc.createJSONString(order);
        System.out.println("**** jason **** : " + json);
        
    }

    /**
     * @author S RAJAIAH
     * @Date : May 20th 2024,
     * @Desc : This is The main class that reads a Orders JSON and converts it into meaningful Java Objects
     *         written for Batch Scheduling. Changed to add start and end dates per Beth's request.
	 * @param args
	 * @throws IOException 
     * @throws ParseException 
	 */
	public String getWooCommerceOrders(String startDate, String endDate) throws IOException, ParseException {
		
        wooCommerce = new WooCommerceAPI(new OAuthConfig(WC_URL, CONSUMER_KEY, CONSUMER_SECRET), ApiVersionType.V3);
        System.out.println("wooCommerce *** : " + wooCommerce);
        
        apiGetAllOrdersMultiPage(startDate, endDate);
		//apiGetAllCoupons();
		String message ="Done Processing";
		return message; 
		
	}
  
    
    /**
     * @author S RAJAIAH
     * @Date : January 31, 2022
     * @Desc : This is The main class that reads a Orders JSON and converts it into meaningful Java Objects
     *         written for Batch Scheduling
	 * @param args
	 * @throws IOException 
	 */
	public String getWooCommerceOrders(String flag) throws IOException {
		
        wooCommerce = new WooCommerceAPI(new OAuthConfig(WC_URL, CONSUMER_KEY, CONSUMER_SECRET), ApiVersionType.V3);
        System.out.println("wooCommerce *** : " + wooCommerce);
        
        apiGetAllOrders(flag);
		//apiGetAllCoupons();
		String message ="Done Processing";
		return message; 
		

	}
	
	
	
}
