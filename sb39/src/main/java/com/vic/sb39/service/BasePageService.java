package com.vic.sb39.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vic.sb39.bo.PageBo;

import java.util.Collections;
import java.util.List;

/**
 * 基础分页服务
 */
public interface BasePageService<P, R> {

    /**
     * 分页查询
     * @param pageBo
     * @return
     */
    default PageInfo<R> page(PageBo<P> pageBo) {
        return PageHelper.startPage(pageBo.getPageNum(), pageBo.getPageSize())
                .doSelectPageInfo(() -> list(pageBo.getParam()));
    }

    /**
     * 集合查询
     * @param param
     * @return
     */
    default List<R> list(P param) {
        return Collections.emptyList();
    }
}
