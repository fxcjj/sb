package com.vic.sb39.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "t_user")
public class User extends IdEntity {

    String name;

    Integer age;

}
