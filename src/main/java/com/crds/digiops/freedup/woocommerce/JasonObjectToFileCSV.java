
package com.crds.digiops.freedup.woocommerce;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.crds.digiops.freedup.model.OrderPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * @author S RAJAIAH
 * @Date : August 3, 2021
 * @Desc : Converts Jason to CSV
 * 
 * 
 */
public class JasonObjectToFileCSV {

	/**
	 * 
	 */
	public JasonObjectToFileCSV() {
		// TODO Auto-generated constructor stub
	}

	public String createJSONString(Map order) {
		
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(order);
            System.out.println("**** jason **** : " + json);
            convertJasonToCSV();
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "JsonProcessingException" + e.getMessage();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "IOException" + e.getMessage();
		}
		//return null;
		
	}
	
	
	/*
	 * This means that if our JSON document has an array of objects,
	 *  we can reformat each object into a new line of our CSV file. So, as an example, 
	 * let's use a JSON document containing the following list of items from an order:
	 */
	public void convertJasonToCSV() throws JsonProcessingException, IOException {
		
		System.out.println("**** convertJasonToCSV() **** : ");
		
        try {
    		//use Jackson's ObjectMapper to read our example JSON document into a tree of JsonNode objects
    		JsonNode jsonTree = new ObjectMapper().readTree(new File("src/main/OneOrder.json"));
    		
    		System.out.println("**** jasonTree **** : " + jsonTree);
    		
    		//create a csv schema. This determines the column headers, types, and sequence of columns in the CSV file. 
    		
    		com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
    		JsonNode firstObject = jsonTree.elements().next();
    		System.out.println("**** firstObject **** : " + firstObject);
    		firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
    		CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
    		
    		System.out.println("**** csvSchema **** : " + csvSchema);		
    		
    		//Then, we create a CsvMapper with our CsvSchema, and finally, we write the jsonTree to our CSV file:
    		
    		CsvMapper csvMapper = new CsvMapper();
    		csvMapper.writerFor(JsonNode.class)
    		  .with(csvSchema)
    		  .writeValue(new File("src/main/orderLines.csv"), jsonTree);
    		
            System.out.println("**** jason **** : " + jsonTree);
           
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            //return "JsonProcessingException";
        }
	
		//return null;
	}
	
	
}
