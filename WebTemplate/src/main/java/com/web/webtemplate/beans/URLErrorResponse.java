package com.web.webtemplate.beans;

public class URLErrorResponse {
	
	private String status;
	private String error;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public URLErrorResponse(String status, String error) {
		super();
		this.status = status;
		this.error = error;
	}
	public URLErrorResponse() {
		super();
	}
	@Override
	public String toString() {
		return "URLErrorResponse [status=" + status + ", error=" + error + "]";
	}
	
	

}
