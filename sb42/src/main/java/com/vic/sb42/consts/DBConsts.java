package com.vic.sb42.consts;

public interface DBConsts {

    /**
     * 订单主库
     */
    String DATASOURCE_ORDER_MASTER = "order-master";

    /**
     * 订单从库（从数据源组）
     */
    String DATASOURCE_ORDER_SLAVE = "order-slave";
    String DATASOURCE_ORDER_SLAVE_1 = "order-slave_1";
    String DATASOURCE_ORDER_SLAVE_2 = "order-slave_2";


    /**
     * 用户主库
     */
    String DATASOURCE_USER_MASTER = "user-master";

    /**
     * 用户从库
     */
    String DATASOURCE_USER_SLAVE = "user-slave";

}
