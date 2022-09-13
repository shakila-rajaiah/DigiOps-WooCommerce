package com.crds.digiops.freedup.model;

/**
 * @author S RAJAIAH
 * @Date : August 19, 2021
 * @Desc : This is s POJO for the CouponLinesPOJO (Array) Java object..
 *
 */
public class CouponLinesPOJO {

	/**
	 * 
	 */
	public CouponLinesPOJO() {
		// TODO Auto-generated constructor stub
	}
	
	private int id; //": 17454,
	private String code; //": "freedupmay20",
	private double discount; //": "198",
	private double discount_tax; //": "0",
	/**
	 * @param id
	 * @param code
	 * @param discount
	 * @param discount_tax
	 */
	public CouponLinesPOJO(int id, String code, double discount, double discount_tax) {
		super();
		this.id = id;
		this.code = code;
		this.discount = discount;
		this.discount_tax = discount_tax;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}
	/**
	 * @return the discount_tax
	 */
	public double getDiscount_tax() {
		return discount_tax;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	/**
	 * @param discount_tax the discount_tax to set
	 */
	public void setDiscount_tax(double discount_tax) {
		this.discount_tax = discount_tax;
	}
	@Override
	public String toString() {
		return "CouponLinesPOJO [id=" + id + ", code=" + code + ", discount=" + discount + ", discount_tax="
				+ discount_tax + "]";
	}


	
	
//    "coupon_lines": [
//                     {
//                         "id": 17454,
//                         "code": "freedupmay20",
//                         "discount": "198",
//                         "discount_tax": "0",
//                         "meta_data": [
//                             {
//                                 "id": 110764,
//                                 "key": "coupon_data",
//                                 "value": {
//                                     "id": 17628,
//                                     "code": "freedupmay20",
//                                     "amount": "100",
//                                     "date_created": {
//                                         "date": "2021-05-19 11:51:32.000000",
//                                         "timezone_type": 3,
//                                         "timezone": "America/Detroit"
//                                     },
//                                     "date_modified": {
//                                         "date": "2021-05-19 11:52:58.000000",
//                                         "timezone_type": 3,
//                                         "timezone": "America/Detroit"
//                                     },
//                                     "date_expires": {
//                                         "date": "2021-07-01 00:00:00.000000",
//                                         "timezone_type": 3,
//                                         "timezone": "America/Detroit"
//                                     },
//                                     "discount_type": "percent",
//                                     "description": "Free access to FreedUp for participants of 05/20/2021 webinar",
//                                     "usage_count": 17,
//                                     "individual_use": false,
//                                     "product_ids": [
//                                         337,
//                                         338
//                                     ],
//                                     "excluded_product_ids": [],
//                                     "usage_limit": 250,
//                                     "usage_limit_per_user": 1,
//                                     "limit_usage_to_x_items": null,
//                                     "free_shipping": true,
//                                     "product_categories": [],
//                                     "excluded_product_categories": [],
//                                     "exclude_sale_items": false,
//                                     "minimum_amount": "",
//                                     "maximum_amount": "",
//                                     "email_restrictions": [],
//                                     "virtual": false,
//                                     "meta_data": [
//                                         {
//                                             "id": 419174,
//                                             "key": "_coupon_held_1623868514_FY0pKL",
//                                             "value": ""
//                                         },
//                                         {
//                                             "id": 419175,
//                                             "key": "_maybe_used_by_1623868514_myLh1g",
//                                             "value": "elyse.kauffman@everence.com"
//                                         }
//                                     ]
//                                 },
//                                 "display_key": "coupon_data",
//                                 "display_value": {
//                                     "id": 17628,
//                                     "code": "freedupmay20",
//                                     "amount": "100",
//                                     "date_created": {
//                                         "date": "2021-05-19 11:51:32.000000",
//                                         "timezone_type": 3,
//                                         "timezone": "America/Detroit"
//                                     },
//                                     "date_modified": {
//                                         "date": "2021-05-19 11:52:58.000000",
//                                         "timezone_type": 3,
//                                         "timezone": "America/Detroit"
//                                     },
//                                     "date_expires": {
//                                         "date": "2021-07-01 00:00:00.000000",
//                                         "timezone_type": 3,
//                                         "timezone": "America/Detroit"
//                                     },
//                                     "discount_type": "percent",
//                                     "description": "Free access to FreedUp for participants of 05/20/2021 webinar",
//                                     "usage_count": 17,
//                                     "individual_use": false,
//                                     "product_ids": [
//                                         337,
//                                         338
//                                     ],
//                                     "excluded_product_ids": [],
//                                     "usage_limit": 250,
//                                     "usage_limit_per_user": 1,
//                                     "limit_usage_to_x_items": null,
//                                     "free_shipping": true,
//                                     "product_categories": [],
//                                     "excluded_product_categories": [],
//                                     "exclude_sale_items": false,
//                                     "minimum_amount": "",
//                                     "maximum_amount": "",
//                                     "email_restrictions": [],
//                                     "virtual": false,
//                                     "meta_data": [
//                                         {
//                                             "id": 419174,
//                                             "key": "_coupon_held_1623868514_FY0pKL",
//                                             "value": ""
//                                         },
//                                         {
//                                             "id": 419175,
//                                             "key": "_maybe_used_by_1623868514_myLh1g",
//                                             "value": "elyse.kauffman@everence.com"
//                                         }
//                                     ]
//                                 }
//                             }
//                         ]
//                     }
//                 ],

}
