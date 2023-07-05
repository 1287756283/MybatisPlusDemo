package com.lsl.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author LSL
 * @since 2022-11-17
 */
@TableName(value ="national_address")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NationalAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 地址code
     */
    private String addrId;

    /**
     * 父级id
     */
    private String parentId;

    /**
     * 层级
     */
    private Integer lev;

    /**
     * 地址名称
     */
    private String name;

    /**
     * 说明
     */
    private String addrExplain;

    /**
     * 来源
     */
    private String source;


}
