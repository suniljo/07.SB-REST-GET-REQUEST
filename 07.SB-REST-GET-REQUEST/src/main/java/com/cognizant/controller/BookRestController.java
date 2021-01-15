package com.cognizant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bindings.Book;

@RestController
@RequestMapping("/library")
public class BookRestController {
	@GetMapping(
				path="/book", 
				produces= {"application/json","application/xml"}
			)
	public ResponseEntity<Book> getBook() {
		// logic to retrieve the book from DB
		Book book = new Book();
		book.setBookId(100123);
		book.setBookName("Spring Boot with Microservices");
		book.setBookPrice(550.5f);
		book.setIsbn("COG-101");
		
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
	@GetMapping(
			  value="/book/{isbn}",
			  produces = {"application/xml","application/json"}
			)
	public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
		//logic to retrieve the Book based on isbn 
		Book book = new Book();
		book.setBookId(100123);
		book.setBookName("Angular 10");
		book.setBookPrice(450.5f);
		book.setIsbn(isbn);
		
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
}