package com.vic.sb24.service;

import com.vic.sb24.entity.Goods;
import com.vic.sb24.repository.GoodsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Victor
 * date: 2020/4/7 17:49
 */
@Slf4j
@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    /**
     * 更新商品名称
     * @return
     */
    public int updateName(Goods goods) {
        return goodsRepository.updateName(goods.getName(), goods.getId(), goods.getVersion());
    }

    /**
     * 通过id查询商品
     * @param id
     * @return
     */
    public Goods findById(Long id) {
        Optional<Goods> opt = goodsRepository.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    /**
     * 插入商品
     * @param g
     * @return
     */
    public Goods insert(Goods g) {
        return goodsRepository.save(g);
    }
}
