package com.example.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/books")
	public List<Book> getBooks() {
		List<Book> b = new ArrayList<>();
		b.add(new Book("1", "Where the Red Fern Grows", false));
		b.add(new Book("2", "Tale of Two Cities", false));

		return b;
	}

	@PostMapping("/books/{bookId}")
	public Book saveBook(@PathVariable("bookId") String bookId, @RequestBody Book book) {
		if (book.isFavorited() == null || book.getId() == null || book.getTitle() == null) {
			throw new Error("Unable to save book!");
		}

		return book;
	}

}
