package com.vic.sb47.mapper;

import com.vic.sb47.entity.Seckill;
import org.apache.ibatis.annotations.Param;

//@Mapper
public interface SeckillMapper {

    Seckill findBySeckillId(Long seckillId);

    /**
     * 基于mysql自带行锁扣减库存
     * @param seckillId
     * @return
     */
    int deInventoryByLock(@Param("seckillId")Long seckillId);

    /**
     * 基于version字段乐观锁扣减库存
     * @param seckillId
     * @return
     */
    int deInventoryByOptimisticLock(@Param("seckillId")Long seckillId, @Param("version")Long version);
}