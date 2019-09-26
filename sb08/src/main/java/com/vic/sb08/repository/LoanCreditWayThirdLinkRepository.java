package com.vic.sb08.repository;

import com.vic.sb08.entity.LoanCreditWayThirdLink;
import com.vic.sb08.vo.LoanCreditWayThirdLinkVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 认证方式和认证三方关联表repo
 * @since jdk1.8
 */
@Repository
public interface LoanCreditWayThirdLinkRepository extends JpaRepository<LoanCreditWayThirdLink, Long>, JpaSpecificationExecutor<LoanCreditWayThirdLink> {

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update LoanCreditWayThirdLink c set c.dflag = 0 where c.id = ?1")
    int deleteByPrimaryKey(Long id);

    @Query(value = "select count(c) from LoanCreditWayThirdLink c where c.dflag = 1 and c.thirdId = ?1")
    int countByThirdId(Long thirdId);

    @Query(value = "select count(c) from LoanCreditWayThirdLink c where c.dflag = 1 and c.creditWayId = ?1")
    int countByWayId(Long wayId);

    /**
     * 查询非id的启用条数
     * @param status
     * @param id
     * @return
     */
    @Query(value = "select count(c) from LoanCreditWayThirdLink c where c.dflag = 1 and c.status = ?1 and c.id <> ?2")
    int countByStatusAndIdNot(Integer status, Long id);

    /**
     * 启用认证方式
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update LoanCreditWayThirdLink c set c.status = 1, c.gmtModified = ?2 where c.id = ?1")
    int enabled(Long id, Date date);


    /**
     * 禁用认证方式
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update LoanCreditWayThirdLink c set c.status = 2, c.gmtModified = ?2 where c.id = ?1")
    int disabled(Long id, Date date);

    /**
     * 关联分页查询
     *
     * @return
     */
    @Query(value = "select new com.vic.sb08.vo.LoanCreditWayThirdLinkVo(wt.id, w.id, w.name, t.id, t.name, wt.status) from LoanCreditWay w INNER JOIN LoanCreditWayThirdLink wt on w.id = wt.creditWayId INNER JOIN LoanCreditThird t on wt.thirdId = t.id where w.dflag = 1 and wt.dflag = 1 and t.dflag = 1 and wt.status = 1",
            countQuery = "select count(wt.id)" +
                    "from LoanCreditWay w INNER JOIN LoanCreditWayThirdLink wt on w.id = wt.creditWayId INNER JOIN LoanCreditThird t on wt.thirdId = t.id where w.dflag = 1 and wt.dflag = 1 and t.dflag = 1 and wt.status = 1")
    Page<LoanCreditWayThirdLinkVo> testPage2(Pageable pageable);

    /**
     * 关联分页查询
     *
     * @return
     */
    @Query(value = "select w.id as creditWayId, w.name as creditWayName, t.id as thirdId, t.name as thirdName, wt.status from loan_credit_way w INNER JOIN loan_credit_way_third_link wt on w.id = wt.credit_way_id INNER JOIN loan_credit_third t on wt.third_id = t.id where w.dflag = 1 and wt.dflag = 1 and t.dflag = 1 and wt.status = 1",
            countQuery = "select count(*)" +
                    "from loan_credit_way w INNER JOIN loan_credit_way_third_link wt on w.id = wt.credit_way_id INNER JOIN loan_credit_third t on wt.third_id = t.id where w.dflag = 1 and wt.dflag = 1 and t.dflag = 1 and wt.status = 1",
            nativeQuery = true)
    Page<Object[]> testPage1(Pageable pageable);

}
