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
 * 部门请求对象
 * @author Victor
 * date: 2019/5/16 16:19
 */
@ApiModel("部门请求对象参数")
@Data
public class DeptReq {

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

    @ApiModelProperty(value = "部门名称", dataType = "String", name = "name", example = "技术部")
    @NotEmpty(message = "部门名称为空", groups = {Add.class, Update.class})
    @Size(min = 2, max = 20, message = "部门名称长度在2-10位之间", groups = {Add.class, Update.class})
    private String name;

}
