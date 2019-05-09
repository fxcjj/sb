package com.vic.sb07.vo;

import com.vic.sb07.validator.constraints.Gender;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 *
 * @author 罗利华
 * date: 2019/5/7 16:19
 */
@Data
public class UserVo {

    /**
     * validation group
     * 配合前面的注解使用，
     * 例如@Null(groups = {Add.class})
     * 表示标注的属性，当为Add组时，此属性必须为null
     *
     * 比较恶心的是：
     * 必须所有属性都声明groups，否则此属性标注的其它注解（如@NotEmpty）无效
     */

    /**
     * 新增组
     */
    public interface Add {}

    /**
     * 更新组
     */
    public interface Update {}

    @Null(message = "id必须为空", groups = {Add.class})
    @NotNull(message = "id必须不能为空", groups = {Update.class})
    private Long id;

    @NotEmpty(message = "姓名不能为空", groups = {Add.class, Update.class})
    @Length(min = 2, max = 20, message = "姓名长度在2-10位之间")
    private String name;

    @NotEmpty(message = "密码不能为空", groups = {Add.class, Update.class})
    @Length(min = 3, message = "密码长度至少3位")
    private String password;

    @Min(value = 6, message = "年龄不合法", groups = {Add.class, Update.class})
    private Integer age;

    @NotEmpty(message = "邮箱不能为空", groups = {Add.class, Update.class})
    @Email(message = "邮箱地址不合法")
    private String email;

    /**
     * 自定义校验注解
     */
    //0未知 1男 2女
    @Gender(allowed = {0, 1, 2}, groups = {Add.class, Update.class})
    private Integer gender;

    //部门
    /*@Valid //嵌套验证必须用@Valid
    @Null(message = "部门必须为空", groups = {Add.class})
    @NotNull(message = "部门不能为空", groups = {Update.class})
    private DeptVo deptVo;*/

}
