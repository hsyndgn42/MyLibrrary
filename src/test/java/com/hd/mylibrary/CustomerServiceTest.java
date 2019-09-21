package com.hd.mylibrary;

import com.hd.mylibrary.common.AuthorBuilderForTest;
import com.hd.mylibrary.common.BooksBuilderForTest;
import com.hd.mylibrary.common.CustomerBuilderForTest;
import com.hd.mylibrary.model.dao.AuthorDAO;
import com.hd.mylibrary.model.dao.BookDAO;
import com.hd.mylibrary.model.dao.CustomerDAO;
import com.hd.mylibrary.model.entity.Author;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.entity.Customer;
import com.hd.mylibrary.service.BookService;
import com.hd.mylibrary.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private AuthorDAO authorDAO;
    @Autowired
    private BookDAO bookDAO;


    @Test
    public void whenFindByIdThenReturnCustomer() {

        BooksBuilderForTest booksBuilderForTest = new BooksBuilderForTest();
        AuthorBuilderForTest authorBuilderForTest = new AuthorBuilderForTest();
        CustomerBuilderForTest customerBuilderForTest = new CustomerBuilderForTest();
        Author author = authorBuilderForTest.buildAuthor();
        Book book = booksBuilderForTest.buildBooks();
        Customer customer = customerBuilderForTest.buildCustomer();
        book.setAuthor(author);
        book.setCustomer(customer);
        authorDAO.save(author);
        customerDAO.save(customer);
        bookDAO.save(book);
        Optional<Customer> foundCustomer = customerService.getCustomer(customer.getId());

        Assert.assertTrue(foundCustomer.isPresent());
        Assert.assertEquals(foundCustomer.get().getId(), customer.getId());

    }

    @Test
    public void findBooksByCustomerId() {

        BooksBuilderForTest booksBuilderForTest = new BooksBuilderForTest();
        AuthorBuilderForTest authorBuilderForTest = new AuthorBuilderForTest();
        CustomerBuilderForTest customerBuilderForTest = new CustomerBuilderForTest();
        Author author = authorBuilderForTest.buildAuthor();
        Book book = booksBuilderForTest.buildBooks();
        Customer customer = customerBuilderForTest.buildCustomer();
        book.setAuthor(author);
        book.setCustomer(customer);
        authorDAO.save(author);
        customerDAO.save(customer);
        bookDAO.save(book);

        Set<Book> books = new HashSet<>();
        books.add(bookService.retrieveBooks().get(0));
        Set<Book> foundBooks = new HashSet<>(customerService.retrieveRentBooks(customer.getId()));
        Assert.assertEquals(books.stream().findFirst().get().getId(), foundBooks.stream().findFirst().get().getId());

    }


}
