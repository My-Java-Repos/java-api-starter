package com.org.link.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloworldService {
/*	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getdataFallback")
	public String getdata() {
		ParameterizedTypeReference<String> ptr = new ParameterizedTypeReference<String>() {
		};

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<String> serviceResponse = this.restTemplate.exchange("http://localhost:8090/recommended",
				HttpMethod.GET, entity, ptr);
		return serviceResponse.getBody();
	}*/

	public String getdataFallback() {
		String response = "Fallback";

		return response;
	}
	
	public String getMethodNameVALUE_TO_BE_CHANGED(String uuid, Long deletedObjectId, String requestHeader){
		String response = "Fallback";

		return response;
	}

}
