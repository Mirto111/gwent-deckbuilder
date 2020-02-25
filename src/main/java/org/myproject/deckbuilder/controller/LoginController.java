package org.myproject.deckbuilder.controller;

import org.myproject.deckbuilder.config.AppUserPrincipal;
import org.myproject.deckbuilder.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class LoginController {
	@RequestMapping(produces = "application/json")
	public User getUser() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        AppUserPrincipal principal = (AppUserPrincipal)auth.getPrincipal();
		
		return  principal.getAppUser();

	}
}

