package com.vic.sb47.service;

import com.vic.sb47.entity.Seckill;
import com.vic.sb47.mapper.SeckillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillService {

    @Autowired
    SeckillMapper seckillMapper;

    public Seckill findBySeckillId(Long seckillId) {
        return seckillMapper.findBySeckillId(seckillId);
    }

    /**
     * 基于mysql自带行锁扣减库存
     * @param seckillId
     * @return
     */
    public int deInventoryByLock(Long seckillId) {
        return seckillMapper.deInventoryByLock(seckillId);
    }

    /**
     * 基于version字段乐观锁扣减库存
     * @param seckillId
     * @return
     */
    public int deInventoryByOptimisticLock(Long seckillId, Long version) {
        return seckillMapper.deInventoryByOptimisticLock(seckillId, version);
    }

}
