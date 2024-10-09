package com.crds.digiops.freedup.model;


/**
 * @author S RAJAIAH
 * @Date : August 2, 2021
 * @Desc : This is The main class for Refund POJO
 *
 */
public class RefundPOJO {

	public RefundPOJO() {
		// TODO Auto-generated constructor stub
	}

    private int orderId; //": 17558,
    private String reason; //": "Refunded via Stripe Dashboard",
    private double total; //": "-108.95"
	/**
	 * @param orderId
	 * @param reason
	 * @param total
	 */
	public RefundPOJO(int orderId, String reason, double total) {
		super();
		this.orderId = orderId;
		this.reason = reason;
		this.total = total;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "RefundPOJO [orderId=" + orderId + ", reason=" + reason + ", total=" + total + "]";
	}
    
    
	
	
}
