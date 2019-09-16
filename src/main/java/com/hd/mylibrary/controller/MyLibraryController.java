package com.hd.mylibrary.controller;

import com.hd.mylibrary.model.converter.CreateAuthorRequestConverter;
import com.hd.mylibrary.model.converter.CreateBookRequestConverter;
import com.hd.mylibrary.model.converter.CreateCustomerRequestConverter;
import com.hd.mylibrary.model.entity.Author;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.entity.Customer;
import com.hd.mylibrary.model.request.CreateAuthorRequest;
import com.hd.mylibrary.model.request.CreateBookRequest;
import com.hd.mylibrary.model.request.CreateCustomerRequest;
import com.hd.mylibrary.model.response.CreateAuthorResponse;
import com.hd.mylibrary.model.response.CreateBookResponse;
import com.hd.mylibrary.model.response.CreateCustomerResponse;
import com.hd.mylibrary.service.AuthorService;
import com.hd.mylibrary.service.BookService;
import com.hd.mylibrary.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MyLibraryController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private CreateAuthorRequestConverter createAuthorRequestConverter;
    private CreateBookRequestConverter createBookRequestConverter;
    private CreateCustomerRequestConverter createCustomerRequestConverter;
    private AuthorService authorService;
    private BookService bookService;
    private CustomerService customerService;

    @Autowired
    public MyLibraryController(CreateAuthorRequestConverter createAuthorRequestConverter,
                               CreateBookRequestConverter createBookRequestConverter,
                               CreateCustomerRequestConverter createCustomerRequestConverter,
                               AuthorService authorService,
                               BookService bookService,
                               CustomerService customerService) {
        this.createAuthorRequestConverter = createAuthorRequestConverter;
        this.authorService = authorService;
        this.createBookRequestConverter = createBookRequestConverter;
        this.bookService = bookService;
        this.createCustomerRequestConverter = createCustomerRequestConverter;
        this.customerService = customerService;
    }

    @PostMapping(path = "/myLibrary/author")
    public String saveAuthor(@RequestBody @Valid CreateAuthorRequest createAuthorRequest) {

        CreateAuthorResponse createAuthorResponse = authorService.saveAuthor(createAuthorRequestConverter.convert(createAuthorRequest));
        return createAuthorResponse.toString();
    }

    @GetMapping("/myLibrary/authors")
    public List<Author> getAuthors() {
        return authorService.retrieveAuthors();

    }

    @PostMapping(path = "/myLibrary/book")
    public String saveBook(@RequestBody @Valid CreateBookRequest createBookRequest) {

        CreateBookResponse createBookResponse = bookService.saveBook(createBookRequestConverter.convert(createBookRequest));
        return createBookResponse.toString();
    }

    @GetMapping("/myLibrary/books")
    public List<Book> getBooks() {
        return bookService.retrieveBooks();
    }

    @PostMapping(path = "/myLibrary/customer")
    public String saveCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {

        CreateCustomerResponse createCustomerResponse = customerService.saveCustomer(createCustomerRequestConverter.convert(createCustomerRequest));
        return createCustomerResponse.toString();
    }


    @GetMapping("/myLibrary/customers")
    public List<Customer> getCustomers() {
        return customerService.retrieveCustomers();
    }

    @GetMapping("/myLibrary/author/books")
    public List<Book> getBooksByAuthorId(@RequestParam Long authorId) {
        return authorService.getBooks(authorId);
    }

    @Cacheable(value = "customers",key = "#customerId")
    @GetMapping("/myLibrary/customer/books")
    public List<Book> getBooksByCustomerId(@RequestParam Long customerId) {
        LOG.info("Getting customer's books with customerId {}.", customerId);
        return customerService.retrieveRentBooks(customerId);
    }


}
