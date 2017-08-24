package com.highcode.sms.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		
		
			logger.info("getWelcome is executed!");
		

		return "index";
	}
}
