package com.hd.mylibrary.model.dao;

import com.hd.mylibrary.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

}
