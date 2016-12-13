package com.example.repository;

import com.example.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by 瀬戸 on 2016/12/08.
 */
@Repository
public class CustomRepository {
    private final ConcurrentMap<Integer, Customer> customerMap = new ConcurrentHashMap<>();

    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }
    public Customer findOne(Integer customerId) {
        return customerMap.get(customerId);
    }
    public Customer save(Customer customer){
        return customerMap.put(customer.getId(), customer);
    }
    public void delete(Integer customerID){
        customerMap.remove(customerID);
    }
}
