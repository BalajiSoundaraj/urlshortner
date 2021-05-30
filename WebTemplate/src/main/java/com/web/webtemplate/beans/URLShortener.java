package com.web.webtemplate.beans;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class URLShortener {
	
	
	
	
	private String originalUrl;
	@Id
	private String shortUrl;
	private LocalDateTime creationDate;
	@Field
	private int urlHitCount=1;
	
	
	
	
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

	public int getUrlHitCount() {
		return urlHitCount;
	}
	public void setUrlHitCount(int urlHitCount) {
		this.urlHitCount = urlHitCount;
	}
	public URLShortener() {
		super();
	}
	public URLShortener(String originalUrl, String shortUrl, LocalDateTime creationDate, int urlHitCount) {
		super();
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.creationDate = creationDate;
		this.urlHitCount = urlHitCount;
	}
	@Override
	public String toString() {
		return "URLShortener [originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", creationDate=" + creationDate
				+ ", urlHitCount=" + urlHitCount + "]";
	}
	
	
	
	
	
}
