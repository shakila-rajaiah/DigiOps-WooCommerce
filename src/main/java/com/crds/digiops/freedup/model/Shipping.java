/**
 * 
 */
package com.crds.digiops.freedup.model;

/**
 * @author S RAJAIAH
 * @Date : August 3, 2021
 * @Desc : This is s POJO for the Shipping Java object..
 *
 */
public class Shipping {

	/**
	 * 
	 */
	public Shipping() {
		// TODO Auto-generated constructor stub
	}

	private String first_name;
	private String last_name;	
	private String company;	
	private String address_1;	
	private String address_2;	
	private String city;	
	private String state;	
	private String postcode;	
	private String country;

	/**
	 * @param first_name
	 * @param last_name
	 * @param company
	 * @param address_1
	 * @param address_2
	 * @param city
	 * @param state
	 * @param postcode
	 * @param country
	 * @param payment_method
	 */
	public Shipping(String first_name, String last_name, String company, String address_1, String address_2,
			String city, String state, String postcode, String country, String payment_method) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.company = company;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
		this.country = country;

	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @return the address_1
	 */
	public String getAddress_1() {
		return address_1;
	}
	/**
	 * @return the address_2
	 */
	public String getAddress_2() {
		return address_2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @param address_1 the address_1 to set
	 */
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	/**
	 * @param address_2 the address_2 to set
	 */
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Shipping [first_name=" + first_name + ", last_name=" + last_name + ", company=" + company
				+ ", address_1=" + address_1 + ", address_2=" + address_2 + ", city=" + city + ", state=" + state
				+ ", postcode=" + postcode + ", country=" + country + ", payment_method=" + "]";
	}	

	
	
}
