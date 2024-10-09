package com.crds.digiops.freedup.util;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author Shakila Rajaiah
 * @Date - August 31, 2021
 * @Modified: 
 * @Description - This class contains a list of JSON Utils. 
 * @return 
 * @Params
 * @Called from : 
 */
public class JsonUtils {

	// static as i need only 1 object mapper
	private static ObjectMapper objectMapper = getDefaultObjectMapper();
	
	// return an object mapper
	private static ObjectMapper getDefaultObjectMapper() {
		
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		// if you have a JSON with many fields, and you do not have a POJO for each field, then set this extra confic=guration
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return defaultObjectMapper;
	}
	
	//convert a String to a JsonNode
	public static JsonNode parse(String src) throws IOException {
		
		return objectMapper.readTree(src);
		
	}
	
	//convert a JsonNode to an object/class
	public static <A> A fromJson(JsonNode node, Class<A> clazz) {
		
		
		try {
			return objectMapper.treeToValue(node, clazz);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	//convert a POJO to a JsonNode
	public static JsonNode toJson(Object a) {
		
		
		try {
			return objectMapper.valueToTree(a);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	
	//convert a JsonNode to a String
	public static String jsonToString(JsonNode node) {
		
		
		try {
			ObjectWriter objectWriter = objectMapper.writer();
			return objectWriter.writeValueAsString(node);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	//convert a JsonNode to a pretty string (with indentation etc) 
	public static String prettyPrintString(JsonNode node) {
		
		
		try {
			ObjectWriter objectWriter = objectMapper.writer();
			objectWriter.with(SerializationFeature.INDENT_OUTPUT);
			return objectWriter.writeValueAsString(node);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
