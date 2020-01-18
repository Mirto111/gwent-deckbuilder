package org.myproject.deckbuilder.service;

import javax.annotation.PostConstruct;

import org.myproject.deckbuilder.config.AppUserPrincipal;
import org.myproject.deckbuilder.model.User;
import org.myproject.deckbuilder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
public class UserService implements UserDetailsService {
 
    @Autowired
    private WebApplicationContext applicationContext;
    private UserRepository userRepository;

    @PostConstruct
    public void completeSetup() {
        userRepository = applicationContext.getBean(UserRepository.class);
    }
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AppUserPrincipal(user);
    }
}