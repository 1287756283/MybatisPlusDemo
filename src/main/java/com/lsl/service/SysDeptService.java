package com.lsl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsl.entity.SysDept;
import com.lsl.entity.User;

import java.util.List;

/**
 * @author: lsl
 * @description:
 * @date: 2022/7/28 16:13
 */
public interface SysDeptService extends IService<SysDept>{

    SysDept guessDeptByAddress(String address);


    SysDept guessDeptByAddress2(String address);


    SysDept guessDeptByAddress3(String address);
}
