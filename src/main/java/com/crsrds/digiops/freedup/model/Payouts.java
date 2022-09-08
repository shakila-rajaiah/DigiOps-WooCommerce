package com.crsrds.digiops.freedup.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;



/**
 * @author S RAJAIAH
 * @Date March 18, 2021
 *
 */
public class Payouts{
	// fields sent to TrinSoft...
	//Payout_ID	Cash_Deposit_date	Charge_ID	Description	Created	Currency	Amount	Fee	Net	
	//Reporting_category	Card_Brand	Customer_email	Customer_name	Address_line1	Address_line2	Address_city	
	//Address_state	Address_zip	Address_country	Fund

	@CsvBindByName(column="payoutID")
	@CsvBindByPosition(position = 0)
	private String payoutID;
	
	@CsvBindByName(column="cashDepositDate")
	@CsvBindByPosition(position = 1)
	private String cashDepositDate;
	
	@CsvBindByName(column="chargeID")
	@CsvBindByPosition(position = 2)
	private String chargeID;
	
	@CsvBindByName(column="description")
	@CsvBindByPosition(position = 3)
	private String description;
	
	@CsvBindByName(column="createdDate")
	@CsvBindByPosition(position = 4)
	private String createdDate;
	
	@CsvBindByName(column="currency")
	@CsvBindByPosition(position = 5)
	private String  currency;
	
	@CsvBindByName(column="amount")
	@CsvBindByPosition(position = 6)
	private Double amount;
	
	@CsvBindByName(column="fee")
	@CsvBindByPosition(position = 7)
	private Double fee;
	
	@CsvBindByName(column="net")
	@CsvBindByPosition(position = 8)
	private Double net;
	
	@CsvBindByName(column="reportingCategory")
	@CsvBindByPosition(position = 9)
	private String reportingCategory;
	
	@CsvBindByName(column="cardBrand")
	@CsvBindByPosition(position = 10)
	private String cardBrand;
	
	@CsvBindByName(column="customerEmail")
	@CsvBindByPosition(position = 11)
	private String customerEmail;
	
	@CsvBindByName(column="contactName")
	@CsvBindByPosition(position = 12)
	private String contactName;
	
	@CsvBindByName(column="addressLine1")
	@CsvBindByPosition(position = 13)
	private String addressLine1;
	
	@CsvBindByName(column="addressLine2")
	@CsvBindByPosition(position = 14)
	private String addressLine2;
	
	@CsvBindByName(column="addressCity")
	@CsvBindByPosition(position = 15)
	private String addressCity;	
	
	@CsvBindByName(column="addressState")
	@CsvBindByPosition(position = 16)
	private String addressState;
	
	@CsvBindByName(column="addressZip")
	@CsvBindByPosition(position = 17)
	private String addressZip;	
	
	@CsvBindByName(column="addressCountry")
	@CsvBindByPosition(position = 18)
	private String addressCountry;
	
	@CsvBindByName(column="fund")
	@CsvBindByPosition(position = 19)
	private String fund;
		
	@CsvBindByName(column="fundTrunc")
	@CsvBindByPosition(position = 20)
	private String fundTrunc;
	
	@CsvBindByName(column="documentNumber")
	@CsvBindByPosition(position = 21)
	private String documentNumber;
	
	@CsvBindByName(column="addressID")
	@CsvBindByPosition(position = 22)
	private String addressID;
		
	@CsvBindByName(column="emailTrunc")
	@CsvBindByPosition(position = 23)
	private String customerEmailTrunc;
	
	@CsvBindByName(column="contactNameTrunc")
	@CsvBindByPosition(position = 24)
	private String contactNameTrunc;
	
	
	public Payouts() {
		
	}

	
	
	/**
	 * @param payoutID
	 * @param cashDepositDate
	 * @param chargeID
	 * @param description
	 * @param createdDate
	 * @param currency
	 * @param amount
	 * @param fee
	 * @param net
	 * @param reportingCategory
	 * @param cardBrand
	 * @param customerEmail
	 * @param customerName
	 * @param addressLine1
	 * @param addressLine2
	 * @param addressCity
	 * @param addressState
	 * @param address_zip
	 * @param address_country
	 * @param fund
	 */
	public Payouts(String payoutID, String cashDepositDate, String chargeID, String description, String createdDate,
			String currency, Double amount, Double fee, Double net, String reportingCategory, String cardBrand,
			String customerEmail, String contactName, String addressLine1, String addressLine2, String addressCity,
			String addressState, String addressZip, String addressCountry, String fund, String fundTrunc, String documentNumber, String addressID, String customerEmailTrunc, String contactNameTrunc) {
		super();
		this.payoutID = payoutID;
		this.cashDepositDate = cashDepositDate;
		this.chargeID = chargeID;
		this.description = description;
		this.createdDate = createdDate;
		this.currency = currency;
		this.amount = amount;
		this.fee = fee;
		this.net = net;
		this.reportingCategory = reportingCategory;
		this.cardBrand = cardBrand;
		this.customerEmail = customerEmail;
		this.contactName = contactName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressZip = addressZip;
		this.addressCountry = addressCountry;
		this.fund = fund;
		this.fundTrunc = fundTrunc;
		this.documentNumber = documentNumber;
		this.addressID = addressID;
		this.customerEmailTrunc = customerEmailTrunc;
		this.contactNameTrunc = contactNameTrunc;
	}
	
