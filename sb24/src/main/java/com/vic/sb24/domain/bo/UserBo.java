package com.vic.sb24.domain.bo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author 罗利华
 * date: 2020/6/19 14:06
 */
@Data
public class UserBo implements Serializable {

    private String name;

    private Integer age;

    private String address;

}
