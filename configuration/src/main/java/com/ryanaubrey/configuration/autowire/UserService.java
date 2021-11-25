package com.ryanaubrey.configuration.autowire;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Inject
    private UserDao userDao;

    public User getUserByName(String name) {
        Optional<User> u = this.userDao.getUserByName(name);
        if (!u.isPresent()) {
            throw new Error(String.format("Entity User not found by name \"%s\"", name));
        }
        return u.get();
    }
}
