package com.web.webtemplate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.webtemplate.beans.URLOutput;
import com.web.webtemplate.beans.URLShortener;

@Service
public interface URLShortenerService {
	
	 URLShortener generateShortURL(URLOutput urlObject);
	 URLShortener persistShortURL(URLShortener urlObject);
	 URLShortener getEncodedURL(String url);
	List<URLShortener> fetchExistingShortURL();
	 

}
