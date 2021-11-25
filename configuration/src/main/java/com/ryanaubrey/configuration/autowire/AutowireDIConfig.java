package com.ryanaubrey.configuration.autowire;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowireDIConfig {

    @Inject
    private UserService userService;

    public UserService userService() {
        return this.userService;
    }
}
