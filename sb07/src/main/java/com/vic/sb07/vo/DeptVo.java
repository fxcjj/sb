package com.vic.sb07.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 部门vo
 * @author 罗利华
 * date: 2019/5/9 17:21
 */
@Data
public class DeptVo {

    /**
     * 新增组
     */
    public interface Add {}

    /**
     * 更新组
     */
    public interface Update {}

    @Null(message = "部门id必须为空", groups = {UserVo.Add.class})
    @NotNull(message = "部门id必须不能为空", groups = {UserVo.Update.class})
    private Long id;

    @NotEmpty(message = "部门名称不能为空", groups = {UserVo.Add.class, UserVo.Update.class})
    @Length(min = 3, max = 20, message = "名称长度在3-20位之间")
    private String name;


}
