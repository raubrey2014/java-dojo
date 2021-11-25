package com.ryanaubrey.configuration.autowire;

import java.util.UUID;

public class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static User fromName(String name) {
        String id = UUID.randomUUID().toString();
        return new User(id, name);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return String.format("User - id: %s, name: %s", id, name);
    }
}