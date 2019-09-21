package com.hd.mylibrary.model.dao;

import com.hd.mylibrary.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

}
