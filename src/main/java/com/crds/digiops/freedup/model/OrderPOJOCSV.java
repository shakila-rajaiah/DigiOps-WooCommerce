package com.crds.digiops.freedup.model;

import java.lang.reflect.Array;
import java.util.List;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;



/**
 * @author S RAJAIAH
 * @Date : August 2, 2021
 * @Desc : This is s POJO for the OrdersCSV Java object..
 *
 */
public class OrderPOJOCSV {

	/**
	 * 
	 */
		// for Jackson to work , have a no arg constructor
		public OrderPOJOCSV() {
			// TODO Auto-generated constructor stub
		}
		

		@CsvBindByName(column="orderId")
		@CsvBindByPosition(position = 0)
		private int  orderId;
	
		@CsvBindByName(column="firstName")
		@CsvBindByPosition(position = 1)
		private String firstName;
		
		@CsvBindByName(column="lastName")
		@CsvBindByPosition(position = 2)
		private String lastName;
		
		@CsvBindByName(column="status")
		@CsvBindByPosition(position = 3)
		private String status; 
		
		@CsvBindByName(column="dateCreated")
		@CsvBindByPosition(position = 4)
		private String  dateCreated; 
		
		@CsvBindByName(column="discountTotal")
		@CsvBindByPosition(position = 5)		
		private double  discountTotal;
		
		//total of subTotalItem#1 +subTotalItem#2
		@CsvBindByName(column="subtotalAmount")
		@CsvBindByPosition(position = 6)
		private double  subtotalAmount;	
		
		@CsvBindByName(column="shippingMethod")
		@CsvBindByPosition(position = 7)
		private String shippingMethod;
		
		@CsvBindByName(column="shippingTotal")
		@CsvBindByPosition(position = 8)
		private double  shippingTotal;
		
		@CsvBindByName(column="refundAmount")
		@CsvBindByPosition(position = 9)
		private double refundAmount;
		
		@CsvBindByName(column="orderTotal")
		@CsvBindByPosition(position = 10)
		private double  orderTotal;
		
		@CsvBindByName(column="orderTotalTax")
		@CsvBindByPosition(position = 11)
		private double  orderTotalTax;
		
		@CsvBindByName(column="sku1")
		@CsvBindByPosition(position = 12)
		private String  sku1; 
		
		@CsvBindByName(column="variationId1")
		@CsvBindByPosition(position = 13)
		private int  variationId1; 
		
		@CsvBindByName(column="itemNo1")
		@CsvBindByPosition(position = 14)
		private int itemNo1; 
				
		@CsvBindByName(column="itemName1")
		@CsvBindByPosition(position = 15)		
		private String itemName1;
		
		@CsvBindByName(column="itemQuantity1")
		@CsvBindByPosition(position = 16)			
		private int itemQuantity1; 
		
		@CsvBindByName(column="itemCost1")
		@CsvBindByPosition(position = 17)			
		private double itemCost1;
		
//		// add sub_total amount
//		@CsvBindByName(column="subTotal1")
//		@CsvBindByPosition(position = 19)
//		private double subTotal1; 
		
//		@CsvBindByName(column="itemCostofGoods1")
//		@CsvBindByPosition(position = 18)
//		private double itemCostofGoods1; 
		
		// for line item #2
		@CsvBindByName(column="sku2")
		@CsvBindByPosition(position = 18)
		private String  sku2; 
		
		@CsvBindByName(column="variationId2")
		@CsvBindByPosition(position = 19)
		private int  variationId2; 
		
		@CsvBindByName(column="itemNo2")
		@CsvBindByPosition(position = 20)
		private int itemNo2; 
		
		@CsvBindByName(column="itemName2")
		@CsvBindByPosition(position = 21)	
		private String itemName2;
		
		@CsvBindByName(column="itemQuantity2")
		@CsvBindByPosition(position = 22)	
		private int itemQuantity2; 
		
		@CsvBindByName(column="itemCost2")
		@CsvBindByPosition(position = 23)	
		private double itemCost2;
		
//		@CsvBindByName(column="subTotal2")
//		@CsvBindByPosition(position = 19)
//		private double subTotal2; 
//		
//		@CsvBindByName(column="itemCostofGoods2")
//		@CsvBindByPosition(position = 25)	
//		private double itemCostofGoods2; 
		
		//total of costOfGoodsSold#1+costOfGoodsSold#2
		@CsvBindByName(column="costofGoodsSold")
		@CsvBindByPosition(position = 24)	
		private double totalCostofGoods; 
		
