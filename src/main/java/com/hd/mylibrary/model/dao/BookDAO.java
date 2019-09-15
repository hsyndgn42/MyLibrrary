package com.hd.mylibrary.model.dao;

import com.hd.mylibrary.model.entity.Author;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<Book, Long> {

    @Query(value = "SELECT b FROM Book b WHERE b.author = :author")
    public List<Book> retrieveBooksByAuthorId(@Param("author") Author author);

    @Query(value = "SELECT b FROM Book b WHERE b.customer = :customer")
    public List<Book> retrieveBooksByCustomerId(@Param("customer") Customer customer);
}
