package com.hd.mylibrary.common;

import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.entity.Customer;
import com.hd.mylibrary.model.enumerated.BookLanguage;
import com.hd.mylibrary.model.enumerated.BookType;

import java.util.HashSet;
import java.util.Set;

public class CustomerBuilderForTest {

    public Customer buildCustomer() {

        Customer customer = new Customer();
        customer.setPhone("905555555555");
        customer.setEmail("test@test.com");
        customer.setAge(21);
        customer.setAddress("Test");
        customer.setSurname("Test");
        customer.setFirstName("Test");

        return customer;
    }


}
