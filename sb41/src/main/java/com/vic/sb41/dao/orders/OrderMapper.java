package com.vic.sb41.dao.orders;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.vic.sb41.consts.DBConsts;
import com.vic.sb41.entity.Order;

@DS(DBConsts.DATASOURCE_ORDERS)
public interface OrderMapper {
    Order findById(Long id);
}