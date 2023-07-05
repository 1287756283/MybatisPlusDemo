package com.lsl.entity;

/**
 * @author: lsl
 * @description:
 * @date: 2022/7/28 16:12
 */

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门表
 * @TableName sys_dept
 */
@TableName(value ="sys_dept")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysDept implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private String id;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 父部门id
     */
    private String parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 负责人编号
     */
    private Integer leaderId;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 查询级别
     */
    private String cxjb;

    /**
     * 级别
     */
    private Integer lev;

    /**
     * 是否常用，默认0否，1是
     */
    private Boolean isUse;

    /**
     * 简化后名称
     */
    private String shortName;

    /**
     * 反诈二期排序
     */
    private Integer sortNum;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}