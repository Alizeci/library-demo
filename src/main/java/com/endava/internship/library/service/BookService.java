package com.endava.internship.library.service;

import com.endava.internship.library.exception.BookNotFoundException;
import com.endava.internship.library.model.Book;

import java.util.List;

public interface BookService {
    List<Book> all();

    List<Book> findByAuthor(String author) throws BookNotFoundException;

    Book create(Book book);

    Boolean deleteById(Long id);
}
