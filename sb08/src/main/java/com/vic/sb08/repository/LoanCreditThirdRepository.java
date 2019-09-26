package com.vic.sb08.repository;

import com.vic.sb08.entity.LoanCreditThird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 认证三方表repo
 * @since jdk1.8
 */
@Repository
public interface LoanCreditThirdRepository extends JpaRepository<LoanCreditThird, Long>, JpaSpecificationExecutor<LoanCreditThird> {

    List<LoanCreditThird> findByDflagAndStatus(Byte dflag, Integer status);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Modifying
    @Query("update LoanCreditThird c set c.dflag = 0 where c.id = ?1")
    int deleteByPrimaryKey(Long id);
}
