package com.vic.sb11.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 罗利华
 * date: 2019/6/27 19:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private String role;

}
