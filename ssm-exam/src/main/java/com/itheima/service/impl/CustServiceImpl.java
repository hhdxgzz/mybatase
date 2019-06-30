package com.itheima.service.impl;

import com.itheima.dao.CustDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Mr_Zhao
 * @Description:
 * @Date: Create in  2019/6/17 10:52
 */
@Service
@Transactional
public class CustServiceImpl implements CustService {

    @Autowired
    private CustDao custDao;
    @Override
    public List<Customer> findAll(Customer customer) {
        return custDao.findAll(customer);
    }

    @Override
    public Integer save(Customer customer) {

        return custDao.save(customer);
    }

    @Override
    public void delete(Integer cid) {
        custDao.delete(cid);
    }
}
