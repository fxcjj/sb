package com.vic.sb08.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Victor
 * date: 2019/5/13 19:06
 */
@Data
@Entity
@Table(name = "v_dept_employee_link")
@ToString
public class DeptEmployeeLink implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deptCode;
    private String employeeCode;

    /**
     * 0:无效 1:有效
     */
    private Integer dflag;


}
