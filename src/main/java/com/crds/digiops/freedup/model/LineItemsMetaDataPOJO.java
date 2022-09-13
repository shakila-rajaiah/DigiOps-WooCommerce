package com.crds.digiops.freedup.model;

/**
 * @author S RAJAIAH
 * @Date : August 24, 2021
 * @Desc : This is s POJO for the LineItemsMetaDataPOJO (Array) Java object..
 *
 */
public class LineItemsMetaDataPOJO {

	public LineItemsMetaDataPOJO() {
		// TODO Auto-generated constructor stub
	}
	
	private int id; //": 110745,
	private String key; //: "style",
	private String value;  //": "Full App Access & 1 Workbook",
	private String display_key; 
	private String display_value;  //": "Full App Access &amp; 1 Workbook"
	/**
	 * @param id
	 * @param key
	 * @param value
	 * @param display_key
	 * @param display_value
	 */
	public LineItemsMetaDataPOJO(int id, String key, String value, String display_key, String display_value) {
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
		return "LineItemsMetaDataPOJO [id=" + id + ", key=" + key + ", value=" + value + ", display_key=" + display_key
				+ ", display_value=" + display_value + "]";
	}

	
}