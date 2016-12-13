package com.example.service;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by 瀬戸 on 2016/12/13.
 */
@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAllorderByName();
    }

    public Customer findOne(Integer id){
        return customerRepository.findOne(id);
    }

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updata(Customer customer){
        return customerRepository.save(customer);
    }

    public void delete(Integer id){
        customerRepository.delete(id);
    }

}
