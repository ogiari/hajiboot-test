package com.example;

import com.example.com.example.repository.CustomerRepository;
import com.example.domain.Customer;
import org.h2.expression.Rownum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner{
    @Autowired
    CustomerRepository customerRepository;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
        System.out.println(created + "is created!");
        customerRepository.findALL()
                .forEach(System.out::println);
    }
}

