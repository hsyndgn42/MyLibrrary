package com.hd.mylibrary.service;

import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.entity.Customer;
import com.hd.mylibrary.model.response.CreateCustomerResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<Customer> retrieveCustomers();

    public Optional<Customer> getCustomer(Long customerId);

    public CreateCustomerResponse saveCustomer(Customer customer);

    public void deleteCustomer(Long customerId);

    public void updateCustomer(Customer customer);

    public List<Book> retrieveRentBooks(Long customerId);
}
