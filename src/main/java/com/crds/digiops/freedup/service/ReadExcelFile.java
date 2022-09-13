package com.crds.digiops.freedup.service;

import java.io.File;  
import java.io.FileInputStream;  
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  


/**
 * @author S RAJAIAH
 * @Date - October 14 , 2021
 * @Description: Reads an Excel file
 * @return  
 * @Called from : none
 *
 * 
 */

public class ReadExcelFile {

	public ReadExcelFile() {
		// TODO Auto-generated constructor stub
	}
	
	//public static void main(String[] args)   
	public static void readExcelFile()  
	{  
	try  
		{  
			File file = new File("C:\\CitiLink\\employee.xlsx");   //creating a new file instance  
			FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			while (itr.hasNext())                 
			{  
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
				while (cellIterator.hasNext())   
				{  
					Cell cell = cellIterator.next();  
					//System.out.println("  " + cell.getStringCellValue());
					//track column A, 1, p, and Y
					//orderId, shipping total , itemName1, totalcostofGoods
					
					switch (cell.getCellType())               
					{  
						case STRING:    //field that represents string cell type  
						System.out.print(cell.getStringCellValue() + "\t\t\t"); 
//						if (cell.getStringCellValue().equalsIgnoreCase("orderid")){
//							System.out.print(cell.getStringCellValue() + "\t\t\t"); 
//						}
//						else if (cell.getStringCellValue().equalsIgnoreCase("shippingTotal")){
//							System.out.print(cell.getStringCellValue() + "\t\t\t"); 
//						}
//						else if (cell.getStringCellValue().equalsIgnoreCase("itemName1")){
//							System.out.print(cell.getStringCellValue() + "\t\t\t"); 
//						}
//						else if (cell.getStringCellValue().equalsIgnoreCase("totalCostofGoods")){
//							System.out.print(cell.getStringCellValue() + "\t\t\t"); 
//						}
						break;  
						case NUMERIC:    //field that represents number cell type  
							System.out.print(cell.getNumericCellValue() + "\t\t\t");  
						break;  
						default:  
					}  										
				} //while 
				System.out.println("");  
			} //while outer 
	}  //try
	catch(Exception e)  
		{  
			e.printStackTrace();  
		}  
	}  //main


}

