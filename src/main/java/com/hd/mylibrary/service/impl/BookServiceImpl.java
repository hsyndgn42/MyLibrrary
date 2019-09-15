package com.hd.mylibrary.service.impl;

import com.hd.mylibrary.model.dao.BookDAO;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.response.CreateBookResponse;
import com.hd.mylibrary.service.AuthorService;
import com.hd.mylibrary.service.BookService;
import com.hd.mylibrary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDAO bookDAO;

    @Autowired
    AuthorService authorService;

    @Autowired
    CustomerService customerService;

    @Override
    public List<Book> retrieveBooks() {
        List<Book> books = bookDAO.findAll();
        return books;
    }

    @Override

    public List<Book> retrieveBooksByAuthorId(Long authorId) {

        return bookDAO.retrieveBooksByAuthorId(authorService.getAuthor(authorId));
    }

    @Override
    public List<Book> retrieveBooksByCustomerId(Long customerId) {
        return bookDAO.retrieveBooksByCustomerId(customerService.getCustomer(customerId).get());
    }

    @Override
    public Optional<Book> getBook(Long bookId) {
        return bookDAO.findById(bookId);
    }

    @Override
    public CreateBookResponse saveBook(Book book) {

        try {
            bookDAO.save(book);
        } catch (Exception e) {
            return new CreateBookResponse("Fail", "Error : " + e.toString());
        }
        return new CreateBookResponse("Success", "Book created successfully.");

    }

    @Override
    public void deleteBook(Long bookId) {
        bookDAO.deleteById(bookId);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.save(book);
    }

    public void updateBooks(Set<Book> books) {
        bookDAO.saveAll(books);
    }
}
