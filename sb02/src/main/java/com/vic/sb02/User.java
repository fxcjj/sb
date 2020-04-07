package com.vic.sb02;

import lombok.*;

/**
 * @author Victor
 * date: 2019/4/16 16:15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private Integer age;

    public static void main(String[] args) {
        UserBuilder user = User.builder() //auto generate builder way
                .name("victor")
                .age(18);

        System.out.println(user.name);
        System.out.println(user.age);

        User user1 = new User();
        user1.setName("martin"); //auto generate setter/getter
        user1.setAge(19);
    }
}
