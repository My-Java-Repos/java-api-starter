package com.org.link.helloworld.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.link.helloworld.service.HelloworldService;
import com.org.link.idx.jwt.annotations.Uuid;

import io.swagger.annotations.Api;

@RefreshScope
@RestController
@RequestMapping(value = "/java-skeleton")
@Api(value = "java-skeleton")
public class HelloWorldController {

	@Value("${spring.main.show_banner}")
	String test;

	@Value("${test.encrypted.value}")
	String encryptedValue;

	@Autowired
	HelloworldService service;

	// THESE ARE EXAMPLES OF THE IDX ANNOTATIONS THAT ARE AVAILABLE
	// The set of annotations for common claims is available:
	//
	// @Uuid (IDX user identifier)
	// @Email
	// @Username
	// @FirstName
	// @LastName
	// @IdpUserId: (IDP user identifier)
	// @Idp: (IDP name)

	// GET METHOD

	@RequestMapping(method = GET, value = "/api/hello")
	public ResponseEntity get(@Uuid String uuid) {
		String reponse = "Hello";
		return new ResponseEntity(reponse, HttpStatus.OK);

	}
}
