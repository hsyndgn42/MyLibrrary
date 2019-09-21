package com.hd.mylibrary.service.impl;

import com.hd.mylibrary.model.dao.CustomerDAO;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.entity.Customer;
import com.hd.mylibrary.model.response.CreateCustomerResponse;
import com.hd.mylibrary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private BookServiceImpl bookService;

    @Override
    public List<Customer> retrieveCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public Optional<Customer> getCustomer(Long customerId) {
        return customerDAO.findById(customerId);
    }

    @Override
    public CreateCustomerResponse saveCustomer(Customer customer) {
        try {
            customerDAO.save(customer);
        } catch (Exception e) {
            return new CreateCustomerResponse("Fail", "Error : " + e.toString());
        }
        return new CreateCustomerResponse("Success", "Book created successfully.");

    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerDAO.deleteById(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public List<Book> retrieveRentBooks(Long customerId) {
        return bookService.retrieveBooksByCustomerId(customerId);
    }
}
