package com.example.springboot;

public class Book {
    private final String id;
    private final String title;
    private Boolean isFavorited;

    public Book(String id, String title, Boolean isFavorited) {
        this.id = id;
        this.title = title;
        this.isFavorited = isFavorited;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Boolean isFavorited() {
        return this.isFavorited;
    }

    public void setIsFavorited(Boolean b) {
        this.isFavorited = b;
    }
}
