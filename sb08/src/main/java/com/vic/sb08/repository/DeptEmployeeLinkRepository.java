package com.vic.sb08.repository;

import com.vic.sb08.entity.User;
import com.vic.sb08.vo.EmployeeVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Victor
 * date: 2019/5/13 19:12
 */

public interface DeptEmployeeLinkRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {


    @Query(value = "select new com.vic.sb08.vo.EmployeeVo(d.code, d.name, e.code, e.name)"
            + "from Dept d "
            + "INNER JOIN DeptEmployeeLink del ON d.code = del.deptCode "
            + "INNER JOIN Employee e ON del.employeeCode = e.code "
            + "WHERE d.dflag = 1 and del.dflag = 1 and e.dflag = 1 and del.deptCode = ?1",
            countQuery = "select count(del.id)"
                    + "from Dept d "
                    + "INNER JOIN DeptEmployeeLink del ON d.code = del.deptCode "
                    + "INNER JOIN Employee e ON del.employeeCode = e.code "
                    + "WHERE d.dflag = 1 and del.dflag = 1 and e.dflag = 1 and del.deptCode = ?1")
    Page<EmployeeVo> findEmployeeVoPage(Pageable pageable, String deptCode);

}
