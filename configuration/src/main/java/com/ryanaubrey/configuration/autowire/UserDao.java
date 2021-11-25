package com.ryanaubrey.configuration.autowire;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public Optional<User> getUserByName(String name) {
        return Optional.of(User.fromName(name));
    }
}