		@CsvBindByName(column="couponCode1")
		@CsvBindByPosition(position = 25)	
		private String couponCode1;
		
		@CsvBindByName(column="couponDiscount1")
		@CsvBindByPosition(position = 26)	
		private double couponDiscount1; 
		
		@CsvBindByName(column="couponDiscountTax1")
		@CsvBindByPosition(position = 27)	
		private double couponDiscountTax1; 
		
		@CsvBindByName(column="couponCode2")
		@CsvBindByPosition(position = 28)	
		private String couponCode2;
		
		@CsvBindByName(column="couponDiscount2")
		@CsvBindByPosition(position = 29)	
		private double couponDiscount2; 
		
		@CsvBindByName(column="couponDiscountTax2")
		@CsvBindByPosition(position = 30)	
		private double couponDiscountTax2; 
		
		@CsvBindByName(column="paymentMethod")
		@CsvBindByPosition(position = 31)	
		private String paymentMethod;
		
		@CsvBindByName(column="paymentMethodTitle")
		@CsvBindByPosition(position = 32)	
		private String paymentMethodTitle;
		
		@CsvBindByName(column="transactionId")
		@CsvBindByPosition(position = 33)	
		private String transactionId;
		
		@CsvBindByName(column="stripeFee")
		@CsvBindByPosition(position = 34)	
		private String stripeFee;
		
		@CsvBindByName(column="stripeNet")
		@CsvBindByPosition(position = 35)	
		private String stripeNet;
		
		@CsvBindByName(column="stripeCurrency")
		@CsvBindByPosition(position = 36)	
		private String stripeCurrency;
		
//		@CsvBindByName(column="stripeSourceId")
//		@CsvBindByPosition(position = 37)	
//		private String stripeSourceId;
//		
//		
//		_stripe_intent_id
//		_stripe_customer_id
//		_stripe_intent_id
//		_stripe_charge_captured

		/**
		 * @return the orderId
		 */
		public int getOrderId() {
			return orderId;
		}

		/**
		 * @param orderId
		 * @param firstName
		 * @param lastName
		 * @param status
		 * @param dateCreated
		 * @param discountTotal
		 * @param subtotalAmount
		 * @param shippingMethod
		 * @param shippingTotal
		 * @param refundAmount
		 * @param orderTotal
		 * @param orderTotalTax
		 * @param sku1
		 * @param variationId1
		 * @param itemNo1
		 * @param itemName1
		 * @param itemQuantity1
		 * @param itemCost1
		 * @param sku2
		 * @param variationId2
		 * @param itemNo2
		 * @param itemName2
		 * @param itemQuantity2
		 * @param itemCost2
		 * @param totalCostofGoods
		 * @param couponCode1
		 * @param couponDiscount1
		 * @param couponDiscountTax1
		 * @param couponCode2
		 * @param couponDiscount2
		 * @param couponDiscountTax2
		 * @param paymentMethod
		 * @param paymentMethodTitle
		 * @param transactionId
		 * @param stripeFee
		 * @param stripeNet
		 * @param stripeCurrency
		 */
		public OrderPOJOCSV(int orderId, String firstName, String lastName, String status, String dateCreated,
				double discountTotal, double subtotalAmount, String shippingMethod, double shippingTotal,
				double refundAmount, double orderTotal, double orderTotalTax, String sku1, int variationId1,
				int itemNo1, String itemName1, int itemQuantity1, double itemCost1, String sku2, int variationId2,
				int itemNo2, String itemName2, int itemQuantity2, double itemCost2, double totalCostofGoods,
				String couponCode1, double couponDiscount1, double couponDiscountTax1, String couponCode2,
				double couponDiscount2, double couponDiscountTax2, String paymentMethod, String paymentMethodTitle,
				String transactionId, String stripeFee, String stripeNet, String stripeCurrency) {
			super();
			this.orderId = orderId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.status = status;
			this.dateCreated = dateCreated;
			this.discountTotal = discountTotal;
			this.subtotalAmount = subtotalAmount;
			this.shippingMethod = shippingMethod;
			this.shippingTotal = shippingTotal;
			this.refundAmount = refundAmount;
			this.orderTotal = orderTotal;
			this.orderTotalTax = orderTotalTax;
			this.sku1 = sku1;
			this.variationId1 = variationId1;
			this.itemNo1 = itemNo1;
			this.itemName1 = itemName1;
			this.itemQuantity1 = itemQuantity1;
			this.itemCost1 = itemCost1;
			this.sku2 = sku2;
			this.variationId2 = variationId2;
			this.itemNo2 = itemNo2;
			this.itemName2 = itemName2;
			this.itemQuantity2 = itemQuantity2;
			this.itemCost2 = itemCost2;
			this.totalCostofGoods = totalCostofGoods;
			this.couponCode1 = couponCode1;
			this.couponDiscount1 = couponDiscount1;
			this.couponDiscountTax1 = couponDiscountTax1;
			this.couponCode2 = couponCode2;
			this.couponDiscount2 = couponDiscount2;
			this.couponDiscountTax2 = couponDiscountTax2;
			this.paymentMethod = paymentMethod;
			this.paymentMethodTitle = paymentMethodTitle;
			this.transactionId = transactionId;
			this.stripeFee = stripeFee;
			this.stripeNet = stripeNet;
			this.stripeCurrency = stripeCurrency;
		}

		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @return the dateCreated
		 */
		public String getDateCreated() {
			return dateCreated;
		}

