package com.vic.sb08.repository;

import com.vic.sb08.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 罗利华
 * date: 2019/5/13 19:12
 */

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过用户名查询
     * @param name 用户名
     * @return
     */
    List<User> findByName(String name);


    /**
     * 通过用户名like查询
     * @param name
     * @return
     */
    List<User> findByNameLike(String name);

    /**
     * 通过用户名和手机号码查询
     * @param name
     * @param phone
     * @return
     */
    User findByNameAndPhone(String name, String phone);

    /**
     * 根据用户类型，分页查询
     *
     * @param userType 用户类型
     * @param pageable
     * @return
     */
    Page<User> findByUserType(Integer userType, Pageable pageable);

    /**
     * 根据用户名，排序查询
     *
     * @param name 用户名
     * @param sort
     * @return
     */
    List<User> findByName(String name, Sort sort);
}
