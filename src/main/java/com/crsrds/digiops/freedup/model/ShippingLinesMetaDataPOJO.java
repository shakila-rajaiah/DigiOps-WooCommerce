/**
 * 
 */
package com.crsrds.digiops.freedup.model;

/**
 * @author S RAJAIAH
 * @Date : August 26, 2021
 * @Desc : This is s POJO for the ShippingLinesMetaDataPOJO (Array) Java object..
 *
 */
public class ShippingLinesMetaDataPOJO {

	/**
	 * 
	 */
	public ShippingLinesMetaDataPOJO() {
		// TODO Auto-generated constructor stub
	}
	
	private int id; // ": 110761,
	private String key; //": "Items",
	private String value; //": "FreedUp App & Workbook - Full App Access & 1 Workbook &times; 1, FreedUp App & Workbook - Full App Access & 2 Workbooks (for couples) &times; 1",
	private String display_key; //": "Items",
	private String display_value; //": "FreedUp App &amp; Workbook - Full App Access &amp; 1 Workbook &times; 1, FreedUp App &amp; Workbook - Full App Access &amp; 2 Workbooks (for couples) &times; 1"
	/**
	 * @param id
	 * @param key
	 * @param value
	 * @param display_key
	 * @param display_value
	 */
	public ShippingLinesMetaDataPOJO(int id, String key, String value, String display_key, String display_value) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
		this.display_key = display_key;
		this.display_value = display_value;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @return the display_key
	 */
	public String getDisplay_key() {
		return display_key;
	}
	/**
	 * @return the display_value
	 */
	public String getDisplay_value() {
		return display_value;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @param display_key the display_key to set
	 */
	public void setDisplay_key(String display_key) {
		this.display_key = display_key;
	}
	/**
	 * @param display_value the display_value to set
	 */
	public void setDisplay_value(String display_value) {
		this.display_value = display_value;
	}
	@Override
	public String toString() {
		return "ShippingLinesMetaDataPOJO [id=" + id + ", key=" + key + ", value=" + value + ", display_key="
				+ display_key + ", display_value=" + display_value + "]";
	}

}
