package com.vic.sb42.dao.orders;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.vic.sb42.consts.DBConsts;
import com.vic.sb42.entity.Order;

//@DS(DBConsts.DATASOURCE_ORDERS)
public interface OrderMapper {

    /**
     * 读从库
     * 负载均衡默认采用轮询的方式。
     * @param id
     * @return
     */
    @DS(DBConsts.DATASOURCE_ORDER_SLAVE)
    Order findById0(Long id);

    /**
     * 读从库1
     * @param id
     * @return
     */
    @DS(DBConsts.DATASOURCE_ORDER_SLAVE_1)
    Order findById1(Long id);

    /**
     * 读从库2
     * @param id
     * @return
     */
    @DS(DBConsts.DATASOURCE_ORDER_SLAVE_2)
    Order findById2(Long id);


    @DS(DBConsts.DATASOURCE_ORDER_MASTER)
    int insertAndGetId1(Order order);
}