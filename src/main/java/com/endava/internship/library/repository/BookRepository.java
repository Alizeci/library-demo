package com.endava.internship.library.repository;

import com.endava.internship.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findAll(Pageable pageable);

    Optional<List<Book>> findByAuthor(String author);

    List<Book> findByAuthorAndCategoryOrderByTitleAsc(String author, String category);

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword% OR b.author LIKE %:keyword% ORDER BY b.title ASC")
    List<Book> findByKeywordOrderByTitleAsc(String keyword);

}
