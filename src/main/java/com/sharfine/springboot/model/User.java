package com.sharfine.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
/**
 * mybatis
 */
@Data
public class User {

    private Integer id;

    private String name;

    private Integer age;

}
