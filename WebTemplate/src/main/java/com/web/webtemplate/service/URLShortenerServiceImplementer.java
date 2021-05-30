package com.web.webtemplate.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.hash.Hashing;
import com.web.webtemplate.beans.URLOutput;
import com.web.webtemplate.beans.URLShortener;
import com.web.webtemplate.repository.URLShortenerRepository;

@Component
public class URLShortenerServiceImplementer implements URLShortenerService{
	
	@Autowired
	URLShortenerRepository urlShortRepo;
	

	@Override
	public URLShortener generateShortURL(URLOutput urlObject) {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(urlObject.getInputURL()))
		{
			URLShortener urlToPersist = new URLShortener();
			String encodedURL = createEncodedURL(urlObject.getInputURL());
			urlToPersist.setOriginalUrl(urlObject.getInputURL());
			urlToPersist.setShortUrl(encodedURL);
			urlToPersist.setCreationDate(LocalDateTime.now());
			URLShortener urlToReturn = persistShortURL(urlToPersist);
			if(urlToReturn != null)
			{
				return urlToReturn;
			}
			
		}
		return null;
	}

	private String createEncodedURL(String inputURL) {
		// TODO Auto-generated method stub
		LocalDateTime time = LocalDateTime.now();
		String encodedURL = Hashing.murmur3_32().hashString(inputURL.concat(time.toString()), StandardCharsets.UTF_8).toString();
		return encodedURL;
	}

	@Override
	public URLShortener persistShortURL(URLShortener urlObject) {
		// TODO Auto-generated method stub
		URLShortener urlShortner = urlShortRepo.save(urlObject);
		return urlShortner;
	}

	@Override
	public URLShortener getEncodedURL(String url) {
		// TODO Auto-generated method stub
		URLShortener retrieveURL = urlShortRepo.findByShortUrl(url);
		return retrieveURL;
	}

	@Override
	public List<URLShortener> fetchExistingShortURL() {
		// TODO Auto-generated method stub
		
		return urlShortRepo.findAll();
	}

}
