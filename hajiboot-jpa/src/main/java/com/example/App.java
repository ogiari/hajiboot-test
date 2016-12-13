package com.example;

import com.example.repository.CustomerRepository;
import com.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@EnableAutoConfiguration
@ComponentScan
public class App {
    @Autowired
    CustomerRepository customerRepository;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}

