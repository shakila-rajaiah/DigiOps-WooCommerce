package com.crds.digiops.freedup.model;

/**
 * @author S RAJAIAH
 * @Date : July 12, 2021
 * @Description: This is the main class for the Email Object.
 *
 */

public class Email {

	/**
	 * 
	 */
	public Email() {
		// TODO Auto-generated constructor stub
		
	}
	
	/**
	 * @param to
	 * @param from
	 * @param cc
	 * @param subject
	 * @param messageBody
	 * @param toRecepient1
	 * @param toRecepient2
	 * @param toRecepient3
	 * @param ccRecepient1
	 * @param ccRecepient2
	 * @param ccRecepient3
	 */
	public Email(String to, String from, String cc, String subject, String messageBody, String toRecepient1,
			String toRecepient2, String toRecepient3, String ccRecepient1, String ccRecepient2, String ccRecepient3) {
		super();
		this.to = to;
		this.from = from;
		this.cc = cc;
		this.subject = subject;
		this.messageBody = messageBody;
		this.toRecepient1 = toRecepient1;
		this.toRecepient2 = toRecepient2;
		this.toRecepient3 = toRecepient3;
		this.ccRecepient1 = ccRecepient1;
		this.ccRecepient2 = ccRecepient2;
		this.ccRecepient3 = ccRecepient3;
	}
	
	
	private String to;
	private String from;
	private String cc;
	private String subject;
	private String messageBody;
	private String toRecepient1;
	private String toRecepient2;
	private String toRecepient3;
	private String ccRecepient1;
	private String ccRecepient2;
	private String ccRecepient3;
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @return the messageBody
	 */
	public String getMessageBody() {
		return messageBody;
	}
	/**
	 * @return the toRecepient1
	 */
	public String getToRecepient1() {
		return toRecepient1;
	}
	/**
	 * @return the toRecepient2
	 */
	public String getToRecepient2() {
		return toRecepient2;
	}
	/**
	 * @return the toRecepient3
	 */
	public String getToRecepient3() {
		return toRecepient3;
	}
	/**
	 * @return the ccRecepient1
	 */
	public String getCcRecepient1() {
		return ccRecepient1;
	}
	/**
	 * @return the ccRecepient2
	 */
	public String getCcRecepient2() {
		return ccRecepient2;
	}
	/**
	 * @return the ccRecepient3
	 */
	public String getCcRecepient3() {
		return ccRecepient3;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @param cc the cc to set
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @param messageBody the messageBody to set
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	/**
	 * @param toRecepient1 the toRecepient1 to set
	 */
	public void setToRecepient1(String toRecepient1) {
		this.toRecepient1 = toRecepient1;
	}
	/**
	 * @param toRecepient2 the toRecepient2 to set
	 */
	public void setToRecepient2(String toRecepient2) {
		this.toRecepient2 = toRecepient2;
	}
	/**
	 * @param toRecepient3 the toRecepient3 to set
	 */
	public void setToRecepient3(String toRecepient3) {
		this.toRecepient3 = toRecepient3;
	}
	/**
	 * @param ccRecepient1 the ccRecepient1 to set
	 */
	public void setCcRecepient1(String ccRecepient1) {
		this.ccRecepient1 = ccRecepient1;
	}
	/**
	 * @param ccRecepient2 the ccRecepient2 to set
	 */
	public void setCcRecepient2(String ccRecepient2) {
		this.ccRecepient2 = ccRecepient2;
	}
	/**
	 * @param ccRecepient3 the ccRecepient3 to set
	 */
	public void setCcRecepient3(String ccRecepient3) {
		this.ccRecepient3 = ccRecepient3;
	}
	@Override
	public String toString() {
		return "Email [to=" + to + ", from=" + from + ", cc=" + cc + ", subject=" + subject + ", messageBody="
				+ messageBody + ", toRecepient1=" + toRecepient1 + ", toRecepient2=" + toRecepient2 + ", toRecepient3="
				+ toRecepient3 + ", ccRecepient1=" + ccRecepient1 + ", ccRecepient2=" + ccRecepient2 + ", ccRecepient3="
				+ ccRecepient3 + ", getTo()=" + getTo() + ", getFrom()=" + getFrom() + ", getCc()=" + getCc()
				+ ", getSubject()=" + getSubject() + ", getMessageBody()=" + getMessageBody() + ", getToRecepient1()="
				+ getToRecepient1() + ", getToRecepient2()=" + getToRecepient2() + ", getToRecepient3()="
				+ getToRecepient3() + ", getCcRecepient1()=" + getCcRecepient1() + ", getCcRecepient2()="
				+ getCcRecepient2() + ", getCcRecepient3()=" + getCcRecepient3() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	

}
