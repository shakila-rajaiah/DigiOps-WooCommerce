package com.crds.digiops.freedup.model;

import java.lang.reflect.Array;
import java.util.List;


/**
 * @author S RAJAIAH
 * @Date : August 23, 2021
 * @Desc
 *
 */
public class OrderPOJO {

	/**
	 * 
	 */
	// for Jackson to work , have a no arg constructor
	public OrderPOJO() {
		// TODO Auto-generated constructor stub
		// no arg constructor needed for JSON
	}

		private int  id;
		private String status; 
		private String  date_created; //datetime
		private double  discount_total;
		private double  shipping_total;	
		private double  totalRefundAmount;	
		private double  total;	
		private double  totalTax;
		private double  subtotal_amount;	
		private double  subtotal_Tax;
		private Shipping shipping;
		private String payment_method;
		private String payment_method_title;
		private String transaction_id;
		private List<LineItemPOJO> line_items;
		private List<ShippingLinesPOJO>  shipping_lines; //"shipping_lines"
		private List<CouponLinesPOJO>  coupon_lines;
		private List<MetaDataPOJO>  meta_data; 
		private List<RefundPOJO> refunds;
		/**
		 * @param id
		 * @param status
		 * @param date_created
		 * @param discount_total
		 * @param shipping_total
		 * @param totalRefundAmount
		 * @param total
		 * @param totalTax
		 * @param subtotal_amount
		 * @param subtotal_Tax
		 * @param shipping
		 * @param payment_method
		 * @param payment_method_title
		 * @param transaction_id
		 * @param line_items
		 * @param shipping_lines
		 * @param coupon_lines
		 * @param metaDatas
		 * @param refunds
		 */
		public OrderPOJO(int id, String status, String date_created, double discount_total, double shipping_total,
				double totalRefundAmount, double total, double totalTax, double subtotal_amount, double subtotal_Tax,
				Shipping shipping, String payment_method, String payment_method_title, String transaction_id,
				List<LineItemPOJO> line_items, List<ShippingLinesPOJO> shipping_lines,
				List<CouponLinesPOJO> coupon_lines, List<MetaDataPOJO> meta_data, List<RefundPOJO> refunds) {
			super();
			this.id = id;
			this.status = status;
			this.date_created = date_created;
			this.discount_total = discount_total;
			this.shipping_total = shipping_total;
			this.totalRefundAmount = totalRefundAmount;
			this.total = total;
			this.totalTax = totalTax;
			this.subtotal_amount = subtotal_amount;
			this.subtotal_Tax = subtotal_Tax;
			this.shipping = shipping;
			this.payment_method = payment_method;
			this.payment_method_title = payment_method_title;
			this.transaction_id = transaction_id;
			this.line_items = line_items;
			this.shipping_lines = shipping_lines;
			this.coupon_lines = coupon_lines;
			this.meta_data = meta_data;
			this.refunds = refunds;
		}
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}
		/**
		 * @return the date_created
		 */
		public String getDate_created() {
			return date_created;
		}
		/**
		 * @return the discount_total
		 */
		public double getDiscount_total() {
			return discount_total;
		}
		/**
		 * @return the shipping_total
		 */
		public double getShipping_total() {
			return shipping_total;
		}
		/**
		 * @return the totalRefundAmount
		 */
		public double getTotalRefundAmount() {
			return totalRefundAmount;
		}
		/**
		 * @return the total
		 */
		public double getTotal() {
			return total;
		}
		/**
		 * @return the totalTax
		 */
		public double getTotalTax() {
			return totalTax;
		}
		/**
		 * @return the subtotal_amount
		 */
		public double getSubtotal_amount() {
			return subtotal_amount;
		}
		/**
		 * @return the subtotal_Tax
		 */
		public double getSubtotal_Tax() {
			return subtotal_Tax;
		}
		/**
		 * @return the shipping
		 */
		public Shipping getShipping() {
			return shipping;
		}
		/**
		 * @return the payment_method
		 */
		public String getPayment_method() {
			return payment_method;
		}
		/**
		 * @return the payment_method_title
		 */
		public String getPayment_method_title() {
			return payment_method_title;
		}
		/**
		 * @return the transaction_id
		 */
		public String getTransaction_id() {
			return transaction_id;
		}
		/**
		 * @return the line_items
		 */
		public List<LineItemPOJO> getLine_items() {
			return line_items;
		}
		/**
		 * @return the shipping_lines
		 */
		public List<ShippingLinesPOJO> getShipping_lines() {
			return shipping_lines;
		}
		/**
		 * @return the coupon_lines
		 */
		public List<CouponLinesPOJO> getCoupon_lines() {
			return coupon_lines;
		}
		/**
		 * @return the metaDatas
		 */
		public List<MetaDataPOJO> getMetaDatas() {
			return meta_data;
		}
		/**
		 * @return the refunds
		 */
		public List<RefundPOJO> getRefunds() {
			return refunds;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}
		/**
		 * @param date_created the date_created to set
		 */
		public void setDate_created(String date_created) {
			this.date_created = date_created;
		}
		/**
		 * @param discount_total the discount_total to set
		 */
		public void setDiscount_total(double discount_total) {
			this.discount_total = discount_total;
		}
		/**
		 * @param shipping_total the shipping_total to set
		 */
		public void setShipping_total(double shipping_total) {
			this.shipping_total = shipping_total;
		}
		/**
		 * @param totalRefundAmount the totalRefundAmount to set
		 */
		public void setTotalRefundAmount(double totalRefundAmount) {
			this.totalRefundAmount = totalRefundAmount;
		}
		/**
		 * @param total the total to set
		 */
		public void setTotal(double total) {
			this.total = total;
		}
		/**
		 * @param totalTax the totalTax to set
		 */
		public void setTotalTax(double totalTax) {
			this.totalTax = totalTax;
		}
		/**
		 * @param subtotal_amount the subtotal_amount to set
		 */
		public void setSubtotal_amount(double subtotal_amount) {
			this.subtotal_amount = subtotal_amount;
		}
		/**
		 * @param subtotal_Tax the subtotal_Tax to set
		 */
		public void setSubtotal_Tax(double subtotal_Tax) {
			this.subtotal_Tax = subtotal_Tax;
		}
		/**
		 * @param shipping the shipping to set
		 */
		public void setShipping(Shipping shipping) {
			this.shipping = shipping;
		}
		/**
		 * @param payment_method the payment_method to set
		 */
		public void setPayment_method(String payment_method) {
			this.payment_method = payment_method;
		}
		/**
		 * @param payment_method_title the payment_method_title to set
		 */
		public void setPayment_method_title(String payment_method_title) {
			this.payment_method_title = payment_method_title;
		}
		/**
		 * @param transaction_id the transaction_id to set
		 */
		public void setTransaction_id(String transaction_id) {
			this.transaction_id = transaction_id;
		}
		/**
		 * @param line_items the line_items to set
		 */
		public void setLine_items(List<LineItemPOJO> line_items) {
			this.line_items = line_items;
		}
		/**
		 * @param shipping_lines the shipping_lines to set
		 */
		public void setShipping_lines(List<ShippingLinesPOJO> shipping_lines) {
			this.shipping_lines = shipping_lines;
		}
		/**
		 * @param coupon_lines the coupon_lines to set
		 */
		public void setCoupon_lines(List<CouponLinesPOJO> coupon_lines) {
			this.coupon_lines = coupon_lines;
		}
		/**
		 * @param metaDatas the metaDatas to set
		 */
		public void setMetaDatas(List<MetaDataPOJO> meta_data) {
			this.meta_data = meta_data;
		}
		/**
		 * @param refunds the refunds to set
		 */
		public void setRefunds(List<RefundPOJO> refunds) {
			this.refunds = refunds;
		}
		@Override
		public String toString() {
			return "OrderPOJO [id=" + id + ", status=" + status + ", date_created=" + date_created + ", discount_total="
					+ discount_total + ", shipping_total=" + shipping_total + ", totalRefundAmount=" + totalRefundAmount
					+ ", total=" + total + ", totalTax=" + totalTax + ", subtotal_amount=" + subtotal_amount
					+ ", subtotal_Tax=" + subtotal_Tax + ", shipping=" + shipping + ", payment_method=" + payment_method
					+ ", payment_method_title=" + payment_method_title + ", transaction_id=" + transaction_id
					+ ", line_items=" + line_items + ", shipping_lines=" + shipping_lines + ", coupon_lines="
					+ coupon_lines + ", meta_data=" + meta_data + ", refunds=" + refunds + "]";
		}
		
		

		
		
		
		
		// other available fields in the ordersJSON
		
		//	private String currency; 
		//	private String version; //new
		//	private boolean  price_include_tax;
		//	private String date_modified; //datetime
		//	private String  discount_tax;
		//	private String  shipping_tax;
		//	private String  cart_tax;
		//	private String  total_tax;
		//	private String  customer_id;
		//	private String order_key; 
		//	private Billing billing;
	//	private String  customer_ip_address;
	//	private String  customer_user_agent;
	//	private String created_via;
	//	private String  customer_note;
	//	private String date_completed; //datetime
	//	private String date_paid; //datetime
	//	private String cart_hash;	
	//	private String  number; //order number
	//	private String date_created_gmt; //datetime
	//	private String  date_modified_gmt; //datetime
	//	private String date_paid_gmt; //datetime
	//	private String date_completed_gmt; //datetim
}
	
	
