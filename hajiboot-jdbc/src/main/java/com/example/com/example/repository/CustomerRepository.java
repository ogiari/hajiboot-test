package com.example.com.example.repository;

import com.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by 瀬戸 on 2016/12/12.
 */
@Repository
@Transactional
public class CustomerRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private final static RowMapper<Customer> CUSTOMER_ROW_MAPPER = (ResultSet rs, int i) -> {
        Integer id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new Customer(id, firstName, lastName);
    };

    public List<Customer> findALL() {
        List<Customer> customers = jdbcTemplate.query("select id,first_name,last_name from customers order by id",
                CUSTOMER_ROW_MAPPER);
        return customers;
    }

    public Customer findOne(Integer id){
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(
                "select id,first_name,last_name from customers where id=:id",
                param,
                CUSTOMER_ROW_MAPPER
        );
    }

    public Customer save (Customer customer){
        SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
        if (customer.getId() == null){
            jdbcTemplate.update("insert into customers(first_name,last_name) values(:Firstname, :Lastname)",
                    param);
        } else {
            jdbcTemplate.update("updata customers set first_name=:Firstname, last_name=:Lastname where id=:id",
                    param);
        }
        return customer;
    }

    public void delete(Integer id){
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        jdbcTemplate.update("delete from customers where id=:id",
                param);
    }

}
