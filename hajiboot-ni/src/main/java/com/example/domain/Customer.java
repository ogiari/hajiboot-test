package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by 瀬戸 on 2016/12/08.
 */
@Data
@AllArgsConstructor
public class Customer implements Serializable {
    private  Integer id;
    private  String firstname;
    private  String lastname;
}
