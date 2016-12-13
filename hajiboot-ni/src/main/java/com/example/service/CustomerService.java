package com.example.service;

import com.example.domain.Customer;
import com.example.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 瀬戸 on 2016/12/08.
 */
@Service
public class CustomerService {
    @Autowired
    CustomRepository customRepository;

    public Customer save(Customer customer){
        return customRepository.save(customer);
    }

    public List<Customer> findAll(){
        return customRepository.findAll();
    }
}