		/**
		 * @return the discountTotal
		 */
		public double getDiscountTotal() {
			return discountTotal;
		}

		/**
		 * @return the subtotalAmount
		 */
		public double getSubtotalAmount() {
			return subtotalAmount;
		}

		/**
		 * @return the shippingMethod
		 */
		public String getShippingMethod() {
			return shippingMethod;
		}

		/**
		 * @return the shippingTotal
		 */
		public double getShippingTotal() {
			return shippingTotal;
		}

		/**
		 * @return the refundAmount
		 */
		public double getRefundAmount() {
			return refundAmount;
		}

		/**
		 * @return the orderTotal
		 */
		public double getOrderTotal() {
			return orderTotal;
		}

		/**
		 * @return the orderTotalTax
		 */
		public double getOrderTotalTax() {
			return orderTotalTax;
		}

		/**
		 * @return the sku1
		 */
		public String getSku1() {
			return sku1;
		}

		/**
		 * @return the variationId1
		 */
		public int getVariationId1() {
			return variationId1;
		}

		/**
		 * @return the itemNo1
		 */
		public int getItemNo1() {
			return itemNo1;
		}

		/**
		 * @return the itemName1
		 */
		public String getItemName1() {
			return itemName1;
		}

		/**
		 * @return the itemQuantity1
		 */
		public int getItemQuantity1() {
			return itemQuantity1;
		}

		/**
		 * @return the itemCost1
		 */
		public double getItemCost1() {
			return itemCost1;
		}

//		/**
//		 * @return the itemCostofGoods1
//		 */
//		public double getItemCostofGoods1() {
//			return itemCostofGoods1;
//		}

		/**
		 * @return the sku2
		 */
		public String getSku2() {
			return sku2;
		}

		/**
		 * @return the variationId2
		 */
		public int getVariationId2() {
			return variationId2;
		}

		/**
		 * @return the itemNo2
		 */
		public int getItemNo2() {
			return itemNo2;
		}

		/**
		 * @return the itemName2
		 */
		public String getItemName2() {
			return itemName2;
		}

		/**
		 * @return the itemQuantity2
		 */
		public int getItemQuantity2() {
			return itemQuantity2;
		}

		/**
		 * @return the itemCost2
		 */
		public double getItemCost2() {
			return itemCost2;
		}

//		/**
//		 * @return the itemCostofGoods2
//		 */
//		public double getItemCostofGoods2() {
//			return itemCostofGoods2;
//		}

		/**
		 * @return the totalCostofGoods
		 */
		public double getTotalCostofGoods() {
			return totalCostofGoods;
		}

		/**
		 * @return the couponCode1
		 */
		public String getCouponCode1() {
			return couponCode1;
		}

		/**
		 * @return the couponDiscount1
		 */
		public double getCouponDiscount1() {
			return couponDiscount1;
		}

		/**
		 * @return the couponDiscountTax1
		 */
		public double getCouponDiscountTax1() {
			return couponDiscountTax1;
		}

		/**
		 * @return the couponCode2
		 */
		public String getCouponCode2() {
			return couponCode2;
		}

		/**
		 * @return the couponDiscount2
		 */
		public double getCouponDiscount2() {
			return couponDiscount2;
		}

		/**
		 * @return the couponDiscountTax2
		 */
		public double getCouponDiscountTax2() {
			return couponDiscountTax2;
		}

