package com.vic.sb08.repository;

import com.vic.sb08.entity.LoanCreditWay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 认证方式表repo
 * @since jdk1.8
 */
@Repository
public interface LoanCreditWayRepository extends JpaRepository<LoanCreditWay, Long>, JpaSpecificationExecutor<LoanCreditWay> {

    List<LoanCreditWay> findByDflagAndStatus(Byte dflag, Integer status);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update LoanCreditWay w set w.dflag = 0 where w.id = ?1")
    int deleteByPrimaryKey(Long id);
}
