package com.vic.sb09.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 用户请求对象
 * @author 罗利华
 * date: 2019/5/16 16:19
 */
@ApiModel("用户请求对象参数")
@Data
public class UserReq {

    /**
     * 新增组
     */
    public interface Add {}

    /**
     * 更新组
     */
    public interface Update {}

    @ApiModelProperty(value = "主键", dataType = "Long", name = "id", example = "123")
    @Null(message = "id必须为空", groups = {Add.class})
    @NotNull(message = "id必须不能为空", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "姓名", dataType = "String", name = "name", example = "张三")
    @NotEmpty(message = "姓名不能为空", groups = {Add.class, Update.class})
    @Size(min = 2, max = 20, message = "姓名长度在2-10位之间", groups = {Add.class, Update.class})
    private String name;

    @ApiModelProperty(value = "密码", dataType = "String", name = "password", example = "p1")
    @NotEmpty(message = "密码不能为空", groups = {Add.class, Update.class})
    @Size(min = 2, max = 10, message = "密码长度至少2位", groups = {Add.class, Update.class})
    private String password;

    private String phone;
    private Byte userType; //1普通用户 2管理员
    private Byte status; //状态 1启用 0 停用
    private Date gmtModified; //修改时间

}
