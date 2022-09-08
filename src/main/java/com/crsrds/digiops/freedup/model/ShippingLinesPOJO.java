/**
 * 
 */
package com.crsrds.digiops.freedup.model;

import java.util.List;

/**
 * @author S RAJAIAH
 * @Date : August 26, 2021
 * @Desc : This is s POJO for the ShippingLinesPOJO (Array) Java object..
 *
 */
public class ShippingLinesPOJO {

	/**
	 * 
	 */
	public ShippingLinesPOJO() {
		// TODO Auto-generated constructor stub
	}

	private int id; //": 17453,
	private String method_title;  //": "Free shipping",
	private String method_id; //": "free_shipping",
	private int instance_id; //": "2",
	private Double total; //": "0.00",
	private Double total_tax; // ": "0.00",
	List <ShippingLinesMetaDataPOJO> shippingLinesMetaDataPOJO;
	/**
	 * @param id
	 * @param method_title
	 * @param method_id
	 * @param instance_id
	 * @param total
	 * @param total_tax
	 * @param shippingLinesMetaDataPOJO
	 */
	public ShippingLinesPOJO(int id, String method_title, String method_id, int instance_id, Double total,
			Double total_tax, List<ShippingLinesMetaDataPOJO> shippingLinesMetaDataPOJO) {
		super();
		this.id = id;
		this.method_title = method_title;
		this.method_id = method_id;
		this.instance_id = instance_id;
		this.total = total;
		this.total_tax = total_tax;
		this.shippingLinesMetaDataPOJO = shippingLinesMetaDataPOJO;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the method_title
	 */
	public String getMethod_title() {
		return method_title;
	}
	/**
	 * @return the method_id
	 */
	public String getMethod_id() {
		return method_id;
	}
	/**
	 * @return the instance_id
	 */
	public int getInstance_id() {
		return instance_id;
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
	 * @return the shippingLinesMetaDataPOJO
	 */
	public List<ShippingLinesMetaDataPOJO> getShippingLinesMetaDataPOJO() {
		return shippingLinesMetaDataPOJO;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param method_title the method_title to set
	 */
	public void setMethod_title(String method_title) {
		this.method_title = method_title;
	}
	/**
	 * @param method_id the method_id to set
	 */
	public void setMethod_id(String method_id) {
		this.method_id = method_id;
	}
	/**
	 * @param instance_id the instance_id to set
	 */
	public void setInstance_id(int instance_id) {
		this.instance_id = instance_id;
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
	 * @param shippingLinesMetaDataPOJO the shippingLinesMetaDataPOJO to set
	 */
	public void setShippingLinesMetaDataPOJO(List<ShippingLinesMetaDataPOJO> shippingLinesMetaDataPOJO) {
		this.shippingLinesMetaDataPOJO = shippingLinesMetaDataPOJO;
	}
	@Override
	public String toString() {
		return "ShippingLinesPOJO [id=" + id + ", method_title=" + method_title + ", method_id=" + method_id
				+ ", instance_id=" + instance_id + ", total=" + total + ", total_tax=" + total_tax
				+ ", shippingLinesMetaDataPOJO=" + shippingLinesMetaDataPOJO + "]";
	}
	

}
