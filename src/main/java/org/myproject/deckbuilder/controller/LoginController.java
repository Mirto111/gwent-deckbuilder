package org.myproject.deckbuilder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
	@RequestMapping(produces = "application/json")
	public String getUser() {
		
		return  "Success login";

	}
}

