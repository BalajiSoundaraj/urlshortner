package com.web.webtemplate.beans;

public class URLOutput {

	private String inputURL;
	private String expirationDate;
	public String getInputURL() {
		return inputURL;
	}
	public void setInputURL(String inputURL) {
		this.inputURL = inputURL;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public URLOutput(String inputURL, String expirationDate) {
		super();
		this.inputURL = inputURL;
		this.expirationDate = expirationDate;
	}
	@Override
	public String toString() {
		return "URLOutput [inputURL=" + inputURL + ", expirationDate=" + expirationDate + "]";
	}
	
	
	
}