		/**
		 * @return the paymentMethod
		 */
		public String getPaymentMethod() {
			return paymentMethod;
		}

		/**
		 * @return the paymentMethodTitle
		 */
		public String getPaymentMethodTitle() {
			return paymentMethodTitle;
		}

		/**
		 * @return the transactionId
		 */
		public String getTransactionId() {
			return transactionId;
		}

		/**
		 * @param orderId the orderId to set
		 */
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}

		/**
		 * @param dateCreated the dateCreated to set
		 */
		public void setDateCreated(String dateCreated) {
			this.dateCreated = dateCreated;
		}

		/**
		 * @param discountTotal the discountTotal to set
		 */
		public void setDiscountTotal(double discountTotal) {
			this.discountTotal = discountTotal;
		}

		/**
		 * @param subtotalAmount the subtotalAmount to set
		 */
		public void setSubtotalAmount(double subtotalAmount) {
			this.subtotalAmount = subtotalAmount;
		}

		/**
		 * @param shippingMethod the shippingMethod to set
		 */
		public void setShippingMethod(String shippingMethod) {
			this.shippingMethod = shippingMethod;
		}

		/**
		 * @param shippingTotal the shippingTotal to set
		 */
		public void setShippingTotal(double shippingTotal) {
			this.shippingTotal = shippingTotal;
		}

		/**
		 * @param refundAmount the refundAmount to set
		 */
		public void setRefundAmount(double refundAmount) {
			this.refundAmount = refundAmount;
		}

		/**
		 * @param orderTotal the orderTotal to set
		 */
		public void setOrderTotal(double orderTotal) {
			this.orderTotal = orderTotal;
		}

		/**
		 * @param orderTotalTax the orderTotalTax to set
		 */
		public void setOrderTotalTax(double orderTotalTax) {
			this.orderTotalTax = orderTotalTax;
		}

		/**
		 * @param sku1 the sku1 to set
		 */
		public void setSku1(String sku1) {
			this.sku1 = sku1;
		}

		/**
		 * @param variationId1 the variationId1 to set
		 */
		public void setVariationId1(int variationId1) {
			this.variationId1 = variationId1;
		}

		/**
		 * @param itemNo1 the itemNo1 to set
		 */
		public void setItemNo1(int itemNo1) {
			this.itemNo1 = itemNo1;
		}

		/**
		 * @param itemName1 the itemName1 to set
		 */
		public void setItemName1(String itemName1) {
			this.itemName1 = itemName1;
		}

		/**
		 * @param itemQuantity1 the itemQuantity1 to set
		 */
		public void setItemQuantity1(int itemQuantity1) {
			this.itemQuantity1 = itemQuantity1;
		}

		/**
		 * @param itemCost1 the itemCost1 to set
		 */
		public void setItemCost1(double itemCost1) {
			this.itemCost1 = itemCost1;
		}

//		/**
//		 * @param itemCostofGoods1 the itemCostofGoods1 to set
//		 */
//		public void setItemCostofGoods1(double itemCostofGoods1) {
//			this.itemCostofGoods1 = itemCostofGoods1;
//		}

		/**
		 * @param sku2 the sku2 to set
		 */
		public void setSku2(String sku2) {
			this.sku2 = sku2;
		}

		/**
		 * @param variationId2 the variationId2 to set
		 */
		public void setVariationId2(int variationId2) {
			this.variationId2 = variationId2;
		}

		/**
		 * @param itemNo2 the itemNo2 to set
		 */
		public void setItemNo2(int itemNo2) {
			this.itemNo2 = itemNo2;
		}

		/**
		 * @param itemName2 the itemName2 to set
		 */
		public void setItemName2(String itemName2) {
			this.itemName2 = itemName2;
		}

		/**
		 * @param itemQuantity2 the itemQuantity2 to set
		 */
		public void setItemQuantity2(int itemQuantity2) {
			this.itemQuantity2 = itemQuantity2;
		}

		/**
		 * @param itemCost2 the itemCost2 to set
		 */
		public void setItemCost2(double itemCost2) {
			this.itemCost2 = itemCost2;
		}

