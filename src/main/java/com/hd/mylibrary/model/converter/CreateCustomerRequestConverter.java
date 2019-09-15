package com.hd.mylibrary.model.converter;

import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.entity.Customer;
import com.hd.mylibrary.model.request.CreateCustomerRequest;
import com.hd.mylibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CreateCustomerRequestConverter {

    @Autowired
    BookService bookService;

    public Customer convert(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        customer.setFirstName(createCustomerRequest.getFirstName());
        customer.setSurname(createCustomerRequest.getSurname());
        customer.setAddress(createCustomerRequest.getAddress());
        customer.setAge(createCustomerRequest.getAge());
        customer.setEmail(createCustomerRequest.getEmail());
        customer.setPhone(createCustomerRequest.getPhone());
        Set<Book> books = new HashSet<>();
        for(Long ids:createCustomerRequest.getBookIds())
         books.add(bookService.getBook(ids).get());
        customer.setBooks(books);

        return customer;

    }
}

