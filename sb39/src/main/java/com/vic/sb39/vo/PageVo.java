package com.vic.sb39.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页响应
 */
@Data
public class PageVo<T> implements Serializable {

    Integer curPageNum;

    Integer pageSize;

    Long total;

    List<T> datas;

}
