package com.vic.sb08.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求实体
 *
 * @param <T>
 */
@Data
public class PageBo<T> implements Serializable {

    /**
     * 当前页数
     */
    private Integer page;

    /**
     * 每页显示数
     */
    private Integer size;

    /**
     * 参数
     */
    private T param;

    public static <K> PageBo<K> init(PageBo<K> pageBo) {
        if (pageBo == null) {
            pageBo = new PageBo<>();
        }
        if (pageBo.getPage() == null || pageBo.getPage() < 1) {
            pageBo.setPage(1);
        }
        if (pageBo.getSize() == null || pageBo.getSize() < 0) {
            pageBo.setSize(10);
        }
        return pageBo;
    }

    public void init() {
        if (this.getPage() == null || this.getPage() < 1) {
            this.setPage(1);
        }
        if (this.getSize() == null || this.getSize() < 0) {
            this.setSize(10);
        }
    }
}
