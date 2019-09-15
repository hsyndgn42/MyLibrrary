package com.hd.mylibrary.service.impl;

import com.hd.mylibrary.model.dao.CustomerDAO;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.entity.Customer;
import com.hd.mylibrary.model.response.CreateCustomerResponse;
import com.hd.mylibrary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
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
        Set<Book> books = new HashSet<>();
        try {
            customerDAO.save(customer);

            for (Book book : customer.getBooks()){
                book.setCustomer(customer);
                books.add(book);
            }
        } catch (Exception e) {
            return new CreateCustomerResponse("Fail", "Error : " + e.toString());
        }
        try{
            bookService.updateBooks(books);
        }catch (Exception e){
            return new CreateCustomerResponse("Fail","Books update error : "+e.toString());
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
