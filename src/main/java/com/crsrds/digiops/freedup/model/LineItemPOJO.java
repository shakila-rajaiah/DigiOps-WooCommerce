/**
 * 
 */
package com.crsrds.digiops.freedup.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author S RAJAIAH
 * @Date : August 18, 2021
 * @Desc : This is s POJO for the LineItemPOJO (Array) Java object..
 *
 */
public class LineItemPOJO {

		/**
		 * 
		 */
		public LineItemPOJO() {
			// TODO Auto-generated constructor stub
		}
		
		private int id;
		private String name;
		private int product_id;
		private int variation_id;
		private int quantity;
		private Double subtotal; //": "99.00",
		private Double subtotal_tax; //": "0.00",
		private Double total;
		private Double total_tax; //": "0.00",
		private String sku; //": "freedup-workbook",
		private Double price; //": 0,
		private Double cog_item_cost; //": 2.25,
		private Double cog_item_total_cost; //": 2.25
		private List <LineItemsMetaDataPOJO> lineItemsMetaData;
		
		/**
		 * @param id
		 * @param name
		 * @param product_id
		 * @param variation_id
		 * @param quantity
		 * @param subtotal
		 * @param subtotal_tax
		 * @param total
		 * @param total_tax
		 * @param sku
		 * @param price
		 * @param cog_item_cost
		 * @param cog_item_total_cost
		 * @param lineItemsMetaData
		 */
		public LineItemPOJO(int id, String name, int product_id, int variation_id, int quantity, Double subtotal,
				Double subtotal_tax, Double total, Double total_tax, String sku, Double price, Double cog_item_cost,
				Double cog_item_total_cost, ArrayList<LineItemsMetaDataPOJO> lineItemsMetaData) {
			super();
			this.id = id;
			this.name = name;
			this.product_id = product_id;
			this.variation_id = variation_id;
			this.quantity = quantity;
			this.subtotal = subtotal;
			this.subtotal_tax = subtotal_tax;
			this.total = total;
			this.total_tax = total_tax;
			this.sku = sku;
			this.price = price;
			this.cog_item_cost = cog_item_cost;
			this.cog_item_total_cost = cog_item_total_cost;
			this.lineItemsMetaData = lineItemsMetaData;
		}
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @return the product_id
		 */
		public int getProduct_id() {
			return product_id;
		}
		/**
		 * @return the variation_id
		 */
		public int getVariation_id() {
			return variation_id;
		}
		/**
		 * @return the quantity
		 */
		public int getQuantity() {
			return quantity;
		}
		/**
		 * @return the subtotal
		 */
		public Double getSubtotal() {
			return subtotal;
		}
		/**
		 * @return the subtotal_tax
		 */
		public Double getSubtotal_tax() {
			return subtotal_tax;
		}
		/**
		 * @return the total
		 */
		public Double getTotal() {
			return total;
		}
		/**
		 * @return the total_tax
		 */
		public Double getTotal_tax() {
			return total_tax;
		}
		/**
		 * @return the sku
		 */
		public String getSku() {
			return sku;
		}
		/**
		 * @return the price
		 */
		public Double getPrice() {
			return price;
		}
		/**
		 * @return the cog_item_cost
		 */
		public Double getCog_item_cost() {
			return cog_item_cost;
		}
		/**
		 * @return the cog_item_total_cost
		 */
		public Double getCog_item_total_cost() {
			return cog_item_total_cost;
		}
		/**
		 * @return the lineItemsMetaData
		 */
		public List<LineItemsMetaDataPOJO> getLineItemsMetaData() {
			return lineItemsMetaData;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @param product_id the product_id to set
		 */
		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}
		/**
		 * @param variation_id the variation_id to set
		 */
		public void setVariation_id(int variation_id) {
			this.variation_id = variation_id;
		}
		/**
		 * @param quantity the quantity to set
		 */
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		/**
		 * @param subtotal the subtotal to set
		 */
		public void setSubtotal(Double subtotal) {
			this.subtotal = subtotal;
		}
		/**
		 * @param subtotal_tax the subtotal_tax to set
		 */
		public void setSubtotal_tax(Double subtotal_tax) {
			this.subtotal_tax = subtotal_tax;
		}
		/**
		 * @param total the total to set
		 */
		public void setTotal(Double total) {
			this.total = total;
		}
		/**
		 * @param total_tax the total_tax to set
		 */
		public void setTotal_tax(Double total_tax) {
			this.total_tax = total_tax;
		}
		/**
		 * @param sku the sku to set
		 */
		public void setSku(String sku) {
			this.sku = sku;
		}
		/**
		 * @param price the price to set
		 */
		public void setPrice(Double price) {
			this.price = price;
		}
		/**
		 * @param cog_item_cost the cog_item_cost to set
		 */
		public void setCog_item_cost(Double cog_item_cost) {
			this.cog_item_cost = cog_item_cost;
		}
		/**
		 * @param cog_item_total_cost the cog_item_total_cost to set
		 */
		public void setCog_item_total_cost(Double cog_item_total_cost) {
			this.cog_item_total_cost = cog_item_total_cost;
		}
		/**
		 * @param lineItemsMetaData the lineItemsMetaData to set
		 */
		public void setLineItemsMetaData(ArrayList<LineItemsMetaDataPOJO> lineItemsMetaData) {
			this.lineItemsMetaData = lineItemsMetaData;
		}
		@Override
		public String toString() {
			return "LineItemPOJO [id=" + id + ", name=" + name + ", product_id=" + product_id + ", variation_id="
					+ variation_id + ", quantity=" + quantity + ", subtotal=" + subtotal + ", subtotal_tax=" + subtotal_tax
					+ ", total=" + total + ", total_tax=" + total_tax + ", sku=" + sku + ", price=" + price
					+ ", cog_item_cost=" + cog_item_cost + ", cog_item_total_cost=" + cog_item_total_cost
					+ ", lineItemsMetaData=" + lineItemsMetaData + "]";
		}
		
	
	

	}



