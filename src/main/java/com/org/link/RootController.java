package com.org.link;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	@RequestMapping("/")
	public String index() {
		return "Greetings from the Java Skeleton Application!";
	}

}
