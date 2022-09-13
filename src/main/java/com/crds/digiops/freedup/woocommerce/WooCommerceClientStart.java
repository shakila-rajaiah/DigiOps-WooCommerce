package com.crds.digiops.freedup.woocommerce;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crds.digiops.freedup.oauth.OAuthConfig;
import com.crds.digiops.freedup.oauth.SpecialSymbol;
import com.crds.digiops.freedup.service.ConvertJsonORDERSToCSVFile;
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
 *
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
    
    
    public static void apiGetAllOrders() throws IOException {
    	   	
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
			String message = ConvertJsonORDERSToCSVFile.convertJSONString(jsonString3);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	  System.out.println("orders all : " + orders.toString()); 
        
   }


    public static void apiGetOrder() {
    	
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

  
//	/**
//	 * @param args
//	 * @throws IOException 
//	 */
//	public static void main(String[] args) throws IOException {
//		
//        wooCommerce = new WooCommerceAPI(new OAuthConfig(WC_URL, CONSUMER_KEY, CONSUMER_SECRET), ApiVersionType.V3);
//        System.out.println("wooCommerce *** : " + wooCommerce);
//        
//		//apiGetOrder();
//		apiGetAllOrders();
//		
//
//	}
    
    /**
     * @author S RAJAIAH
     * @Date : January 31, 2022
     * @Desc : This is The main class that reads a Orders JSON and converts it into meaningful Java Objects
     *         written for Batch Scheduling
	 * @param args
	 * @throws IOException 
	 */
	public String getWooCommerceOrders() throws IOException {
		
        wooCommerce = new WooCommerceAPI(new OAuthConfig(WC_URL, CONSUMER_KEY, CONSUMER_SECRET), ApiVersionType.V3);
        System.out.println("wooCommerce *** : " + wooCommerce);
        
		//apiGetOrder();
		apiGetAllOrders();
		String message ="Done Processing";
		return message; 
		

	}
	
	
	
}
