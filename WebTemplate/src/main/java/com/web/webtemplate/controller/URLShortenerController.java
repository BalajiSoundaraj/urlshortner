package com.web.webtemplate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.webtemplate.beans.URLErrorResponse;
import com.web.webtemplate.beans.URLOutput;
import com.web.webtemplate.beans.URLResponse;
import com.web.webtemplate.beans.URLShortener;
import com.web.webtemplate.service.URLShortenerService;

@RestController
public class URLShortenerController {
	
	@Autowired
	URLShortenerService urlShortenerService;	
	
	
	@RequestMapping("helloworld")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	@RequestMapping(value="generateShortenedURL1", method = RequestMethod.POST) 
	public String generateShortenedURL1(@RequestBody String url)
	{
		return url;
	}
	
	@RequestMapping("/fetchExistingShortURL")
	public List<URLShortener> fetchExistingShortURL()
	{
		return urlShortenerService.fetchExistingShortURL();
	}

	@RequestMapping(value="generateShortenedURL", method = RequestMethod.POST)
	public ResponseEntity<?> generateShortenedURL(@RequestBody URLOutput url)
	{
		URLShortener urlShortener = urlShortenerService.generateShortURL(url);
		if(urlShortener!=null)
		{
			URLResponse response = new URLResponse();
			response.setOriginalUrl(urlShortener.getOriginalUrl());
			response.setShortLink(urlShortener.getShortUrl());
			return new ResponseEntity<URLResponse>(response, HttpStatus.OK);
		}
		URLErrorResponse errorResponse = new URLErrorResponse();
		errorResponse.setError("Error processing your request. Please try again");
		errorResponse.setStatus("404");
		return new ResponseEntity<URLErrorResponse>(errorResponse, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{shortLink}" ,method = RequestMethod.GET)
	public ResponseEntity<?> redirectToOriginalURL(@PathVariable String shortLink, HttpServletResponse response) throws IOException
	{
		URLErrorResponse errorResponse = new URLErrorResponse();
		if(StringUtils.isEmpty(shortLink))
		{
			
			errorResponse.setError("Invalid URL");
			errorResponse.setStatus("400");
			return new ResponseEntity<URLErrorResponse>(errorResponse, HttpStatus.OK);
		}
		
		if(shortLink.equalsIgnoreCase("index.html") || shortLink.equalsIgnoreCase("home"))
		{
			response.sendRedirect("");
			return null;
		}
		
		URLShortener urlShortener = urlShortenerService.getEncodedURL(shortLink);
		
		if(urlShortener == null)
		{

			errorResponse.setError("URL does not exist");
			errorResponse.setStatus("400");
			return new ResponseEntity<URLErrorResponse>(errorResponse, HttpStatus.OK);
		
			
		}
		response.sendRedirect(urlShortener.getOriginalUrl());
		return null;
		
		
	}
	
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public ResponseEntity<?> redirectToOriginalURL()
	{
		return null;
		
		
	}
	
}
