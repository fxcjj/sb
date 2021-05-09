package com.vic.sb39.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求
 */
@Data
public class PageBo<T> implements Serializable {

    Integer pageNum;

    Integer pageSize;

    T param;

}
