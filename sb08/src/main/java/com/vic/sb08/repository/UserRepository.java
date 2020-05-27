package com.vic.sb08.repository;

import com.vic.sb08.entity.User;
import com.vic.sb08.vo.SimpleUserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Victor
 * date: 2019/5/13 19:12
 */

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

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
     * 根据用户类型，排序查询
     *
     * @param userType 用户名
     * @param sort
     * @return
     */
    List<User> findByUserType(Integer userType, Sort sort);

    /**
     *
     * @param phone
     * @return
     */
    User findByPhone(String phone);

    /**
     * 测试不相等，null会取出来
     * @param userType
     * @return
     */
    @Query(value = "select * from v_user where delete_flag = 1 and user_type <> :userType or user_type is null", nativeQuery = true)
    List<User> testNotEqualsAndIsNull(@Param("userType") Byte userType);

    /**
     * 测试不相等，null不会取出来
     * @param userType
     * @return
     */
    @Query(value = "select * from v_user where delete_flag = 1 and user_type <> :userType", nativeQuery = true)
    List<User> testNotEquals(@Param("userType") Byte userType);

    /**
     * 不行
     * @param userType
     * @return
     */
    @Query(value = "select * from v_user where delete_flag = 1 and (user_type = :userType or user_type is null)", nativeQuery = true)
    List<User> testParamNullc(@Param("userType") Byte userType);

    /**
     * 可以
     * @param userType
     * @return
     */
    @Query(value = "select * from v_user where delete_flag = 1 and if(:userType != '', user_type = :userType, user_type is null)", nativeQuery = true)
    List<User> testParamNullb(@Param("userType") Byte userType);

    /**
     * 可以
     * @param userType
     * @return
     */
    @Query(value = "select * from v_user where delete_flag = 1 and if(:userType != '', user_type = :userType, 1=1)", nativeQuery = true)
    List<User> testParamNulla(@Param("userType") Byte userType);


    /**
     * 两种in的写法
     * @param name
     * @param status
     * @param userTypes
     * @return
     */
    List<User> findByNameAndStatusAndUserTypeIn(String name, String status, List<Integer> userTypes);

    @Query(value = "select * from v_user where delete_flag = 1 and name = :name and status = :status and user_type in(:userTypes) limit 1", nativeQuery = true)
    List<User> testInb(String name, String status, List<Integer> userTypes);
//    List<User> testInb(@Param("name") String name, @Param("status") String status, @Param("userTypes") List<Integer> userTypes);


    @Query("select u from User u where u.status = ?1")
    List<User> testUseEntity(String status);

    @Query("select new com.vic.sb08.vo.SimpleUserVo(u.id, u.name) from User u where u.id = ?1")
    SimpleUserVo testCustomeVo(Long id);
//    List<User> findTopByUserTypeAndStatus();



}
