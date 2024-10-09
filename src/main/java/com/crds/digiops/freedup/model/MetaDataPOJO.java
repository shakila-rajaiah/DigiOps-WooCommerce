package com.crds.digiops.freedup.model;

/**
 * @author S RAJAIAH
 * @Date : August 23, 2021
 * @Desc : This is s POJO for the MetaDataPOJO Main (Array) Java object..
 *
 */
public class MetaDataPOJO {

	/**
	 * 
	 */
	public MetaDataPOJO() {
		// TODO Auto-generated constructor stub
	}

    private int id; //": 430527,
    private String key; //": "_stripe_customer_id",
    private String value; //": "cus_Jy4BjaJgBL1M5o"
	/**
	 * @param id
	 * @param key
	 * @param value
	 */
	public MetaDataPOJO(int id, String key, String value) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
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
	@Override
	public String toString() {
		return "MetaDataPOJO [id=" + id + ", key=" + key + ", value=" + value + "]";
	}
    
    
	
	
}
