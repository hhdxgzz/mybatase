package com.itheima.service;

import com.itheima.domain.Customer;

import java.util.List;

public interface CustService {

    List<Customer> findAll(Customer customer);

    Integer save(Customer customer);

    void delete(Integer cid);
}