//		/**
//		 * @param itemCostofGoods2 the itemCostofGoods2 to set
//		 */
//		public void setItemCostofGoods2(double itemCostofGoods2) {
//			this.itemCostofGoods2 = itemCostofGoods2;
//		}

		/**
		 * @param totalCostofGoods the totalCostofGoods to set
		 */
		public void setTotalCostofGoods(double totalCostofGoods) {
			this.totalCostofGoods = totalCostofGoods;
		}

		/**
		 * @param couponCode1 the couponCode1 to set
		 */
		public void setCouponCode1(String couponCode1) {
			this.couponCode1 = couponCode1;
		}

		/**
		 * @param couponDiscount1 the couponDiscount1 to set
		 */
		public void setCouponDiscount1(double couponDiscount1) {
			this.couponDiscount1 = couponDiscount1;
		}

		/**
		 * @param couponDiscountTax1 the couponDiscountTax1 to set
		 */
		public void setCouponDiscountTax1(double couponDiscountTax1) {
			this.couponDiscountTax1 = couponDiscountTax1;
		}

		/**
		 * @param couponCode2 the couponCode2 to set
		 */
		public void setCouponCode2(String couponCode2) {
			this.couponCode2 = couponCode2;
		}

		/**
		 * @param couponDiscount2 the couponDiscount2 to set
		 */
		public void setCouponDiscount2(double couponDiscount2) {
			this.couponDiscount2 = couponDiscount2;
		}

		/**
		 * @param couponDiscountTax2 the couponDiscountTax2 to set
		 */
		public void setCouponDiscountTax2(double couponDiscountTax2) {
			this.couponDiscountTax2 = couponDiscountTax2;
		}

		/**
		 * @param paymentMethod the paymentMethod to set
		 */
		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}

		/**
		 * @param paymentMethodTitle the paymentMethodTitle to set
		 */
		public void setPaymentMethodTitle(String paymentMethodTitle) {
			this.paymentMethodTitle = paymentMethodTitle;
		}

		/**
		 * @param transactionId the transactionId to set
		 */
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}

		/**
		 * @return the stripeFee
		 */
		public String getStripeFee() {
			return stripeFee;
		}

		/**
		 * @return the stripeNet
		 */
		public String getStripeNet() {
			return stripeNet;
		}

		/**
		 * @return the stripeCurrency
		 */
		public String getStripeCurrency() {
			return stripeCurrency;
		}

		/**
		 * @param stripeFee the stripeFee to set
		 */
		public void setStripeFee(String stripeFee) {
			this.stripeFee = stripeFee;
		}

		/**
		 * @param stripeNet the stripeNet to set
		 */
		public void setStripeNet(String stripeNet) {
			this.stripeNet = stripeNet;
		}

		/**
		 * @param stripeCurrency the stripeCurrency to set
		 */
		public void setStripeCurrency(String stripeCurrency) {
			this.stripeCurrency = stripeCurrency;
		}

		@Override
		public String toString() {
			return "OrderPOJOCSV [orderId=" + orderId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", status=" + status + ", dateCreated=" + dateCreated + ", discountTotal=" + discountTotal
					+ ", subtotalAmount=" + subtotalAmount + ", shippingMethod=" + shippingMethod + ", shippingTotal="
					+ shippingTotal + ", refundAmount=" + refundAmount + ", orderTotal=" + orderTotal
					+ ", orderTotalTax=" + orderTotalTax + ", sku1=" + sku1 + ", variationId1=" + variationId1
					+ ", itemNo1=" + itemNo1 + ", itemName1=" + itemName1 + ", itemQuantity1=" + itemQuantity1
					+ ", itemCost1=" + itemCost1 + ", sku2=" + sku2 + ", variationId2=" + variationId2 + ", itemNo2="
					+ itemNo2 + ", itemName2=" + itemName2 + ", itemQuantity2=" + itemQuantity2 + ", itemCost2="
					+ itemCost2 
					+ ", totalCostofGoods=" + totalCostofGoods 
					+ ", couponCode1=" + couponCode1
					+ ", couponDiscount1=" + couponDiscount1 
					+ ", couponDiscountTax1=" + couponDiscountTax1
					+ ", couponCode2=" + couponCode2 
					+ ", couponDiscount2=" + couponDiscount2
					+ ", couponDiscountTax2="+ couponDiscountTax2 
					+ ", paymentMethod=" + paymentMethod 
					+ ", paymentMethodTitle=" + paymentMethodTitle 
					+ ", transactionId=" + transactionId 
					+ ", stripeFee=" + stripeFee
					+ ", stripeNet=" + stripeNet 
					+ ", stripeCurrency=" + stripeCurrency 
					+ "]";
		}

	}
	
	
