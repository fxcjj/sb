package com.vic.sb42.dao.orders;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.vic.sb42.consts.DBConsts;
import com.vic.sb42.entity.Order;

@DS(DBConsts.DATASOURCE_ORDERS)
public interface OrderMapper {
    Order findById(Long id);
}