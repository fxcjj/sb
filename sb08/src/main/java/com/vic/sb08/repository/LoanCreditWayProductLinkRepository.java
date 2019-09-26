package com.vic.sb08.repository;

import com.vic.sb08.entity.LoanCreditWayProductLink;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * 产品与认证方式关联表repo
 * @since jdk1.8
 */
@Repository
public interface LoanCreditWayProductLinkRepository extends CrudRepository<LoanCreditWayProductLink, Long>, JpaSpecificationExecutor<LoanCreditWayProductLink> {
    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update LoanCreditWayProductLink p set p.dflag = 0 where p.id = ?1")
    int deleteByPrimaryKey(Long id);

    /**
     * 查询可用的产品-认证方式-认证三方
     * @return
     */
    /*@Query(value = "select new com.xcom.loan.credit.domain.vo.SimpleCreditWayProductLinkVo"
            + "("
            + "wp.productId,"
            + "wp.optionType,"
            + "tt.wayCode,"
            + "tt.wayName,"
            + "tt.thirdCode,"
            + "tt.thirdName"
            + ")"
            + "from ("
            + "select wt.id, w.code wayCode, w.name wayName, t.code thirdCode, t.name thirdName"
            + "from LoanCreditWay w inner join LoanCreditWayThirdLink wt on w.id = wt.creditWayId"
            + "inner join LoanCreditThird t on wt.thirdId = t.id"
            + "where w.dflag = 1 and wt.dflag = 1 and t.dflag = 1"
            + ") tt"
            + "inner join LoanCreditWayProductLink wp on wp.creditWayLinkId = tt.id "
            + "where wp.productId = :productId and wp.dflag = 1 and wp.status = 1", nativeQuery = true)
    List<SimpleCreditWayProductLinkVo> findVoByCondition(@Param("productId") Long productId);*/


}
