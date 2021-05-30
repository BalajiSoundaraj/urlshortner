package com.web.webtemplate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.web.webtemplate.beans.URLShortener;

@Repository
public interface URLShortenerRepository extends MongoRepository<URLShortener, Long>{

	URLShortener findByShortUrl(String url);
	
	

}
