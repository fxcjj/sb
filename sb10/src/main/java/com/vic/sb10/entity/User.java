package com.vic.sb10.entity;

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

    public static void main(String[] args) throws InterruptedException {
        /**
         * 1563277138751
         * 1563277139751
         * 1563277140752
         * 1563277141753
         * 1563277142753
         * 1563277143754
         */
        for(int i = 0; i < 10; i++) {
            System.out.println(System.currentTimeMillis());
            Thread.sleep(1000);
        }

    }

}
