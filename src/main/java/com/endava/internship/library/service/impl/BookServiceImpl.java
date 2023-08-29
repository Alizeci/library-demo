package com.endava.internship.library.service.impl;

import com.endava.internship.library.exception.BookNotFoundException;
import com.endava.internship.library.model.Book;
import com.endava.internship.library.repository.BookRepository;
import com.endava.internship.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(@Autowired BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> all() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) throws BookNotFoundException {
        return bookRepository
                .findByAuthor(author)
                .orElseThrow(() -> new BookNotFoundException("Book did not found it!"));
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
