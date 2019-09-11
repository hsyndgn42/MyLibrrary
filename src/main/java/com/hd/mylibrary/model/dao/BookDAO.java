package com.hd.mylibrary.model.dao;

import com.hd.mylibrary.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<Book, Long> {

    @Query(value = "SELECT b FROM Book b WHERE b.author = :authorId")
    public List<Book> retrieveBooksByAuthorId(@Param("authorId") Long authorId);

    @Query(value = "SELECT b FROM Book b WHERE b.customer = :customerId")
    public List<Book> retrieveBooksByCustomerId(@Param("customerId") Long authorId);
}
