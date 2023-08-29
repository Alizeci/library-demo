package com.endava.internship.library.controller;

import com.endava.internship.library.dto.BookDto;
import com.endava.internship.library.exception.BookNotFoundException;
import com.endava.internship.library.model.Book;
import com.endava.internship.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping( "/book" )
@RestController
public class BookController {

    private final BookService bookService;

    public BookController(@Autowired BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> allBooks() {
        return ResponseEntity.ok(bookService.all());
    }

    @GetMapping( "/{author}" )
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable String author) throws BookNotFoundException {
        return ResponseEntity.ok(bookService.findByAuthor(author));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDto BookDto) {
        return ResponseEntity.ok(bookService.create(new Book(BookDto)));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteById(id));
    }
}
