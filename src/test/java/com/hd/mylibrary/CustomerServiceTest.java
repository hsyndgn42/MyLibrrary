package com.hd.mylibrary;

import com.hd.mylibrary.common.BooksBuilderForTest;
import com.hd.mylibrary.model.dao.CustomerDAO;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.entity.Customer;
import com.hd.mylibrary.service.BookService;
import com.hd.mylibrary.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    BookService bookService;
    @Autowired
    CustomerService customerService;

    @Test
    public void whenFindByIdThenReturnCustomer() {
        BooksBuilderForTest booksBuilderForTest = new BooksBuilderForTest();
        Set<Book> books = booksBuilderForTest.buildBooks(3);
        Customer customer = new Customer();
        customer.setBooks(books);
        customer.setPhone("905555555555");
        customer.setEmail("test@test.com");
        customer.setAge(21);
        customer.setAddress("Test");
        customer.setSurname("Test");
        customer.setFirstName("Test");

        testEntityManager.persist(customer);
        testEntityManager.flush();

        Optional<Customer> foundCustomer = customerService.getCustomer(customer.getId());

        Assert.assertTrue(foundCustomer.isPresent());
        Assert.assertEquals(foundCustomer.get().getId(),customer.getId());
        Assert.assertEquals(foundCustomer.get().getBooks(),customer.getBooks());

    }

    @Test
    public void FindBooksByCustomerId() {
        BooksBuilderForTest booksBuilderForTest = new BooksBuilderForTest();
        int count = 5;
        Set<Book> books = booksBuilderForTest.buildBooks(count);
        Customer customer = new Customer();
        customer.setBooks(books);
        customer.setPhone("905555555555");
        customer.setEmail("test@test.com");
        customer.setAge(21);
        customer.setAddress("Test");
        customer.setSurname("Test");
        customer.setFirstName("Test");

        testEntityManager.persist(customer);
        testEntityManager.flush();


        List<Book> foundBooks = customerService.retrieveRentBooks(customer.getId());

        Assert.assertEquals(foundBooks.size(),count);
        Assert.assertEquals(books,foundBooks);

    }


}
