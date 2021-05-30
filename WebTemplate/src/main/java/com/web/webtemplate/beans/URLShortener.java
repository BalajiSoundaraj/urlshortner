package com.web.webtemplate.beans;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class URLShortener {
	
	
	
	
	private String originalUrl;
	@Id
	private String shortUrl;
	private LocalDateTime creationDate;
	private String urlHitCount;
	
	
	
	public String getUrlHitCount() {
		return urlHitCount;
	}
	public void setUrlHitCount(String urlHitCount) {
		this.urlHitCount = urlHitCount;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	

	@Override
	public String toString() {
		return "URLShortener [originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", creationDate=" + creationDate
				+ ", urlHitCount=" + urlHitCount + "]";
	}
	public URLShortener(String originalUrl, String shortUrl, LocalDateTime creationDate, String urlHitCount) {
		super();
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.creationDate = creationDate;
		this.urlHitCount = urlHitCount;
	}
	public URLShortener() {
		super();
	}
	
	
	
	
}
