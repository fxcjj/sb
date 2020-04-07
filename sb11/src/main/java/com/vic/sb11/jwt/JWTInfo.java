package com.vic.sb11.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户信息
 * @author Victor
 * date: 2019/7/22 09:20
 */
@Data
@AllArgsConstructor
public class JWTInfo {

    private Long userId;

    private String name;

    private String email;

}
