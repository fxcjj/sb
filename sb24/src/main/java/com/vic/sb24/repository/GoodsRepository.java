package com.vic.sb24.repository;

import com.vic.sb24.entity.Goods;
import com.vic.sb24.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Victor
 * date: 2019/5/13 19:12
 */

public interface GoodsRepository extends JpaRepository<Goods, Long> {

    /**
     * 更新商品名称
     * @param name
     * @param id
     * @param version
     * @return
     */
    @Transactional
    @Modifying
    @Query("update Goods g set g.name = ?1, g.version = g.version + 1 where g.id = ?2 and g.version = ?3")
    int updateName(String name, Long id, Long version);

}