	@Override
	public String toString() {
		
		return "Payout [payoutID=" + payoutID 
				+  ", cashDepositDate=" + cashDepositDate				
				+ ", chargeID=" + chargeID
				+ ", description=" + description
				+ ", createdDate=" + createdDate
				+ ", currency=" + currency
				+ ", amount=" + amount
				+ ", fee=" + fee
				+ ", net=" + net
				+ ", reportingCategory=" + reportingCategory
				+ ", cardBrand=" + cardBrand
				+ ", customerEmail=" + customerEmail
				+ ", contactName=" + contactName
				+ ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2
				+ ", addressCity=" + addressCity
				+ ", addressState=" + addressState
				+ ", addressZip=" + addressZip
				+ ", addressCountry=" + addressCountry		
				+ ", fund=" + fund
				+ ", fundTrunc=" + fundTrunc
				+ ", documentNumber=" + documentNumber
				+ ", addressID=" + addressID
				+ ", customerEmailTrunc=" + customerEmailTrunc
				+ ", contactNameTrunc=" + contactNameTrunc
	    		+ "]";
	}
	
	
	
	/**
	 * @return the cashDepositDate
	 */
	public String getCashDepositDate() {
		return cashDepositDate;
	}



	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}



	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}



	/**
	 * @return the fee
	 */
	public Double getFee() {
		return fee;
	}



	/**
	 * @return the net
	 */
	public Double getNet() {
		return net;
	}



	/**
	 * @param cashDepositDate the cashDepositDate to set
	 */
	public void setCashDepositDate(String cashDepositDate) {
		this.cashDepositDate = cashDepositDate;
	}



	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}



	/**
	 * @return the addressZip
	 */
	public String getAddressZip() {
		return addressZip;
	}
	/**
	 * @return the addressCountry
	 */
	public String getAddressCountry() {
		return addressCountry;
	}
	/**
	 * @param addressZip the addressZip to set
	 */
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
	/**
	 * @param addressCountry the addressCountry to set
	 */
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	
	
	
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}



	/**
	 * @param fee the fee to set
	 */
	public void setFee(Double fee) {
		this.fee = fee;
	}



	/**
	 * @param net the net to set
	 */
	public void setNet(Double net) {
		this.net = net;
	}



	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @return the addressCity
	 */
	public String getAddressCity() {
		return addressCity;
	}
	/**
	 * @return the addressState
	 */
	public String getAddressState() {
		return addressState;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @param addressCity the addressCity to set
	 */
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	/**
	 * @param addressState the addressState to set
	 */
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}


	

	/**
	 * @return the payoutID
	 */
	public String getPayoutID() {
		return payoutID;
	}

	/**
	 * @return the chargeID
	 */
	public String getChargeID() {
		return chargeID;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @return the reportingCategory
	 */
	public String getReportingCategory() {
		return reportingCategory;
	}
	/**
	 * @return the cardBrand
	 */
	public String getCardBrand() {
		return cardBrand;
	}
	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * @return the customerName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @return the fund
	 */
	public String getFund() {
		return fund;
	}
	/**
	 * @param payoutID the payoutID to set
	 */
	public void setPayoutID(String payoutID) {
		this.payoutID = payoutID;
	}

	/**
	 * @param chargeID the chargeID to set
	 */
	public void setChargeID(String chargeID) {
		this.chargeID = chargeID;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @param reportingCategory the reportingCategory to set
	 */
	public void setReportingCategory(String reportingCategory) {
		this.reportingCategory = reportingCategory;
	}
	/**
	 * @param cardBrand the cardBrand to set
	 */
	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @param fund the fund to set
	 */
	public void setFund(String fund) {
		this.fund = fund;
	}


	// added on 4/15/2021 for truncated values.
	/**
	 * @return the fundTrunc
	 */
	public String getFundTrunc() {
		return fundTrunc;
	}


	/**
	 * @return the documentNumber
	 */
	public String getDocumentNumber() {
		return documentNumber;
	}



	/**
	 * @return the addressID
	 */
	public String getAddressID() {
		return addressID;
	}



	/**
	 * @return the emailTrunc
	 */
	public String getCustomerEmailTrunc() {
		return customerEmailTrunc;
	}



	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}



	/**
	 * @param fundTrunc the fundTrunc to set
	 */
	public void setFundTrunc(String fundTrunc) {
		this.fundTrunc = fundTrunc;
	}


	/**
	 * @param documentNumber the documentNumber to set
	 */
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}


	/**
	 * @param addressID the addressID to set
	 */
	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}


	/**
	 * @param emailTrunc the emailTrunc to set
	 */
	public void setCustomerEmailTrunc(String customerEmailTrunc) {
		this.customerEmailTrunc = customerEmailTrunc;
	}



	/**
	 * @return the contactNameTrunc
	 */
	public String getContactNameTrunc() {
		return contactNameTrunc;
	}



	/**
	 * @param contactNameTrunc the contactNameTrunc to set
	 */
	public void setContactNameTrunc(String contactNameTrunc) {
		this.contactNameTrunc = contactNameTrunc;
	}
	
	
	
		
	
}


