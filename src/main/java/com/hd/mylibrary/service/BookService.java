package com.hd.mylibrary.service;

import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.response.CreateBookResponse;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> retrieveBooks();

    public List<Book> retrieveBooksByAuthorId(Long authorId);

    public List<Book> retrieveBooksByCustomerId(Long customerId);

    public Optional<Book> getBook(Long bookId);

    public CreateBookResponse saveBook(Book book);

    public void deleteBook(Long bookId);

    public void updateBook(Book book);

}
