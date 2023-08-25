package com.lsl.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author 连石磊
 * @since 2021-07-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    private String name;

    @NotBlank(message="email格式错误") //是不不为空的情况
    private String email;

    private Integer age;

    @TableField( fill = FieldFill.INSERT)
    private Date createTime;

    @TableField( fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
